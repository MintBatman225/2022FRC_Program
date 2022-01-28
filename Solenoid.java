// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants;
import frc.robot.RobotContainer;



public class Solenoid extends SubsystemBase {

  /** Creates a new Solenoid. */
 // private DoubleSolenoid arm;
  public Solenoid(){
  Compressor Comp = new Compressor(null);
   DoubleSolenoid arm = new DoubleSolenoid( null, 0, 1);
  }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }
  public void drivewithjoysticks(XboxController controller, double speed){

  }
 Button aButton = new JoystickButton(RobotContainer.driverJoystick, Constants.A_BUTTON);
  {
  
  aButton.whenPressed(arm.set(DoubleSolenoid.Value.kReverse));
    
  }
 Button bButton = new JoystickButton(RobotContainer.driverJoystick, Constants.B_BUTTON);
  {
   bButton.whenPressed(arm.set(DoubleSolenoid.Value.kForward));

  }
}