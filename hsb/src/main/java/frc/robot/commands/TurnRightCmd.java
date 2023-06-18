package frc.robot.commands;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TurnRightCmd extends CommandBase{
    private final DriveSubsystem driveSubsystem;

    public TurnRightCmd(DriveSubsystem driveSubsystem){
        this.driveSubsystem = driveSubsystem;
        addRequirements(driveSubsystem);

    }
       
    @Override
    public void initialize() {
    driveSubsystem.resetGyro_hex();
 
    } 
  
    @Override
    public void execute() {
        driveSubsystem.turnRight();
    }
  
    @Override
    public void end(boolean interrupted) {}
  
    @Override
    public boolean isFinished() {
      return false;
    }



}