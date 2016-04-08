package org.usfirst.frc.team3019.robot.commands;

import org.usfirst.frc.team3019.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class VisionAlign extends Command{

	public VisionAlign() {
		// TODO Auto-generated constructor stub
		requires(Robot.driveTrain);
	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		double differnece = Robot.gyro.getAngle()+Robot.Azimuth;
		Robot.driveTrain.setSetpoint(differnece);
		Robot.driveTrain.enable();
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return Robot.driveTrain.onTarget();
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.driveTrain.disable();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
