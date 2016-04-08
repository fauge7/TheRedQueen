package org.usfirst.frc.team3019.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem {

		// TODO Auto-generated constructor stub
		DoubleSolenoid soli;
		DoubleSolenoid lifter;
		public Pneumatics() {
			// TODO Auto-generated constructor stub
		
//		assign objects to correct ports
//		DoubleSolenoid soli1 = new DoubleSolenoid(1, 0);
		soli = new DoubleSolenoid(6,7);
		lifter = new DoubleSolenoid(0,1);
		}
	@Override
	public void initDefaultCommand() {

		// when pneumatics starts set solenoid off and start compressing
//		soli1.set(DoubleSolenoid.Value.kOff);
//		setDefaultCommand(new Push());
		
	}

	// DO: turn solenoid to forward
	public void soliForward() {

		soli.set(DoubleSolenoid.Value.kReverse);
//		soli.set(DoubleSolenoid.Value.kForward);
	}

	// DO: turn solenoid to reverse
	public void soliReverse() {

		soli.set(DoubleSolenoid.Value.kForward);
//		soli.set(DoubleSolenoid.Value.kReverse);
	}

	// DO: turn solenoid off
	public void soliOff() {

		soli.set(DoubleSolenoid.Value.kOff);
//		soli.set(false);
	}
	public void extend(){
		lifter.set(DoubleSolenoid.Value.kForward);
	}
	public void retract(){
		lifter.set(DoubleSolenoid.Value.kReverse);
	}

}
