/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Programmer
 */
public class AutonomousDrive extends CommandBase {
    
    Timer time = new Timer();
    
    protected void initialize() {
    }

    protected void execute() {
        time.start();
    }

    protected boolean isFinished() {
        if(time.get() >= 30000000) {
            time.stop();
            time.reset();
            return true;
        } else {
            return false;
        }
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
