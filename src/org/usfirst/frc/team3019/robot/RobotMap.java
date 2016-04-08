package org.usfirst.frc.team3019.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static final boolean runArms = false;
	public static float kP = 0.03f;
	public static double driveStraightCorrection = 1;
	public static int potTurnTotal = 3;
	public static double driveNerf = 1;
	public static double turnNerf = 1;
	public static double angleOff;
	public static double ShooterAngleOfset = 217;
	public static boolean autoAngle = false;

	// systems in use, change to pos or neg here
	public static final boolean usePneumatics = true;
	public static final boolean usePID = true;
	public static final boolean usePuncher = true;
	public static final boolean useAutoAlign = true;
	public static int numRan = 0;
	public static final boolean useArms = true;

//	 pwm ports
	public static final int leftRearDrivePWM = 3;//3
	public static final int leftFrontDrivePWM = 2;//0
	public static final int rightRearDrivePWM = 1;//1 
	public static final int rightFrontDrivePWM = 0;//2 

	
	public static final int leftLaunchPWM = 9; 
	public static final int rightLaunchPWM = 5;

	public static final int liftAnglerPWM = 6;  
	public static final int liftAngler2PWM =7;

	public static final int launchAnglerPWM = 8;
	public static final int intakeArmsPMW = 4;

//	digital input ports
	public static final int liftSwitchDIO = 1;
	
//	constant speeds
	public static final double AngleSpeed = .5;
	public static final double IntakeSpeed = -.5;
	public static final double ShootSpeed = .85;
	
		
}
