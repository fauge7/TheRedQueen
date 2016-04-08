package org.usfirst.frc.team3019.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCommandGroup extends CommandGroup {
	
	public AutonomousCommandGroup() {
		// TODO Auto-generated constructor stub
	//hard coded auton
		addSequential(new LowerArms());
		addSequential(new Drive(.8,0),3);
		//spy
//		addSequential(new PIDTurn(true));
	
	
	
	
	}
}
