
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
//import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
//import java.util.ArrayList;
import java.util.Arrays;
//import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Andriy Pavlovych The class is meant to illustrate a couple of
 *         image-processing algorithms: Gaussian blurring and simple sharpening
 *         Java Swing is used to implement the GUI of the application
 *         Limitations: image sizes are limited by computer screen resolution
 *         (no scaling is implemented)
 */
@SuppressWarnings("serial")
public class ImageFilter1 extends JFrame implements ActionListener {
	private String fileName;
	private BufferedImage image;
	private JButton blurButton, sharpenButton;
	private JLabel sourceImageLabel, resultImageLabel;
	private JTextField sigmaField;
	private JPanel sourcePanel, middlePanel, resultPanel, blurPanel, sharpenPanel;
//	private double[] kernel1D = { 0.006, 0.061, 0.242, 0.383, 0.242, 0.061, 0.006 }; // sigma = 1;
	private double[][] kernel2D = { {}, { 0.006, 0.061, 0.242, 0.383, 0.242, 0.061, 0.006 }, {},
			{ 0.063327, 0.093095, 0.122589, 0.144599, 0.152781, 0.144599, 0.122589, 0.093095, 0.063327 }, // sigma = 3

			{}, { 0.034619, 0.044859, 0.055857, 0.066833, 0.076841, 0.084894, 0.090126, 0.09194, 0.090126, 0.084894,
					0.076841, 0.066833, 0.055857, 0.044859, 0.034619 } }; // sigma = 5

	/**
	 * @param fileName name of the image file to process loads the image with the
	 *                 filename provided
	 */
	public ImageFilter1(String fileName) {
		this.fileName = fileName;
		try {
			image = ImageIO.read(new File(fileName));
		} catch (IOException e) {
		}
		initUI();
	}

	private void initUI() {
		sourceImageLabel = new JLabel(new ImageIcon(fileName));

		resultImageLabel = new JLabel(new ImageIcon(image));

		sigmaField = new JTextField(4);
		sigmaField.setText("1.0");
		blurButton = new JButton("Blur");
		blurButton.setPreferredSize(new Dimension(84, 24));
		blurButton.addActionListener(this);
		sharpenButton = new JButton("Sharpen");
		sharpenButton.setPreferredSize(new Dimension(84, 24));
		sharpenButton.addActionListener(this);

		getContentPane().setLayout(new BorderLayout());
		sourcePanel = new JPanel();
		middlePanel = new JPanel();
		resultPanel = new JPanel();
		sourcePanel.setLayout(new BoxLayout(sourcePanel, BoxLayout.Y_AXIS));
		sourcePanel.add(new JLabel("Source"));
		sourcePanel.add(sourceImageLabel);
		add(sourcePanel, BorderLayout.WEST);

		middlePanel.setLayout(new BorderLayout(10, 10));

		blurPanel = new JPanel();
		blurPanel.setLayout(new FlowLayout(FlowLayout.TRAILING, 5, 5));
		blurPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		blurPanel.add(new JLabel("Sigma "));
		blurPanel.add(sigmaField);
		blurPanel.add(blurButton);

		sharpenPanel = new JPanel();
		sharpenPanel.setLayout(new FlowLayout(FlowLayout.TRAILING, 5, 5));
		sharpenPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		sharpenPanel.add(sharpenButton);
		middlePanel.add(new JLabel(" "), BorderLayout.NORTH);
		middlePanel.add(blurPanel, BorderLayout.CENTER);
		middlePanel.add(sharpenPanel, BorderLayout.SOUTH);
		add(middlePanel, BorderLayout.CENTER);

		resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
		resultPanel.add(new JLabel("Result"));
		resultPanel.add(resultImageLabel);
		add(resultPanel, BorderLayout.EAST);

		pack();
		setTitle("ImageFilter");
		setLocationRelativeTo(null); // place in the centre of the screen
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		String fileNam = args[0]; // take the first argument
		// TODO notify the user if the number of arguments is not equal to 1
		// if(fileNam == args[1]) {

		// }
		// TODO remove the line below to enable reading the file from an argument
		// fileName = "flower.png";

		ImageFilter ex = new ImageFilter(fileNam);
		ex.setVisible(true);
	}

	/**
	 * Method implements Gaussian blurring
	 * 
	 * @param imageData array of image pixels
	 * @param width     image width
	 * @param sigma     parameter of the Gaussian distribution
	 */

	private void blur(int[] imageData, int width, double sigma) {
		int kernalSize = (this.kernel2D[(int) sigma].length) / 2;
		int size = 2 * kernalSize + 1;
		double[] kernal = new double[size];
		int limit = kernalSize;
		// TODO your task is to replace this stub code with the proper implementation of
		// the method

		// calculate kernal
		double twoSigmaSqr = -1 / (2 * sigma * sigma);
		double oneOver2PiSigma = 1 / (sigma * (Math.sqrt(2 * Math.PI)));
		double guassSum = 0;
		int index = 0;

		for (int i = -kernalSize; i <= kernalSize; i++) {
			double range = i * i;
			double expo = range * twoSigmaSqr;
			kernal[index] = oneOver2PiSigma * Math.pow(Math.E, expo);
			guassSum += kernal[index];
			index++;
		}
		for (int i = 0; i < kernal.length; i++) {
			kernal[i] /= guassSum;
		}
		System.out.print("image1D " + Arrays.toString(kernal));
		// calculate kernal

		// create a temporary array to store the result
		int[] resultImageData = new int[imageData.length];
		int height = image.getHeight();
		// apply convolution in one dimension
		for (int x = 0; x < height; x++) {
			for (int y = 0; y < width; y++) {
				for (int k = -limit; k <= limit; k++) {
					int imageColumnIndex = y + k;
					if (imageColumnIndex < 0)
						imageColumnIndex = 0;
					if (imageColumnIndex >= width)
						imageColumnIndex = width - 1;
					int imageDataIndex = x * width + imageColumnIndex;
					int red, green, blue;
					red = (int) (kernal[(k + limit)] * ((imageData[imageDataIndex] & 0x00FF0000) >> 16));
					green = (int) (kernal[(k + limit)] * ((imageData[imageDataIndex] & 0x0000FF00) >> 8));
					blue = (int) (kernal[(k + limit)] * (imageData[imageDataIndex] & 0x000000FF));
					resultImageData[x * width + y] += red << 16 | green << 8 | blue;
				}
			}
		}
		// store the result back to the original array
		System.arraycopy(resultImageData, 0, imageData, 0, imageData.length);

		resultImageData = new int[imageData.length];
		// repeat for the other dimension
		for (int y = 0; y < width; y++) {
			for (int x = 0; x < height; x++) {
				for (int k = -limit; k <= limit; k++) {
					int imageRowIndex = x + k;
					if (imageRowIndex < 0)
						imageRowIndex = 0;
					if (imageRowIndex >= height)
						imageRowIndex = height - 1;
					int imageDataIndex = imageRowIndex * width + y;
					int red, green, blue;
					red = (int) (kernal[(k + limit)] * ((imageData[imageDataIndex] & 0x00FF0000) >> 16));
					green = (int) (kernal[(k + limit)] * ((imageData[imageDataIndex] & 0x0000FF00) >> 8));
					blue = (int) (kernal[(k + limit)] * ((imageData[imageDataIndex] & 0x000000FF)));
					resultImageData[x * width + y] += red << 16 | green << 8 | blue;
				}
			}
		}
		// store the result back to the original array
		System.arraycopy(resultImageData, 0, imageData, 0, imageData.length);

	}

	/**
	 * Method implements simple sharpening
	 * 
	 * @param imageData imageData array of image pixels
	 * @param width     image width
	 */
	private void sharpen(int[] imageData, int width) {
		// TODO your task is to replace this stub code with the proper implementation of
		// the method
		// Currently, it demonstrates how to extract RGB pixel values from the image and
		// how to write them them back

		float[][] kernal2Ddata = { { 0, -1, 0 }, { -1, 5, -1 }, { 0, -1, 0 } };
		int limit = kernal2Ddata.length / 2;
		int[] resultImageData = new int[imageData.length];
		int height = image.getHeight();
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int red = 0, green = 0, blue = 0;
				for (int k = -limit; k <= limit; k++) {
					for (int m = -limit; m <= limit; m++) {

						// Row
						int imageRowIndex = i + k;
						if (imageRowIndex < 0) {
							imageRowIndex = 0;
						} else if (imageRowIndex >= height) {
							imageRowIndex = height - 1;
						}

						// Column
						int imageColumnIndex = j + k;
						if (imageColumnIndex < 0) {
							imageColumnIndex = 0;
						} else if (imageColumnIndex >= width) {
							imageColumnIndex = width - 1;
						}

						int imageDataIndex = imageRowIndex * width + imageColumnIndex;
						// do some operations

						red += (int) (kernal2Ddata[k + limit][m + limit]
								* ((imageData[imageDataIndex] & 0x00FF0000) >> 16));
						green += (int) (kernal2Ddata[k + limit][m + limit]
								* ((imageData[imageDataIndex] & 0x0000FF00) >> 8));
						blue += (int) (kernal2Ddata[k + limit][m + limit] * (imageData[imageDataIndex] & 0x000000FF));
					}
				}
				// then store the result back
				if (red < 0) {
					red = 0;
				}
				if (green < 0) {
					green = 0;
				}
				if (blue < 0) {
					blue = 0;
				}
				if (red > 255) {
					red = 255;
				}
				if (green > 255) {
					green = 255;
				}
				if (blue > 255) {
					blue = 255;
				}
				resultImageData[i * width + j] = red << 16 | green << 8 | blue;
			}
		}
		System.arraycopy(resultImageData, 0, imageData, 0, imageData.length);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == blurButton) {
			int[] rgbData = image.getRGB(0, 0, image.getWidth(), image.getHeight(), null, 0, image.getWidth());
			blur(rgbData, image.getWidth(), Double.parseDouble(sigmaField.getText()));
			image.setRGB(0, 0, image.getWidth(), image.getHeight(), rgbData, 0, image.getWidth());
			resultImageLabel.setIcon(new ImageIcon(image));

		} else if (e.getSource() == sharpenButton) {
			int[] rgbData = image.getRGB(0, 0, image.getWidth(), image.getHeight(), null, 0, image.getWidth());
			sharpen(rgbData, image.getWidth());
			image.setRGB(0, 0, image.getWidth(), image.getHeight(), rgbData, 0, image.getWidth());
			resultImageLabel.setIcon(new ImageIcon(image));
		}
	}

}
