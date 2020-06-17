package mapviewer

import geoscript.GeoScript
import geoscript.geom.Point
import grails.gorm.transactions.Transactional
import org.springframework.context.MessageSource


@Transactional
class CsvService
{
	MessageSource messageSource
	
	// apply custom metrics timer to this method
	// this is where the cities are loaded
	def loadCSV()
	{
		if ( City.count() == 0 ) {
			File csvFile = new File( 'data/cities.csv' )
			
			csvFile.eachLine { String line ->
				List<String> tokens = line.split( ',' )
				
				City city = new City(
					name: tokens[0],
					country: tokens[1],
					population: tokens[2]?.toInteger(),
					capital: tokens[3] == 'Y',
					longitude: tokens[4]?.toDouble(),
					latitude: tokens[5].toDouble()
				)
				
				city.location = GeoScript.unwrap( new Point( city.longitude, city.latitude ) )
				city.location.setSRID( 4326 )
				
				if ( !city.save() )
				{
					city.errors.allErrors.each {
						println messageSource.getMessage( it, Locale.default )
					}
				}
			}
		}			
	}
}
