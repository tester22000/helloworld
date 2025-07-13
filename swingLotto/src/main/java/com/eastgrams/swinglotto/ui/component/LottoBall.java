package com.eastgrams.swinglotto.ui.component;

import com.eastgrams.swinglotto.Constants;

import javax.swing.*;
import java.awt.*;

public class LottoBall extends JLabel {
    private static Color[] ballColors;
    private static final Dimension DEFAULT_SIZE = new Dimension(64, 64);
    private static final Font ballFont = Constants.nanumFont.deriveFont(24f);
    static {
        try {
            ballColors = new Color[]{
                    Color.decode("#c99d01"),
                    Color.decode("#0c6389"),
                    Color.decode("#880200"),
                    Color.decode("#474e50"),
                    Color.decode("#637619")
            };
        } catch(Exception ignored){}
    }
    private Color ballColor;

    public LottoBall(int number) {
        super();
        setBackground(Color.BLACK);
        setForeground(Color.WHITE); // Set text color to white
        setFont(ballFont);
        this.setMinimumSize(DEFAULT_SIZE);
        this.setPreferredSize(DEFAULT_SIZE);
        this.setMaximumSize(DEFAULT_SIZE);
        setNumber(number);
    }

    public void setNumber(int number){
        this.ballColor = ballColors[(number / 10)];
        setOpaque(true); // Make the label opaque
        setText(Integer.toString(number));
        invalidate();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        int diameter = Math.min(getWidth(), getHeight());
        int x = (getWidth() - diameter) / 2;
        int y = (getHeight() - diameter) / 2;

        g2.setColor(Color.BLACK);
        g2.fillRect(0,0, getWidth(), getHeight());
        // Draw the background circle
        g2.setColor(this.ballColor);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY); // Optional: for higher rendering quality
        g2.fillOval(x, y, diameter, diameter);

        // Draw the text
        g2.setColor(getForeground());
        FontMetrics fm = g2.getFontMetrics();
        int textX = (getWidth() - fm.stringWidth(getText())) / 2;
        int textY = (getHeight() - fm.getHeight()) / 2 + fm.getAscent() + 4;
        g2.drawString(getText(), textX, textY);

        g2.dispose();
    }
}
