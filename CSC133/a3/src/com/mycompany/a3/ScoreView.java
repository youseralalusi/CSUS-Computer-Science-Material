package com.mycompany.a3;

import java.util.Observable;
import java.util.Observer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.FlowLayout;

public class ScoreView extends Container implements Observer{
	
	private Label timeClock;
	private Label livesLeft;
	private Label lastFlagReached;
	private Label foodLevel;
	private Label healthLevel;
	private Label soundSetting;
	private GameWorld gw;
	
	public ScoreView() {
		
		this.setLayout(new FlowLayout(Component.CENTER));
		
		gameClock();
		playerLives();
		lastFlagReached();
		foodLevel();
		healthLevel();
		setSound();
		
	}
	/**
	 * Label for game clock
	 */
	private void gameClock() {
		Label time = new Label("Time: ");
		time.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		timeClock = new Label("0");
		timeClock.getAllStyles().setPadding(RIGHT, 5);
		this.add(time);
		this.add(timeClock);
	}
	/**
	 * Label for player lives
	 */
	private void playerLives() {
		
		Label lives = new Label("Lives Left: ");
		lives.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		livesLeft = new Label("3");
		livesLeft.getAllStyles().setPadding(RIGHT, 5);
		this.add(lives);
		this.add(livesLeft);
	}
	/**
	 * Label for last flag reached
	 */
	private void lastFlagReached() {
		
		Label lastFlag = new Label("Last Flag Reached: ");
		lastFlag.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		lastFlagReached = new Label("1");
		lastFlagReached.getAllStyles().setPadding(RIGHT, 5);
		this.add(lastFlag);
		this.add(lastFlagReached);
	}
	/**
	 * Label for food level
	 */
	private void foodLevel() {
		
		Label food = new Label("Food Level: ");
		food.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		foodLevel = new Label("15");
		foodLevel.getAllStyles().setPadding(RIGHT, 5);
		this.add(food);
		this.add(foodLevel);
	}
	/**
	 * Label for health level
	 */
	private void healthLevel() {
		Label health = new Label("Health Level: ");
		health.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		healthLevel = new Label("10");
		healthLevel.getAllStyles().setPadding(RIGHT, 5);
		this.add(health);
		this.add(healthLevel);
	}
	/**
	 * Label for sound setting
	 */
	private void setSound() {
		
		Label sound = new Label("Sound: ");
		sound.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		soundSetting = new Label("OFF");
		soundSetting.getAllStyles().setPadding(RIGHT, 5);
		this.add(sound);
		this.add(soundSetting);
	}
	
	
	/**
	 * Method to update observable and data
	 */

	public void update(Observable observable, Object data) {
		
		gw = (GameWorld) data;
		this.timeClock.setText(" " + gw.getTime());
		this.livesLeft.setText(" " + gw.getAntLives());
		this.lastFlagReached.setText(" " + gw.getLastFlagReached());
		this.foodLevel.setText(" " + gw.getFoodLevel());
		this.healthLevel.setText(" " + gw.getHealthLevel());
		if(gw.getSound()) {
			
			this.soundSetting.setText("ON");
		}
		else 
			this.soundSetting.setText("OFF");
		
		this.repaint();
	}

}
