// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.pivotSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandPS5Controller;

/** An example command that uses an example subsystem. */
public class pivotCommands extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  public final pivotSubsystem pivotCommand;
  Joystick joystick = new Joystick(0);
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public pivotCommands(pivotSubsystem subsystem) {
    pivotCommand = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("Trying to start pivot arm...");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      double bothwaysSpeed = joystick.getX();
      pivotCommand.pivot(bothwaysSpeed);
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
