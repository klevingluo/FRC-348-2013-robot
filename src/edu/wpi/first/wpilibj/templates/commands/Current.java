/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Programmer
 */

public class Current extends CommandBase{

    protected void initialize() {
        requires(shooter);
    }

    protected void execute() {
        System.out.print(shooter.getCurrent());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }

    
    
}
