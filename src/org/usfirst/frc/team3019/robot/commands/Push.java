package org.usfirst.frc.team3019.robot.commands;

import org.usfirst.frc.team3019.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Push extends Command {

	public Push() {
		// TODO Auto-generated constructor stub
		requires(Robot.pnumatics);
	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
//		Robot.pnumatics.soliOff();
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
			Robot.pnumatics.soliReverse();
			Timer.delay(.5);
			Robot.pnumatics.soliForward();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.pnumatics.soliForward();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
