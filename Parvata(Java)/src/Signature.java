import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class Signature {

	Layout layout;
	int inputPageOffset, outputPageOffset;
	InputPage inputPages[];
	OutputPage[] outputPages;
	int test = 0;

	public Signature(Layout layout, int inputPageOffset, int outputPageOffset) {
		this.layout = layout;
		/////////////////
//		layout.layoutArray = new String[][] { { "5u", "12u", "4", "33" }, { "11u", "6u", "14", "3" },
//				{ "7u", "10u", "2", "15" }, { "9u", "8u", "16", "1" } };
//		layout.inputPageCount = 16;
//		layout.outputPageCount = 4;
		/////////////////
		this.inputPageOffset = inputPageOffset;
		this.outputPageOffset = outputPageOffset;
		inputPages = new InputPage[layout.getLayout().length * layout.getLayout()[0].length];
		outputPages = new OutputPage[layout.getInputPageCount()];
		String numberString = "";
		for (int i = 0; i < layout.getInputPageCount(); i++) {
			numberString = String.format("%04d", i + inputPageOffset);
			inputPages[i] = new InputPage("input-" + numberString + ".png");
		}
		inputPages[0].load();
	}

	public void impose() {

		int inputPagesPerOutputPages = layout.getLayout()[0].length;
		// int outputRows = layout.getOutputPageRows();
		// int outputCols = layout.getOutputPageCols();
		int outputRows = 2;
		int outputCols = 2;
		String numberString = "";

		for (int i = 0; i < layout.getLayout().length; i++) {
			// for each output page

			// initialize the output page
			numberString = String.format("%04d", i);
			outputPages[i] = new OutputPage("output-" + numberString + ".png", outputCols * inputPages[0].getWidth(),
					outputRows * inputPages[0].getHeight());
			Graphics g = outputPages[i].pageImage.getGraphics();
//			for (int j = 0; j < layout.getLayout()[i].length; j++) {
				// for each input page

				// get the index of the next input page

				// render the input page
				// g.drawImage(inputPages[pageIndex].pageImage, inputPages[pageIndex].getWidth()
				// * (j % outputCols), inputPages[pageIndex].getHeight() * (j % outputRows),
				// null);

				for (int x = 0; x < outputRows; x++) {
					// for each row
					for (int z = 0; z < outputCols; z++) {
						// for each column
						String iPage = layout.getLayout()[i][x * outputRows + z];
						float rotation = 0;
						System.out.println(iPage);
						if (iPage.substring(iPage.length() - 1).compareTo("u") == 0) {
							// the page needs to be upsidedown
							rotation = 180;
							iPage = iPage.substring(0, iPage.length() - 1);
						}
						int pageIndex = Integer.parseInt(iPage) - 1;
						
						// load the input page
						inputPages[pageIndex].load();
						
						// flip image if necessary
						if(rotation == 180)
							inputPages[pageIndex].flipImage((byte)0b11);
						
						//render the input page to the output page
						g.drawImage(inputPages[pageIndex].pageImage, inputPages[pageIndex].getWidth() * z, inputPages[pageIndex].getHeight() * x, null);
					}
				}

				// unload the input page
//				inputPages[pageIndex].cleanup();

//			}
			// render the output page
			FileManager.saveImage(outputPages[i].pageImage, outputPages[i].fileLocation);

			// unload the output page
			outputPages[i].unload();
		}
	}

	class InputPage {

		BufferedImage pageImage = null;
		String fileLocation = "";

		public InputPage(String loc) {
			this.fileLocation = loc;
		}

		public void load() {
			try {
				pageImage = FileManager.loadImage(fileLocation);
			} catch (Exception e) {
				System.out.println("Failed to load inputpage");
				e.printStackTrace();
			}
		}

		public void cleanup() {
			pageImage = null;
			// delete the image file
			// todo
		}

		public void flipImage(byte axis) {
			// 0 -> no flip
			// 1 -> vertical flip
			// 2 -> horizontal flip
			// 3 -> both flip (equal to 180 degree rotation)

			int scaleHo = (((axis >> 1) % 2) == 1) ? -1 : 1;
			int scaleV = ((axis % 2) == 1) ? -1 : 1;

			int scaleWidth = -pageImage.getWidth() * ((axis >> 1) % 2);
			int scaleHeight = -pageImage.getHeight() * (axis % 2);

			AffineTransform tx = AffineTransform.getScaleInstance(scaleHo, scaleV);
			tx.translate(scaleWidth, scaleHeight);
			AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
			pageImage = op.filter(pageImage, null);
		}

		public int getHeight() {
			return pageImage.getHeight();
		}

		public int getWidth() {
			return pageImage.getWidth();
		}
	}

	class OutputPage {
		BufferedImage pageImage = null;
		String fileLocation = "";

		public OutputPage(String loc, int width, int height) {
			this.fileLocation = loc;
			pageImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		}

		public void renderPage() {
			FileManager.saveImage(pageImage, fileLocation);
		}

		public void unload() {
			pageImage = null;
		}
	}
}