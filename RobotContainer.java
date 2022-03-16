// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.DriveforwardTimed;
import frc.robot.commands.Drivewithjoysticks;
import frc.robot.subsystems.Solenoid;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ShooterMotors;
import frc.robot.subsystems.intakeDoor;



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
  private final ShooterMotors innerDrive;
  private final intakeDoor intakedoor; 
  private final Solenoid solenoid;
  
 
 

 
  private Drivewithjoysticks drivewithjoysticks;
  private final DriveforwardTimed driveforwardTimed;
  public static XboxController driverjoystick;
  

 



  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    
 

   



    driveTrain = new DriveTrain();
    innerDrive = new ShooterMotors();
    intakedoor = new intakeDoor();
    solenoid = new Solenoid();
    
    

    
   
   
    drivewithjoysticks = new Drivewithjoysticks(driveTrain, innerDrive, intakedoor, solenoid);

    driveforwardTimed = new DriveforwardTimed(driveTrain, innerDrive, intakedoor);
    driveforwardTimed.addRequirements(driveTrain);
   

    driverjoystick = new XboxController(0);

   
    drivewithjoysticks.addRequirements(innerDrive);
    drivewithjoysticks.addRequirements(intakedoor);
   
    
    
    
    innerDrive.setDefaultCommand(drivewithjoysticks);
    intakedoor.setDefaultCommand(drivewithjoysticks);


 
  


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
