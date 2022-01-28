// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import frc.robot.Constants;
public class InnerDrive extends SubsystemBase {
Victor innerLeft;
Victor innerRight;

static DifferentialDrive drive;
  /** Creates a new InnerDrive. */
  public InnerDrive() {
innerLeft = new Victor(Constants.INNER_LEFT);
innerLeft.setInverted(false);
 innerRight = new Victor(Constants.INNER_RIGHT);
  innerRight.setInverted(false);



  drive = new DifferentialDrive(innerLeft, innerRight);
  
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public static void drivewithjoysticks(XboxController controller, double speed)
  {
    drive.tankDrive(controller.getRawAxis(Constants.XBOX_LEFT_X_AXIS)*speed, controller.getRawAxis(Constants.XBOX_RIGHT_X_AXIS)*speed);
  }
  public void driveBackward(double speed)
  {
  drive.tankDrive(speed, speed);
  }

  public void stop()
  {
    drive.stopMotor();
  }
}