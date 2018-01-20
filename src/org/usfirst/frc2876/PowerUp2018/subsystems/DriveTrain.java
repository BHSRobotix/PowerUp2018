// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2876.PowerUp2018.subsystems;

import org.usfirst.frc2876.PowerUp2018.RobotMap;
import org.usfirst.frc2876.PowerUp2018.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

import com.kauailabs.navx.frc.AHRS;

/**
 *
 */
public class DriveTrain extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final WPI_TalonSRX rigthtTalonSRX1 = RobotMap.driveTrainRigthtTalonSRX1;
    private final WPI_TalonSRX rightTalonSRX2 = RobotMap.driveTrainRightTalonSRX2;
    private final SpeedControllerGroup speedControllerGroupRight = RobotMap.driveTrainSpeedControllerGroupRight;
    private final WPI_TalonSRX leftTalonSRX3 = RobotMap.driveTrainLeftTalonSRX3;
    private final WPI_TalonSRX leftTalonSRX4 = RobotMap.driveTrainLeftTalonSRX4;
    private final SpeedControllerGroup speedControllerGroupLeft = RobotMap.driveTrainSpeedControllerGroupLeft;
    private final DifferentialDrive differentialDrive = RobotMap.driveTrainDifferentialDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public AHRS navx;
    
    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new XboxDrive());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

	public DriveTrain() {
		navx = new AHRS(SPI.Port.kMXP);
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void arcadeDrive(double xSpeed, double zRotation){
    	differentialDrive.arcadeDrive(xSpeed, zRotation);
    	
    }
    
    public void tankDrive(double leftSpeed, double rightSpeed){
    	differentialDrive.tankDrive(leftSpeed, rightSpeed);
    }
    
    public void updateSmartDashboard() {
    	SmartDashboard.putData("NavX", navx);
		SmartDashboard.putNumber("navX angle", navx.getAngle());
		SmartDashboard.putBoolean("is navx conneced?", navx.isConnected());
//		SmartDashboard.putBoolean("navx is calibrating", navx.isCalibrating());
    }
    
}

