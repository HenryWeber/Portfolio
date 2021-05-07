import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FileManager {
		
		static BufferedImage source_image = null;
		static BufferedImage blurred_image = null;
		static InputWindow input;
		
		
		public FileManager(InputWindow window) {
			input = window;
		}
		
		public static void performTasks(String str, double[][] weights) {
			MyBlur b = new MyBlur();
			
			try {
			source_image = ImageIO.read(new File(str));
			blurred_image = b.generateGaussianImage(source_image, weights, 31);
			
			ImageIO.write(source_image, "PNG", new File("original_image.png"));//1
			ImageIO.write(blurred_image, "PNG", new File("blurred_image.png"));//2
			
			}catch (IOException e) {
				
				e.printStackTrace();
			}
			finally {
				input.addImages();
				
			}
		}
	
}