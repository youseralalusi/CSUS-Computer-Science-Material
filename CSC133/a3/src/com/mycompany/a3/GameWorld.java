package com.mycompany.a3;

import java.util.Observable;
import java.util.Random;

import com.codename1.ui.geom.Point;

/**
 * @author Youser Alalusi
 *
 */
public class GameWorld extends Observable {
	
	private int elapsedTime;
	private int antLives;
	private int foodLevel;
	private int lastFlagReached;
	private boolean soundSetting;
	private int healthLevel;
	private GameObjectCollection gameObjects;
	private Ant theAnt;
	Random random = new Random();
	private int gameWorldHeight;
	private int gameWorldWidth;
	private boolean position;
	private BGSound bkgSound;
	private Sound spiderSound;
	private Sound foodSound;
	private Sound flagSound;
	private Point maxLocation;
	private boolean pause;

	public GameWorld() {}
	
	//Method to create initial state of world
	public void init() {
		
		antLives = 3;
		this.elapsedTime = 0;
		lastFlagReached = 1;
		setHealthLevel(15);
		setFoodLevel(500);
		position = false;
		gameObjects = new GameObjectCollection();
		this.soundSetting = false;
		Flags.resetSequenceNumber();
		
	
		//Creating objects of world
		theAnt = createAnt();
		createFoodStations();
		createFlags();
		createSpiders();
		
		this.setChanged();
		this.notifyObservers(this);
	}
	

	/**
	 * Method to create Ant using singleton
	 * @return theAnt
	 */
	public Ant createAnt() {
		
		theAnt = Ant.getTheAnt();
		gameObjects.add(theAnt);
		return theAnt;

	}
	
	//Creating Spider object
	public void createSpiders() {
		
		Spider spider1 = new Spider(this);
		Spider spider2 = new Spider(this);
		gameObjects.add(spider1);
		gameObjects.add(spider2);
	}
	
	//Create flags objects
	public void createFlags() {
		
		Flags flag1 = new Flags(this);
		flag1.setLocation(NewPoint.validRandomLocation(maxLocation, flag1.getSize()));
		gameObjects.add(flag1);
		
		Flags flag2 = new Flags(this);
		flag2.setLocation(NewPoint.validRandomLocation(maxLocation, flag2.getSize()));
		gameObjects.add(flag2);
		
		Flags flag3 = new Flags(this);
		flag3.setLocation(NewPoint.validRandomLocation(maxLocation, flag3.getSize()));
		gameObjects.add(flag3);
		
		Flags flag4 = new Flags(this);
		flag4.setLocation(NewPoint.validRandomLocation(maxLocation, flag4.getSize()));
		gameObjects.add(flag4);
	
	}
	
	//Create food stations
	public void createFoodStations() {
		
		FoodStation foodStation1 = new FoodStation(this);
		foodStation1.setLocation(NewPoint.validRandomLocation(maxLocation, foodStation1.getSize()));
		FoodStation foodStation2 = new FoodStation(this);
		foodStation2.setLocation(NewPoint.validRandomLocation(maxLocation, foodStation2.getSize()));
		
		gameObjects.add(foodStation1);
		gameObjects.add(foodStation2);
		
	}
	//Creating additional food stations
	public void addFoodStation() {
		
		FoodStation newStation = new FoodStation(this);
		gameObjects.add(newStation);
	}
	/**
	 * Method to get Ant current lives
	 * @return antLives
	 */
	public int getAntLives() {
		return antLives;
	}
	//Method to increase Ant speed
	public void increaseSpeed() {

		IIterator itr = gameObjects.getIterator();
		while(itr.hasNext())
		{
			GameObject tempObject = itr.getNext();
			if(tempObject instanceof Ant)
			{
				((Ant)tempObject).increaseSpeed();
			}
		}
		this.setChanged();
		this.notifyObservers(this);

	}
	//Method created to decrease speed
	public void decreaseSpeed() {
		
		IIterator itr = gameObjects.getIterator();
		while(itr.hasNext())
		{
			GameObject tempObject = itr.getNext();
			if(tempObject instanceof Ant)
			{
				((Ant)tempObject).decreaseSpeed();;
			}
		}
		this.setChanged();
		this.notifyObservers(this);

	}

	//Method to notify flag collision
	public void flagCollision(int i) {
		
		int flag = i;
		if((flag == lastFlagReached + 1)) {
			setLastFlagReached(flag);
			System.out.println("\nYou have reached flag #" + flag);
			if(lastFlagReached == 4) {
				System.out.println("\nGame over! You win!");
				System.out.println("Total time: " + getTime() + " clock ticks");
				System.exit(0);
			}
			
		}
		else {
			System.out.println("\nYou can't jump to this flag!");
			
		}
		
		this.setChanged();
		this.notifyObservers(this);
		
	}
	//Method to update last flag reached
	public void setLastFlagReached(int x) {
		
		lastFlagReached = x;
	}
	//Method to request current flag
	public int getLastFlagReached() {
		
		return lastFlagReached;
	}
	//Method to notify food station collision
	public void foodCollision(FoodStation station) {
		
		if(!station.isEmpty() && station.getCapacity() != 0) {
			station.emptyVerified();
			int foodLevelNew = station.getCapacity();
			setFoodLevel(foodLevel + foodLevelNew);
			station.setCapacity(0);
			station.setColor(128, 128, 0);
			addFoodStation();
		}
		
		
		this.setChanged();
		this.notifyObservers(this);
	}
	
	//Method to notify spider collision
	public void spiderCollision() {
		
		System.out.println("\nYou have collided with a Spider!");
		if(getSound()) {
			spiderSound.play();
		}
		IIterator itr = gameObjects.getIterator();
		while(itr.hasNext()) {
			GameObject tempObject = itr.getNext();
			if(tempObject instanceof Spider) {
				if(getHealthLevel() != 0) {
					setHealthLevel(getHealthLevel() -1);
					if(getHealthLevel() == 0) {
						System.out.println("The Ant has lost a life...");
						int tempTime = getTime();
						int tempLives = antLives - 1;
						init();
						antLives = tempLives;
						elapsedTime = tempTime;
						this.setChanged();
						notifyObservers(this);
						
						if(antLives == 0) {
							System.out.println("Game over, you failed!");
							System.exit(0);
						}
						
					}
					System.out.println("Health: " + getHealthLevel());
					theAnt.setColor(255, 102, 102);
					break;

				}
				
			}
		}
		this.setChanged();
		this.notifyObservers(this);
		
	}
	//Method to start clock and move objects
	public void clockTick(long gameClock) {
		elapsedTime++;
		IIterator itr  = gameObjects.getIterator();
		while(itr.hasNext()) {
			GameObject tempObject = itr.getNext();
			if(tempObject instanceof MovableGameObject) {
				((MovableGameObject) tempObject).moveNew(gameClock, maxLocation);
				this.setChanged();
				this.notifyObservers(this);
				
				if(tempObject instanceof Spider) {
					Spider tempSpider = (Spider) itr.getCurrent();
					int tempDirection = tempSpider.getDirection();
					int randNum = random.nextInt(1)+1; 
			
					if(randNum == 1){
					    tempSpider.setDirection(tempDirection + 5);
					}
					else {
					    tempSpider.setDirection(tempDirection - 5);
					}
				}
			}
		}
		foodLevel = (int) (foodLevel - ((.1/gameClock) * theAnt.getFoodConsumptionRate()));
		if(foodLevel <= 0) {
			System.out.println("The Ant has lost a life...");
			int tempTime = getTime();
			int tempLives = antLives - 1;
			init();
			theAnt.setSpeed(0);
			soundSetting = true;
			antLives = tempLives;
			elapsedTime = tempTime;
			this.setChanged();
			notifyObservers(this);
			
			if(antLives == 0) {
				System.out.println("\nGame over, you failed!");
				System.exit(0);
			}
		}
		checkCollision();
		this.setChanged();
		this.notifyObservers(this);
	}
	
	public void checkCollision() {
		
		IIterator itr = gameObjects.getIterator();
		while(itr.hasNext()) {
			GameObject tempObject = itr.getNext();
			IIterator itr2 = gameObjects.getIterator();
			while(itr2.hasNext()) {
				GameObject tempObject2 = itr2.getNext();
				if(tempObject != tempObject2) {
					if(tempObject.collidesWith(tempObject2)) {
						if(tempObject instanceof Ant && tempObject2 instanceof Spider) {
							if(getSound())
								spiderSound.play();
						}
						else if(tempObject instanceof Ant && tempObject2 instanceof Flags) {
							if(getSound())
								flagSound.play();
						}
						else if(tempObject instanceof Ant && tempObject2 instanceof FoodStation) {
							if(getSound())
								foodSound.play();
						}
						
						tempObject.handleCollision(tempObject2);
					}
				}
			}
		}
	}

	/*
	 * Method to get game clock
	 */
	public int getTime() {
		
		return this.elapsedTime/2;
	}
	/*
	 * Method to get sound setting
	 */
	public boolean getSound() {
		
		return soundSetting;
	}
	/*
	 * Method to set sound setting
	 */
	public void setSound() {
		
		if(soundSetting) {
			soundSetting = false;
			bkgSound.pause();
		}	
		else {
			soundSetting = true;
			bkgSound.play();
		}
		this.setChanged();
		this.notifyObservers(this);
		
		
	}
	/**
	 * Method to request health
	 * 
	 * @return healthLevel
	 */
	public int getHealthLevel() {
		
		return healthLevel;
	}
	/**
	 * Method to set health
	 * 
	 * @param x
	 */
	public void setHealthLevel(int x) {
		
		healthLevel = x;
	}
	/**
	 * Method to request food level
	 * 
	 * @return foodLevel
	 */
	public int getFoodLevel() {
		
		return foodLevel;
	}
	/**
	 * Method to set food level
	 * 
	 * @param x
	 */
	public void setFoodLevel(int x) {
		
		foodLevel = x;
		
	}
	/*
	 * Method to get objects in game collection
	 */
	public GameObjectCollection getCollection() {
		
		return gameObjects;
	}
	/*
	 *Method to set game height
	 */
	public void setGameWorldHeight(int mapHeight) {

		gameWorldHeight = mapHeight;
	}
	public int getGameWorldHeight() {
		
		return gameWorldHeight;
	}
	/*
	 * Method to set game width
	 */
	public void setGameWorldWidth(int mapWidth) {
		
		gameWorldWidth = mapWidth;
	}
	public int getGameWorldWidth() {
		
		return gameWorldWidth;
	}
	
	public void setPause(boolean p) {
		
		pause = p;
	}
	//Method to check game pause
	public boolean getPause() {
		
		return pause;
	}
	//Method to create sounds
	public void createSound() {
		bkgSound = new BGSound("backGround.wav");
		spiderSound = new Sound("spider.wav");
		foodSound = new Sound("food.wav");
		flagSound = new Sound("flag.wav");
		
	}
	//Method to create max location
	public void setMaxLocation(Point point) {
		
		maxLocation = point;
		
	}
	//Method to turn sound off
	public void turnOffSound() {
		bkgSound.pause();
	}
	//Method to turn sound on
	public void turnOnSound() {
		if(getSound()) {
			bkgSound.play();
		}
	}
	//Method to position on 
	public void turnOnPosition() {
		
		if(position == true)
			position = false;
		
		else
			position = true;
		
	}
	//Method to turn position off
	public void turnOffPostion() {
		
		if(position == false)
			position = true;
		
		else
			position = false;
	}
	//Method to get position
	public boolean getPosition() {
		
		return position;
	}
	//Method to change direction left
	public void changeDirectionLeft() {
		
		IIterator itr = gameObjects.getIterator();
		while(itr.hasNext()) {
			GameObject tempObject = itr.getNext();
			if(tempObject instanceof Ant) {
				((Ant)tempObject).changeDirectionLeft();
			}
		}
		this.setChanged();
		this.notifyObservers(this);
	}
	//Method to change direction left
	public void changeDirectionRight() {
		
		IIterator itr = gameObjects.getIterator();
		while(itr.hasNext()) {
			GameObject tempObject = itr.getNext();
			if(tempObject instanceof Ant) {
				((Ant)tempObject).changeDirectionRight();
			}
		}
		
		this.setChanged();
		this.notifyObservers(this);
	}

}
