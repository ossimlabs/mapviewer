package mapviewer

import groovy.transform.ToString
import org.locationtech.jts.geom.Point

@ToString(includeNames = true)
class City
{
	String name
	String country
	Integer population
	Boolean capital
	Double longitude
	Double latitude
	Point location
 
	static constraints = {
		name()
		country()
		population(min: 0)
		capital()
		longitude()
		latitude()
		location(nullable: true)
	}
	
	static mapping = {
		location  sqlType: 'geometry(Point, 4326)'
	}
}
