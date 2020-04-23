package mapviewer

import java.awt.Color
import java.awt.Graphics2D
import java.awt.image.BufferedImage
import javax.imageio.ImageIO

class TileRendererService
{
	def getTile( Map<String, Object> params )
	{
		println params
		
		int width = params.WIDTH as int
		int height = params.HEIGHT as int
		String format = params.FORMAT
		
		BufferedImage image = new BufferedImage( width, height, BufferedImage.TYPE_INT_ARGB )
		ByteArrayOutputStream ostream = new ByteArrayOutputStream()
		Graphics2D g2d = image.createGraphics()
		
		g2d.color = Color.blue
		g2d.drawRect( 0, 0, width - 1, height - 1 )
		g2d.dispose()
		
		ImageIO.write( image, format?.split( '/' )?.last(), ostream )
		
		[ contentType: format, file: ostream.toByteArray() ]
	}
}
