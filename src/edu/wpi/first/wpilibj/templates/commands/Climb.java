/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Programmer
 */
public class Climb extends CommandBase {

    public Climb() {
        requires(climber);
    }
    
    protected void initialize() {
    }

    protected void execute() {
        climber.climb(CLIMBER_SPEED, CLIMBER_SPEED);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        climber.climb(0,0);
    }

    protected void interrupted() {
        climber.climb(0,0);
    }
    
}
