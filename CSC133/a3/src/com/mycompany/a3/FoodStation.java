package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class FoodStation extends FixedGameObject {
	
	private int capacity;
	private int size;
	private GameWorld gw;
	private boolean empty;;
	
	public FoodStation(GameWorld gw) {
		
		super();
		this.gw = gw;
		setSize((50) + getRandom(5));
		setColor(255, 255, 0); //Yellow
		size = getSize();
		setCapacity(size);
		empty = false;
		
	}
	/**
	 * Method to check if food
	 * station is empty
	 * @return
	 */
	public boolean isEmpty() {
		
		return empty;
	}
	//Method to verify empty food station
	public void emptyVerified() {
	
		empty = true;
	}
	/**
	 * Method to request capacity
	 * 
	 * @return capacity
	 */
	public int getCapacity() {
		
		return capacity;
	}
	/**
	 * Method to set capacity
	 * 
	 * @param cap
	 */
	public void setCapacity(int cap) {
		
		capacity = cap;
	}
	/**
	 * Method to override toString
	 */
	public String toString() {
		
		String supString = super.toString();
		String value = " size= " + getSize() + " capacity= " + capacity;
		
		String concValue = "FoodStation: " + supString + value;
		
		return concValue;
	}
	//Method to draw food station object on component
	public void draw(Graphics g, Point pCmpRelPrnt) {
		
		g.setColor(super.getColor());
		int xLoc = (int)this.getLocation().getX() + pCmpRelPrnt.getX() ;
		int yLoc = (int)this.getLocation().getY() + pCmpRelPrnt.getY();	
		if (super.isSelected())
			g.drawRect(xLoc, yLoc, this.getSize(),this.getSize());
		else
			g.fillRect(xLoc, yLoc, this.getSize(),this.getSize());
		g.setColor(ColorUtil.rgb(0, 0, 0));
		g.drawString("" + this.capacity, xLoc + 10, yLoc + 15);
	}

	//Method to handle collision between objects

	public void handleCollision(GameObject otherObject) {
		
		if(this instanceof FoodStation && otherObject instanceof Ant) {
			gw.foodCollision(this);
		}
		
	}

}
