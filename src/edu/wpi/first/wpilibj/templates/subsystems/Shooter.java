/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.Shoot;

/**
 *
 * @author Programmer
 */
public class Shooter extends Subsystem {

    Jaguar feederMotor = new Jaguar(RobotMap.FRISBEE_FEEDER);
    Jaguar shooterMotor = new Jaguar(RobotMap.FRISBEE_SHOOTER);
    
    protected void initDefaultCommand() {
        setDefaultCommand(new Shoot());
    }
    
    public void shoot(double speed) {
        shooterMotor.set(speed);
    }
    
    public void feed(double speed) {
        feederMotor.set(speed);
    }
    
}
