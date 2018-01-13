// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2876.PowerUp2018;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static WPI_TalonSRX driveTrainRigthtTalonSRX1;
    public static WPI_TalonSRX driveTrainRightTalonSRX2;
    public static SpeedControllerGroup driveTrainSpeedControllerGroupRight;
    public static WPI_TalonSRX driveTrainLeftTalonSRX3;
    public static WPI_TalonSRX driveTrainLeftTalonSRX4;
    public static SpeedControllerGroup driveTrainSpeedControllerGroupLeft;
    public static DifferentialDrive driveTrainDifferentialDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainRigthtTalonSRX1 = new WPI_TalonSRX(1);
        
        
        driveTrainRightTalonSRX2 = new WPI_TalonSRX(2);
        
        
        driveTrainSpeedControllerGroupRight = new SpeedControllerGroup(driveTrainRigthtTalonSRX1, driveTrainRightTalonSRX2  );
        LiveWindow.addActuator("DriveTrain", "SpeedControllerGroupRight", driveTrainSpeedControllerGroupRight);
        
        driveTrainLeftTalonSRX3 = new WPI_TalonSRX(3);
        
        
        driveTrainLeftTalonSRX4 = new WPI_TalonSRX(4);
        
        
        driveTrainSpeedControllerGroupLeft = new SpeedControllerGroup(driveTrainLeftTalonSRX3, driveTrainLeftTalonSRX4  );
        LiveWindow.addActuator("DriveTrain", "SpeedControllerGroupLeft", driveTrainSpeedControllerGroupLeft);
        
        driveTrainDifferentialDrive = new DifferentialDrive(driveTrainSpeedControllerGroupLeft, driveTrainSpeedControllerGroupRight);
        LiveWindow.addActuator("DriveTrain", "DifferentialDrive", driveTrainDifferentialDrive);
        driveTrainDifferentialDrive.setSafetyEnabled(true);
        driveTrainDifferentialDrive.setExpiration(0.1);
        driveTrainDifferentialDrive.setMaxOutput(1.0);


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
