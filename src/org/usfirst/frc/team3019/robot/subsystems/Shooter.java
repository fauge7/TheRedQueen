package org.usfirst.frc.team3019.robot.subsystems;

import org.usfirst.frc.team3019.robot.RobotMap;
import org.usfirst.frc.team3019.robot.commands.Shoot;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Shooter extends PIDSubsystem{

	VictorSP left;
	VictorSP right;
	VictorSP angler;
	AnalogPotentiometer anglePot;
	
	public Shooter() {
		// TODO Auto-generated constructor stub
		super("Shooter",0.15, 0, 0.005);
		setInputRange(-45, 45);
		setAbsoluteTolerance(.6);
		setOutputRange(-0.6, 0.6);
		getPIDController().setToleranceBuffer(150);
		left = new VictorSP(9);
		right = new VictorSP(5);
		left.setInverted(true);
		anglePot = new AnalogPotentiometer(2, 1080, 0);
		angler = new VictorSP(RobotMap.launchAnglerPWM);
		anglePot.startLiveWindowMode();
		LiveWindow.addActuator("Shooter", "Shooter", getPIDController());
		
	}
	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new Shoot());
	}

	public void launch(double speed) {
		// setting launch motors
		left.set(speed);
		right.set(speed);
	}
	public void angle(double speed){
		angler.set(speed);
	}
	public double getPot(){
		return anglePot.get();
	}
	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return -(anglePot.get()/3 - RobotMap.ShooterAngleOfset);
	}
	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		angler.set(-output);
	}
}
