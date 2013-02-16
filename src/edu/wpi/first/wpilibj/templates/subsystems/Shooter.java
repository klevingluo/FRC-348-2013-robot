/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.Shoot;

/**
 *
 * @author Programmer
 */
public class Shooter extends Subsystem {

    Jaguar feederMotor = new Jaguar(RobotMap.FRISBEE_FEEDER_SHOOTER);
    Jaguar shooterMotor = new Jaguar(RobotMap.FRISBEE_SHOOTER);
    DigitalInput feederSwitch = new DigitalInput(RobotMap.FEEDER_SHOOTER_SWITCH);
    CANJaguar shootSpeed;
    boolean doNothing = false;
    
    public Shooter() {
        try {
            shootSpeed = new CANJaguar(RobotMap.FRISBEE_SHOOTER_CAN);
        } catch(Exception e) {
            doNothing = true;
        }
    }
    
    protected void initDefaultCommand() {
        setDefaultCommand(new Shoot());
    }
    
    public void shoot(double speed) {
        shooterMotor.set(speed);
    }
    
    public void reverseShoot(double speed) {
        shooterMotor.set(-speed);
    }
    
    public void feed(double speed) {
        while(feederSwitch.get()) {
                feederMotor.set(speed);
        }
        while(!feederSwitch.get()) {
            feederMotor.set(speed);
        }
    }
    
    public boolean getSwitchValue() {
        return feederSwitch.get();
    }
    
    public double getCurrent() {
        if(doNothing) {
            try {
                return shootSpeed.getOutputCurrent();
            } catch(Exception e) {
                return 0; 
            }
        } else {
            return 0;
        }
    }
    
}
