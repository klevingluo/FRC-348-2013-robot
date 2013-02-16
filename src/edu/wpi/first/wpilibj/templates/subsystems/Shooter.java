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

    Jaguar shooterMotor = new Jaguar(RobotMap.FRISBEE_SHOOTER);
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
