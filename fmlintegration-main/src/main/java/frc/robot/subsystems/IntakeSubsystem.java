// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.RelativeEncoder;
public class IntakeSubsystem extends SubsystemBase {

  /** Creates a new ExampleSubsystem. */
  //CANSparkMax BottomMotor = new CANSparkMax(Constants.DrivetrainConstants.BottomMotorCANID, CANSparkLowLevel.MotorType.kBrushless);
//CANSparkMax TopMotor = new CANSparkMax (Constants.DrivetrainConstants.TopMotorCANID, CANSparkLowLevel.MotorType.kBrushless);

TalonSRX TopMotor = new TalonSRX(Constants.DrivetrainConstants.TopMotorID);
TalonSRX BottomMotor = new TalonSRX(Constants.DrivetrainConstants.BottomMotorID);

//CANSparkMax PivotPoint = new CANSparkMax (Constants.DrivetrainConstants.LeftBackCANID, CANSparkLowLevel.MotorType.kBrushless);

// RelativeEncoder leftEncoder = LeftFrontMotor.getEncoder();
// RelativeEncoder rightEncoder = RightFrontMotor.getEncoder();

public void controlIntake(double intakeSpeed) {
    TopMotor.set(TalonSRXControlMode.PercentOutput, intakeSpeed);
    BottomMotor.set(TalonSRXControlMode.PercentOutput, intakeSpeed);

}


//DifferentialDrive differentialDrive = new DifferentialDrive(leftMotorControllerGroup, RightMotorControllerGroup);
  public IntakeSubsystem() {
 

  //PivotPoint.restoreFactoryDefaults();
  //LeftBackMotor.follow(LeftFrontMotor);
 


  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

//   @Override
//   public void simulationPeriodic() {
//     // This method will be called once per scheduler run during simulation
  //public void IntakewithJoystickCommand(double Speed1, double Speed2) {
    

   // BottomMotor.set(Speed1);
   // TopMotor.set(Speed2);

    

  }
  
 