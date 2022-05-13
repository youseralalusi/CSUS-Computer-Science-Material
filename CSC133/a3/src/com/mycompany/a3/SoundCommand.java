package com.mycompany.a3;

import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.Toolbar;


public class SoundCommand extends Command{
	
	private CheckBox soundCheck;
	private GameWorld gw;
	private Toolbar toolBar;
	
	public SoundCommand (GameWorld gw, CheckBox soundCheck, Toolbar myToolbar) {
		
		super("Sound");
		this.gw = gw;
		this.soundCheck = soundCheck;
		this.toolBar = myToolbar;
	}
	public void actionPerformed(ActionEvent e) {
		
		if(soundCheck.isSelected()) {
			System.out.println("\nSound ON");
		
		}
		
		else {
			System.out.println("Sound OFF");
			
		}
		
		gw.setSound();
		toolBar.closeSideMenu();
		
	}
	

}
