package org.usfirst.frc.team3019.robot.commands;

import org.usfirst.frc.team3019.robot.Robot;
import org.usfirst.frc.team3019.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Shoot extends Command {

    public Shoot() {
        // Use requires() here to declare subsystem dependencies
         requires(Robot.shooter);
         
    }

    // Called just before this Command runs the first time
    @Override
	protected void initialize() {
    	Robot.shooter.disable();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
	protected void execute() {

    	
    	if(Robot.oi.buttonShooterUp.get()){
    		Robot.shooter.angle(-RobotMap.AngleSpeed);
    	}
    	else if(Robot.oi.buttonShooterDown.get()){
    		Robot.shooter.angle(RobotMap.AngleSpeed);
    	}
    	else{
    		Robot.shooter.angle(0);
    	}
    	if(Robot.oi.xbox1.getRawAxis(3) > .6){
    		Robot.shooter.launch(RobotMap.IntakeSpeed);
    	}
    	else if(Robot.oi.xbox1.getRawAxis(2) > .6){
    		Robot.shooter.launch(RobotMap.ShootSpeed);
    	}
    	else{
    		Robot.shooter.launch(0);
    	}
    	
    	SmartDashboard.putString("AnglerState", "Manual");
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
	protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
	protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
	protected void interrupted() {
    }
}
