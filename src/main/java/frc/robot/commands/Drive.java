// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandPS5Controller;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;
import frc.slicelibs.PolarJoystickFilter;
import frc.slicelibs.util.config.JoystickFilterConfig;

public class Drive extends Command {
  private Drivetrain m_drivetrain;
  private CommandPS5Controller m_driveController;
  private final PolarJoystickFilter translationFilter, rotationFilter;
  
  /** Creates a new drive. */
  public Drive(Drivetrain drivetrain, CommandPS5Controller controller) {
    m_drivetrain = drivetrain;    
    m_driveController = controller;

    translationFilter = new PolarJoystickFilter(new JoystickFilterConfig(
        0.07,
        0.9,
        1,
        1));
    rotationFilter = new PolarJoystickFilter(new JoystickFilterConfig(
        0.07,
        0.6,
        1,
        1));

    
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drivetrain.drive(0, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    //double[] translationCalculations = translationFilter.filter(m_driveController.getLeftY(), 0);
    //double[] rotationCalculations = rotationFilter.filter(0, m_driveController.getRightX());

    //m_drivetrain.drive(translationCalculations[1], rotationCalculations[0]);
    m_drivetrain.drive(m_driveController.getLeftY() / 1.99, m_driveController.getRightX() / 1.99);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.drive(0, 0);
    //m_drivetrain.setMotorsTest(0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}