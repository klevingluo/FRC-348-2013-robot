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

    public Current() {
        requires(shooter);
    }
    
    protected void initialize() {
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
