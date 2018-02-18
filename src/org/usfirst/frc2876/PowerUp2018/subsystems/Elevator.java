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

import org.usfirst.frc2876.PowerUp2018.Robot;
import org.usfirst.frc2876.PowerUp2018.RobotMap;
import org.usfirst.frc2876.PowerUp2018.commands.ElevatorPosition;
import org.usfirst.frc2876.PowerUp2018.commands.ElevatorStop;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS



/**
 *
 */
public class Elevator extends Subsystem {

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OI

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OI

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	private final WPI_TalonSRX elevatorTalonSRX5 = RobotMap.elevatorElevatorTalonSRX5;
	private final WPI_TalonSRX elevatorTalonSRX6 = RobotMap.elevatorElevatorTalonSRX6;

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	private final WPI_TalonSRX elevatorMaster = RobotMap.elevatorMaster;
	private final WPI_TalonSRX elevatorFollower = RobotMap.elevatorFollower;

	private Ultrasonic usElevatorSensor = RobotMap.usElevatorSensor;
	
	private int lastPosition = 0;
	
	@Override
	public void initDefaultCommand() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		setDefaultCommand(new ElevatorPosition(RobotMap.ELEVATOR_POSITION_ACQUIRE_CUBE));
		//setDefaultCommand(new ElevatorStop());

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	private static final double PULSES_PER_REV = 4096;

	//private final AnalogInput hallEffectSensor = RobotMap.ai;
	public static final int kTimeoutMs = 0;
	public static final int kPIDLoopIdx = 0;
	public static boolean kSensorPhase = true;
	public static boolean kMotorInvert = false;
	
	public Elevator(){
		setupPID();
		
	}

	public void setupPID(){

		/* choose the sensor and sensor direction */
		elevatorMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, kPIDLoopIdx,
				kTimeoutMs);

		/* choose to ensure sensor is positive when output is positive */
		elevatorMaster.setSensorPhase(kSensorPhase);

		/* choose based on what direction you want forward/positive to be.
		 * This does not affect sensor phase. */ 
		elevatorMaster.setInverted(kMotorInvert);
		elevatorFollower.setInverted(kMotorInvert);

		/* set the peak and nominal outputs, 12V means full */
		elevatorMaster.configNominalOutputForward(0, kTimeoutMs);
		elevatorMaster.configNominalOutputReverse(0, kTimeoutMs);
		// 1 means full power, 12v.  Perhaps make down smaller than up since gravity is helping go down.
		elevatorMaster.configPeakOutputForward(.3, kTimeoutMs);
		elevatorMaster.configPeakOutputReverse(-.3, kTimeoutMs);
		/*
		 * set the allowable closed-loop error, Closed-Loop output will be
		 * neutral within this range. See Table in Section 17.2.1 for native
		 * units per rotation.
		 */
		elevatorMaster.configAllowableClosedloopError(kPIDLoopIdx, 10, kTimeoutMs);

		/* set closed loop gains in slot0, typically kF stays zero. */
		elevatorMaster.config_kF(kPIDLoopIdx, 0.0, kTimeoutMs);
		elevatorMaster.config_kP(kPIDLoopIdx, 0.4, kTimeoutMs);
		elevatorMaster.config_kI(kPIDLoopIdx, 0.0, kTimeoutMs);
		elevatorMaster.config_kD(kPIDLoopIdx, 0.0, kTimeoutMs);

		resetPositionValue(RobotMap.ELEVATOR_POSITION_KICKSTAND);
		/*
		 * lets grab the 360 degree position of the MagEncoder's absolute
		 * position, and initially set the relative sensor to match.
		 */
//		int absolutePosition = elevatorMaster.getSensorCollection().getPulseWidthPosition();
//		/* mask out overflows, keep bottom 12 bits */
//		absolutePosition &= 0xFFF;
//		if (kSensorPhase)
//			absolutePosition *= -1;
//		if (kMotorInvert)
//			absolutePosition *= -1;
//		/* set the quadrature (relative) sensor to match absolute */
//		elevatorMaster.setSelectedSensorPosition(absolutePosition, kPIDLoopIdx, kTimeoutMs);
		
		
	}
	
	public double nativeToInches(double nativeUnits){
		return (nativeUnits / PULSES_PER_REV);
	}
//	TODO: Add a diameter value for the spool; somewhat to the effect of the wheel diameter for the drivetrain
//	Spool value = 1.12 inches
	public double inchesToNative(double inches){
		return (inches * PULSES_PER_REV);
	}

	@Override
	public void periodic() {
		// Put code here to be run every loop

	}
	
	public void updateSmartDashboard(){
		SmartDashboard.putNumber("Elevator Cur Pos", getCurrentPosition());
		//SmartDashboard.putNumber("Elevator Set Pos", getLastPosition());
	
		SmartDashboard.putBoolean("Elevator Bottom", isBottom());

		SmartDashboard.putNumber("Elevator Ultrasonic in mm ", usElevatorSensor.getRangeMM());
    	SmartDashboard.putNumber("Elevator Ultrasonic distance in Inches ",usElevatorSensor.getRangeInches());
      	usElevatorSensor.ping();
    	SmartDashboard.putBoolean("Elevator Ultrasonic Enabled", usElevatorSensor.isEnabled());
       	SmartDashboard.putBoolean("Elevator Ultrasonic isRangeValid", usElevatorSensor.isRangeValid());
       	
	}

//	public int getLastPosition() {
//		return lastPosition;
//	}
//	public void setLastPosition(int pos) {
//		lastPosition = pos;
//	}
	
	public void setPosition(double positionInches){
//		Double d = new Double(positionInches);
//		setLastPosition(d.intValue());
//		double positionNative = inchesToNative(positionInches);
		elevatorMaster.set(ControlMode.Position, positionInches);
	}
	
	public void resetPositionValue(int value){
		elevatorMaster.setSelectedSensorPosition(value, 0, 0);
	}
	
	public double getCurrentPosition(){
		return elevatorMaster.getSelectedSensorPosition(0);
	}
	
	public boolean isOnTarget() {
		if (elevatorMaster.getClosedLoopError(0) < 500) {
//			if (elevatorMaster.getMotorOutputPercent() < 0.1) {
//				// Within error and motor has stopped moving alot so call it done.
//				return true;
//			}
			return true;
		}
		return false;
	}
	
	public void Up() {
		elevatorMaster.set(-.3);

	}

	public void Stop() {
		elevatorMaster.set(0);

	}

	public void Down() {
		elevatorMaster.set(.3);

	}
	
	public boolean isBottom(){
		if(usElevatorSensor.getRangeInches() >= 1.0 && usElevatorSensor.getRangeInches() < 8.0){
			
			return true;
		}
		return false;
	}

}