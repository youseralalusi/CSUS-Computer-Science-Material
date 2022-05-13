package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class ExitCommand extends Command {
	
	public ExitCommand() {
		
		super("Exit");
	}

	public void actionPerformed(ActionEvent e) {
		
		if(Dialog.show("Exit", "Do you want to exit the game?", "Yes", "No")) {
			System.exit(0);
		}
		
	}

}