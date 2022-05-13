package com.mycompany.a3;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.mycompany.a3.Ant;

public class Ant extends MovableGameObject {
	
	private int maxSpeed;
	private int foodConsumptionRate;
	private int directionNew;
	private static Ant theAnt;
	
	public Ant() {
		
		maxSpeed = 50;
		setSize(40);
		setColor(255, 0, 0); //Red
		setFoodConsumptionRate(1);
		setSpeed(0);
		setDirection(0);
	}
	
	//Singleton implementation
	public static Ant getTheAnt() {
		
		if(theAnt == null) 
			theAnt = new Ant();
		return theAnt;
	}
	//Resets the Ant location
	public void resetLocation() {
		
		setLocationX(0);
		setLocationY(0);
	}
	/*
	 * Method to set consumption rate
	 */
	public void setFoodConsumptionRate(int r) {
		
		foodConsumptionRate = r;
	}
	/*
	 * Method to get consumption rate
	 */
	public int getFoodConsumptionRate() {
		
		return foodConsumptionRate;
	}
	

	public void moveNew(long elapsedTime, Point maxLocation) {
		
		turn();
		super.moveNew(elapsedTime, maxLocation);
		
	}
	/**
	 * Method to override toString
	 */
	public String toString() {
		
		String supString = super.toString();
		String value = " size= " + getSize() + " maxSpeed= " + maxSpeed + 
				" foodConsumptionRate= " + foodConsumptionRate;
		
		String concValue = "Ant:    " + supString + value;
		
		return concValue;
	}

	public void draw(Graphics g, Point pCmpRelPrnt) {
		
		g.setColor(super.getColor());
		int x =  (int)this.getLocationX()+ pCmpRelPrnt.getX();
		int y =  (int)this.getLocationY()+ pCmpRelPrnt.getY();
		g.fillArc(x, y, this.getSize(), this.getSize(), 0, 360);
	}


	public void handleCollision(GameObject otherObject) {
		
	}
	//Changes direction of Ant
	public void changeDirectionLeft() {
		
		directionNew += -5;
		System.out.println("\nAnt has changed heading...");

		
	}
	//Changes direction of Ant
	public void changeDirectionRight() {
		
		directionNew += 5;
		System.out.println("\nAnt has changed heading...");


	}
	//Implements direction of Ant
	public void turn() {
		
		if(directionNew >= 5) {
			int temp = super.getDirection() + 5;
			directionNew -= 5;
			setDirection(temp);
			
		}
		else if(directionNew <= -5) {
			int temp = super.getDirection() - 5;
			directionNew += 5;
			setDirection(temp);

		}
	}
	//Increases Ant speed
	public void increaseSpeed() {
		
		int currentSpeed = super.getSpeed();
		if (currentSpeed + 1 <= maxSpeed) {
			this.setSpeed(++currentSpeed);
		}
		System.out.println("\nAnt is accelerating...");
		System.out.println("Current Speed: " + getSpeed());
	
	}
	//Decreases Ant speed
	public void decreaseSpeed() {
		
		System.out.println("\nAnt is slowing down...");
		System.out.println("Current Speed: " + getSpeed());
		int currSpeed = super.getSpeed();
		if (currSpeed > 0)
		{
			this.setSpeed(--currSpeed);
		}
		else {
			System.out.println("Can't go any slower!");
		}
	}


}	