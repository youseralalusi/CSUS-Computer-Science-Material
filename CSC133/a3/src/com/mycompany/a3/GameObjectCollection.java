package com.mycompany.a3;

import java.util.ArrayList;

public class GameObjectCollection implements ICollection {
	
	private ArrayList<GameObject> gameObjects;
	
	/*
	 * Constructor that creates new game objects
	 */
	public GameObjectCollection() {
		gameObjects = new ArrayList<GameObject>();
	}
	
	/*
	 * Method to add objects into array list
	 */
	
	public void add(GameObject obj) {
		
		gameObjects.add(obj);
		
	}
	public int size() {
		
		return gameObjects.size();
		
	}
	
	/*
	 * Method to get Iterator
	 */

	public IIterator getIterator() {
		
		return new GameObjectIterator();
	}
	/*
	 * Private class to create iterator
	 */
	 private class GameObjectIterator implements IIterator {
		 
		 private int index;
		 
		 /*
		  * Iterator constructor
		  */
		 public GameObjectIterator() {
			 
			 index = -1;
		 }
		 public boolean hasNext() {
			
			 if(gameObjects.size() <= 0)
				 return false;
			 
			 if(index == gameObjects.size() -1) {
				 return false;
			 }
			 
			 return true;
		 }
		
		public GameObject getNext() {
			
			index++;
			return gameObjects.get(index);
		}
		
		public GameObject getCurrent() {
			
			return gameObjects.get(index);
		}
		
		public void remove(GameObject object) {
			
			gameObjects.remove(object);
		}
		
	 }


}
