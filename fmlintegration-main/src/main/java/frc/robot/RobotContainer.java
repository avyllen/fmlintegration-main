// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.IntakewithJoystickCommand;
import frc.robot.commands.Shootercommands.ShooterReset;
import frc.robot.commands.Shootercommands.ShooterPosition.ShooterPosition0;
import frc.robot.commands.Shootercommands.ShooterPosition.ShooterPosition50;
import frc.robot.commands.Shootercommands.ShooterPosition.ShooterPositionN70;
import frc.robot.commands.Shootercommands.ShooterSpeeds.ShooterSpeed0;
import frc.robot.commands.Shootercommands.ShooterSpeeds.ShooterSpeed50;
import frc.robot.commands.Shootercommands.ShooterSpeeds.ShooterSpeed85;
import frc.robot.commands.Shootercommands.ShooterSpeeds.ShooterSpeed90;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj.Joystick;



/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);
        // The robot's subsystems and commands are defined here...
  private final IntakeSubsystem drivetrainSubsystem = new IntakeSubsystem();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final IntakewithJoystickCommand DrivewithJoystickCommand = new IntakewithJoystickCommand(drivetrainSubsystem);

public static XboxController xboxController = new XboxController(1);
public static Joystick joystick = new Joystick(0);
public static Object Joystick;


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    shooterSubsystem.setDefaultCommand(new ShooterSpeed0(shooterSubsystem));
    drivetrainSubsystem.setDefaultCommand(DrivewithJoystickCommand);
    new Trigger(drivetrainSubsystem::exampleCondition)
    .onTrue(new IntakewithJoystickCommand(drivetrainSubsystem));
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

    // CONTROLS SHOOTER SPEED :>
   new JoystickButton(xboxController,1).toggleOnTrue(new ShooterSpeed0(shooterSubsystem));
   new JoystickButton(xboxController,2).toggleOnTrue(new ShooterSpeed50(shooterSubsystem));
   new JoystickButton(xboxController,3).toggleOnTrue(new ShooterSpeed85(shooterSubsystem));
   new JoystickButton(xboxController,4).toggleOnTrue(new ShooterSpeed90(shooterSubsystem));

   new JoystickButton(joystick,8).toggleOnTrue(new ShooterPosition0(shooterSubsystem));
   new JoystickButton(joystick,10).toggleOnTrue(new ShooterPosition50(shooterSubsystem));
   new JoystickButton(joystick,12).toggleOnTrue(new ShooterPositionN70(shooterSubsystem));
   new JoystickButton(joystick,7).toggleOnTrue(new ShooterReset(shooterSubsystem));

// CONTROLS INTAKE :>
  // new JoystickButton(joystick, 2).toggleonTrue(new IntakeSpeed70(drivetrainSubsystem));

  
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(drivetrainSubsystem);
    }
}
