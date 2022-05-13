package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class PauseCommand extends Command{
	
	private Game game;
	
	public PauseCommand(Game gme) {
		
		super("Pause");
		this.game = gme;
	
	}
	 
	public void actionPerformed(ActionEvent e) {
		
		game.pauseGame();
	}
}