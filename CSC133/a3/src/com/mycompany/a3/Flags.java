package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class Flags extends FixedGameObject {
	
	private int flagNum;
	private int flagSize;
	private GameWorld gw;
	private int currFlag;
	private static int objectNum;
	

	public Flags(GameWorld gw) {
		
		this.gw = gw;
		flagNum = getSequenceNumber();
		flagSize = 20;
		setColor(0, 255, 0); //Green
		
	}
	//Method to set flag number
	public void setSequenceNumber() {
		
		objectNum++;
	}
	/**
	 * Method to get flag number
	 * 
	 * @objectNum
	 */
	public int getSequenceNumber() {
		
		objectNum++;
		
		return objectNum;
	}
	//Method to reset flag number
	public static void resetSequenceNumber() {
		
		objectNum = 0;
	}

	/**
	 * Method to override toString
	 */
	public String toString() {
		
		String supString = super.toString();
		String value = " size= " + flagSize + " seqNum= " + flagNum;
		
		String concValue = "Flag:   " + supString + value;
		
		return concValue;
	}
	//Method to draw flag object on component
	
	  public void draw(Graphics g, Point pCmpRelPrnt) {

		  g.setColor(super.getColor());
		  int xLoc = (int)this.getLocation().getX() + pCmpRelPrnt.getX();
		  int yLoc = (int)this.getLocation().getY() + pCmpRelPrnt.getY();
		  int[] xPoints = { xLoc, (xLoc - 20), (xLoc + 20), xLoc };
		  int[] yPoints = { (yLoc + 30), (yLoc - 30), (yLoc - 30), (yLoc + 30) };
		  int nPoints = 4;
		  if (super.isSelected())
			  
			  g.drawPolygon(xPoints, yPoints, nPoints);
		  else
			  
			  g.fillPolygon(xPoints, yPoints, nPoints);
		  	  g.setColor(ColorUtil.BLACK);
		  	  g.drawString("" + this.flagNum, xLoc + 10, yLoc + 15);
		
	
	  }
	 //Method to verify two points for selection

	 public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt) {
			
			int px = pPtrRelPrnt.getX();
			int py = pPtrRelPrnt.getY();
			
			int xLoc = (int)this.getLocation().getX() + pCmpRelPrnt.getX();
			int yLoc = (int)this.getLocation().getY() + pCmpRelPrnt.getY();
		
			if (((px >= xLoc) && (px <= xLoc + (flagSize / 2))) && 
					((py >= yLoc) && (py <= yLoc + (flagSize / 2))))
			{
				return true;
			}
			return false;
		}
	//Method to handle collision between objects

	public void handleCollision(GameObject otherObject) {
		
		if(this instanceof Flags && otherObject instanceof Ant) {
			if(gw.getLastFlagReached() + 1 == flagNum) {
				currFlag = flagNum;
				gw.setLastFlagReached(currFlag);
				System.out.println("\nYou have reached flag #" + currFlag);
				if(currFlag == 4) {
					System.out.println("\nGame over! You win!");
					System.out.println("Total time: " + gw.getTime() + " clock ticks");
					System.exit(0);
				}
			}
			else {
				System.out.println("\nYou can't access this flag!");
			}
		}
		
	}


}
