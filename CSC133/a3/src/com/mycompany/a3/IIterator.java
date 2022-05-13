package com.mycompany.a3;

/*
 * Interface to implement methods in GameObjectCollection class
 */
public interface IIterator {
	
	public boolean hasNext();
	
	public GameObject getNext();
	
	public GameObject getCurrent();

	void remove(GameObject object);

}
