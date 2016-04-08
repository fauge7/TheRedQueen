
package org.usfirst.frc.team3019.robot.subsystems;

import org.usfirst.frc.team3019.robot.Robot;
import org.usfirst.frc.team3019.robot.RobotMap;
import org.usfirst.frc.team3019.robot.commands.Drive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class DriveTrain extends PIDSubsystem {

	// instantiate motors and drives used
	VictorSP rearLeftMotor;
	VictorSP rearRightMotor;
	VictorSP frontLeftMotor;
	VictorSP frontRightMotor;
	
	RobotDrive drive;

	public DriveTrain() {

		super("DriveTrain", 0.13, 0.015, 0.02, 0);
		setInputRange(-360,360);
		setAbsoluteTolerance(1);
		setOutputRange(-0.8, 0.8);
		getPIDController().setToleranceBuffer(250);
		
		
		
		
		
		
		// setting left and right motors to correct ports
		rearRightMotor = new VictorSP(RobotMap.rightRearDrivePWM);
		frontRightMotor = new VictorSP(RobotMap.rightFrontDrivePWM);
		rearLeftMotor = new VictorSP(RobotMap.leftRearDrivePWM);
		frontLeftMotor = new VictorSP(RobotMap.leftFrontDrivePWM);
//		rearLeftMotor.disable();
//		rearRightMotor.disable();
		drive = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
		LiveWindow.addActuator("DriveTrain", "Drive", this.getPIDController());
        
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new Drive());
	}
	public void DefaultArcadeDrive(double moveValue, double rotateValue){
		
		drive.arcadeDrive(moveValue, rotateValue);
		
	}
	public void ArcadeDrive(double moveValue, double rotateValue){
//		boolean useBoost = Robot.oi.buttonSpeedRacer.get();
		boolean useBoost = Robot.oi.buttonBoosteArms.get();
		double leftMotorSpeed;
	    double rightMotorSpeed;
	    double leftFrontSpeed = 0;
	    double rightFrontSpeed = 0;
	    if (moveValue >= 0.0) {
	        moveValue = (moveValue * moveValue);
	      } else {
	        moveValue = -(moveValue * moveValue);
	      }
	      if (rotateValue >= 0.0) {
	        rotateValue = (rotateValue * rotateValue);
	      } else {
	        rotateValue = -(rotateValue * rotateValue);
	      }
	    
	    if (moveValue > 0.0) {
	      if (rotateValue > 0.0) {
	        leftMotorSpeed = moveValue - rotateValue;
	        rightMotorSpeed = Math.max(moveValue, rotateValue);
	      } else {
	        leftMotorSpeed = Math.max(moveValue, -rotateValue);
	        rightMotorSpeed = moveValue + rotateValue;
	      }
	    } else {
	      if (rotateValue > 0.0) {
	        leftMotorSpeed = -Math.max(-moveValue, rotateValue);
	        rightMotorSpeed = moveValue + rotateValue;
	      } else {
	        leftMotorSpeed = moveValue - rotateValue;
	        rightMotorSpeed = -Math.max(-moveValue, -rotateValue);
	      }
	    }

	    //if we want to turn
	    if(Math.abs(rotateValue) > Math.abs(moveValue)) {
	    	frontLeftMotor.set(leftMotorSpeed);
	    	frontRightMotor.set(-rightMotorSpeed * RobotMap.driveStraightCorrection);
	    	rearLeftMotor.set(leftMotorSpeed);
	    	rearRightMotor.set(-rightMotorSpeed * RobotMap.driveStraightCorrection);
	    } else if(Math.abs(moveValue) > Math.abs(rotateValue)) {
	    	leftFrontSpeed = leftMotorSpeed;
	    	rightFrontSpeed = -rightMotorSpeed * RobotMap.driveStraightCorrection;
	    	
	    	frontLeftMotor.set(leftFrontSpeed);
	    	frontRightMotor.set(rightFrontSpeed);
	    	if(useBoost){
	    		rearLeftMotor.set(leftFrontSpeed);
	    		rearRightMotor.set(rightFrontSpeed);
	    	}
	    } else{ //if we want to go straight and turn
	    	frontLeftMotor.set(leftMotorSpeed);
	    	frontRightMotor.set(-rightMotorSpeed * RobotMap.driveStraightCorrection);
	    	if(useBoost){
	    		rearLeftMotor.set(leftMotorSpeed);
	    		rearRightMotor.set(-rightMotorSpeed * RobotMap.driveStraightCorrection);
	    	}
	    }
	}

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return -Robot.gyro.pidGet();
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		DefaultArcadeDrive(0, output);
	}
}