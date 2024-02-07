// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


package frc.robot.subsystems;


import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkLowLevel.MotorType;


public class ShooterSubsystem extends SubsystemBase {
private CANSparkFlex tshooter;
private CANSparkFlex bshooter;

PIDController pid = new PIDController(0.01, 0, 0);


 /** Creates a new ShooterSubsystem. */
 public ShooterSubsystem() {
//tshooter1 = new TalonFX(Constants.ShooterConstants.tshooter1ID);
//bshooter2 = new TalonFX(Constants.ShooterConstants.bshooter2ID);

//tshooter = new CANSparkFlex(1, MotorType.kBrushless);
//bshooter = new CANSparkFlex(4, MotorType.kBrushless);

tshooter = new CANSparkFlex(Constants.ShooterConstants.tshooterID, MotorType.kBrushless);
//bshooter = new CANSparkFlex(Constants.ShooterConstants.bshooterID, MotorType.kBrushless);
 }

public void controlShooter(double shooterSpeed) {
   tshooter.set(shooterSpeed);
   bshooter.set(shooterSpeed);
 }
 public void PIDControl(double position) {
   //tshooter.set(-pid.calculate(position,tshooter.getPosition().getValue()));
   //bshooter.set(-pid.calculate(position,bshooter.getPosition().getValue()));
   tshooter.set(-pid.calculate(position,tshooter.getEncoder().getPosition()));
   bshooter.set(-pid.calculate(position,tshooter.getEncoder().getPosition()));
 } 
 public void resetEncoders() {
  //tshooter.setPosition(0);
  //bshooter.setPosition(0);

  tshooter.getEncoder().setPosition(0);
  //bshooter.getEncoder().setPosition(0);
 }

 @Override
 public void periodic() {
   // This method will be called once per scheduler run
  // SmartDashboard.putNumber("tshooter1 Encoder", tshooter1.getPosition().getValue());
   //SmartDashboard.putNumber("bshooter2 Encoder", bshooter2.getPosition().getValue());

 }
 public void setspeed(double speed1) {
  
  }
}



