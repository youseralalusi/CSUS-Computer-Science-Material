package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class BrakeCommand extends Command {
	
	private GameWorld gw;
	
	public BrakeCommand(GameWorld gw) {
		
		super("Brake");
		this.gw = gw;
		
	}

	public void actionPerformed(ActionEvent e) {
		
		gw.decreaseSpeed();
		
	}

}
