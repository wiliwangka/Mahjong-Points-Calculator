package ui;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
//        new Mahjongapp();


        JFrame frame = new JFrame("mahjongappgui");
        frame.setContentPane(new Mahjongappgui().getMahjongPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
