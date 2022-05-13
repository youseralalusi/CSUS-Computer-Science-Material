package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.geom.Point;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.UITimer;

public class Game extends Form implements Runnable{
	
	private GameWorld gw;
	private ScoreView sv;
	private MapView mv;
	private UITimer timer;
	private long gameClock;
	private ButtonObj pauseButton;
	private AccelCommand accelCommand;
	private LeftCommand leftCommand;
	private BrakeCommand brakeCommand;
	private RightCommand rightCommand;
	private ButtonObj accelButton;
	private ButtonObj leftButton;
	private ButtonObj brakeButton;
	private ButtonObj rightButton;
	private PositionCommand positionCommand;
	private ButtonObj positionButton;
	private Button accelButtonSideMenu;
	private static String gameTitle = "OnTarget Game";

	
	public Game() {
		
		gw = new GameWorld();
		mv = new MapView();
		sv = new ScoreView();
		gw.addObserver(mv);
		gw.addObserver(sv);
	
		this.setLayout(new BorderLayout());
		this.setScrollable(false);
		
		this.addComponent(BorderLayout.CENTER, mv);
		this.addComponent(BorderLayout.NORTH, sv);
		
		createTB();
		createCommands();
		
		this.show();
		gw.setMaxLocation(new Point(mv.getWidth(), mv.getHeight()));
		
		
		gw.init();
		gw.createSound();
		revalidate();
		
		gameClock = 100;
		timer = new UITimer(this);
		timer.schedule((int)gameClock, true, this);
	}
	//Method to create tool bar
	public void createTB() {
		
		Toolbar myToolbar = new Toolbar();
		this.setToolbar(myToolbar);
		myToolbar.setTitle(gameTitle);
		
		accelCommand = new AccelCommand(gw);
		myToolbar.addCommandToSideMenu(accelCommand);
		accelButtonSideMenu = new Button("Accelerate");
		accelButtonSideMenu.setCommand(accelCommand);
		addKeyListener('a', accelCommand);
		
		CheckBox soundOn = new CheckBox("Sound");
		soundOn.getAllStyles().setBgColor(ColorUtil.LTGRAY);
		soundOn.getAllStyles().setBgTransparency(255);
		SoundCommand soundCommand = new SoundCommand(gw, soundOn, myToolbar);
		soundOn.setCommand(soundCommand);
		myToolbar.addComponentToSideMenu(soundOn);
		
		AboutCommand abtCommand = new AboutCommand();
		myToolbar.addCommandToSideMenu(abtCommand);
		
		ExitCommand exitCommand = new ExitCommand();
		myToolbar.addCommandToSideMenu(exitCommand);
		
		HelpCommand helpCommand = new HelpCommand();
		myToolbar.addCommandToRightBar(helpCommand);
	
	}
	//Method to create button commands
	public void createCommands() {
		
		Container myContainerLeft = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		Container myContainerRight = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		Container myContainerBottom = new Container(new FlowLayout(Component.CENTER));
	
		//Left container commands
		accelCommand = new AccelCommand(gw);
		accelButton = new ButtonObj(accelCommand);
		accelButton.getAllStyles().setMarginTop(100);
		addKeyListener('a', accelCommand);
		myContainerLeft.add(accelButton);
		
		leftCommand = new LeftCommand(gw);
		leftButton = new ButtonObj(leftCommand);
		addKeyListener('l', leftCommand);
		myContainerLeft.add(leftButton);
		
		myContainerLeft.getAllStyles().setBorder(Border.createLineBorder(3,ColorUtil.rgb(0, 0, 0)));
		this.addComponent(BorderLayout.WEST, myContainerLeft);
		
		//Right container commands
		brakeCommand = new BrakeCommand(gw);
		brakeButton = new ButtonObj(brakeCommand);
		brakeButton.getAllStyles().setMarginTop(100);
		addKeyListener('b', brakeCommand);
		myContainerRight.add(brakeButton);
		
		rightCommand = new RightCommand(gw);
		rightButton = new ButtonObj(rightCommand);
		addKeyListener('r', rightCommand);
		myContainerRight.add(rightButton);
		
		myContainerRight.getAllStyles().setBorder(Border.createLineBorder(3,ColorUtil.rgb(0, 0, 0)));
		this.addComponent(BorderLayout.EAST, myContainerRight);
		
		//Bottom container commands
		positionCommand = new PositionCommand(gw);
		positionButton = new ButtonObj(positionCommand);
		positionButton.setEnabled(false);
		myContainerBottom.add(positionButton);

		PauseCommand pauseCommand = new PauseCommand(this);
		pauseButton = new ButtonObj(pauseCommand);
		myContainerBottom.add(pauseButton);
		myContainerBottom.getAllStyles().setBorder(Border.createLineBorder(3,ColorUtil.rgb(0, 0, 0)));
		this.add(BorderLayout.SOUTH, myContainerBottom);
	}
	public void run() {
		
		revalidate();
		gw.clockTick(gameClock);
	}
	//Method to pause game
	public void pauseGame() {
		
		if(!gw.getPause()) {
			
			System.out.println("\n***GAME PAUSED***");
			pauseButton.setText("Play");
			timer.cancel();
			gw.turnOffSound();
			accelCommand.setEnabled(false);
			leftCommand.setEnabled(false);
			brakeCommand.setEnabled(false);
			rightCommand.setEnabled(false);
			positionCommand.setEnabled(true);
			removeKeyListener('a', accelCommand);
			removeKeyListener('l', leftCommand);
			removeKeyListener('b', brakeCommand);
			removeKeyListener('r', rightCommand);
			accelButton.setEnabled(false);
			brakeButton.setEnabled(false);
			leftButton.setEnabled(false);
			rightButton.setEnabled(false);
			positionButton.setEnabled(true);
			gw.setPause(!gw.getPause());

		}
		else {
			
			System.out.println("\n***GAME RESUMED***");
			pauseButton.setText("Pause");
			timer.schedule((int)gameClock, true, this);
			gw.turnOnSound();
			accelCommand.setEnabled(true);
			leftCommand.setEnabled(true);
			brakeCommand.setEnabled(true);
			rightCommand.setEnabled(true);
			positionCommand.setEnabled(false);
			addKeyListener('a', accelCommand);
			addKeyListener('l', leftCommand);
			addKeyListener('b', brakeCommand);
			addKeyListener('r', rightCommand);
			accelButton.setEnabled(true);
			brakeButton.setEnabled(true);
			leftButton.setEnabled(true);
			rightButton.setEnabled(true);
			positionButton.setEnabled(false);
			gw.setPause(!gw.getPause());
		}
		
		
	}

}