package mapviewer

import geoscript.geom.Bounds
import geoscript.layer.Shapefile
import static geoscript.style.Symbolizers.*

import java.awt.Color
import java.awt.Graphics2D
import java.awt.image.BufferedImage
import javax.imageio.ImageIO

import geoscript.render.Map as GeoScriptMap

class TileRendererService
{
	def getTile( Map<String, Object> params )
	{
		println params
		
		int width = params.WIDTH as int
		int height = params.HEIGHT as int
		String srs = params.SRS
		String bbox = params.BBOX
		
		String format = params.FORMAT
		ByteArrayOutputStream ostream = new ByteArrayOutputStream()
		
		Bounds bounds = new Bounds(
			*( bbox?.split( ',' )?.collect { it.toDouble() } ),
			srs
		)
		
		Shapefile borders = new Shapefile( 'world_adm0.shp' )
		
		borders.style = fill( opacity: 0 ) + stroke( color: 'blue' )
		
		GeoScriptMap map = new GeoScriptMap(
			width: width,
			height: height,
			bounds: bounds,
			proj: bounds.proj,
			layers: [
				borders
			]
		)
		
		map.render( ostream )
		map.close()

//		BufferedImage image = new BufferedImage( width, height, BufferedImage.TYPE_INT_ARGB )
//		Graphics2D g2d = image.createGraphics()
//
//		g2d.color = Color.blue
//		g2d.drawRect( 0, 0, width - 1, height - 1 )
//		g2d.dispose()
//
//		ImageIO.write( image, format?.split( '/' )?.last(), ostream )
		
		
		[ contentType: format, file: ostream.toByteArray() ]
	}
}
