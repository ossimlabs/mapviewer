package mapviewer

class MapWidgetController
{
    TileRendererService tileRendererService
    
    def index() { [
      mapParams: [:]
    ]}
    
    def getTile()
    {
        render tileRendererService.getTile( params )
    }
}
