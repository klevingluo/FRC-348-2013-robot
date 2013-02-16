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

    public FeedHopper() {
        requires(hopper);
    }
    
    protected void initialize() {
        hopper.feed(HOPPER_FEEDER_SPEED);
    }

    protected void execute() {

    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        hopper.stop();
    }

    protected void interrupted() {
        hopper.stop();
    }
    
}
