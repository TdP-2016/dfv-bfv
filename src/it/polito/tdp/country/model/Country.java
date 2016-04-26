/**
 * Java Bean class for representing instances of the COUNTRY table in the COUNTRIES data-set.
 * 
 * <p>Includes 3 properties: 
 * <ul>
 * <li>{@code cCode} (the country code)
 * <li>{@code stateAbb} (a 3 letter abbreviation for the state),
 * <li>{@code stateName} (the full name of the state).
 * </ul>
 * 
 * @author Fulvio
 *
 */

package it.polito.tdp.country.model;

public class Country {

	private int cCode ; // Country Code for the state
	private String stateAbb ; // State Abbreviation (3 capital letters)
	private String stateName ; // Full State name
	
	/**
	 * Initialize a new {@link Country} object, with full parameters.
	 * 
	 * @param cCode
	 * @param stateAbb
	 * @param stateName
	 */
	public Country(int cCode, String stateAbb, String stateName) {
		super();
		this.cCode = cCode;
		this.stateAbb = stateAbb;
		this.stateName = stateName;
	}

	/**
	 * @return the cCode
	 */
	public int getcCode() {
		return cCode;
	}

	/**
	 * @param cCode the cCode to set
	 */
	public void setcCode(int cCode) {
		this.cCode = cCode;
	}

	/**
	 * @return the stateAbb
	 */
	public String getStateAbb() {
		return stateAbb;
	}

	/**
	 * @param stateAbb the stateAbb to set
	 */
	public void setStateAbb(String stateAbb) {
		this.stateAbb = stateAbb;
	}

	/**
	 * @return the stateName
	 */
	public String getStateName() {
		return stateName;
	}

	/**
	 * @param stateName the stateName to set
	 */
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return cCode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (cCode != other.cCode)
			return false;
		return true;
	}	
	
	
	
}
