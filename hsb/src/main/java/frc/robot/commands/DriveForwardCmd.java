package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
public class DriveForwardCmd extends CommandBase {
    DriveSubsystem driveSubsystem;
    double setPoint;
    double meterToPulse  = 42 /(0.0254 * 6 * Math.PI);                                   // 0.0254 * 6 * Math.PI / 42;



    public DriveForwardCmd(DriveSubsystem driveSubsystem_p,double setPoint_p){
      this.driveSubsystem = driveSubsystem_p;
      this.setPoint = setPoint_p;
      addRequirements(driveSubsystem);
    }
    

  @Override
  public void initialize() {
    
  }

  @Override
  public void execute() {
    driveSubsystem.setMotors(-0.5,0);
  }


  @Override
  public void end(boolean interrupted) {
    driveSubsystem.setMotors(0,0);
  
  }

  @Override
  public boolean isFinished() {
    if(driveSubsystem.getEncoderPulse() >= setPoint * meterToPulse){
      return true;
    }
    else{
    return false;
    }
  }


}
