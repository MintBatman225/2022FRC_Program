// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
// importing our command class



/** This is a demo program showing how to use Mecanum control with the MecanumDrive class. */
public class Robot extends TimedRobot {

  Servo exampleServo1 = new Servo(Constants.SERVO_ONE);
  Servo exampleServo2 = new Servo(Constants.SERVO_TWO);

  


  
   
    
 DoubleSolenoid Armsolenoid= new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1,0 );


  private Command m_autonomousCommand;


  private RobotContainer m_robotContainer;
 
  @Override



  public void robotInit() {

    
    m_robotContainer = new RobotContainer();
// assign motors to their ports
  CameraServer.startAutomaticCapture(); 

  }


  @Override
  public void robotPeriodic() {
 
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }


    // schedule the autonomous command (example)
  
  
  

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
   
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    
    XboxController controller = new XboxController(0);

   if(controller.getAButtonPressed()){

      Armsolenoid.set(Value.kForward);
  
  }   else if (controller.getAButtonReleased()){
  
      Armsolenoid.set(Value.kOff);
     
  } else if(controller.getYButtonPressed()){

    Armsolenoid.set(Value.kReverse);

}   else if (controller.getYButtonReleased()){
    Armsolenoid.set(Value.kOff);

}
  if (controller.getLeftBumper()){
    exampleServo1.setPosition(1);
    exampleServo2.setPosition(0);
  
  } else if(controller.getRightBumper()){
    exampleServo1.setPosition(0.3);
       exampleServo2.setPosition(0.7);
      
 
  } else {
    exampleServo1.setPosition(0.5);
       exampleServo2.setPosition(0.5);
}

  
  }
    
  

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
  
