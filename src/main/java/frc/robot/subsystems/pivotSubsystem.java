package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class pivotSubsystem extends SubsystemBase{
    // temporary device ID and motortype
    public final PWMSparkMax pivotMotor = new PWMSparkMax(1);

    public pivotSubsystem() {
    }

    public void pivot(double speed) {
        pivotMotor.set(speed);
    }
    @Override
    public void periodic() {

    }
    
}