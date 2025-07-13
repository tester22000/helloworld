package com.eastgrams.swinglotto.ui.component;

import com.eastgrams.swinglotto.Constants;

import javax.swing.*;
import java.awt.*;

public class NavButton extends JButton {
    boolean isPrevious;
    public NavButton(boolean isPrevious){
        super();
        this.isPrevious = isPrevious;
        setIcon(isPrevious ? Constants.leftIcon : Constants.rightIcon);
        setBackground(Color.BLACK);
        setBorder(null);
        setContentAreaFilled(false);
    }
}
