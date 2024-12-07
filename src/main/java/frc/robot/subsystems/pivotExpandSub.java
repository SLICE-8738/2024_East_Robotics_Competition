// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class pivotExpandSub extends SubsystemBase {
  /** Creates a new pivotExpandSub. */
  // CHANGE THE CHANNEL
  public final PWMSparkMax pivotExpand = new PWMSparkMax(9);
  
  public pivotExpandSub() {

  }

  public void expandPivot(double speed) {
    pivotExpand.set(speed);
  }
  @Override
  public void periodic() {
  }
}
