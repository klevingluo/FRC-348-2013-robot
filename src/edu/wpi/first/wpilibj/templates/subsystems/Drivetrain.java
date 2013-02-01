/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalModule;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.Drive;

/**
 *
 * @author Programmer
 */
public class Drivetrain extends Subsystem{

    public Jaguar leftMotorFront = new Jaguar(RobotMap.LEFT_DRIVE_FRONT);
    public Jaguar leftMotorBack = new Jaguar(RobotMap.LEFT_DRIVE_BACK);
    public Jaguar rightMotorFront = new Jaguar(RobotMap.RIGHT_DRIVE_FRONT);
    public Jaguar rightMotorBack = new Jaguar(RobotMap.RIGHT_DRIVE_BACK);
    
    public byte[] buffer = new byte[1];
    
    I2C displacement = (DigitalModule.getInstance(RobotMap.MOUSE_ARDUINO_MODULE).getI2C(RobotMap.MOUSE_ADDRESS));
    
    protected void initDefaultCommand() {
        setDefaultCommand(new Drive());
    }
    
    public void drive(double leftSpeed, double rightSpeed) {
        leftMotorFront.set(leftSpeed);
        leftMotorBack.set(leftSpeed);
        rightMotorFront.set(rightSpeed);
        rightMotorBack.set(rightSpeed);
    }
    
    public byte getText() {
        displacement.setCompatabilityMode(true);
        for(int i = 0; i < 127; i++) {
            if(displacement.verifySensor(i, 1, buffer)) {
                System.out.println("g");
            }
        }
        displacement.read(RobotMap.MOUSE_ADDRESS, 1, buffer);
        return buffer[0];
    }
    
    public double getAngle() {
        long theta = 0;
        displacement.read(RobotMap.MOUSE_ADDRESS, 7, buffer);
        for(int i = 0; i < buffer.length; i++) {
            theta = (theta + buffer[i]) << 8;
        }
        return (double)theta;
    }
    
    public void correct(double leftSpeed, double rightSpeed, double angle) {
    }
    
}
