package com.eastgrams.swinglotto.ui.component;

import com.eastgrams.swinglotto.Constants;

import javax.swing.*;
import java.awt.*;

public class DrawInfoLabel extends JLabel {
    private static final Font infoFont = Constants.nanumFont.deriveFont(24f);

    public DrawInfoLabel(String text){
        this(text, Color.WHITE);
    }

    public DrawInfoLabel(String text, Color textColor){
        super();
        this.setFont(infoFont);
        this.setText(text);
        this.setForeground(textColor);
    }
}
