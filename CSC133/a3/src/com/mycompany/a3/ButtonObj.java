package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.plaf.Border;

public class ButtonObj extends Button {
	
	public ButtonObj(Command com) {
		
		this.getAllStyles().setBgTransparency(255);
		this.getAllStyles().setBorder(Border.createLineBorder(3,ColorUtil.rgb(0, 0, 0)));
		this.getAllStyles().setPadding(TOP, 3);
		this.getAllStyles().setPadding(BOTTOM, 3);
		this.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		this.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		this.getPressedStyle().setBgTransparency(125);
		this.getPressedStyle().setBgColor(ColorUtil.rgb(0, 100, 100));
		this.getPressedStyle().setFgColor(ColorUtil.BLACK);
		this.getDisabledStyle().setBgTransparency(255);
		this.getDisabledStyle().setBgColor(ColorUtil.GRAY);
		this.getDisabledStyle().setFgColor(ColorUtil.BLUE);
		this.setCommand(com);
	}

}
