/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 *
 * @author Programmer
 */
public class BackwardsButton extends JoystickButton {
 
    public BackwardsButton(GenericHID g, int num) {
        super(g,num);
    }
    
    public boolean get() {
        return !super.get();
    }
    
}
