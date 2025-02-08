package edu.sdmesa.cisc191;

import java.awt.Color;

import edu.gatech.cc.DigitalPicture;
import edu.gatech.cc.Pixel;
/**
 * Lead Author(s):
 * 
 * @author Jade Dunne
 * 
 * References:
 *         Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 *         Retrieved from
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 * Version/date:
 * @version 001
 * 02/08/2025
 * 
 * Responsibilities of class:
 * To alter images pixel by pixel
 * 
 */
public class Logic
{

	/**
	 * Alters the picture so that each pixel's blue channel has been zeroed out. All
	 * other channels remain the same
	 * 
	 * @param picture the image to be altered
	 */
	public static void zeroBlue(DigitalPicture picture)
	{

		Pixel[][] pixel2D = picture.getPixels2D();
		for (int r = 0; r < pixel2D.length; r++)
		{
			for (int c = 0; c < pixel2D[r].length; c++)
			{
				pixel2D[r][c].setBlue(0);
			}
		}

	}


	/**
	 * Alters the picture so that is is black and white by setting each pixels color value to be the average
	 * of the pixels red, green, and blue channel. 
	 * @param picture,  the image to be altered
	 */
	public static void blackAndWhite(DigitalPicture picture) 
	{
		Pixel[][] pixel2D = picture.getPixels2D();
		for (int r = 0; r < pixel2D.length; r++)
		{
			for (int c = 0; c < pixel2D[r].length; c++)
			{
				int red = pixel2D[r][c].getRed();
				int blue = pixel2D[r][c].getBlue();
				int green = pixel2D[r][c].getGreen();
				
				int val = (red + blue + green) / 3;
				
				pixel2D[r][c].setRed(val);
				pixel2D[r][c].setGreen(val);
				pixel2D[r][c].setBlue(val);
			}
		}
	}

	/**
	 * Alters the picture so that each pixel's value becomes negative
	 * 
	 * @param picture the image to be altered
	 */
	public static void negative(DigitalPicture picture)
	{

		Pixel[][] pixel2D = picture.getPixels2D();
		for (int r = 0; r < pixel2D.length; r++)
		{
			for (int c = 0; c < pixel2D[r].length; c++)
			{
				int red = (255 - pixel2D[r][c].getRed());
				int blue = (255 - pixel2D[r][c].getBlue());
				int green = (255 - pixel2D[r][c].getGreen());
				
				pixel2D[r][c].setRed(red);
				pixel2D[r][c].setGreen(green);
				pixel2D[r][c].setBlue(blue);
			}
		}
	}
	
	/**
	 * Alters the picture so that each pixel's value becomes negative
	 * 
	 * @param picture the image to be altered, amount to increase red, amount to reduce green/blue
	 */
	public static void makeSunset(DigitalPicture picture, double redIntensity, double greenBlueReduction)
	{

		Pixel[][] pixel2D = picture.getPixels2D();
		for (int r = 0; r < pixel2D.length; r++)
		{
			for (int c = 0; c < pixel2D[r].length; c++)
			{
				double red = (redIntensity * pixel2D[r][c].getRed());
				double green = (greenBlueReduction * pixel2D[r][c].getGreen());
				double blue = (greenBlueReduction * pixel2D[r][c].getBlue());
				
				pixel2D[r][c].setRed((int) red);
				pixel2D[r][c].setGreen((int) green);
				pixel2D[r][c].setBlue((int) blue);
			}
		}
	}
	
	/**
	 * Alters the picture so that the pixel values are flipped on the y-axis
	 * 
	 * @param picture the image to be altered
	 */
	public static void mirrorHorizontal(DigitalPicture picture)
	{
		Pixel[][] pixel2D = picture.getPixels2D();
		int rowLength = pixel2D[0].length;
		int mirrorPoint = (rowLength / 2);
		for (int r = 0; r < pixel2D.length; r++)
		{
			for (int c = 0; c < mirrorPoint ; c++)
			{
				// Get new column calculation
				int newC = rowLength - 1 - c;
				
				// Get left side values
				int leftRed = pixel2D[r][c].getRed();
				int leftGreen = pixel2D[r][c].getGreen();
				int leftBlue = pixel2D[r][c].getBlue();
				
				// Get right side values
				int rightRed = pixel2D[r][newC].getRed();
				int rightGreen = pixel2D[r][newC].getGreen();
				int rightBlue = pixel2D[r][newC].getBlue();
				
				// Set left pixels
				pixel2D[r][c].setRed(rightRed);
				pixel2D[r][c].setGreen(rightGreen);
				pixel2D[r][c].setBlue(rightBlue);
				
				// Set right pixels
				pixel2D[r][newC].setRed(leftRed);
				pixel2D[r][newC].setGreen(leftGreen);
				pixel2D[r][newC].setBlue(leftBlue);
			}
		}
	}
	
	/**
	 * Alters the picture so that the pixel values are flipped on the x-axis
	 * 
	 * @param picture the image to be altered
	 */
	public static void mirrorVertical(DigitalPicture picture)
	{
		Pixel[][] pixel2D = picture.getPixels2D();
		int columnHeight = pixel2D.length;
		int mirrorPoint = (columnHeight / 2);
		for (int c = 0; c < pixel2D.length; c++)
		{
			for (int r = 0; r < mirrorPoint ; r++)
			{
				// Get new row calculation
				int newR = columnHeight - 1 - r;
				
				// Get top values
				int topRed = pixel2D[r][c].getRed();
				int topGreen = pixel2D[r][c].getGreen();
				int topBlue = pixel2D[r][c].getBlue();
				
				// Get bottom values
				int bottomRed = pixel2D[newR][c].getRed();
				int bottomGreen = pixel2D[newR][c].getGreen();
				int bottomBlue = pixel2D[newR][c].getBlue();
				
				// Set top pixels
				pixel2D[r][c].setRed(bottomRed);
				pixel2D[r][c].setGreen(bottomGreen);
				pixel2D[r][c].setBlue(bottomBlue);
				
				// Set bottom pixels
				pixel2D[newR][c].setRed(topRed);
				pixel2D[newR][c].setGreen(topGreen);
				pixel2D[newR][c].setBlue(topBlue);
			}
		}
	}
	
	/**
	 * Alters the picture so that each top left pixel in a 2x2 grid is the average of the pixels
	 *  in the 2x2 grid in order to create a blur effect
	 * 
	 * @param picture the image to be altered
	 */
	public static void blur(DigitalPicture picture)
	{

		Pixel[][] pixel2D = picture.getPixels2D();
		for (int r = 0; r < pixel2D.length - 1; r++)
		{
			for (int c = 0; c < pixel2D[r].length - 1; c++)
			{
				// Top Left pixel values
				int TLred = pixel2D[r][c].getRed();
				int TLgreen = pixel2D[r][c].getGreen();
				int TLblue = pixel2D[r][c].getBlue();
				
				// Top Right pixel values
				int TRred = pixel2D[r][c + 1].getRed();
				int TRgreen = pixel2D[r][c + 1].getGreen();
				int TRblue = pixel2D[r][c + 1].getBlue();
				
				// Bottom Left pixel values
				int BLred = pixel2D[r + 1][c].getRed();
				int BLgreen = pixel2D[r + 1][c].getGreen();
				int BLblue = pixel2D[r + 1][c].getBlue();
				
				// Bottom Right pixel values
				int BRred = pixel2D[r + 1][c + 1].getRed();
				int BRgreen = pixel2D[r + 1][c + 1].getGreen();
				int BRblue = pixel2D[r + 1][c + 1].getBlue();
				
				int newRed = (TLred + TRred + BLred + BRred) / 4;
				int newGreen = (TLgreen + TRgreen + BLgreen + BRgreen) / 4;
				int newBlue = (TLblue + TRblue + BLblue + BRblue) / 4;
				
				// Set reds
				pixel2D[r][c].setRed(newRed);
				
				// Set greens
				pixel2D[r][c].setGreen(newGreen);
				
				// Set blues
				pixel2D[r][c].setBlue(newBlue);
			}
		}
	}
}
