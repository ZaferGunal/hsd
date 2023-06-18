package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.ctre.phoenix.sensors.CANCoder;
import com.revrobotics.AbsoluteEncoder;

public class IntakeSubsytem extends SubsystemBase {
  
    CANSparkMax motor = new CANSparkMax(5,MotorType.kBrushless);
    private final double pulseToCM = 420.0;
               
  
    
   
    


    
}
