package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class HelpCommand extends Command {
	
	public HelpCommand() {
		
		super("Help");
	}
	
	public void actionPerformed(ActionEvent e) {
		
		String help = "Game Commands: \n"
				+ "A - Accelerate \n "
				+ "B - Brake \n" 
				+ "L - Turn Left \n" 
				+ "R - Turn Right \n";
				
		
		Dialog.show("Help", help, "Exit", null);
	}

}
