package com.mycompany.a3;

import com.codename1.ui.geom.Point;

public abstract class FixedGameObject extends GameObject implements ISelectable{
	
	private int size;
	private boolean isSelected;
	
	public FixedGameObject(){}
	
	//Method to set object size
	public void setSize(int i) {
		
		size = i;
	}
	//Method to get object size
	public int getSize() {
		
		return size;
	}
	//Method to set selection status
	public void setSelected(boolean selected) {
		
		isSelected = selected;
	}
	//Method to check selection status
	public boolean isSelected() {
		
		return isSelected;
	}
	//Method to verify if two points can be selected
	public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt) {
		
		int px = pPtrRelPrnt.getX();
		int py = pPtrRelPrnt.getY();
		
		int xLoc = (int)this.getLocation().getX() + pCmpRelPrnt.getX();
		int yLoc = (int)this.getLocation().getY() + pCmpRelPrnt.getY();
	
		if (((px >= xLoc) && (px <= xLoc + getSize() / 2)) && 
				((py >= yLoc) && (py <= yLoc + getSize() / 2)))
		{
			return true;
		}
		return false;
	}

}