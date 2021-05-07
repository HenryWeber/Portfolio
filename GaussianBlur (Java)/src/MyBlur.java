import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MyBlur {

	public MyBlur() {}
		
		public MyBlur blur;
		
		//------------------------------
		// Compute Kernel
		//------------------------------	
		public BufferedImage makeColor(BufferedImage source_image, int radius, double[][] weights, BufferedImage answer) {
			
			for(int i = 0; i < source_image.getWidth(); i++) {
				for(int j = 0; j < source_image.getHeight(); j++) {
				
				// Individual Color's for Kernel
				double[][] redKernel = new double[radius][radius];
				double[][] greenKernel = new double[radius][radius];
				double[][] blueKernel = new double[radius][radius];
				
				// Kernel Loop
				for(int tempX = 0; tempX < redKernel.length; tempX++) {
					for(int tempY = 0; tempY < weights[tempX].length; tempY++) {
						
						// Coordinate within Kernel
						int coordinateX = i + tempX - (weights.length/2);
						int coordinateY = j + tempY - (weights.length/2);
						
						//Check if X is out of Bounds
						if(coordinateX > source_image.getWidth() - 1) {
							int amountOutOfBounds = coordinateX - (source_image.getWidth()-1);
							coordinateX = source_image.getWidth() - amountOutOfBounds - 1;
						}
						//Check if Y is out of Bounds
						if(coordinateY > source_image.getHeight() - 1) {
							int amountOutOfBounds = coordinateY - (source_image.getHeight()-1);
							coordinateY = source_image.getHeight() - amountOutOfBounds - 1;
						}
						//Place In Bounds
						if(coordinateX < 0) {
							coordinateX = Math.abs(coordinateX);
						}
						if(coordinateY < 0) {
							coordinateY = Math.abs(coordinateY);
						}
						
						// Retrieve Weight
						double coordinateWeight = weights[tempX][tempY];
						// Retrieve Color's
						Color sampledColor =  new Color(source_image.getRGB(coordinateX, coordinateY));
						
						redKernel[tempX][tempY] = coordinateWeight* sampledColor.getRed();
						greenKernel[tempX][tempY] = coordinateWeight* sampledColor.getGreen();
						blueKernel[tempX][tempY] = coordinateWeight* sampledColor.getBlue();
						
					}
				}
				
				answer.setRGB(i, j, new Color(getWeightedColorValue(redKernel), 
						getWeightedColorValue(greenKernel),getWeightedColorValue(blueKernel)).getRGB());
			}
		}
			return answer;
		}
		
		//------------------------------
		// Get Weighted Color
		//------------------------------
		private int getWeightedColorValue(double[][] weightedColor) {
			double sum = 0;
			for(int i = 0; i < weightedColor.length; i++) {
					for(int j = 0; j < weightedColor.length; j++) {
						sum += (weightedColor[i][j]);
					}
			}
			return (int) sum;
		}
		//------------------------------
		// Generate Gaussian Image
		//------------------------------
		public BufferedImage generateGaussianImage(BufferedImage source_image, double weights[][], int radius) {
			System.out.println("generateGaussianImage");
			BufferedImage answer = new BufferedImage(source_image.getWidth(),source_image.getHeight(),BufferedImage.TYPE_INT_RGB);
			answer =  makeColor(source_image, radius, weights, answer);
			return answer;
		}

		//------------------------------
		// Gaussian Equation
		//------------------------------
		public double gaussianEquation(double x, double y, double variance) {
			return ( 1/( (2*Math.PI)* Math.pow(variance, 2) ) * Math.exp(- (Math.pow(x,2)+ Math.pow(y, 2) )/(2*Math.pow(variance, 2) ) ) );
		}
		//------------------------------
		// Generate Weighted Matrix
		//------------------------------
		public double[][] generateWeightedMatrix(int radius, double variance){
			
			System.out.println("generateWeightedMatrix");
			double[][] weights = new double[radius][radius];
			double sum = 0;
			
			for(int i = 0; i < weights.length; i++) {
				for(int j = 0; j < weights.length; j++) {
					weights[i][j] = gaussianEquation(i-radius /2,j-radius/2,variance);
					sum += weights[i][j];
				}
			}
			
			for(int i = 0; i < weights.length; i++) {
				for(int j = 0; j < weights.length; j++) {
					weights[i][j] /= sum;
				}
			}
			return weights;
		}
		
		
		
	}

