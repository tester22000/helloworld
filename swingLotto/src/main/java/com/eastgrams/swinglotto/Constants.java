package com.eastgrams.swinglotto;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Constants {
    public static Font nanumFont;
    public static ImageIcon leftIcon, rightIcon;

    static {
        try {
            nanumFont = Font.createFont(Font.TRUETYPE_FONT, new File("res/NanumGothic-Regular.ttf"));
            leftIcon = new ImageIcon("res/chevron_left_40dp_FFFFFF_FILL0_wght400_GRAD0_opsz40.png");
            rightIcon = new ImageIcon("res/chevron_right_40dp_FFFFFF_FILL0_wght400_GRAD0_opsz40.png");
        } catch (Exception ex) {
            //
        }
    }
}
