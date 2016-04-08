
package org.usfirst.frc.team3019.robot;

import org.usfirst.frc.team3019.robot.commands.AutonomousCommandGroup;
import org.usfirst.frc.team3019.robot.subsystems.DriveTrain;
import org.usfirst.frc.team3019.robot.subsystems.Intake;
import org.usfirst.frc.team3019.robot.subsystems.Lifter;
import org.usfirst.frc.team3019.robot.subsystems.Pneumatics;
import org.usfirst.frc.team3019.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static  Shooter shooter;
	public static  DriveTrain driveTrain;
	public static  Lifter lifter;
	public static  Pneumatics pnumatics;
	public static Intake intake;
	public static ADXRS450_Gyro gyro;
	public static NetworkTable table;
	public static Compressor compressor;
	
	public static double TargetAngle = 0;
	public static double Azimuth = 0;
	
	public static OI oi;

    Command autonomousCommand;
    SendableChooser chooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
	public void robotInit() {
    	table = NetworkTable.getTable("TowerTracker");
		table.putString("TEST", "isRunning");

		intake = new Intake();
    	shooter = new Shooter();
		driveTrain = new DriveTrain();
		lifter = new Lifter();
		pnumatics = new Pneumatics();
		gyro = new ADXRS450_Gyro();
    	oi = new OI();
		compressor = new Compressor();
    	compressor.start();
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    @Override
	public void disabledInit(){
    	shooter.disable();
    	driveTrain.disable();
    }
	
	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		outputSmartDashboardData();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    @Override
	public void autonomousInit() {
        autonomousCommand = new AutonomousCommandGroup();
        
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
    	
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
	public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        outputSmartDashboardData();
    }

    @Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
	public void teleopPeriodic() {
        Scheduler.getInstance().run();
        compressor.start();
        outputSmartDashboardData();
    }
    
    /**
     * This function is called periodically during test mode
     */
    @Override
    public void testInit() {
    	LiveWindow.addActuator("Shooter", "shooter pid", shooter.getPIDController());
        
    };
    @Override
	public void testPeriodic() {
        LiveWindow.run();
        outputSmartDashboardData();
    }
    public void outputSmartDashboardData(){
    	SmartDashboard.putNumber("Pot Angle", Robot.shooter.getPosition());
    	SmartDashboard.putNumber("Current Heading", Robot.gyro.getAngle());
    	TargetAngle = table.getNumber("targetAngle",0);
    	Azimuth = table.getNumber("VISazimuth",0);
    	SmartDashboard.putNumber("Target Angle", TargetAngle);
    	SmartDashboard.putNumber("Azimuth", Azimuth);
    	SmartDashboard.putBoolean("Launch A", Robot.oi.buttonLaunch.get());
    	SmartDashboard.putBoolean("Arm Limit", lifter.armLimitSwitch.get());
    	SmartDashboard.putBoolean("Compressor", compressor.enabled());
    	
    }
}
