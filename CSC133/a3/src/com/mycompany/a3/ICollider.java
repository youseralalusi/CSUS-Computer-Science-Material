package com.mycompany.a3;

public interface ICollider {
	
	//Methods to handle in game collisions
	public boolean collidesWith(GameObject otherObject);
		
	public void handleCollision(GameObject otherObject);

	}
