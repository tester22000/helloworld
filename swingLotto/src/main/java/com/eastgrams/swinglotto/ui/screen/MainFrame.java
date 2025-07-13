package com.eastgrams.swinglotto.ui.screen;

import com.eastgrams.swinglotto.Constants;
import com.eastgrams.swinglotto.model.LottoDrawServiceResult;
import com.eastgrams.swinglotto.service.LottoDrawResultService;
import com.eastgrams.swinglotto.service.ServiceManager;
import com.eastgrams.swinglotto.ui.component.*;
import com.eastgrams.swinglotto.utils.LottoUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private static int SCREEN_WIDTH = 900;
    private static int SCREEN_HEIGHT =600;

    private JPanel rootPanel;
    private DrawInfoLabel lottoDrawNo;
    private JLabel lottoDrawDate;
    private LottoBall ball1, ball2, ball3, ball4, ball5, ball6, ballBonus;
    private NavButton left, right;
    private LottoDrawResultService service;
    private int drwNo = LottoUtils.lastDrawnNo();
    private CurrencyLabel totalPrize, perGamePrize;
    private ContentLabel firstCount;

    private void createControls() {
        service = ServiceManager.getLottoDrawResultService();

        rootPanel = new JPanel();
        rootPanel.setBackground(Color.BLACK);
        add(rootPanel, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        add(panel, BorderLayout.CENTER);

        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS));

        lottoDrawNo = new DrawInfoLabel("1111회", Color.RED);

        lottoDrawDate = new JLabel("(2025년 07월 05일 추첨)");
        lottoDrawDate.setFont(Constants.nanumFont.deriveFont(14f));
        lottoDrawDate.setForeground(Color.WHITE);

        ball1 = new LottoBall(0);
        ball2 = new LottoBall(0);
        ball3 = new LottoBall(0);
        ball4 = new LottoBall(0);
        ball5 = new LottoBall(0);
        ball6 = new LottoBall(0);
        ballBonus = new LottoBall(0);
        left = new NavButton(true);
        left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( drwNo > 0) {
                    drwNo -=1;
                    getLottoResult();
                }
            }
        });
        right = new NavButton(false);
        right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if( drwNo < LottoUtils.lastDrawnNo()) {
                    drwNo += 1;
                    getLottoResult();
                }
            }
        });

        totalPrize = new CurrencyLabel("1등 총 담첨금액", 280, Color.RED);
        perGamePrize =  new CurrencyLabel("1게임당 당첨금액", 280, Color.BLACK);
        firstCount =  new ContentLabel("당첨게임 수", 100);
    }


    private void showLottoResult(LottoDrawServiceResult result){
        if(result!=null){
            ball1.setNumber(result.drawNo1);
            ball2.setNumber(result.drawNo2);
            ball3.setNumber(result.drawNo3);
            ball4.setNumber(result.drawNo4);
            ball5.setNumber(result.drawNo5);
            ball6.setNumber(result.drawNo6);
            ballBonus.setNumber(result.bonusNo);
            totalPrize.setText(result.firstAccumamntString()+"원 ");
            perGamePrize.setText(result.firstWinAmountString()+ "원 ");
            firstCount.setText(""+result.firstWinCount);
            lottoDrawNo.setText(result.drawNo+ "회");
            lottoDrawDate.setText( "("+ result.drawDate.substring(0,4) + "년 "
                    + result.drawDate.substring(5,7) + "월 "
                    + result.drawDate.substring(8,10) + "일 추첨)"
            );
            left.setVisible(drwNo > 0);
            right.setVisible(drwNo < LottoUtils.lastDrawnNo());
        }
    }

    private void getLottoResult(){
        Call<LottoDrawServiceResult> call = service.getLottoResult(drwNo);
        call.enqueue(new Callback<LottoDrawServiceResult>() {
            @Override
            public void onResponse(Call<LottoDrawServiceResult> call, Response<LottoDrawServiceResult> response) {
                if (response.isSuccessful() && response.body() != null){
                    LottoDrawServiceResult result = response.body();
                    SwingUtilities.invokeLater(() -> showLottoResult(result));
                }
            }
            @Override
            public void onFailure(Call<LottoDrawServiceResult> call, Throwable t) {
            }
        });
    }

    private void addLottoDrawInfoPanel() {
        rootPanel.add(Box.createVerticalStrut(65));

        Box box = Box.createHorizontalBox();

        box.add(Box.createHorizontalGlue());
        box.add(lottoDrawNo);
        box.add(Box.createHorizontalStrut(10));
        box.add(new DrawInfoLabel("당첨 결과"));
        box.add(Box.createHorizontalGlue());

        rootPanel.add(box);
    }

    private void addLottoDrawDatePanel() {
        Box box = Box.createHorizontalBox();

        box.add(Box.createHorizontalGlue());
        box.add(lottoDrawDate);
        box.add(Box.createHorizontalGlue()); // 남는 공간을 모두 차지하도록 늘어남

        rootPanel.add(box);
    }

    private void addLottoDrawResultPanel() {
        rootPanel.add(Box.createVerticalStrut(60));

        Box box = Box.createHorizontalBox();
        box.add(Box.createHorizontalGlue());

        box.add(left);
        box.add(Box.createHorizontalStrut(20));
        box.add(ball1);
        box.add(Box.createHorizontalStrut(15));
        box.add(ball2);
        box.add(Box.createHorizontalStrut(15));
        box.add(ball3);
        box.add(Box.createHorizontalStrut(15));
        box.add(ball4);
        box.add(Box.createHorizontalStrut(15));
        box.add(ball5);
        box.add(Box.createHorizontalStrut(15));
        box.add(ball6);
        box.add(Box.createHorizontalStrut(25));
        JLabel plus = new JLabel("+");
        plus.setFont(Constants.nanumFont.deriveFont(20f));
        plus.setForeground(Color.LIGHT_GRAY);
        box.add(plus);
        box.add(Box.createHorizontalStrut(25));

        box.add(ballBonus);
        box.add(Box.createHorizontalStrut(20));
        box.add(right);
        box.add(Box.createHorizontalGlue());

        rootPanel.add(box);

        rootPanel.add(Box.createVerticalStrut(40));

        Box box2 = Box.createHorizontalBox();
        JLabel info1 = new JLabel("당첨번호");
        info1.setFont(Constants.nanumFont.deriveFont(18f));
        info1.setForeground(Color.LIGHT_GRAY);

        JLabel info2 = new JLabel("보너스");
        info2.setFont(Constants.nanumFont.deriveFont(18f));
        info2.setForeground(Color.LIGHT_GRAY);

        box2.add(Box.createHorizontalGlue());
        box2.add(Box.createHorizontalStrut(220));
        box2.add(info1);
        box2.add(Box.createHorizontalStrut(240));
        box2.add(info2);
        box2.add(Box.createHorizontalGlue());

        rootPanel.add(box2);

    }

    private void addLottoResultPrizeTable() {

        rootPanel.add(Box.createVerticalStrut(100));

        Box box = Box.createHorizontalBox();
        box.add(Box.createHorizontalGlue());
        box.add(new HeaderLabel("1등 총 담첨금액", 280));
        box.add(Box.createHorizontalStrut(1));
        box.add(new HeaderLabel("당첨게임 수", 100));
        box.add(Box.createHorizontalStrut(1));
        box.add(new HeaderLabel("1게임당 당첨금액", 280));
        box.add(Box.createHorizontalGlue());
        rootPanel.add(box);

        rootPanel.add(Box.createVerticalStrut(1));

        Box box2 = Box.createHorizontalBox();
        box2.add(Box.createHorizontalGlue());
        box2.add(totalPrize);
        box2.add(Box.createHorizontalStrut(1));
        box2.add(firstCount);
        box2.add(Box.createHorizontalStrut(1));
        box2.add(perGamePrize);
        box2.add(Box.createHorizontalGlue());

        rootPanel.add(box2);

    }

    private void initMainFrame(){
        setTitle("로또 당첨 결과");
        setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); // Disable layout manager
        setResizable(false);
        createControls();
    }


    public MainFrame() {
        initMainFrame();
        addLottoDrawInfoPanel();
        addLottoDrawDatePanel();
        addLottoDrawResultPanel();
        addLottoResultPrizeTable();
        getLottoResult();

        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setVisible(true);
    }
}
