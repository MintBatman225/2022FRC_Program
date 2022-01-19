// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  Victor leftFront;
  Victor rightFront;
  Victor leftBack;
  Victor rightBack;
  MotorControllerGroup leftMotors;
  MotorControllerGroup rightMotors;
  DifferentialDrive drive;


  /** Creates a new DriveTrain. */
  public DriveTrain() {

  
  leftFront = new Victor(Constants.LEFT_FRONT);
  leftFront.setInverted(false);
  rightFront = new Victor(Constants.RIGHT_FRONT);
  rightFront.setInverted(false);
  leftBack = new Victor(Constants.LEFT_BACK);
  leftBack.setInverted(false);
  rightBack = new Victor(Constants.RIGHT_BACK);
  rightBack.setInverted(false);

  leftMotors = new MotorControllerGroup(leftFront, leftBack);
  rightMotors = new MotorControllerGroup(rightFront, rightBack);
  drive = new DifferentialDrive(leftMotors, rightMotors);

  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void drivewithjoysticks(XboxController controller, double speed)
  {
    drive.tankDrive(controller.getRawAxis(Constants.XBOX_LEFT_Y_AXIS)*speed, controller.getRawAxis(Constants.XBOX_RIGHT_Y_AXIS)*speed);
  }
  public void driveForward(double speed)
  {
  drive.tankDrive(speed, speed);
  }

  public void stop()
  {
    drive.stopMotor();
  }
}

