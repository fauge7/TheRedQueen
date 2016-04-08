package org.usfirst.frc.team3019.robot.commands;

import org.usfirst.frc.team3019.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PIDLevel extends Command {

	double setpoint;
	public PIDLevel() {
		// TODO Auto-generated constructor stub
		requires(Robot.shooter);
		
	}
	public PIDLevel(double setpoint, boolean Vision) {
		// TODO Auto-generated constructor stub
		requires(Robot.shooter);
		if(Vision){
			this.setpoint = Robot.table.getNumber("TargetAngle", 0);
			SmartDashboard.putNumber("Target Angle", this.setpoint);
		}
		else{
			this.setpoint = setpoint;
		}
	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		Robot.shooter.setSetpoint(setpoint);
		Robot.shooter.enable();
		setTimeout(2);
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		SmartDashboard.putString("AnglerState", "PID");
		SmartDashboard.putNumber("Shooter Angle Pid Error", Robot.shooter.getPIDController().getError());
		SmartDashboard.putNumber("Shooter Angle Average Pid Error", Robot.shooter.getPIDController().getAvgError());
		SmartDashboard.putBoolean("Shooter isOneTarget", Robot.shooter.onTarget());
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
	return Robot.shooter.onTarget() || isTimedOut();
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.shooter.disable();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
