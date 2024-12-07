// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandPS5Controller;
import frc.robot.subsystems.pivotExpandSub;

public class pivotExpandCommand extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  public final pivotExpandSub expandCommand;
  private CommandPS5Controller m_operator;
  /** Creates a new pivotExpandCommand. */
  public pivotExpandCommand(pivotExpandSub Sub, CommandPS5Controller expandJoystick) {
    expandCommand = Sub;
    m_operator = expandJoystick;
    /**
   * Creates a new ExampleCommand.
   *
   * @param expandCommand The subsystem used by this command.
   */
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(expandCommand);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  
  @Override
  public void execute() {
    double Speed = m_operator.getLeftY();
    expandCommand.expandPivot(Speed);
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
      expandCommand.expandPivot(0); }
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
