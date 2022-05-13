package com.mycompany.a3;

import com.codename1.ui.geom.Point;

public abstract class MovableGameObject extends GameObject{
	
	private int objectSpeed = 0;
	private int objectDirection;
	private int size;
	
	public MovableGameObject() {
	
		setSpeed(getRandom(5) + 5);
		setDirection(getRandom(359));
	
	}
	/**
	 * Method to move all movable objects in game
	 */
	public void moveNew(long elapsedTime, Point maxLocation) {
		
		Point newLocation = new Point(0, 0);
		
		double oldX = getLocation().getX();
		double oldY= getLocation().getY();
		double newX, newY;
		
		int time = Math.round(elapsedTime/60L);
        newX = Math.cos(Math.toRadians(getDirection())) * getSpeed() * time;
        newY = Math.sin(Math.toRadians(getDirection())) * getSpeed() * time;
        double addX = Math.round((newX + oldX) * 10.0) / 10.0;
        double addY = Math.round((newY + oldY) * 10.0) / 10.0;


        if (addX < 0) {
            objectDirection = 180 - getDirection();
        }
        if (addX > maxLocation.getX()) {
            objectDirection = 180 - getDirection();
        }
        if (addY < 0) {
            objectDirection = 360 - getDirection();
        }
        if (addY > maxLocation.getY()) {
            objectDirection = 360 - getDirection();
        }

        setDirection(objectDirection);
        newLocation.setX((int) addX);
        newLocation.setY((int) addY);
        super.setLocation(newLocation);
		
	}
	//Method to set size
	public void setSize(int i) {
		
		size = i;
	}
	//Method to get size
	public int getSize() {
		
		return size;
	}
	/**
	 * Method to set object speed
	 * 
	 * @param x
	 */
	public void setSpeed(int x) {
		
		this.objectSpeed = x;
	}
	/**
	 * Method to request object speed
	 * 
	 * @return objectSpeed
	 */
	public int getSpeed() {
		
		return this.objectSpeed;
	}
	/**
	 * Method to request object direction
	 * 
	 * @return objectDirection
	 */
	public int getDirection() {
		
		return this.objectDirection;
	}
	/**
	 * Method to set object direction
	 * 
	 * @param x
	 */
	public void setDirection(int dir) {
		
		  while (dir < 0) {
	            dir += 360;
	        }
	        dir %= 360;
	        this.objectDirection = dir;
		
	}
	/**
	 * Method to override toString
	 */
	public String toString() {
		
		String supString = super.toString();
		String value = " heading= " + getDirection() 
		+ " speed= " + getSpeed();
		
		String concValue = supString + value;
	
		return concValue;
	}
}
