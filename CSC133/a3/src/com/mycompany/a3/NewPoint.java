package com.mycompany.a3;

import java.util.Random;

import com.codename1.ui.geom.Point;

public class NewPoint extends Point{
	
	static Random rand = new Random();
	
	public NewPoint(int x, int y) {
		super(x, y);
	}
	//Method to create valid random location
	public static Point validRandomLocation(Point max, int size) {
        int tempX = 0;
        int tempY = 0;
        double maxX = max.getX();
        double maxY = max.getY();
        boolean outOfRange = true;

        while (outOfRange) {
            tempX = (rand.nextInt((int) maxX));
            tempY = (rand.nextInt((int) maxY));
            if (tempX + (size / 2) > maxX || tempX - (size / 2) < 50
                    || tempY + (size / 2) > maxY || tempY - (size / 2) < 50) {
                outOfRange = true;
            } else {
                outOfRange = false;
            }
        }
            return new Point(tempX, tempY);
    }


}
