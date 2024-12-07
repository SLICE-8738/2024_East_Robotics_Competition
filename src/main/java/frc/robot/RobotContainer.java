// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Auto;
import frc.robot.commands.Drive;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.pivotCommands;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.pivotExpandSub;
import frc.robot.commands.pivotExpandCommand;
import frc.robot.commands.rollerCommand;
import frc.robot.subsystems.pivotSubsystem;
import frc.robot.subsystems.rollers;

import edu.wpi.first.wpilibj.Timer;

import edu.wpi.first.wpilibj.PS5Controller;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandPS5Controller;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  private final Drivetrain m_Drivetrain = new Drivetrain();
  private final pivotSubsystem m_PivotSubsystem = new pivotSubsystem();
  private final Timer m_Auto_Timer = new Timer();
  private final CommandPS5Controller m_DriverController = new CommandPS5Controller(Constants.OperatorConstants.DRIVER_CONTROLLER_PORT);
  private final CommandPS5Controller m_OperatorController = new CommandPS5Controller(Constants.OperatorConstants.OPERATOR_CONTROLLER_PORT);

  private final Drive m_DriveCommand = new Drive(m_Drivetrain, m_DriverController);
  private final pivotCommands m_PivotCommands =  new pivotCommands(m_PivotSubsystem, m_OperatorController);


  /* private final pivotExpandSub m_expansion = new pivotExpandSub();
  private final pivotExpandCommand m_expansionCommand = new pivotExpandCommand(m_expansion, m_OperatorController); */
  
  private final rollers roller = new rollers();
  private final rollerCommand  rollCommand = new rollerCommand(roller, m_OperatorController);

  private final Auto m_Auto = new Auto(m_Drivetrain, m_Auto_Timer);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    
    m_Drivetrain.setDefaultCommand(m_DriveCommand);
    m_PivotSubsystem.setDefaultCommand(m_PivotCommands);
    roller.setDefaultCommand(rollCommand);


  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
   public Command getAutonomousCommand() {
    //An example command will be run in autonomous
    return m_Auto;
  }
}
