package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.ctre.phoenix.sensors.CANCoder;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI;
public class DriveSubsystem extends SubsystemBase{

ADXRS450_Gyro gyro_hex = new ADXRS450_Gyro();
ADXRS450_Gyro gyro_per = new ADXRS450_Gyro();

  double pulseToMeter = 0.0254 * 6 * Math.PI / 42;

Encoder encoder = new Encoder(0,1);

CANSparkMax m_frontLeft = new CANSparkMax(3,MotorType.kBrushless);
CANSparkMax m_rearLeft = new CANSparkMax(4,MotorType.kBrushless);
MotorControllerGroup m_left = new MotorControllerGroup(m_frontLeft, m_rearLeft );

CANSparkMax m_frontRight = new CANSparkMax(1,MotorType.kBrushless);
CANSparkMax m_rearRight = new CANSparkMax(2,MotorType.kBrushless);
MotorControllerGroup m_right = new MotorControllerGroup(m_frontRight,m_rearRight);

CANCoder cancoder = new CANCoder(0);      // device number ?
DifferentialDrive drive = new DifferentialDrive(m_left,m_right);

double actSpeed;
double turnSpeed;
public void setArcade(double yAxis,double xAxis){
drive.arcadeDrive(yAxis,xAxis);
}


public void setMotors(double yAxis,double xAxis){
actSpeed = -yAxis;
turnSpeed = xAxis;
m_left.set(actSpeed + turnSpeed);
m_right.set(actSpeed - turnSpeed);
}

public double getEncoderPulse(){
  return encoder.getRaw() ;
  
}

   
public void turnLeft(){
while(gyro_hex.getAngle() <= 90){                                 // açıları ayarla!!1!
  m_left.set(-0.5);
  m_right.set(0.5);
}
}

public void turnRight(){
  while(gyro_hex.getAngle() >= -90){
    m_left.set(0.5);
    m_right.set(-0.5);
  }
}

public void resetGyro_hex(){
gyro_hex.reset();
}

public double getGyro_per(){
  return gyro_hex.getAngle();
}
public void resetGyro_per(){
  gyro_per.reset();
}
public void calibrateGyro_per(){
  gyro_per.calibrate();
}



}
