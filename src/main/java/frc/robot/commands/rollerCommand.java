// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandPS5Controller;
import frc.robot.subsystems.rollers;

public class rollerCommand extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  public final rollers rollersub;
  private CommandPS5Controller m_rollerOperator;
  int a = 0;
  int b = 0;
  /** Creates a new rollerCommand. */
  public rollerCommand(rollers roll, CommandPS5Controller rollJoystick) {
    rollersub = roll;
    m_rollerOperator = rollJoystick;
    addRequirements(rollersub);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //a=0;
    //b=0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() { 
    // might not work
    if (m_rollerOperator.L1().getAsBoolean()) {
      rollersub.roll(0.6);
    }
    else if (m_rollerOperator.R1().getAsBoolean()) {
      rollersub.roll(-0.6);
    }
    else {
      rollersub.roll(0);
    }
  }
/* 
    // hold to keep it turn
    while (m_rollerOperator.L1().getAsBoolean()) {
      rollersub.roll(1);
    }
    while (m_rollerOperator.R1().getAsBoolean()) {
      rollersub.roll(-1);
    }
    rollersub.roll(0);
  }
*/


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    rollersub.roll(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
