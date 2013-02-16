/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.Feed;

/**
 *
 * @author Programmer
 */
public class Feeder extends Subsystem{

    Jaguar feederMotor = new Jaguar(RobotMap.FRISBEE_FEEDER_SHOOTER);
    DigitalInput feederSwitch = new DigitalInput(RobotMap.FEEDER_SHOOTER_SWITCH);
    
    protected void initDefaultCommand() {
        setDefaultCommand(new Feed());
    }
    
    public void feed(double speed) {
        /*while(feederSwitch.get()) {
                feederMotor.set(speed);
        }
        while(!feederSwitch.get()) {
            feederMotor.set(speed);
        }*/ 
        feederMotor.set(speed);
    }
    
    public boolean getSwitchValue() {
        return feederSwitch.get();
    }
    
}
