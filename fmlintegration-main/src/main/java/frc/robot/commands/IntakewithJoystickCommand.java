// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
/** An example command that uses an example subsystem. */
public class IntakewithJoystickCommand extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final IntakeSubsystem DrivetrainSubsystem;
    double BottomMotor = 0;
    double TopMotor = 0;
// }
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public IntakewithJoystickCommand(IntakeSubsystem subsystem) {
    this.DrivetrainSubsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(DrivetrainSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("Starting Joystick drive command");
    BottomMotor = 0;
    TopMotor = 0;
  } 

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
       if (RobotContainer.xboxController.getBackButton()) {
      //this is intake
      BottomMotor = 0.1;
      TopMotor = -0.1;
    
  }
     else if (RobotContainer.xboxController.getStartButton()){
//this is outtake
BottomMotor = -0.1;
TopMotor = 0.1;
     }
     else {
      BottomMotor = 0;
      TopMotor = 0;
    }
     // DrivetrainSubsystem.IntakewithJoystickCommand(BottomMotor, TopMotor);

  }

  // Called once the command ends or is interrupted.
  @Override
public void end(boolean interrupted) {} 
  

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
