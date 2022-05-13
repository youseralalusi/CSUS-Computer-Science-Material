package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class Spider extends MovableGameObject {

	private GameWorld gw;
	public Spider(GameWorld gw) {
		
		this.gw = gw;
		setSize(20 + getRandom((10)));
		setColor(0, 0, 0); //Black

	}

	/**
	 * Method to override toString
	 */
	public String toString() {
		
		String supString = super.toString();
		String value = " size= " + getSize();
		
		String concValue = "Spider: " + supString + value;
		
		return concValue;
	}
	//Method to draw object on component

	public void draw(Graphics g, Point pCmpRelPrnt) {
		
		g.setColor(ColorUtil.BLACK);
		  int x = (int)this.getLocationX() + pCmpRelPrnt.getX();
		  int y = (int)this.getLocationY() + pCmpRelPrnt.getY();
		  int[] xPoints = { x, (x - 20), (x + 20), x };
		  int[] yPoints = { (y + 30), (y - 30), (y- 30), (y + 30) };
		  int nPoints = 3;
		  g.drawPolygon(xPoints, yPoints, nPoints);
	}

	//Method to handle collision
	public void handleCollision(GameObject otherObject) {
		
		if(this instanceof Spider && otherObject instanceof Ant) {
			gw.spiderCollision();
		}
		
	}

}
