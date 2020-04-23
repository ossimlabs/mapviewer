package mapviewer

class MapWidgetController
{
    TileRendererService tileRendererService
    
    def index() { }
    
    def getTile()
    {
        render tileRendererService.getTile( params )
    }
}
