package petter.bjelm;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

public class GetImgFromURL {

	public GetImgFromURL() {

	};
	
	public BufferedImage getURLImage(String imgURL, int imgX, int imgY) {
		BufferedImage image = null;
		try {
			URL url = new URL(imgURL);
			image = ImageIO.read(url);
//			resized = new BufferedImage(imgX, imgY, image.getType());
//            Graphics2D g = resized.createGraphics();
//            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//            g.drawImage(image, 0, 0, imgX, imgY, 0, 0, image.getWidth(), image.getHeight(), null);
//            g.dispose();
		} catch (Exception exp) {
//			exp.printStackTrace();
//			resized = null;
		}
		return image;
	};
}
