package org.usfirst.frc.team3019.robot.commands;

import org.usfirst.frc.team3019.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Lift extends Command {

	double liftSpeed = 0;
	public Lift() {
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
		double rightAxisValue = Robot.oi.xbox2.getRawAxis(5);
		Robot.lifter.canGoUp = true;
		Robot.lifter.canGoDown = Robot.lifter.armLimitSwitch.get();
		if(rightAxisValue < -0.1){
			liftSpeed = rightAxisValue * .9;
		}else if(rightAxisValue > 0.1 && Robot.lifter.canGoDown){
			liftSpeed = rightAxisValue * .9;
		}else{
			liftSpeed = 0;
		}
		Robot.lifter.LiftControl(liftSpeed);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
