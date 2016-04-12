package guimodule;

import processing.core.PApplet;
import processing.core.PImage;

public class MyDisplay extends PApplet{
	PImage img;

	public void setup()
	{
		size(400, 400);		// set canvas size
		background(255, 255, 255);		// set canvas color
		stroke(0);		// set pen color
		img = loadImage("F:/coursera/Java Programming/beach.jpg", "jpg");
		img.resize(0,  height);      // resize loaded image to full height of canvas
		image(img, 0, 0);
	}
	
	public void draw()
	{
		// Add drawing code for MyPApplet
		int[] color = sunColorSec(second());		// calculate color code for sun
		fill(color[0], color[1], color[2]);
		ellipse(width/4, height/5, width/4, height/5);		// draw sun
	}
	
	public int[] sunColorSec(float seconds)
	{
		int[] rgb = new int[3];
		// scale the brightness of the yellow based on the second. 0 seconds
		// is black. 30 seconds is bright yellow.
		float diffFrom30 = Math.abs(30-seconds);
		
		float ratio = diffFrom30 / 30;
		rgb[0] = (int)(255 * ratio);
		rgb[1] = (int)(255 * ratio);
		rgb[2] = 0;
		
		System.out.println("R:" + rgb[0] + " G:" + rgb[1] + " B:" + rgb[2]);
		return rgb;
	}
}
