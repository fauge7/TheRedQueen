package org.usfirst.frc.team3019.robot.commands;

import org.usfirst.frc.team3019.robot.Robot;
import org.usfirst.frc.team3019.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class SuckIn extends Command{

	 
	public SuckIn() {
		// TODO Auto-generated constructor stub
		requires(Robot.intake);
	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		if(Robot.oi.xbox1.getRawAxis(3) > .6){
	    	Robot.intake.spin(RobotMap.IntakeSpeed);
	    }
		else if(Robot.oi.buttonIntake.get())
			Robot.intake.spin(-RobotMap.IntakeSpeed);
		else{
			Robot.intake.spin(0);
		}
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
