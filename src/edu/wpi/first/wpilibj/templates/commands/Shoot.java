/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Programmer
 */
public class Shoot extends CommandBase {
    
    //private double currentLimit = 10;

    public Shoot() {
        requires(shooter);
    }
    
    protected void initialize() {
        shooter.shoot(SHOOTER_SPEED);
    }

    protected void execute() {
        //if(oi.rightStick.getRawButton(1)) {
        //} else {
        //    shooter.shoot(0);
        //}
    }

    protected boolean isFinished() {
        return false;//shooter.getCurrent() > currentLimit ;
    }

    protected void end() {
        shooter.shoot(0);
    }

    protected void interrupted() {
        shooter.shoot(0);
    }
    
}
