
package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class AccelCommand extends Command {
	
	private GameWorld gw;
	
	public AccelCommand(GameWorld gw) {
		
		super("Accelerate");
		this.gw = gw;
		
	}
	public void actionPerformed(ActionEvent e) {
		
		if(!gw.getPause()) {
			
			gw.increaseSpeed();
		}
		else {
			
			gw.setPause(true);
		}
	}

}