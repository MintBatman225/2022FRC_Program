// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import frc.robot.Constants;

public class intakeDoor extends SubsystemBase {
  static Victor intakeLeft;
  static Victor intakeRight;

  
  /** Creates a new intakeDoor. */
  public intakeDoor() {

    intakeRight = new Victor(Constants.INTAKE_RIGHT);
    intakeRight.setInverted(false);
    intakeLeft = new Victor(Constants.INTAKE_LEFT);
    intakeLeft.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public static void drivewithjoysticks(XboxController controller, double speed)

  {
  // This method will be called once per scheduler run
if (controller.getAButtonPressed() ){
  intakeRight.set(0.6);
  intakeLeft.set(0.6);

} else if (controller.getYButton()){
  intakeRight.set(-0.5);
  intakeLeft.set(-0.5);

} else if (controller.getYButtonReleased()){
  intakeRight.set(0);
  intakeLeft.set(0);
}

}
public void closeDoor(double speed){
  intakeRight.set(1);
  intakeLeft.set(1);
}
public void openDoor(double speed){
  intakeRight.set(-0.5);
  intakeLeft.set(-0.5);
}
public void stop()
  {
    intakeRight.stopMotor();
    intakeLeft.stopMotor();
  }
}

