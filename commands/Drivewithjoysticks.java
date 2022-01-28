// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.InnerDrive;
import frc.robot.subsystems.Solenoid;


public class Drivewithjoysticks extends CommandBase {
  private final DriveTrain driveTrain;
  private final InnerDrive innerDrive;
  private final Solenoid solenoid;
  /** Creates a new Drivewithjoysticks. */
  public Drivewithjoysticks(DriveTrain dt, InnerDrive di, Solenoid ds) {
    driveTrain = dt;
    innerDrive = di;
    solenoid = ds;
    addRequirements(solenoid);
    addRequirements(driveTrain);
    addRequirements(innerDrive);
    // Use addRequirements() here to declare subsystem dependencies.

  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveTrain.drivewithjoysticks(RobotContainer.driverJoystick, Constants.DRIVETRAINSPEED);
    InnerDrive.drivewithjoysticks(RobotContainer.driverJoystick, Constants.INNERDRIVESPEED);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
