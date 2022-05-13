package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class AboutCommand extends Command{
	
	public AboutCommand() {
		
		super("About");
	}

	public void actionPerformed(ActionEvent e) {
		
		String abt = "Youser Alalusi\nCSC 133\nOnTarget v.3";
		Dialog.show("About", abt, "Exit", null);
	
	}
}