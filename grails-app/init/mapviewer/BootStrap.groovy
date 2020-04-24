package mapviewer

class BootStrap
{
	CityService cityService
	
	def init = { servletContext ->
		cityService.loadCSV()
	}
	
	def destroy = {
	}
}
