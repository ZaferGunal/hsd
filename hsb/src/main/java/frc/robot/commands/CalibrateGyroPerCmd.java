package frc.robot.commands;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;



public class CalibrateGyroPerCmd extends CommandBase{

  private final DriveSubsystem  driveSubsystem;
  boolean control = false;
  public CalibrateGyroPerCmd(DriveSubsystem driveSubsystem_p){
      this.driveSubsystem = driveSubsystem_p;
      addRequirements(driveSubsystem);
  }


    @Override
    public void initialize() {
      driveSubsystem.calibrateGyro_per();
      control = true;
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
    }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return control;
    }



}
