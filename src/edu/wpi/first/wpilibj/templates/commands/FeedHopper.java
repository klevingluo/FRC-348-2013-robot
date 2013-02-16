/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Programmer
 */
public class FeedHopper extends CommandBase{

    protected void initialize() {
        requires(hopper);
    }

    protected void execute() {
        if (oi.rightStick.getRawButton(3)) {
            while(hopper.getSwitchValue()) {
                hopper.feed(HOPPER_FEEDER_SPEED);
            }
            while(!hopper.getSwitchValue()) {
                hopper.feed(HOPPER_FEEDER_SPEED);
            }
        } else {
            hopper.stop();
        }
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
