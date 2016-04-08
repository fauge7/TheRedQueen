package org.usfirst.frc.team3019.robot.commands;

import org.usfirst.frc.team3019.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drive extends Command{

	double move = 0;
	double turn = 0;
	public Drive() {
		// TODO Auto-generated constructor stub
		requires(Robot.driveTrain);
	}
	public Drive(double move, double turn){
		this();
		this.move = move;
		this.turn = turn;
		
	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		if(move > .1 && !Robot.driveTrain.getPIDController().isEnabled()){
			Robot.driveTrain.ArcadeDrive(move, turn);
		}
		else if(!Robot.driveTrain.getPIDController().isEnabled()){
			Robot.driveTrain.ArcadeDrive(-Robot.oi.xbox1.getY(),-Robot.oi.xbox1.getX());
			SmartDashboard.putString("DriveState","Manual");
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
