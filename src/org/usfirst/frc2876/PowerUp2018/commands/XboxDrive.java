// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2876.PowerUp2018.commands;
import org.usfirst.frc2876.PowerUp2018.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class XboxDrive extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	boolean isStraightBeginning = true;
	int straightTimer = 0;
	
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public XboxDrive() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	Joystick xbox = Robot.oi.getXboxController();
    	if (!Robot.driveTrain.isTurnPIDRunning() && !Robot.driveTrain.isDistancePIDRunning()){
//    		Robot.driveTrain.arcadeDrive(-Robot.oi.getRightX(), Robot.oi.getLeftY());
//    		Robot.driveTrain.tankDrive(Robot.oi.getLeftY(), -Robot.oi.getRightY());
//    		Robot.driveTrain.setVelocityArcadeJoysticks(0, -1);
//    		Robot.driveTrain.arcadeDrive(0,0);
    		
    		if(Math.abs(Robot.oi.getRightX()) <= .1 && !(Math.abs(Robot.oi.getLeftY()) <= .1)){
    			if(isStraightBeginning){
    				Robot.driveTrain.startStraight();
    				isStraightBeginning = false;
    			}
    			Robot.driveTrain.setStraightVelocityArcadeJoysticks(Robot.oi.getLeftY());
    		}else{
    			isStraightBeginning = true;
    			Robot.driveTrain.stopStraight();
    			Robot.driveTrain.setVelocityArcadeJoysticks(Robot.oi.getRightX(), Robot.oi.getLeftY());
    		}
    	}
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
