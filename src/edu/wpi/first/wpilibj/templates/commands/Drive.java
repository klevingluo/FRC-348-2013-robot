/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author Programmer
 */
public class Drive extends CommandBase {
    
    public Drive() {
        requires(drivetrain);
    }
    
    protected void initialize() {
    }

    protected void execute() {
        drivetrain.drive(oi.getLeftYAxis(), oi.getRightYAxis());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        drivetrain.drive(0, 0);
    }

    protected void interrupted() {
        drivetrain.drive(0, 0);
    }
    
}
