package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxAbsoluteEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

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
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {

  private PWMSparkMax leftMotor, rightMotor;
  //private Encoder leftEncoder, rightEncoder;
  private DifferentialDrive driveTrain;


  /** Creates a new Drivetrain. */
  public Drivetrain() {
    leftMotor = new PWMSparkMax(8);
    rightMotor = new PWMSparkMax(9); // TODO: Change channel IDs when able to

    //TODO: CORRECT THE DEFINTION (3 PARAMETERS)

    //leftEncoder = new Encoder();

    //rightEncoder = new Encoder();

    driveTrain = new DifferentialDrive(leftMotor, rightMotor);
  }

  public void drive(double forwardSpeed, double rotationSpeed){
    driveTrain.arcadeDrive(forwardSpeed, rotationSpeed);
  }

  public void setMotorsTest(double speed){
    leftMotor.set(speed);
    rightMotor.set(speed);
  }
    
    @Override
    public void periodic() {
      // This method will be called once per scheduler run
    }
}