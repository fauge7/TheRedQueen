package org.usfirst.frc.team3019.robot.commands;

import org.usfirst.frc.team3019.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LowerArms extends Command{

	public LowerArms() {
		// TODO Auto-generated constructor stub
		requires(Robot.lifter);
	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.lifter.LiftControl(.7);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return !Robot.lifter.armLimitSwitch.get();
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.lifter.LiftControl(0);
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
