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

    public Shoot() {
        requires(shooter);
    }
    
    protected void initialize() {
    }

    protected void execute() {
        shooter.shoot(SHOOTER_SPEED);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        shooter.shoot(0);
    }

    protected void interrupted() {
        shooter.shoot(0);
    }
    
}
