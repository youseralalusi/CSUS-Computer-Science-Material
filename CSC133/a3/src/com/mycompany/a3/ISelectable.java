package com.mycompany.a3;
import com.codename1.ui.Graphics; 
import com.codename1.ui.geom.Point;

public interface ISelectable {
	
	//Methods created to select objects
	public void setSelected(boolean selected);
	
	public boolean isSelected();
	
	public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrint);
	
	public void draw(Graphics g, Point pCmpRelPrnt);
}