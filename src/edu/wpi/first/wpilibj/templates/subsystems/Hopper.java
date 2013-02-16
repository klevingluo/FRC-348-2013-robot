/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.FeedHopper;

/**
 *
 * @author Programmer
 */
public class Hopper extends Subsystem{
    
    protected Jaguar hopperFeeder = new Jaguar(RobotMap.FRISBEE_FEEDER_HOPPER);
    DigitalInput feederSwitch = new DigitalInput(RobotMap.FEEDER_HOPPER_SWITCH);

    protected void initDefaultCommand() {
        setDefaultCommand(new FeedHopper());
    }
    
    public void feed(int speed) {
        hopperFeeder.set(speed);
    }
    
    public void stop() {
        hopperFeeder.set(0);
    }
    
    public boolean getSwitchValue() {
        return feederSwitch.get();
    }
}
