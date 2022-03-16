// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.XboxController;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import frc.robot.Constants;
public class ShooterMotors extends SubsystemBase {
 

PWMSparkMax shooterLeft;
PWMSparkMax shooterRight;


  /** Creates a new InnerDrive. */
  public ShooterMotors() {
shooterLeft = new PWMSparkMax(Constants.SHOOTER_LEFT);
shooterLeft.setInverted(false);
shooterRight = new PWMSparkMax(Constants.SHOOTER_RIGHT);
shooterRight.setInverted(true);



  }
  @Override
  public void periodic() {
  }
    public void drivewithjoysticks(XboxController controller, double speed)

    {
    // This method will be called once per scheduler run
if (controller.getXButtonPressed()){
  shooterRight.set(-0.5);
  shooterLeft.set(-0.5);
  
} else if (controller.getXButtonReleased()){
  shooterRight.set(0);
  shooterLeft.set(0);

}  else if (controller.getBButton()){
  shooterRight.set(1);
  shooterLeft.set(1);

  }

}

public void shootOut(double speed){
  shooterRight.set(1);
  shooterLeft.set(1);
}
public void stop()
  {
    shooterRight.stopMotor();
    shooterLeft.stopMotor();
  }
}


