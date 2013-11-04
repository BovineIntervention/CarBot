/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends SimpleRobot {
    RobotDrive drive = new RobotDrive(1,2,3,4);
    Joystick stickOfJoy = new Joystick(1);
    Gyro gyro = new Gyro(5);
    double x;
    double y;
    double magnitude;
    double angle;
    double rotation;
    double gyroRawAngle;
    double gyroAngle;
    
    
    /**
     * This function is called once each time the robot turns on.
     */
    public void robotInit() {
    }
    
    /**
     * This function is called once each time the robot is disabled.
     */
    public void disabled() {
        
    }
    
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomous() {
        
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        while(true) {
            sense();
            process();
            drive();
            dashboard();
        }
    }
    
    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {
        
    }
    /**
    
    */
    public void sense() {
        x = stickOfJoy.getRawAxis(1);
        y = stickOfJoy.getRawAxis(2);
        rotation = stickOfJoy.getRawAxis(3);
        gyroRawAngle = gyro.getAngle();
    }
    
    /**
    
    */
    public void process() {  
        gyroAngle = gyroRawAngle % 360;
        angle = MathUtils.atan2(y, x);
        magnitude = Math.max(x, y);
    }
    
    /**
     * This function sets the speed of each jaguar
     */
        public void drive() {
            drive.mecanumDrive_Cartesian(x, y, rotation, gyroRawAngle);
        }
        
        /**
         * 
         */
        public void dashboard() {
            SmartDashboard.putNumber("X", x);
            SmartDashboard.putNumber("Y", y);
            SmartDashboard.putNumber("Magnitude", magnitude);
            SmartDashboard.putNumber("Angle", angle);
            SmartDashboard.putNumber("Rotation", rotation);
            
            x = SmartDashboard.getNumber("X");
            y = SmartDashboard.getNumber("Y");
            rotation = SmartDashboard.getNumber("Rotation");
        }
}
