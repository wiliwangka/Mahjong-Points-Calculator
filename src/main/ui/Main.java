package ui;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
//        new Mahjongapp();


        JFrame frame = new JFrame("mahjongappgui");
        frame.setContentPane(new Mahjongappgui().getMahjongPanel());
        frame.addWindowListener(new WindowEvent());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


        frame.setSize(1000, 700);


    }
}
