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
        requires(shooter);
    }

    protected void initialize() {
    }

    protected void execute() {
        if(oi.leftStick.getRawButton(7)) {
            while(shooter.getSwitchValue()) {
                    shooter.feed(FEEDER_SPEED);
            }
            while(!shooter.getSwitchValue()) {
                shooter.feed(FEEDER_SPEED);
            }
        }
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        shooter.feed(0);
    }

    protected void interrupted() {
        shooter.feed(0);
    }
    
}
