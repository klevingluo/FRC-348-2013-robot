/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Programmer
 */
public class Feed extends CommandBase {
    
    public Feed() {
        requires(feeder);
    }

    protected void initialize() {
        feeder.feed(FEEDER_SPEED);
    }

    protected void execute() {
        //if(oi.leftStick.getRawButton(3)) {
            //while(shooter.getSwitchValue()) {
            //}
            //while(!shooter.getSwitchValue()) {
            //    shooter.feed(FEEDER_SPEED);
            //}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        feeder.feed(0);
    }

    protected void interrupted() {
        feeder.feed(0);
    }
    
}
