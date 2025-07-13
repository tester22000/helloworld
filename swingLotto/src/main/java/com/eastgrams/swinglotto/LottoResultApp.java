package com.eastgrams.swinglotto;


import javax.swing.*;
import com.eastgrams.swinglotto.ui.screen.MainFrame;

public class LottoResultApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}
