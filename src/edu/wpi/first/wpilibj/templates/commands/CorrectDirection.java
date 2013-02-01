/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;


/**
 *
 * @author Programmer
 */
public class CorrectDirection extends CommandBase {

    public CorrectDirection() {
        requires(drivetrain);
    }
    
    protected void initialize() {
    }

    protected void execute() {
        double theta = drivetrain.getAngle();
        if(theta < 0) {
            drivetrain.drive(oi.getLeftYAxis(), oi.getRightYAxis()*theta);
        } else {
            drivetrain.drive(oi.getLeftYAxis()*theta, oi.getRightYAxis());
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
