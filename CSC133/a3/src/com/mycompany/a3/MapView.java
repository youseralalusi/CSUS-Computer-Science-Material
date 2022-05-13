package com.mycompany.a3;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.Border;

public class MapView extends Container implements Observer{
	
	private static int height;
	private static int width;
	private static Point mapViewOrigin;
	private GameWorld gw;
	
	public MapView() {
		
		this.getAllStyles().setBorder(Border.createLineBorder(10,ColorUtil.rgb(255, 0, 0)));
		this.setLayout(new BorderLayout());
		this.getAllStyles().setBgColor(ColorUtil.WHITE);
		this.getAllStyles().setBgTransparency(255);
		height = this.getHeight();
		width = this.getWidth();
	
	}
	//Method to set origin
	public void setMapViewOrigin(Point p) { 
		
		MapView.mapViewOrigin = p; 
		
	}
	public static Point getMapViewOrigin() { 
		
		return mapViewOrigin; 
		
	}
	/**
	 * Method to set map height
	 * @param h
	 */
	public static void setMapHeight(int h) {
		
		MapView.height = h;
	}
	/**
	 * Method to get map height
	 * @return height
	 */
	public static int getMapHeight() {
		
		return height;
	}
	/**
	 * Method to set mad width
	 * @param w
	 */
	public static void setMapWidth(int w) {
		MapView.width = w;
	}
	/**
	 * Method to get map width
	 * @return width
	 */
	public static int getMapWidth() {
		
		return width;
	}
	
	/**
	 * Method to update observable and data
	 */

	public void update(Observable observable, Object data) {
		
		gw = (GameWorld) data;
		this.repaint();
		
	}
	//Method to draw objects on component

	public void paint(Graphics g) {
		super.paint(g);
		Point pCmpRelPrnt = new Point(this.getX(), this.getY());
		IIterator itr = gw.getCollection().getIterator();
		while(itr.hasNext()) {
			GameObject tempObject = itr.getNext();
			if (tempObject instanceof IDrawable) {
				((IDrawable) tempObject).draw(g, pCmpRelPrnt);
			}
		}
	}
	//Method to select objects

	public void pointerPressed(int x, int y ) {
		//Point clickPoint = new Point(x - getParent().getAbsoluteX(), y - getParent().getAbsoluteY());
		x = x - getParent().getAbsoluteX();
		y = y - getParent().getAbsoluteY();
		Point pPtrRelPrnt = new Point(x,y);
		Point pCmpRelPrnt = new Point(this.getX(), this.getY());
	
		IIterator itr = gw.getCollection().getIterator();
		while(itr.hasNext()) {
			GameObject tempObject = itr.getNext();
			if(tempObject instanceof ISelectable) {
				ISelectable selectObject = (ISelectable) tempObject;
				if(selectObject.contains(pPtrRelPrnt, pCmpRelPrnt)) {
					selectObject.setSelected(true);
					System.out.println("Object Selected!");
					

				}
				else {
					selectObject.setSelected(false);
				}
			}
		}
		repaint();
		gw.notifyObservers(this);
	}

}