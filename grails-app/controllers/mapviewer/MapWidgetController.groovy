package mapviewer

import grails.plugin.dropwizard.metrics.meters.Metered

class MapWidgetController
{
    TileRendererService tileRendererService
    
    def index() { [
      mapParams: [:]
    ]}
    
    @Metered('some meter')
    def getTile()
    {
        render tileRendererService.getTile( params )
    }
}
