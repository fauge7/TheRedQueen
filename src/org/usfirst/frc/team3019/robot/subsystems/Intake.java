package org.usfirst.frc.team3019.robot.subsystems;

import org.usfirst.frc.team3019.robot.RobotMap;
import org.usfirst.frc.team3019.robot.commands.SuckIn;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem{

	Talon t;
	public Intake() {
		// TODO Auto-generated constructor stub
		this.t = new Talon(RobotMap.intakeArmsPMW);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new SuckIn());
	}
	public void spin(double speed){
		t.set(speed);
	}
}
