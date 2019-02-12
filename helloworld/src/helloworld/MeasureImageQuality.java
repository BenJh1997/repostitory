package helloworld;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MeasureImageQuality {

	public static void main(String[] args) {
	
		ImageFileHandler img_handler = new ImageFileHandler();
		
		BufferedImage org_image = img_handler.readFile("H:\\image\\house_org.jpg");
		BufferedImage compressed_image = img_handler.readFile("H:\\image\\house_org_compressed.jpg");
	}
	
	
	public void displayImage(BufferedImage img) {
		//displaying an image
		
		BufferedImage rescaledImage = resize(img, img.getWidth()/4, img.getHeight()/4);
		JLabel picLabel = new JLabel(new ImageIcon(rescaledImage));
		
		JPanel jPanel = new JPanel();
		jPanel.add(picLabel);
		
		JFrame frame = new JFrame();
		frame.setSize(new Dimension(rescaledImage.getWidth(),
				rescaledImage.getHeight()));
	}
	public static BufferedImage resize(BufferedImage img, int newW, int newH) {
		
		java.awt.Image tmp = img.getScaledInstance(newW, newH, java.awt.Image.SCALE_SMOOTH);
		BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB );
		
		Graphics2D g2d = dimg.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();
		
		return dimg;
	}
	
//	//for(int y = 0; y < org_image.getHeight(); y++) {
//		for(int x = 0; x < org_image.getWidth(); x++) {
//			
//			int rgbvalue_org = org_image.getRGB(x, y);
//			
//			int alpha = (rgbvalue_org >> 24) & 0xff;
//			int red = (rgbvalue_org >> 16) & 0xff;
//			int green = (rgbvalue_org >> 8) & 0xff;
//			int blue = (rgbvalue_org) & 0xff;
//			
//			
//			int grayscale_org = (int) ((0.3 *red) + (0.59 * green) + (0.11 * blue));
//			
//			
//			int rgbvalue_compressed = compressed_image.getRGB(x, y);
//			
//			alpha = (rgbvalue_compressed >> 24) & 0xff;
//			red = (rgbvalue_compressed >> 16) & 0xff;
//			green = (rgbvalue_compressed >> 8) & 0xff;
//			blue = (rgbvalue_compressed) & 0xff;
//			
//			int grayscale_compressed = (int) ((0.3 *red) + (0.59 * green) + (0.11 * blue));
//			
//			squared_sum += (Math.pow((grayscale_org - grayscale_compressed), 2));
//		}
	}
	
	
	
