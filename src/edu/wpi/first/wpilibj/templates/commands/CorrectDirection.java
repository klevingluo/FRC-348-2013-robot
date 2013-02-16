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

    private double ratio = 1; // the factor of left power to right power for straight driving
    private double speed = 0; // the robot's current default left speed
    private static final double RATIO_INCREMENT = 0.001; // the increment with which to adjust the ratio for straigt driving
    private static final double SPEED_INCREMENT = 0.01;
    private static final double MAX_SPEED = 0.5;         // stops testing after this speed is reached  
    
    public CorrectDirection() {
        requires(drivetrain);
    }
    
    protected void initialize() {
    }

    protected void execute() {
        double veer = drivetrain.getVeer();
        if(veer > 1) {
            ratio += RATIO_INCREMENT;
        } else if (veer < 1){
            ratio -= RATIO_INCREMENT;
        }
        speed += SPEED_INCREMENT;
        drivetrain.drive(speed, speed*ratio);
    }

    protected boolean isFinished() {
        return (speed > MAX_SPEED);
    }

    protected void end() {
        // save the ratio value somewhere
    }

    protected void interrupted() {
        
    }
}
