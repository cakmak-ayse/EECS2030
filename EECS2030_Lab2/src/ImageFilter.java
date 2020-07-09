
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

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
public class ImageFilter extends JFrame implements ActionListener {
	private String fileName;
	private BufferedImage image;
	private JButton blurButton, sharpenButton;
	private JLabel sourceImageLabel, resultImageLabel;
	private JTextField sigmaField;
	private JPanel sourcePanel, middlePanel, resultPanel, blurPanel, sharpenPanel;
//	private double[] kernel1D = { 0.006, 0.061, 0.242, 0.383, 0.242, 0.061, 0.006 }; // sigma = 1;

//	private double [] kernel1D3 = {0.063327,	0.093095,	0.122589,	0.144599,	0.152781,	0.144599,	0.122589,	0.093095,	0.063327}; //sigma = 3
//
//	private double [] kernel1D5 = {0.034619,	0.044859,	0.055857,	0.066833,	0.076841,	0.084894,	0.090126,	0.09194,	0.090126,	
//	0.084894, 0.076841,	0.066833,	0.055857,	0.044859,	0.034619}; //sigma = 5

	/**
	 * @param fileName name of the image file to process loads the image with the
	 *                 filename provided
	 */
	public ImageFilter(String fileName) {
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
		String fileName = args[0]; // take the first argument
		for (int i = 0; i <= args.length - 1; i++) {
			if (args[i] != args[0]) {

				System.out.print("The number of argument is not 1");
			}
		}
		ImageFilter ex = new ImageFilter(fileName);
		ex.setVisible(true);
	}

	/*
	 * Title: Blurring and Sharpening source code (ImageFilter) 
	 * Author: Andriy Pavlovych 
	 * Date: 2020 
	 * Code Version: 
	 * Availability:
	 */

	/**
	 * Method implements Gaussian blurring
	 * 
	 * @param imageData array of image pixels
	 * @param width     image width
	 * @param sigma     parameter of the Gaussian distribution
	 */
	private void blur(int[] imageData, int width, double sigma) {
		final int MAX_KERNEL_SIZE = 15;
		double[] kernal1 = new double[MAX_KERNEL_SIZE];
		double kernelSum = 0;
		int height = imageData.length / width;

		for (int i = 0; i <= MAX_KERNEL_SIZE / 2; i++) {
			kernal1[MAX_KERNEL_SIZE / 2 + i] = Math.exp(-0.5 * ((Math.pow(i, 2) / (Math.pow(sigma, 2)))));
			kernal1[MAX_KERNEL_SIZE / 2 - i] = Math.exp(-0.5 * ((Math.pow(i, 2) / (Math.pow(sigma, 2)))));
		}
		for (int i = 0; i < MAX_KERNEL_SIZE; i++) {
			kernelSum += kernal1[i];
		}
		for (int i = 0; i < MAX_KERNEL_SIZE; i++) {
			kernal1[i] /= kernelSum;
		}
		System.out.println(Arrays.toString(kernal1));

		// Gaussian Blur: applying 1D convolution for the x-axis (horizontally)
		int[] result = new int[imageData.length];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int red = 0;
				int green = 0;
				int blue = 0;

				for (int k = 0; k < kernal1.length; k++) {
					int col = j + k - kernal1.length / 2;
					if (col < 0) {
						col = 0;
					}
					if (col >= width) {
						col = width - 1;
					}

					int imageIndex = i * width + col;
					red = (int) (kernal1[k] * ((imageData[imageIndex] & 0x00FF0000) >> 16));
					green = (int) (kernal1[k] * ((imageData[imageIndex] & 0x0000FF00) >> 8));
					blue = (int) (kernal1[k] * ((imageData[imageIndex] & 0x000000FF)));
					result[i * width + j] += red << 16 | green << 8 | blue;
				}
			}
		}
		System.arraycopy(result, 0, imageData, 0, imageData.length);

		// Gaussian Blur: applying 1D convolution for the y-axis (vertically)
		result = new int[imageData.length];
		for (int l = 0; l < width; l++) {
			for (int j = 0; j < height; j++) {
				int red = 0;
				int green = 0;
				int blue = 0;

				for (int k = 0; k < kernal1.length; k++) {
					int row = j + k - kernal1.length / 2;
					if (row < 0) {
						row = 0;
					}
					if (row >= height) {
						row = height - 1;
					}

					int imageIndex = row * width + l;
					red = (int) (kernal1[k] * ((imageData[imageIndex] & 0x00FF0000) >> 16));
					green = (int) (kernal1[k] * ((imageData[imageIndex] & 0x0000FF00) >> 8));
					blue = (int) (kernal1[k] * ((imageData[imageIndex] & 0x000000FF)));
					result[j * width + l] += red << 16 | green << 8 | blue;
				}
			}
		}
		System.arraycopy(result, 0, imageData, 0, imageData.length);
	}

	/**
	 * Method implements simple sharpening
	 * 
	 * @param imageData imageData array of image pixels
	 * @param width     image width
	 */
	private void sharpen(int[] imageData, int width) {
		// Sharpening: applying 2D convolution for the x-axis (horizontally) & y-axis (vertically)
		int height = imageData.length / width;
		float[][] matrixKernal = { { 0, -1, 0 }, { -1, 5, -1 }, { 0, -1, 0 } };
		int[] result = new int[imageData.length];

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int red = 0;
				int green = 0;
				int blue = 0;

				for (int k = 0; k < matrixKernal.length; k++) {
					for (int l = 0; l < matrixKernal.length; l++) {
						int row = i + k - matrixKernal.length / 2;
						if (row < 0) {
							row = 0;
						}
						if (row >= height) {
							row = height - 1;
						}

						int col = j + l - matrixKernal.length / 2;
						if (col < 0) {
							col = 0;
						} else if (col >= width) {
							col = width - 1;
						}

						int imageIndex = row * width + col;
						red += (int) (matrixKernal[k][l] * ((imageData[imageIndex] & 0x00FF0000) >> 16));
						green += (int) (matrixKernal[k][l] * ((imageData[imageIndex] & 0x0000FF00) >> 8));
						blue += (int) (matrixKernal[k][l] * ((imageData[imageIndex] & 0x000000FF)));
					}
				}

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
				result[i * width + j] = red << 16 | green << 8 | blue;
			}
		}
		System.arraycopy(result, 0, imageData, 0, imageData.length);
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
