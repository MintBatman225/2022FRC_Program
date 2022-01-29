// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj.Compressor;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DriveforwardTimed;
import frc.robot.commands.Drivewithjoysticks;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.InnerDrive;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  Compressor Comp = new Compressor( PneumaticsModuleType.CTREPCM);
  
 





  // The robot's subsystems and commands are defined here...
  

  private final DriveTrain driveTrain;
  private final InnerDrive innerDrive;
 
  private Drivewithjoysticks drivewithjoysticks;
  private final DriveforwardTimed driveforwardTimed;
  public static XboxController driverjoystick;
  public static Compressor comp;

 



  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    
 

   



    driveTrain = new DriveTrain();
    innerDrive = new InnerDrive();
   
   
    drivewithjoysticks = new Drivewithjoysticks(driveTrain, innerDrive);
    driveforwardTimed = new DriveforwardTimed(driveTrain, innerDrive);
    driveforwardTimed.addRequirements(driveTrain);
    driveforwardTimed.addRequirements(innerDrive);

    driverjoystick = new XboxController(0);
    
    drivewithjoysticks.addRequirements(innerDrive);
    
    innerDrive.setDefaultCommand(drivewithjoysticks);

   


    // Configure the button bindings
    configureButtonBindings();
  
  
  }
  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
   
    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return driveforwardTimed;
  }
}
