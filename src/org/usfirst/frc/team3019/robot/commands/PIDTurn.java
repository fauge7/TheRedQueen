package org.usfirst.frc.team3019.robot.commands;

import org.usfirst.frc.team3019.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PIDTurn extends Command {

	double setpoint;
	public PIDTurn(double setpoint) {
		// TODO Auto-generated constructor stub
		requires(Robot.driveTrain);
		this.setpoint = setpoint;
	}
	public PIDTurn(boolean b) {
		// TODO Auto-generated constructor stub
		this.setpoint = Robot.gyro.getAngle()-Robot.Azimuth;
	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		Robot.driveTrain.setSetpoint(0);
		Robot.driveTrain.enable();
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		SmartDashboard.putNumber("Current Heading", Robot.gyro.getAngle());
		SmartDashboard.putNumber("Drive Pid Error", Robot.driveTrain.getPIDController().getError());
		SmartDashboard.putNumber("Drive Angle Average Pid Error", Robot.driveTrain.getPIDController().getAvgError());
		SmartDashboard.putBoolean("DriveisOneTarget", Robot.driveTrain.onTarget());
		SmartDashboard.putString("DriveState","PID");
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
