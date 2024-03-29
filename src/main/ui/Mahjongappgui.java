package ui;

import model.Event;
import model.EventLog;
import model.Mahjong;
import model.ScoreCalculator;
import persistence.HandReader;
import persistence.HandWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

// the graphical user interface for the mahjong app
public class Mahjongappgui extends JPanel {
    //todo add riichi and tsumo function
    private boolean enterchannel;
    private JButton so1Button;
    private JButton so5Button;
    private JButton so4Button;
    private JButton so3Button;
    private JButton so2Button;
    private JButton so6Button;
    private JButton so7Button;
    private JButton so8Button;
    private JButton so9Button;
    private JComboBox windBox;
    private JComboBox positionBox;
    private JLabel tile1Label;
    private JPanel mahjongPanel;
    private JButton man2Button;
    private JButton man3Button;
    private JButton man4Button;
    private JButton man5Button;
    private JButton man6Button;
    private JButton man7Button;
    private JButton man8Button;
    private JButton man9Button;
    private JLabel tile2Label;
    private JLabel tile3Label;
    private JLabel tile4Label;
    private JLabel tile5Label;
    private JLabel tile6Label;
    private JLabel tile7Label;
    private JLabel tile8Label;
    private JLabel tile9Label;
    private JLabel tile10Label;
    private JLabel tile11Label;
    private JLabel tile12Label;
    private JLabel tile13Label;
    private JLabel tile14Label;
    private JPanel closedtilespane;
    private JButton man1Button;
    private JLabel tile15Label;
    private JLabel tile16Label;
    private JLabel tile17Label;
    private JLabel tile18Label;
    private JPanel opentilepane;
    private JButton wind1Button;
    private JButton honor2Button;
    private JButton honor3Button;
    private JButton wind2Button;
    private JButton wind3Button;
    private JButton honor1Button;
    private JButton wind4Button;
    private JPanel honorandwindpane;
    private JButton pin1Button;
    private JButton pin2Button;
    private JButton pin3Button;
    private JButton pin4Button;
    private JButton pin5Button;
    private JButton pin6Button;
    private JButton pin7Button;
    private JButton pin8Button;
    private JButton pin9Button;
    private JRadioButton closedhandbutton;
    private JRadioButton openhandbutton;
    private JLabel otile1Label;
    private JLabel otile2Label;
    private JLabel otile3Label;
    private JLabel otile4Label;
    private JLabel otile5Label;
    private JLabel otile6Label;
    private JLabel otile7Label;
    private JLabel otile8Label;
    private JLabel otile9Label;
    private JLabel otile10Label;
    private JLabel otile11Label;
    private JLabel otile12Label;
    private JLabel otile13Label;
    private JLabel otile14Label;
    private JLabel otile15Label;
    private JLabel otile16Label;

    private JButton calculateButton;
    private JButton saveButton;
    private JButton loadButton;
    private JButton restartButton;
    private JComboBox samplehandselection;
    private JButton loadSampleButton;
    private JPanel sopane;
    private JPanel manpane;
    private JPanel pinpane;
    private JPanel tilespanel;
    private JPanel settingpane;
    private JPanel closeopenswitchpane;
    private JButton printlogbutton;
    private JButton clearlogbutton;


    private int s1Count;
    private int s2Count;
    private int s3Count;
    private int s4Count;
    private int s5Count;
    private int s6Count;
    private int s7Count;
    private int s8Count;
    private int s9Count;

    private int m1Count;
    private int m2Count;
    private int m3Count;
    private int m4Count;
    private int m5Count;
    private int m6Count;
    private int m7Count;
    private int m8Count;
    private int m9Count;

    private int p1Count;
    private int p2Count;
    private int p3Count;
    private int p4Count;
    private int p5Count;
    private int p6Count;
    private int p7Count;
    private int p8Count;
    private int p9Count;

    private int w1Count;
    private int w2Count;
    private int w3Count;
    private int w4Count;

    private int h1Count;
    private int h2Count;
    private int h3Count;


    private int tilePositionCount;

    private int opentilePositionCount;


    private int round;
    private int position;

    private ArrayList<String> openedhand;

    private ArrayList<String> closedhand;

    //    private static final String JSON_STORE = "./data/hand.json";
    private static final String JSON_STORE = "data/samplehands/hand.json";


    private HandWriter handWriter;


    private HandReader handReader;

    private String samplehandpath;

    //Modify this
    // Effect construct and record the action of buttons and radio boxes
    @SuppressWarnings("methodlength")
    public Mahjongappgui() {
        initialization(0);

        so1Button.addActionListener(new ActionListener() {
            //Modify this
            // Effect set tile label and add log event for s1
            @Override
            public void actionPerformed(ActionEvent e) {
                if (s1Count + 1 <= 4 && tilePositionCount <= 18 && opentilePositionCount <= 16) {
                    s1Count += 1;
                    setlabelrunner("s1");
                    addtilesevent("s1");
                }
            }
        });
        so2Button.addActionListener(new ActionListener() {
            //Modify this
            // Effect set tile label and add log event for s2
            @Override
            public void actionPerformed(ActionEvent e) {
                if (s2Count + 1 <= 4 && tilePositionCount <= 18 && opentilePositionCount <= 16) {
                    s2Count += 1;
                    setlabelrunner("s2");
                    addtilesevent("s2");
                }
            }
        });
        so3Button.addActionListener(new ActionListener() {
            //Modify this
            // Effect set tile label and add log event for s3
            @Override
            public void actionPerformed(ActionEvent e) {
                if (s3Count + 1 <= 4 && tilePositionCount <= 18 && opentilePositionCount <= 16) {
                    s3Count += 1;
                    setlabelrunner("s3");
                    addtilesevent("s3");
                }
            }
        });
        so4Button.addActionListener(new ActionListener() {
            //Modify this
            // Effect set tile label and add log event for s4
            @Override
            public void actionPerformed(ActionEvent e) {
                if (s4Count + 1 <= 4 && tilePositionCount <= 18 && opentilePositionCount <= 16) {
                    s4Count += 1;
                    setlabelrunner("s4");
                    addtilesevent("s4");
                }
            }
        });
        so5Button.addActionListener(new ActionListener() {
            //Modify this
            // Effect set tile label and add log event for s5
            @Override
            public void actionPerformed(ActionEvent e) {
                if (s5Count + 1 <= 4 && tilePositionCount <= 18 && opentilePositionCount <= 16) {
                    s5Count += 1;
                    setlabelrunner("s5");
                    addtilesevent("s5");
                }
            }
        });
        so6Button.addActionListener(new ActionListener() {
            //Modify this
            // Effect set tile label and add log event for s6
            @Override
            public void actionPerformed(ActionEvent e) {
                if (s6Count + 1 <= 4 && tilePositionCount <= 18 && opentilePositionCount <= 16) {
                    s6Count += 1;
                    setlabelrunner("s6");
                    addtilesevent("s6");
                }
            }
        });
        so7Button.addActionListener(new ActionListener() {
            //Modify this
            // Effect set tile label and add log event for s7
            @Override
            public void actionPerformed(ActionEvent e) {
                if (s7Count + 1 <= 4 && tilePositionCount <= 18 && opentilePositionCount <= 16) {
                    s7Count += 1;
                    setlabelrunner("s7");
                    addtilesevent("s7");
                }
            }
        });
        so8Button.addActionListener(new ActionListener() {
            //Modify this
            // Effect set tile label and add log event for s8
            @Override
            public void actionPerformed(ActionEvent e) {
                if (s8Count + 1 <= 4 && tilePositionCount <= 18 && opentilePositionCount <= 16) {
                    s8Count += 1;
                    setlabelrunner("s8");
                    addtilesevent("s8");
                }
            }
        });
        so9Button.addActionListener(new ActionListener() {
            //Modify this
            // Effect set tile label and add log event for s9
            @Override
            public void actionPerformed(ActionEvent e) {
                if (s9Count + 1 <= 4 && tilePositionCount <= 18 && opentilePositionCount <= 16) {
                    s9Count += 1;
                    setlabelrunner("s9");
                    addtilesevent("s9");
                }
            }
        });
        man1Button.addActionListener(new ActionListener() {
            //Modify this
            // Effect set tile label and add log event for m1
            @Override
            public void actionPerformed(ActionEvent e) {
                if (m1Count + 1 <= 4 && tilePositionCount <= 18 && opentilePositionCount <= 16) {
                    m1Count += 1;
                    setlabelrunner("m1");
                    addtilesevent("m1");
                }
            }
        });
        man2Button.addActionListener(new ActionListener() {
            //Modify this
            // Effect set tile label and add log event for m2
            @Override
            public void actionPerformed(ActionEvent e) {
                if (m2Count + 1 <= 4 && tilePositionCount <= 18 && opentilePositionCount <= 16) {
                    m2Count += 1;
                    setlabelrunner("m2");
                    addtilesevent("m2");
                }
            }
        });
        man3Button.addActionListener(new ActionListener() {
            //Modify this
            // Effect set tile label and add log event for m3
            @Override
            public void actionPerformed(ActionEvent e) {
                if (m3Count + 1 <= 4 && tilePositionCount <= 18 && opentilePositionCount <= 16) {
                    m3Count += 1;
                    setlabelrunner("m3");
                    addtilesevent("m3");
                }
            }
        });
        man4Button.addActionListener(new ActionListener() {
            //Modify this
            // Effect set tile label and add log event for m4
            @Override
            public void actionPerformed(ActionEvent e) {
                if (m4Count + 1 <= 4 && tilePositionCount <= 18 && opentilePositionCount <= 16) {
                    m4Count += 1;
                    setlabelrunner("m4");
                    addtilesevent("m4");
                }
            }
        });
        man5Button.addActionListener(new ActionListener() {
            //Modify this
            // Effect set tile label and add log event for m5
            @Override
            public void actionPerformed(ActionEvent e) {
                if (m5Count + 1 <= 4 && tilePositionCount <= 18 && opentilePositionCount <= 16) {
                    m5Count += 1;
                    setlabelrunner("m5");
                    addtilesevent("m5");
                }
            }
        });
        man6Button.addActionListener(new ActionListener() {
            //Modify this
            // Effect set tile label and add log event for m6
            @Override
            public void actionPerformed(ActionEvent e) {
                if (m6Count + 1 <= 4 && tilePositionCount <= 18 && opentilePositionCount <= 16) {
                    m6Count += 1;
                    setlabelrunner("m6");
                    addtilesevent("m6");
                }
            }
        });
        man7Button.addActionListener(new ActionListener() {
            //Modify this
            // Effect set tile label and add log event for m7
            @Override
            public void actionPerformed(ActionEvent e) {
                if (m7Count + 1 <= 4 && tilePositionCount <= 18 && opentilePositionCount <= 16) {
                    m7Count += 1;
                    setlabelrunner("m7");
                    addtilesevent("m7");
                }
            }
        });
        man8Button.addActionListener(new ActionListener() {
            //Modify this
            // Effect set tile label and add log event for m8
            @Override
            public void actionPerformed(ActionEvent e) {
                if (m8Count + 1 <= 4 && tilePositionCount <= 18 && opentilePositionCount <= 16) {
                    m8Count += 1;
                    setlabelrunner("m8");
                    addtilesevent("m8");
                }
            }
        });
        man9Button.addActionListener(new ActionListener() {
            //Modify this
            // Effect set tile label and add log event for m9
            @Override
            public void actionPerformed(ActionEvent e) {
                if (m9Count + 1 <= 4 && tilePositionCount <= 18 && opentilePositionCount <= 16) {
                    m9Count += 1;
                    setlabelrunner("m9");
                    addtilesevent("m9");
                }
            }
        });
        pin1Button.addActionListener(new ActionListener() {
            //Modify this
            // Effect set tile label and add log event for p1
            @Override
            public void actionPerformed(ActionEvent e) {
                if (p1Count + 1 <= 4 && tilePositionCount <= 18 && opentilePositionCount <= 16) {
                    p1Count += 1;
                    setlabelrunner("p1");
                    addtilesevent("p1");
                }
            }
        });
        pin2Button.addActionListener(new ActionListener() {
            //Modify this
            // Effect set tile label and add log event for p2
            @Override
            public void actionPerformed(ActionEvent e) {
                if (p2Count + 1 <= 4 && tilePositionCount <= 18 && opentilePositionCount <= 16) {
                    p2Count += 1;
                    setlabelrunner("p2");
                    addtilesevent("p2");
                }
            }
        });
        pin3Button.addActionListener(new ActionListener() {
            //Modify this
            // Effect set tile label and add log event for p3
            @Override
            public void actionPerformed(ActionEvent e) {
                if (p3Count + 1 <= 4 && tilePositionCount <= 18 && opentilePositionCount <= 16) {
                    p3Count += 1;
                    setlabelrunner("p3");
                    addtilesevent("p3");
                }
            }
        });
        pin4Button.addActionListener(new ActionListener() {
            //Modify this
            // Effect set tile label and add log event for p4
            @Override
            public void actionPerformed(ActionEvent e) {
                if (p4Count + 1 <= 4 && tilePositionCount <= 18 && opentilePositionCount <= 16) {
                    p4Count += 1;
                    setlabelrunner("p4");
                    addtilesevent("p4");
                }
            }
        });
        pin5Button.addActionListener(new ActionListener() {
            //Modify this
            // Effect set tile label and add log event for p5
            @Override
            public void actionPerformed(ActionEvent e) {
                if (p5Count + 1 <= 4 && tilePositionCount <= 18 && opentilePositionCount <= 16) {
                    p5Count += 1;
                    setlabelrunner("p5");
                    addtilesevent("p5");
                }
            }
        });
        pin6Button.addActionListener(new ActionListener() {
            //Modify this
            // Effect set tile label and add log event for p6
            @Override
            public void actionPerformed(ActionEvent e) {
                if (p6Count + 1 <= 4 && tilePositionCount <= 18 && opentilePositionCount <= 16) {
                    p6Count += 1;
                    setlabelrunner("p6");
                    addtilesevent("p6");
                }
            }
        });
        pin7Button.addActionListener(new ActionListener() {
            //Modify this
            // Effect set tile label and add log event for p7
            @Override
            public void actionPerformed(ActionEvent e) {
                if (p7Count + 1 <= 4 && tilePositionCount <= 18 && opentilePositionCount <= 16) {
                    p7Count += 1;
                    setlabelrunner("p7");
                    addtilesevent("p7");
                }
            }
        });
        pin8Button.addActionListener(new ActionListener() {
            //Modify this
            // Effect set tile label and add log event for p8
            @Override
            public void actionPerformed(ActionEvent e) {
                if (p8Count + 1 <= 4 && tilePositionCount <= 18 && opentilePositionCount <= 16) {
                    p8Count += 1;
                    setlabelrunner("p8");
                    addtilesevent("p8");
                }
            }
        });
        pin9Button.addActionListener(new ActionListener() {
            //Modify this
            // Effect set tile label and add log event for p9
            @Override
            public void actionPerformed(ActionEvent e) {
                if (p9Count + 1 <= 4 && tilePositionCount <= 18 && opentilePositionCount <= 16) {
                    p9Count += 1;
                    setlabelrunner("p9");
                    addtilesevent("p9");
                }
            }
        });
        wind1Button.addActionListener(new ActionListener() {
            //Modify this
            // Effect set tile label and add log event for w1
            @Override
            public void actionPerformed(ActionEvent e) {
                if (w1Count + 1 <= 4 && tilePositionCount <= 18 && opentilePositionCount <= 16) {
                    w1Count += 1;
                    setlabelrunner("w1");
                    addtilesevent("w1");
                }
            }
        });
        wind2Button.addActionListener(new ActionListener() {
            //Modify this
            // Effect set tile label and add log event for w2
            @Override
            public void actionPerformed(ActionEvent e) {
                if (w2Count + 1 <= 4 && tilePositionCount <= 18 && opentilePositionCount <= 16) {
                    w2Count += 1;
                    setlabelrunner("w2");
                    addtilesevent("w2");
                }
            }
        });
        wind3Button.addActionListener(new ActionListener() {
            //Modify this
            // Effect set tile label and add log event for w3
            @Override
            public void actionPerformed(ActionEvent e) {
                if (w3Count + 1 <= 4 && tilePositionCount <= 18 && opentilePositionCount <= 16) {
                    w3Count += 1;
                    setlabelrunner("w3");
                    addtilesevent("w3");
                }
            }
        });
        wind4Button.addActionListener(new ActionListener() {
            //Modify this
            // Effect set tile label and add log event for w4
            @Override
            public void actionPerformed(ActionEvent e) {
                if (w4Count + 1 <= 4 && tilePositionCount <= 18 && opentilePositionCount <= 16) {
                    w4Count += 1;
                    setlabelrunner("w4");
                    addtilesevent("w4");
                }
            }
        });
        honor1Button.addActionListener(new ActionListener() {
            //Modify this
            // Effect set tile label and add log event for h1
            @Override
            public void actionPerformed(ActionEvent e) {
                if (h1Count + 1 <= 4 && tilePositionCount <= 18 && opentilePositionCount <= 16) {
                    h1Count += 1;
                    setlabelrunner("h1");
                    addtilesevent("h1");
                }
            }
        });
        honor2Button.addActionListener(new ActionListener() {
            //Modify this
            // Effect set tile label and add log event for h2
            @Override
            public void actionPerformed(ActionEvent e) {
                if (h2Count + 1 <= 4 && tilePositionCount <= 18 && opentilePositionCount <= 16) {
                    h2Count += 1;
                    setlabelrunner("h2");
                    addtilesevent("h2");
                }
            }
        });
        honor3Button.addActionListener(new ActionListener() {
            //Modify this
            // Effect set tile label and add log event for h3
            @Override
            public void actionPerformed(ActionEvent e) {
                if (h3Count + 1 <= 4 && tilePositionCount <= 18 && opentilePositionCount <= 16) {
                    h3Count += 1;
                    setlabelrunner("h3");
                    addtilesevent("h3");
                }
            }
        });
        closedhandbutton.addActionListener(new ActionListener() {
            //Modify this
            // Effect set enter channel for closed
            @Override
            public void actionPerformed(ActionEvent e) {
                enterchannel = true;
                EventLog.getInstance().logEvent(new Event("Event: Change enter channel to closed"));
            }
        });
        openhandbutton.addActionListener(new ActionListener() {
            //Modify this
            // Effect set enter channel for opened
            @Override
            public void actionPerformed(ActionEvent e) {
                enterchannel = false;
                EventLog.getInstance().logEvent(new Event("Event: Change enter channel to opened"));
            }
        });
        calculateButton.addActionListener(new ActionListener() {
            //Modify this
            // Effect Calculate the scoring of entered hand
            @Override
            public void actionPerformed(ActionEvent e) {

                if (round == 0 || position == 0) {
                    JOptionPane.showMessageDialog(null, "please select a round and postion");
                } else if (closedhand.size() + openedhand.size() < 14) {
                    JOptionPane.showMessageDialog(null, "not enough tiles in your hand");
                } else {
                    EventLog.getInstance().logEvent(new Event("Event: Calculate hand"));
                    Mahjong game = new Mahjong(closedhand, openedhand, round, position);
                    ScoreCalculator score = new ScoreCalculator((game));
                    int yaku = score.getYaku() + 14 * score.getYakumanCount() + 28 * score.getDoubleyakumanCount();
                    JOptionPane.showMessageDialog(null, "Your yaku is:" + yaku
                            + "\n your point contains:" + "\n" + Arrays.toString(score.getWiningMessages().toArray()));
                    EventLog.getInstance().logEvent(new Event("Event: Score earned = " + yaku
                            + "\n hand contains:" + Arrays.toString(score.getWiningMessages().toArray())));
                }

            }
        });
        windBox.addItemListener(new ItemListener() {
            //Modify this
            // Effect set wind to one of east, south ,west or north
            @Override
            public void itemStateChanged(ItemEvent e) {
                String s = windBox.getSelectedItem().toString();
                switch (s) {
                    case "Wind":
                        round = 0;
                        break;
                    case "East":
                        round = 1;
                        EventLog.getInstance().logEvent(new Event("Event:  set wind to East"));
                        break;
                    case "South":
                        round = 2;
                        EventLog.getInstance().logEvent(new Event("Event: set wind to South"));
                        break;
                    case "West":
                        round = 3;
                        EventLog.getInstance().logEvent(new Event("Event: set wind to West"));
                        break;
                    case "North":
                        round = 4;
                        EventLog.getInstance().logEvent(new Event("Event: set wind to North"));
                        break;

                }

            }
        });
        positionBox.addItemListener(new ItemListener() {
            //Modify this
            // Effect set position to one of east, south ,west or north
            @Override
            public void itemStateChanged(ItemEvent e) {
                String s = positionBox.getSelectedItem().toString();
                switch (s) {
                    case "Position":
                        position = 0;
                        break;
                    case "East":
                        position = 1;
                        EventLog.getInstance().logEvent(new Event("Event: set position to East"));
                        break;
                    case "South":
                        position = 2;
                        EventLog.getInstance().logEvent(new Event("Event: set position to South"));
                        break;
                    case "West":
                        position = 3;
                        EventLog.getInstance().logEvent(new Event("Event: set position to West"));
                        break;
                    case "North":
                        position = 4;
                        EventLog.getInstance().logEvent(new Event("Event:  set position to North"));
                        break;

                }
            }
        });
        saveButton.addActionListener(new ActionListener() {
            //Modify this
            // Effect save the entered tiles and wind position value to data folder
            @Override
            public void actionPerformed(ActionEvent e) {
                saveHand();
                EventLog.getInstance().logEvent(new Event("Event: Save hand "));
            }
        });
        loadButton.addActionListener(new ActionListener() {
            //Modify this
            // Effect  load saved tiles and wind position value from the data folder
            @Override
            public void actionPerformed(ActionEvent e) {
                restartButton.doClick();
                loadHand(JSON_STORE);
                EventLog.getInstance().logEvent(new Event("Event: Load hand "));
            }
        });
        restartButton.addActionListener(new ActionListener() {
            //Modify this
            // Effect clear all label icon and reset all field value
            @Override
            public void actionPerformed(ActionEvent e) {
                initialization(1);

                clearlabels();
                windBox.setSelectedIndex(round);
                positionBox.setSelectedIndex(position);
                EventLog.getInstance().logEvent(new Event("Event: Restart calculator "));

            }
        });
        loadSampleButton.addActionListener(new ActionListener() {
            //Modify this
            // Effect  load pre-entered tiles and wind position value from the data/samplehand folder
            @Override
            public void actionPerformed(ActionEvent e) {
                restartButton.doClick();
                if (samplehandpath == null || samplehandpath.equals("data/samplehands/.json")
                        || samplehandpath.equals("")
                ) {
                    JOptionPane.showMessageDialog(null, "please select a sample hand to load");
                } else {
                    loadHand(samplehandpath);
                    EventLog.getInstance().logEvent(new Event("Event: Loaded sample hand from library"));
                }


            }
        });


        samplehandselection.addItemListener(new ItemListener() {
            //Modify this
            // Effect  select a pre-entered sample hand form the data/samplehand folder
            @Override
            public void itemStateChanged(ItemEvent e) {
                String h = "";
                String s = samplehandselection.getSelectedItem().toString();


                switch (s) {
                    case "Select Sample Hand":
                        h = "";
                        break;
                    case "Daisuushii 大四喜":
                        h = "Daisuushii";
                        break;
                    case "Chuuren poutou 九連宝燈":
                        h = "Chuurenpoutou";
                        break;
                    case "Suukantsu 四槓子":
                        h = "Suukantsu";
                        break;
                    case "Shousuushii 小四喜":
                        h = "Shousuushii";
                        break;
                    case "Tsuuiisou 字一色":
                        h = "Tsuuiisou";
                        break;
                    case "Daisangen 大三元":
                        h = "Daisangen";
                        break;
                    case "Chinitsu 清一色":
                        h = "Chinitsu";
                        break;
                    case "Kokushi musou 国士無双":
                        h = "Kokushimusou";
                        break;
                    case "Suuankou 四暗刻":
                        h = "Suuankou";
                        break;
                    case "Chinroutou 清老頭":
                        h = "Chinroutou";
                        break;
                    case "Ryuuiisou 緑一色":
                        h = "Ryuuiisou";
                        break;
                    case "Honitsu 混一色":
                        h = "Honitsu";
                        break;
                    case "Junchan taiyao 純全帯么":
                        h = "Junchantaiyao";
                        break;
                    case "Ryanpeikou 二盃口":
                        h = "Ryanpeikou";
                        break;
                    case "Ittsu 一気通貫":
                        h = "Ittsu";
                        break;
                    case "Chanta 混全帯么九":
                        h = "Chanta";
                        break;
                    case "Chiitoitsu 七対子":
                        h = "Chiitoitsu";
                        break;
                    case "Honroutou 混老頭":
                        h = "Honroutou";
                        break;
                    case "Shousangen 小三元":
                        h = "Shousangen";
                        break;
                    case "三暗刻+三色同刻+対々和":
                        h = "SanankouSanshokudoukouToitoi";
                        break;
                    case "Sankantsu 三槓子":
                        h = "Sankantsu";
                        break;
                    case "Sanshoku doujun 三色同順":
                        h = "Sanshokudoujun";
                        break;
                    case "Iipeikou 一盃口":
                        h = "Iipeikou";
                        break;
                    case "Pinfu 平和":
                        h = "Pinfu";
                        break;
                    case "Tanyao 断么九":
                        h = "Tanyao";
                        break;
                }

                samplehandpath = ("data/samplehands/" + h + ".json");
                EventLog.getInstance().logEvent(new Event("Event: select a sample hand"));
            }
        });
        printlogbutton.addActionListener(new ActionListener() {
            //Modify this
            // Effect print the recorded log using a pop-up window
            @Override
            public void actionPerformed(ActionEvent e) {
                LogPrinter l = new LogPrinter();

                JTextArea textArea = new JTextArea(l.gatherlogtext(EventLog.getInstance()));
                JScrollPane scrollPane = new JScrollPane(textArea);

                final Dimension d = scrollPane.getSize();
                scrollPane.setPreferredSize(new Dimension(250, 500));

                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                JOptionPane.showMessageDialog(null, scrollPane, "Event Log",
                        JOptionPane.YES_NO_OPTION, new ImageIcon());

//                JOptionPane.showMessageDialog(null, l.gatherlogtext(EventLog.getInstance()));
            }
        });
        clearlogbutton.addActionListener(new ActionListener() {
            //Modify this
            // Effect clear recorded log and add clear log event to log
            @Override
            public void actionPerformed(ActionEvent e) {
                EventLog.getInstance().clear();
            }
        });
    }

    // require a string that represent a tile in mahjong
    //Modify this
    // Effect  add s tile adding event to log
    private static void addtilesevent(String s) {
        EventLog.getInstance().logEvent(new Event("Event: Added Tile " + s + " to hand"));
    }

    // Require int of one of 0 or 1
    //Modify this
//EFFECT initialize the buttons and Jlabels by given numbers 0 being start of program and 1 for restart button
    private void initialization(int i) {

        handWriter = new HandWriter(JSON_STORE);
        handReader = new HandReader(JSON_STORE);
        tilePositionCount = 0;
        opentilePositionCount = 0;

        round = 0;
        position = 0;

        openedhand = new ArrayList<String>();

        closedhand = new ArrayList<String>();
        tileCountinitialization();
        enterchannel = true;


        if (i == 0) {
            setButtonIcon();
            ButtonGroup handswitch = new ButtonGroup();
            handswitch.add(closedhandbutton);
            handswitch.add(openhandbutton);
            closedhandbutton.setSelected(true);
//            samplehandpath = "";
            samplehandselection.setSelectedIndex(0);


        }

    }

    //Modify this
    // EFFECT set icon for the mahjong buttons
    protected void setButtonIcon() {
        setbhelper1();
        setbhelper2();
    }

    //Modify this
    // EFFECT set icon for the mahjong buttons for the first half of buttons
    private void setbhelper1() {
        so1Button.setIcon((new ImageIcon("data/mahjongtiles/s1.jpg")));
        so2Button.setIcon((new ImageIcon("data/mahjongtiles/s2.jpg")));
        so3Button.setIcon((new ImageIcon("data/mahjongtiles/s3.jpg")));
        so4Button.setIcon((new ImageIcon("data/mahjongtiles/s4.jpg")));
        so5Button.setIcon((new ImageIcon("data/mahjongtiles/s5.jpg")));
        so6Button.setIcon((new ImageIcon("data/mahjongtiles/s6.jpg")));
        so7Button.setIcon((new ImageIcon("data/mahjongtiles/s7.jpg")));
        so8Button.setIcon((new ImageIcon("data/mahjongtiles/s8.jpg")));
        so9Button.setIcon((new ImageIcon("data/mahjongtiles/s9.jpg")));

        man1Button.setIcon((new ImageIcon("data/mahjongtiles/m1.jpg")));
        man2Button.setIcon((new ImageIcon("data/mahjongtiles/m2.jpg")));
        man3Button.setIcon((new ImageIcon("data/mahjongtiles/m3.jpg")));
        man4Button.setIcon((new ImageIcon("data/mahjongtiles/m4.jpg")));
        man5Button.setIcon((new ImageIcon("data/mahjongtiles/m5.jpg")));
        man6Button.setIcon((new ImageIcon("data/mahjongtiles/m6.jpg")));
        man7Button.setIcon((new ImageIcon("data/mahjongtiles/m7.jpg")));
        man8Button.setIcon((new ImageIcon("data/mahjongtiles/m8.jpg")));
        man9Button.setIcon((new ImageIcon("data/mahjongtiles/m9.jpg")));
    }

    //Modify this
    // EFFECT set icon for the mahjong buttons for the second half of buttons
    private void setbhelper2() {
        pin1Button.setIcon((new ImageIcon("data/mahjongtiles/p1.jpg")));
        pin2Button.setIcon((new ImageIcon("data/mahjongtiles/p2.jpg")));
        pin3Button.setIcon((new ImageIcon("data/mahjongtiles/p3.jpg")));
        pin4Button.setIcon((new ImageIcon("data/mahjongtiles/p4.jpg")));
        pin5Button.setIcon((new ImageIcon("data/mahjongtiles/p5.jpg")));
        pin6Button.setIcon((new ImageIcon("data/mahjongtiles/p6.jpg")));
        pin7Button.setIcon((new ImageIcon("data/mahjongtiles/p7.jpg")));
        pin8Button.setIcon((new ImageIcon("data/mahjongtiles/p8.jpg")));
        pin9Button.setIcon((new ImageIcon("data/mahjongtiles/p9.jpg")));

        wind1Button.setIcon((new ImageIcon("data/mahjongtiles/w1.jpg")));
        wind2Button.setIcon((new ImageIcon("data/mahjongtiles/w2.jpg")));
        wind3Button.setIcon((new ImageIcon("data/mahjongtiles/w3.jpg")));
        wind4Button.setIcon((new ImageIcon("data/mahjongtiles/w4.jpg")));


        honor1Button.setIcon((new ImageIcon("data/mahjongtiles/h1.jpg")));
        honor2Button.setIcon((new ImageIcon("data/mahjongtiles/h2.jpg")));
        honor3Button.setIcon((new ImageIcon("data/mahjongtiles/h3.jpg")));
    }

    // require a string that represent a path to a image file in data folder
    //Modify this
    //Effect set label image for open and closed hand when the tile buttons is being click
    protected void setlabelrunner(String tile) {

        setLabelIcon(tile + ".jpg");
        if (enterchannel) {
            tilePositionCount += 1;
            closedhand.add(tile);
        } else {
            opentilePositionCount += 1;
            openedhand.add(tile);

        }
    }

    // REQUIRE a String represent the file insdie the data/mahjongtiles folder
    //Modify this
// EFFECT set label image from different source based on input path

    protected void setLabelIcon(String file) {
        if (enterchannel) {
            ctilesetlabel1(file);
            ctilesetlabel2(file);
            ctilesetlabel3(file);
        } else {
            otilesetlabel1(file);
            otilesetlabel2(file);
            otilesetlabel3(file);
        }
    }

    // REQUIRE a String represent the file insdie the data/mahjongtiles folder
    //Modify this
// EFFECT set label image from different source based on input path
    private void ctilesetlabel1(String file) {
        switch (tilePositionCount + 1) {
            case 1:
                tile1Label.setIcon((new ImageIcon("data/mahjongtiles/" + file)));
                break;
            case 2:
                tile2Label.setIcon((new ImageIcon("data/mahjongtiles/" + file)));
                break;
            case 3:
                tile3Label.setIcon((new ImageIcon("data/mahjongtiles/" + file)));
                break;
            case 4:
                tile4Label.setIcon((new ImageIcon("data/mahjongtiles/" + file)));
                break;
            case 5:
                tile5Label.setIcon((new ImageIcon("data/mahjongtiles/" + file)));
                break;
            case 6:
                tile6Label.setIcon((new ImageIcon("data/mahjongtiles/" + file)));
                break;
        }
    }

    // REQUIRE a String represent the file insdie the data/mahjongtiles folder
    //Modify this
// EFFECT set label image from different source based on input path
    private void ctilesetlabel2(String file) {
        switch (tilePositionCount + 1) {
            case 7:
                tile7Label.setIcon((new ImageIcon("data/mahjongtiles/" + file)));
                break;
            case 8:
                tile8Label.setIcon((new ImageIcon("data/mahjongtiles/" + file)));
                break;
            case 9:
                tile9Label.setIcon((new ImageIcon("data/mahjongtiles/" + file)));
                break;
            case 10:
                tile10Label.setIcon((new ImageIcon("data/mahjongtiles/" + file)));
                break;
            case 11:
                tile11Label.setIcon((new ImageIcon("data/mahjongtiles/" + file)));
                break;
            case 12:
                tile12Label.setIcon((new ImageIcon("data/mahjongtiles/" + file)));
                break;
        }
    }

    // REQUIRE a String represent the file insdie the data/mahjongtiles folder
    //Modify this
// EFFECT set label image from different source based on input path
    private void ctilesetlabel3(String file) {
        switch (tilePositionCount + 1) {
            case 13:
                tile13Label.setIcon((new ImageIcon("data/mahjongtiles/" + file)));
                break;
            case 14:
                tile14Label.setIcon((new ImageIcon("data/mahjongtiles/" + file)));
                break;
            case 15:
                tile15Label.setIcon((new ImageIcon("data/mahjongtiles/" + file)));
                break;
            case 16:
                tile16Label.setIcon((new ImageIcon("data/mahjongtiles/" + file)));
                break;
            case 17:
                tile17Label.setIcon((new ImageIcon("data/mahjongtiles/" + file)));
                break;
            case 18:
                tile18Label.setIcon((new ImageIcon("data/mahjongtiles/" + file)));
                break;
        }
    }

    // REQUIRE a String represent the file insdie the data/mahjongtiles folder
    //Modify this
// EFFECT set label image from different source based on input path
    private void otilesetlabel1(String file) {
        switch (opentilePositionCount + 1) {
            case 1:
                otile1Label.setIcon((new ImageIcon("data/mahjongtiles/" + file)));
                break;
            case 2:
                otile2Label.setIcon((new ImageIcon("data/mahjongtiles/" + file)));
                break;
            case 3:
                otile3Label.setIcon((new ImageIcon("data/mahjongtiles/" + file)));
                break;
            case 4:
                otile4Label.setIcon((new ImageIcon("data/mahjongtiles/" + file)));
                break;
            case 5:
                otile5Label.setIcon((new ImageIcon("data/mahjongtiles/" + file)));
                break;

        }
    }

    // REQUIRE a String represent the file insdie the data/mahjongtiles folder
    //Modify this
// EFFECT set label image from different source based on input path
    private void otilesetlabel2(String file) {
        switch (opentilePositionCount + 1) {
            case 6:
                otile6Label.setIcon((new ImageIcon("data/mahjongtiles/" + file)));
                break;
            case 7:
                otile7Label.setIcon((new ImageIcon("data/mahjongtiles/" + file)));
                break;
            case 8:
                otile8Label.setIcon((new ImageIcon("data/mahjongtiles/" + file)));
                break;
            case 9:
                otile9Label.setIcon((new ImageIcon("data/mahjongtiles/" + file)));
                break;
            case 10:
                otile10Label.setIcon((new ImageIcon("data/mahjongtiles/" + file)));
                break;

        }
    }

    // REQUIRE a String represent the file insdie the data/mahjongtiles folder
    //Modify this
// EFFECT set label image from different source based on input path
    private void otilesetlabel3(String file) {
        switch (opentilePositionCount + 1) {
            case 11:
                otile11Label.setIcon((new ImageIcon("data/mahjongtiles/" + file)));
                break;
            case 12:
                otile12Label.setIcon((new ImageIcon("data/mahjongtiles/" + file)));
                break;
            case 13:
                otile13Label.setIcon((new ImageIcon("data/mahjongtiles/" + file)));
                break;
            case 14:
                otile14Label.setIcon((new ImageIcon("data/mahjongtiles/" + file)));
                break;
            case 15:
                otile15Label.setIcon((new ImageIcon("data/mahjongtiles/" + file)));
                break;
            case 16:
                otile16Label.setIcon((new ImageIcon("data/mahjongtiles/" + file)));
                break;
        }
    }
// motify this
    //EFFECT clear labels image from JLABELS

    public void clearlabels() {
        clearclabel();
        clearolabel();
    }

    // motify this
    //EFFECT clear labels image from JLABELS for closed tiles
    private void clearclabel() {
        tile1Label.setIcon(null);
        tile2Label.setIcon(null);
        tile3Label.setIcon(null);
        tile4Label.setIcon(null);
        tile5Label.setIcon(null);
        tile6Label.setIcon(null);
        tile7Label.setIcon(null);
        tile8Label.setIcon(null);
        tile9Label.setIcon(null);
        tile10Label.setIcon(null);
        tile11Label.setIcon(null);
        tile12Label.setIcon(null);
        tile13Label.setIcon(null);
        tile14Label.setIcon(null);
        tile15Label.setIcon(null);
        tile16Label.setIcon(null);
        tile17Label.setIcon(null);
        tile18Label.setIcon(null);
    }

    // motify this
    //EFFECT clear labels image from JLABELS for opened tiles
    private void clearolabel() {
        otile1Label.setIcon(null);
        otile2Label.setIcon(null);
        otile3Label.setIcon(null);
        otile4Label.setIcon(null);
        otile5Label.setIcon(null);
        otile6Label.setIcon(null);
        otile7Label.setIcon(null);
        otile8Label.setIcon(null);
        otile9Label.setIcon(null);
        otile10Label.setIcon(null);
        otile11Label.setIcon(null);
        otile12Label.setIcon(null);
        otile13Label.setIcon(null);
        otile14Label.setIcon(null);
        otile15Label.setIcon(null);
        otile16Label.setIcon(null);
    }

    // motify this
    //EFFECT reset the count for tile Counter
    public void tileCountinitialization() {


        helper1();
        helper2();
    }

    // motify this
    //EFFECT reset the count for tile Counter
    private void helper1() {
        s1Count = 0;
        s2Count = 0;
        s3Count = 0;
        s4Count = 0;
        s5Count = 0;
        s6Count = 0;
        s7Count = 0;
        s8Count = 0;
        s9Count = 0;

        m1Count = 0;
        m2Count = 0;
        m3Count = 0;
        m4Count = 0;
        m5Count = 0;
        m6Count = 0;
        m7Count = 0;
        m8Count = 0;
        m9Count = 0;
    }

    // motify this
    //EFFECT reset the count for tile Counter
    private void helper2() {
        p1Count = 0;
        p2Count = 0;
        p3Count = 0;
        p4Count = 0;
        p5Count = 0;
        p6Count = 0;
        p7Count = 0;
        p8Count = 0;
        p9Count = 0;

        w1Count = 0;
        w2Count = 0;
        w3Count = 0;
        w4Count = 0;

        h1Count = 0;
        h2Count = 0;
        h3Count = 0;
    }

    // motify this
    // EFFECT record and save the changes to the mahjong app
    protected void saveHand() {

        Mahjongapp app = new Mahjongapp();
        app.setClosedhand(this.closedhand);
        app.setOpenedhand(this.openedhand);
        app.setPosition(this.position);
        app.setRound(this.round);
        try {
            handWriter.open();
            handWriter.write(app);
            handWriter.close();
            System.out.println("Saved " + "your hand" + " to " + JSON_STORE);

        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // motify this
    // EFFECT load hand from the save from previous entery
    protected void loadHand(String path) {
        try {
            HandReader r = new HandReader(path);
            Mahjongapp app = r.read();
            ArrayList<String> closetiles = app.getClosedhand();
            ArrayList<String> opentiles = app.getOpenedhand();
            this.round = app.getRound();
            this.position = app.getPosition();
            enterchannel = true;
            for (String s : closetiles) {
                doclick(s);
            }
            enterchannel = false;
            for (String o : opentiles) {
                doclick(o);
            }
            windBox.setSelectedIndex(round);
            positionBox.setSelectedIndex(position);
            System.out.println("Loaded " + "your hand" + " from " + path);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + path);
        }


    }

    //Require String that represent a tiles in mahjong game
    // motify this
    // EFFECT click the button represent by the tile enter

    protected void doclick(String s) {
        doclickso(s);
        doclickman(s);
        doclickpin(s);
        doclickwindandhonor(s);

    }

    //Require String that represent a  so tiles in mahjong game
    // motify this
    // EFFECT click the button represent by the so tile enter
    private void doclickso(String s) {
        if (s.equals("s1")) {
            so1Button.doClick();
        } else if (s.equals("s2")) {
            so2Button.doClick();
        } else if (s.equals("s3")) {
            so3Button.doClick();
        } else if (s.equals("s4")) {
            so4Button.doClick();
        } else if (s.equals("s5")) {
            so5Button.doClick();
        } else if (s.equals("s6")) {
            so6Button.doClick();
        } else if (s.equals("s7")) {
            so7Button.doClick();
        } else if (s.equals("s8")) {
            so8Button.doClick();
        } else if (s.equals("s9")) {
            so9Button.doClick();
        }
    }

    //Require String that represent a man tiles in mahjong game
    // motify this
    // EFFECT click the button represent by the man tile enter
    private void doclickman(String s) {
        if (s.equals("m1")) {
            man1Button.doClick();
        } else if (s.equals("m2")) {
            man2Button.doClick();
        } else if (s.equals("m3")) {
            man3Button.doClick();
        } else if (s.equals("m4")) {
            man4Button.doClick();
        } else if (s.equals("m5")) {
            man5Button.doClick();
        } else if (s.equals("m6")) {
            man6Button.doClick();
        } else if (s.equals("m7")) {
            man7Button.doClick();
        } else if (s.equals("m8")) {
            man8Button.doClick();
        } else if (s.equals("m9")) {
            man9Button.doClick();
        }
    }

    //Require String that represent a pin tiles in mahjong game
    // motify this
    // EFFECT click the button represent by the pin tile enter
    private void doclickpin(String s) {
        if (s.equals("p1")) {
            pin1Button.doClick();
        } else if (s.equals("p2")) {
            pin2Button.doClick();
        } else if (s.equals("p3")) {
            pin3Button.doClick();
        } else if (s.equals("p4")) {
            pin4Button.doClick();
        } else if (s.equals("p5")) {
            pin5Button.doClick();
        } else if (s.equals("p6")) {
            pin6Button.doClick();
        } else if (s.equals("p7")) {
            pin7Button.doClick();
        } else if (s.equals("p8")) {
            pin8Button.doClick();
        } else if (s.equals("p9")) {
            pin9Button.doClick();
        }
    }

    //Require String that represent a wind or honor tiles in mahjong game
    // motify this
    // EFFECT click the button represent by wind or honor tile enter
    private void doclickwindandhonor(String s) {
        if (s.equals("w1")) {
            wind1Button.doClick();
        } else if (s.equals("w2")) {
            wind2Button.doClick();
        } else if (s.equals("w3")) {
            wind3Button.doClick();
        } else if (s.equals("w4")) {
            wind4Button.doClick();
        } else if (s.equals("h1")) {
            honor1Button.doClick();
        } else if (s.equals("h2")) {
            honor2Button.doClick();
        } else if (s.equals("h3")) {
            honor3Button.doClick();
        }
    }


    public JPanel getMahjongPanel() {
        return mahjongPanel;
    }


}
