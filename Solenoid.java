
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;



public class Solenoid extends SubsystemBase {

  /** Creates a new Solenoid. */
  DoubleSolenoid solenoid;

  public Solenoid(){
  
   DoubleSolenoid solenoid = new DoubleSolenoid( PneumaticsModuleType.CTREPCM, 4, 5);
  }
 
  



  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }
  public void drivewithjoysticks(XboxController controller){
if(controller.getLeftBumperPressed()){
  solenoid.set(Value.kForward);
} else if (controller.getLeftBumperReleased()){
  solenoid.set(Value.kReverse);
}
  }

}