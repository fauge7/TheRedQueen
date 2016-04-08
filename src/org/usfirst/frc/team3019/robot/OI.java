package org.usfirst.frc.team3019.robot;

import org.usfirst.frc.team3019.robot.commands.ExtendClimber;
import org.usfirst.frc.team3019.robot.commands.KillPID;
import org.usfirst.frc.team3019.robot.commands.LowerArms;
import org.usfirst.frc.team3019.robot.commands.PIDLevel;
import org.usfirst.frc.team3019.robot.commands.Push;
import org.usfirst.frc.team3019.robot.commands.RetractClimber;
import org.usfirst.frc.team3019.robot.commands.VisionAlign;
import org.usfirst.frc.team3019.robot.commands.resetPotentiometer;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

		
		/* xbox controller */
		public Joystick xbox1 = new Joystick(0);
		public Joystick xbox2 = new Joystick(1);

		/*AXES USED
		 * 
		 * LEFT STICK
		 * 	X-AXIS: TURNING FOR ARCADE
		 * 	Y-AXIS: FWD/REV FOR ARCADE
		 * 
		 * RIGHT STICK
		 *  X-AXIS: NOT USED
		 * 	Y-AXIS: RAISING PISTON ARMS
		 * 
		 */
		
		/*BUTTONS USED
		 * 
		 * 1 A     -used for toggling solenoid
		 * 2 B     -used to angle down
		 * 3 X     -used to angle up
		 * 4 Y     -used to toggle servo
		 * 5 lBump   -used to manual run launch motors fwd
		 * 6 rBump   -used to manual run launch motors intake
		 * 7 back    -used to manual do PIDTurn
		 * 8 start   -used to manual do PIDAngle
		 * 9 lClick  -NOT USED
		 * 10 rClick -NOT USED
		 * 
		 */
		
		public Button buttonSomething = new JoystickButton(xbox1, 1);
		public Button buttonShooterDown = new JoystickButton(xbox1, 2);
		public Button buttonShooterUp = new JoystickButton(xbox1, 3);
		public Button buttonShooterHeight = new JoystickButton(xbox1, 4);
		public Button buttonLaunch = new JoystickButton(xbox1, 5);
		public Button buttonIntake = new JoystickButton(xbox1, 6);
		public Button buttonPIDTurn = new JoystickButton(xbox1, 7);
		public Button buttonVisionAlign = new JoystickButton(xbox1, 8);
		public Button xb9 = new JoystickButton(xbox1, 9);
		public Button xb10 = new JoystickButton(xbox1, 10);
		
		public Button buttonResetPotentiometer = new JoystickButton(xbox2, 2);
		public Button buttonArms = new JoystickButton(xbox2, 5);
//		public Button buttonLowerArms = new JoystickButton(xbox2, 4);
		public Button buttonLiftUp = new JoystickButton(xbox2, 4);
		public Button buttonLiftDown = new JoystickButton(xbox2, 1);
		public Button buttonBoosteArms = new JoystickButton(xbox2, 7);
//		public Button buttonPowerIntake = new JoystickButton(xbox2, 6);
		public Button buttonKillPID = new JoystickButton(xbox2, 8);
		
		public OI() {
//			
			buttonLaunch.whenPressed(new Push());
			buttonShooterHeight.whenPressed(new PIDLevel(27,false));
			buttonResetPotentiometer.whenPressed(new resetPotentiometer());
			buttonKillPID.whenPressed(new KillPID());
			buttonLiftUp.whenPressed(new ExtendClimber());
			buttonLiftDown.whenPressed(new RetractClimber());
//			buttonVisionAlign.whenPressed(new VisionAlign());
			buttonSomething.whenPressed(new PIDLevel(-30,false));
			
		}
}

