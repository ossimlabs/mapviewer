package mapviewer

class BootStrap
{
	
	def init = { servletContext ->
		File csvFile = new File( 'cities.csv' )
		
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
			
			if ( !city.save() )
			{
				city.errors.allErrors.each {
					println it
				}
			}
		}
	}
	
	def destroy = {
	}
}
