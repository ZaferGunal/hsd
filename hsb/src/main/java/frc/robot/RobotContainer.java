// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.ArcadeDriveCmd;
import frc.robot.commands.DriveForwardCmd;
import frc.robot.commands.TurnLeftCmd;
import frc.robot.commands.TurnRightCmd;
import frc.robot.commands.CalibrateGyroPerCmd;
import frc.robot.commands.GetBalanceCmd;
public class RobotContainer {

private final DriveSubsystem driveSubsystem  = new DriveSubsystem();
private final Joystick joystick = new Joystick(0);
  
  public RobotContainer(){
   driveSubsystem.setDefaultCommand(
    new ArcadeDriveCmd(driveSubsystem, () ->joystick.getRawAxis(0), () ->joystick.getRawAxis(1))
    );
    

    configureBindings();
  }


  private void configureBindings() {

  }

  public Command getAutonomousCommand() {

   new SequentialCommandGroup(
    
   new CalibrateGyroPerCmd(driveSubsystem),new DriveForwardCmd(driveSubsystem,4.5), new TurnLeftCmd(driveSubsystem),
   new GetBalanceCmd(driveSubsystem, 0.3)
   );

   return null;

  }
}
