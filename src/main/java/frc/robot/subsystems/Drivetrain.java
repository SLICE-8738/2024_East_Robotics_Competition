package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.VecBuilder;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.estimator.SwerveDrivePoseEstimator;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {

  private CANSparkMax left, right;
  private RelativeEncoder leftEncoder, rightEncoder;
  private DifferentialDrive driveTrain;


  /** Creates a new Drivetrain. */
  public Drivetrain() {

    //change the device ids on the CANSparkMaxs
    left = new CANSparkMax(15, MotorType.kBrushless);
    right = new CANSparkMax(17, MotorType.kBrushless);

    left.setSmartCurrentLimit(35);
    right.setSmartCurrentLimit(35);

    leftEncoder = left.getEncoder();
    rightEncoder = right.getEncoder();

    driveTrain = new DifferentialDrive(left, right);
  }

  public void drive(double forwardSpeed, double rotationSpeed){
    driveTrain.arcadeDrive(forwardSpeed, rotationSpeed);
  }
    
    @Override
    public void periodic() {
      // This method will be called once per scheduler run
    }
}