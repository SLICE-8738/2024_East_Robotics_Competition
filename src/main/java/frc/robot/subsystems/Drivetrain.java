package frc.robot.subsystems;

import com.revrobotics.RelativeEncoder;

import edu.wpi.first.math.VecBuilder;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.estimator.SwerveDrivePoseEstimator;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMMotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {

  private PWMSparkMax leftMotor, rightMotor;
  private Encoder leftEncoder, rightEncoder;
  private DifferentialDrive driveTrain;


  /** Creates a new Drivetrain. */
  public Drivetrain() {
    leftMotor = new PWMSparkMax(0);
    rightMotor = new PWMSparkMax(1); // TODO: Change channel IDs when able to

    //TODO: CORRECT THE DEFINTION (3 PARAMETERS)

    //leftEncoder = new Encoder();

    //rightEncoder = new Encoder();

    driveTrain = new DifferentialDrive(leftMotor, rightMotor);
  }

  public void drive(double forwardSpeed, double rotationSpeed){
    driveTrain.arcadeDrive(forwardSpeed, rotationSpeed);
  }
    
    @Override
    public void periodic() {
      // This method will be called once per scheduler run
    }
}