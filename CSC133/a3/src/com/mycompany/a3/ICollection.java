package com.mycompany.a3;

public interface ICollection {
	
	/*
	 * Method to add objects of type GameObject
	 */
	public void add(GameObject obj);
	
	IIterator getIterator();
	

}
