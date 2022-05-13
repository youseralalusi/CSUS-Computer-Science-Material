package com.mycompany.a3;

import java.util.Random;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point;

public abstract class GameObject implements IDrawable, ICollider {
	
	private double locationX;
	private double locationY;
	private int rgb;
	private int size;
	private Point location;
	
	
	public GameObject() {
		
		this.setLocationX(getRandom(1000));
		this.setLocationY(getRandom(1000));
		
		int x = (int) (Math.round(getRandom(1000) * 10.0) / 10.0);
		int y = (int) (Math.round(getRandom(1000) * 10.0) / 10.0);
		
		location = new Point(x,y);
			
	}
	/**
	 * Method to return point location
	 * 
	 * @return location
	 */
	public Point getLocation() {
		
		return location;
	}
	/**
	 * Method to set x-coordinate
	 * 
	 * @param locX
	 */
	public void setLocationX(double locX) {
		
		locationX = locX;
		
	}
	/**
	 * Method to set y-coordinate
	 * 
	 * @param locY
	 */
	public void setLocationY(double locY) {
		
		locationY = locY;
		
	}
	/**
	 * Method to set Point location
	 * 
	 * @param loc
	 */
	public void setLocation(Point loc) {
		
		setLocationX((float) ((Math.round(loc.getX()) * 10.0) / 10.0));
		setLocationY((float) ((Math.round(loc.getY()) * 10.0) / 10.0));
		location = new Point((int)locationX, (int)locationY);
	}
	/**
	 * Method to request x-location
	 * 
	 * @return locationX
	 */
	public double getLocationX() {
		
		return locationX;
	}
	/**
	 * Method to request y-location
	 * 
	 * @return locationY
	 */
	public double getLocationY() {
		
		return locationY;
	}
	/**
	 * Method to produce random number
	 * 
	 * @param num
	 * @return
	 */
	public int getRandom(int num) {
		
		Random random = new Random();
		return random.nextInt(num);
	}
	/**
	 * Method to request color
	 * 
	 * @return rgb
	 */
	public int getColor() {
		 
		return rgb;
	}
	/**
	 * Method to set rgb color
	 * 
	 * @param r
	 * @param g
	 * @param b
	 */
	public void setColor(int r, int g, int b) {
		
		this.rgb = ColorUtil.rgb(r, g, b);
		
	}
	/**
	 * Method to request size of object
	 * 
	 * @return size
	 */
	public int getSize() {
		
		return size;
	}
	//Method to check collision between two objects
	
	public boolean collidesWith(GameObject otherObject) {
		boolean result = false;
		double thisCenterX = this.getLocationX() + (otherObject.size/2);
		double thisCenterY = this.getLocationY()+ (otherObject.size/2);
		
		double otherCenterX = otherObject.getLocationX();
		double otherCenterY = otherObject.getLocationY();
		
		double dx = thisCenterX - otherCenterX;
		double dy = thisCenterY - otherCenterY;
		double distBetweenCentersSqr = (dx * dx + dy * dy);
		
		int thisRadius= this.getSize() / 2;
		int otherRadius= otherObject.getSize() / 2;
		int radiiSqr= (thisRadius * thisRadius + 2 * thisRadius * otherRadius + otherRadius * otherRadius);
		
		if (distBetweenCentersSqr <= radiiSqr) { 
			result = true;
		}
			return result;
		
	}
	
	/**
	 * Method to override toString
	 */
	public String toString() {
		
		String value = 
				"Loc= " + getLocationX() + ", " + getLocationY()
				+ " Color= [" + ColorUtil.red(rgb) + "," + ColorUtil.green(rgb) + "," 
				+ ColorUtil.blue(rgb) + "]";
		
		return value;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	

}

