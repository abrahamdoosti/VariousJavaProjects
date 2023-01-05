package com.example.main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

//Problem description: https://en.wikipedia.org/wiki/Sierpi%C5%84ski_triangle 
public class Application {

	public static void main(String[] args) {
		 createSierpinskiTriangle(1500);
		
	}

	public static void createSierpinskiTriangle(int length) {
		// image dimension
		int width = 2400;
		int height = 1800;

		// create buffered image object img
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		// file object
		File f = null;

		// create random image pixel by pixel

//				for (int y = 0; y < height; y++) {
//					for (int x = 0; x < width; x++) {
//						int a = (int) (Math.random() * 256);// alpha
//						int r = (int) (Math.random() * 256);// red
//						int g = (int) (Math.random() * 256);// green
//						int b = (int) (Math.random() * 256);// blue
//
//						int p = (a << 24) | (r << 16) | (g << 8) | b; // pixel
//						int p1 = (255 << 24) | (0 << 16) | (0 << 8) | 0;
//						img.setRGB(x, y, p1);
//
//					}
//				}
		Coordinate a = new Coordinate(0, 0);
		Coordinate b = new Coordinate((length / 2), (float)(length *(Math.sqrt(3) / 2)));
		Coordinate c = new Coordinate(length, 0);

		int p = (255 << 24) | (0 << 16) | (0 << 8) | 0;
		img.setRGB((int)(a.getX()), (int)(a.getY()), p);
		img.setRGB((int)(b.getX()), (int)(b.getY()), p);
		img.setRGB((int)(c.getX()), (int)(c.getY()), p);
		
		Coordinate newCoordinate = genRandPoint(a, b, c);
		img.setRGB((int)(newCoordinate.getX()), (int)(newCoordinate.getY()), p);
		Coordinate currentSelected = chooseFromThree(a, b, c);
		
		for (int i = 0; i < 10000000; i++) {
			newCoordinate = moveHalfWay(newCoordinate, currentSelected);
			img.setRGB((int)(newCoordinate.getX()),(int) (newCoordinate.getY()), p);
			currentSelected = chooseFromThree(a, b, c);
		}

		// write image
		try {
			//f = new File("output.jpg");
			f = new File("output.png");
			ImageIO.write(img, "png", f);
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}

	}

	private static Coordinate moveHalfWay(Coordinate a, Coordinate b) {
		float midX = (a.getX() + b.getX()) / 2;
		float midY = (a.getY() + b.getY()) / 2;

		return new Coordinate(midX, midY);

	}

	private static Coordinate genRandPoint(Coordinate a, Coordinate b, Coordinate c) {
		// TODO Auto-generated method stub
		//pick any coordinate within the triangle to start the iteration
		// The distance from point a to new point shouldn't be more 
		// than half side length of the triangle, otherwise the new point will be outside the triangle.
		int salt = new Random().nextInt((int)(b.getX()-a.getX()));
		return new Coordinate(a.getX()+salt,a.getY()+salt);
		//we could have used point b as reference too.
		//return new Coordinate(b.getX()-salt,b.getY()-salt); 
	}

	public static Coordinate chooseFromThree(Coordinate a, Coordinate b, Coordinate c) {
		int select = new Random().nextInt(3) + 1;

		switch (select) {
		case 1:
			return a;
		case 2:
			return b;
		case 3:
			return c;
		default:
			break;
		}
		return null;

	}

}

class Coordinate {
	private float x;
	private float y;

	public Coordinate() {

	}

	public Coordinate(float x, float y) {
		super();
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	

}
