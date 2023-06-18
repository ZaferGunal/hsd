package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.Timer;
public class GetBalanceCmd  extends CommandBase{

private final Timer timer = new Timer();
private final DriveSubsystem  driveSubsystem;
double kBalance;
double speed;
boolean control ;
public GetBalanceCmd(DriveSubsystem driveSubsystem_p,double kBalance){
    this.driveSubsystem = driveSubsystem_p;
    this.kBalance = kBalance;
    addRequirements(driveSubsystem);
}


    @Override
    public void initialize() {
        control = false;
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
    speed = driveSubsystem.getGyro_per() * kBalance;
    driveSubsystem.setMotors(speed,0);
    if(speed == 0){
        timer.start();
        if(timer.get() >= 1 && speed == 0){
            control = true;
        };
        
    
    
    }



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



