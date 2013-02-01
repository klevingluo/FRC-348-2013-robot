/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.Climb;

/**
 *
 * @author Programmer
 */
public class Climber extends Subsystem {

    Jaguar leftClimbMotor = new Jaguar(RobotMap.LEFT_CLIMB);
    Jaguar rightClimbMotor = new Jaguar(RobotMap.RIGHT_CLIMB);
    
    protected void initDefaultCommand() {
        setDefaultCommand(new Climb());
    }
    
    public void climb(double leftSpeed, double rightSpeed) {
        leftClimbMotor.set(leftSpeed);
        rightClimbMotor.set(rightSpeed);
    }
    
}
