package mapviewer

class BootStrap
{
	CsvService csvService
	
	def init = { servletContext ->
		csvService.loadCSV()
	}
	
	def destroy = {
	}
}
