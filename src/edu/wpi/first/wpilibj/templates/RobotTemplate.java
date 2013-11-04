/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.Joystick;
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
    Victor FL = new Victor(1);
    Victor FR = new Victor(2);
    Victor BL = new Victor(3);
    Victor BR = new Victor(4);
    Joystick stickOfJoy = new Joystick(1);
    double x;
    double y;
    
    double magnitude;
    double angle;
    
    double FLSpeed;
    double FRSpeed;
    double BLSpeed;
    double BRSpeed;
    /**
     * This function is called once each time the robot turns on.
     */
    public void robotInit() {
        operatorControl();
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
            dashboard();
            drive();
        }
    }
    
    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {
        
    }
    /**
     * This function sets the speed of each jaguar
     */
        public void drive() {
            magnitude = Math.max(x, y);
            angle = MathUtils.atan2(y, x) / Math.PI;
            /*
            angle = .5 --> forward -->  +;+;+;+
            angle = 0 ----> right --->  +;-;+;-
            angle = 1, -1 --> left -->  -;+;-;+
            angle = -.5 ---> back --->  -;-;-;-
            */
            FLSpeed = magnitude;
            FRSpeed = magnitude;
            BLSpeed = magnitude;
            BRSpeed = magnitude;
            
        }
        
        public void dashboard()
        {
            SmartDashboard.putNumber("X", stickOfJoy.getRawAxis(1));
            SmartDashboard.putNumber("Y", stickOfJoy.getRawAxis(2));
            SmartDashboard.putNumber("Magnitude", magnitude);
            SmartDashboard.putNumber("Angle", angle);
            SmartDashboard.putNumber("Front Left Wheel Speed", FLSpeed);
            SmartDashboard.putNumber("Front Right Wheel Speed", FRSpeed);
            SmartDashboard.putNumber("Back Left Wheel Speed", BLSpeed);
            SmartDashboard.putNumber("Back Right Wheel Speed", BRSpeed);
            
            x = SmartDashboard.getNumber("X");
            y = SmartDashboard.getNumber("Y");
        }
}
