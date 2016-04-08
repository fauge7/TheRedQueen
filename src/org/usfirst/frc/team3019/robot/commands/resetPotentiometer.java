package org.usfirst.frc.team3019.robot.commands;

import org.usfirst.frc.team3019.robot.Robot;
import org.usfirst.frc.team3019.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class resetPotentiometer extends Command {

	public resetPotentiometer() {
		// TODO Auto-generated constructor stub
//		requires(Robot.shooter);
	}
	@Override	
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
//		RobotMap.ShooterAngleOfset = Robot.shooter.getPot()/3;
		SmartDashboard.putNumber("ShooterAngleOffset", RobotMap.ShooterAngleOfset);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
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
