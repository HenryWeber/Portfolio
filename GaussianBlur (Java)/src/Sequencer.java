import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sequencer {

	MyBlur blur = new MyBlur();
	
	public Sequencer() {}
	
	double[][] weights;
	
	public void run(String str, String str2, String str3) {
		
		int radius = Integer.parseInt(str2);
		int variance = Integer.parseInt(str3);
		
		weights = blur.generateWeightedMatrix(radius, variance);
		FileManager.performTasks(str, weights);
	}


}