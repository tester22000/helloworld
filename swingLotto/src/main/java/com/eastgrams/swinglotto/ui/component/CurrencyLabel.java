package com.eastgrams.swinglotto.ui.component;

import com.eastgrams.swinglotto.Constants;

import javax.swing.*;
import java.awt.*;

public class CurrencyLabel extends JLabel {
    public CurrencyLabel(String text, int width, Color color){
        super();
        Dimension dimension = new Dimension(width, 40);
        setFont(Constants.nanumFont.deriveFont(16f));
        setBackground(Color.WHITE);
        setForeground(color == null ? Color.BLACK : color);
        setOpaque(true);
        setPreferredSize(dimension);
        setMinimumSize(dimension);
        setMaximumSize(dimension);
        setHorizontalAlignment(SwingConstants.RIGHT);
        setText(text);
    }
}
