// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Shootercommands;

import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.RobotContainer;

/** An example command that uses an example subsystem. */
public class ShooterReset extends Command {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final ShooterSubsystem shooterSubsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ShooterReset(ShooterSubsystem shooterSubsystem) {
    this.shooterSubsystem = shooterSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(shooterSubsystem);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("Starting intake command");

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    /*
     * if (RobotContainer.xboxController.getAButton()) {
     * shooterSpeed = 0.5;
     * }
     * else if (RobotContainer.xboxController.getBButton()){
     * shooterSpeed = 0.7;
     * } else if (RobotContainer.xboxController.getXButton()){
     * shooterSpeed = 0.9;
     * } else {
     * shooterSpeed = 0;
     * }
     */

    // shooterSubsystem.resetEncoders();
    shooterSubsystem.resetEncoders();
    // testing

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
