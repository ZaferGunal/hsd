package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import java.util.function.Supplier;
public class ArcadeDriveCmd extends CommandBase{
    
    private final DriveSubsystem driveSubsystem ;
    Supplier<Double> yFunction,xFunction;

public ArcadeDriveCmd(DriveSubsystem driveSubsystem, Supplier<Double> yFunction , Supplier<Double> xFunction){
this.driveSubsystem = driveSubsystem;
this.xFunction = xFunction;
this.yFunction = yFunction;
addRequirements(driveSubsystem);
}






    ///////////////////////////////////////////
  @Override
  public void initialize() {}

  
  @Override
  public void execute() {
    driveSubsystem.setArcade(yFunction.get(),xFunction.get());
  }

  
  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
