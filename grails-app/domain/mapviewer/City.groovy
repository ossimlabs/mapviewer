package mapviewer

import groovy.transform.ToString

@ToString(includeNames = true)
class City
{
	// CITY_NAME,COUNTRY,POP,CAP,LONGITUDE,LATITUDE
	String name
	String country
	Integer population
	Boolean capital
	Double longitude
	Double latitude
 
	static constraints = {
		name()
		country()
		population()
		capital()
		longitude()
		latitude()
	}
}
