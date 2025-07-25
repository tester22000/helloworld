package com.eastgrams.swinglotto.ui.component;

import com.eastgrams.swinglotto.Constants;

import javax.swing.*;
import java.awt.*;

public class HeaderLabel extends JLabel {
    public HeaderLabel(String text, int width){
        super();
        Dimension dimension = new Dimension(width, 40);
        setFont(Constants.nanumFont.deriveFont(16f));
        setBackground(Color.LIGHT_GRAY);
        setForeground(Color.BLACK);
        setOpaque(true);
        setPreferredSize(dimension);
        setMinimumSize(dimension);
        setMaximumSize(dimension);
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        setText(text);
    }
}
