/*****************************************************************-*-java-*-*\
*               *  Classroom code for "Tecniche di Programmazione"           *
*    #####      *  (!) Giovanni Squillero <giovanni.squillero@polito.it>     *
*   ######      *                                                            *
*   ###   \     *  Copying and distribution of this file, with or without    *
*    ##G  c\    *  modification, are permitted in any medium without royalty *
*    #     _\   *  provided this notice is preserved.                        *
*    |   _/     *  This file is offered as-is, without any warranty.         *
*    |  _/      *                                                            *
*               *  See: http://bit.ly/tecn-progr                             *
\****************************************************************************/

/**
 * 
 * @author Giovanni
 *
 */

import it.polito.tdp.country.db.CountryDAO;
import it.polito.tdp.country.model.Country;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.jgrapht.Graphs;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.Pseudograph;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.DepthFirstIterator;
import org.jgrapht.traverse.GraphIterator;

public class Main {

	protected Set<String> recVisited = new HashSet<String>();
	protected CountryDAO dao = new CountryDAO();
	protected SimpleGraph<String, DefaultEdge> worldGraph = new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);
	protected Map<String, Country> countriesMap = new HashMap<String, Country>();

	public static void main(String[] args) {
		Main sh = new Main();
		sh.run();
	}

	protected void run() {
		System.err.println("Here I am!");

		for (Country c : dao.loadAllCountries()) {
			countriesMap.put(c.getStateAbb(), c);
			worldGraph.addVertex(c.getStateAbb());
		}
		for (Country c : countriesMap.values()) {
			System.out.print(c.getStateName() + "(" + c.getStateAbb() + "):");
			for (Country c2 : dao.getBorderingCountries(c, 3, 2006)) {
				System.out.print(" \"" + c2.getStateName() + "\" (" + c2.getStateAbb() + ")");
				worldGraph.addEdge(c.getStateAbb(), c2.getStateAbb());
			}
			System.out.println("");
		}

		Set<String> Visited = new HashSet<String>();
		String targetCountry = "ITA";

		System.out.println(worldGraph.degreeOf("ITA"));
		for (DefaultEdge e : worldGraph.edgesOf("ITA")) {
			System.out.println(Graphs.getOppositeVertex(worldGraph, e, "ITA"));
			System.out.println(e);
		}
		for (String c : Graphs.neighborListOf(worldGraph, "FRN")) {
			System.out.println(" " + countriesMap.get(c).getStateName());
		}

		System.out.print(targetCountry + ":");
		GraphIterator<String, DefaultEdge> dfv = new DepthFirstIterator<String, DefaultEdge>(worldGraph, targetCountry);
		while (dfv.hasNext()) {
			String t = dfv.next();
			Visited.add(t);
			System.out.print(" " + t);
		}
		System.out.println("");

		System.out.print("MISSING:");
		for (String c : countriesMap.keySet()) {
			if (!Visited.contains(c))
				System.out.print(" " + c);
		}
		System.out.println("");

		System.out.print("BFV:");
		recursiveVisit(targetCountry);
		System.out.println("");
		System.out.print("MISSING:");
		for (String c : countriesMap.keySet()) {
			if (!recVisited.contains(c))
				System.out.print(" " + c);
		}
		System.out.println("");
	}

	protected void recursiveVisit(String n) {
		System.out.print(" " + n);
		if (recVisited.contains(n))
			return;
		recVisited.add(n);
		for (String c : Graphs.neighborListOf(worldGraph, n)) {
			recursiveVisit(c);
		}
	}
}
