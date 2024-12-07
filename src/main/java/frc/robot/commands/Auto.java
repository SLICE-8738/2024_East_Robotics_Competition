// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import org.opencv.core.Mat;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.Constants;
import frc.robot.LimelightHelpers;
import frc.robot.LimelightTable;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.SliceLimelight;
import frc.robot.subsystems.pivotSubsystem;
import frc.robot.subsystems.rollers;



public class Auto extends Command {

  private final Drivetrain m_drivetrain;
  private final Timer m_auto_timer;
  private final Timer m_pivot_timer;
  private final pivotSubsystem m_pivot;

  /** Creates a new Auto. */
  public Auto(Drivetrain drivetrain, Timer auto_timer, Timer pivot_timer, pivotSubsystem pivot) {

    addRequirements(drivetrain);

    m_drivetrain = drivetrain;
    m_auto_timer = auto_timer;
    m_pivot_timer = pivot_timer;
    m_pivot = pivot;


  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drivetrain.drive(0, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_auto_timer.start();
    m_drivetrain.drive(-0.75, 0);

    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.drive(0,0);
    m_pivot.pivot(0.7);
    if (m_pivot_timer.get() > 1) {
      m_pivot.pivot(0);
      m_pivot_timer.stop();
    }
  } 

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (m_auto_timer.get() > 1) {
      m_auto_timer.stop();
      m_pivot_timer.start();
      return true;
    } else {
      return false;
    }
  }
}
