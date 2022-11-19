package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mahjongappgui extends JPanel {
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


    private int tilePositionCount;


    public Mahjongappgui() {

        ImageIcon img = new ImageIcon("data/mahjongtiles/s1.jpg");
        tile1Label = new JLabel(img);
        add(tile1Label);

        tilePositionCount = 0;
        so1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                tile1Label.setIcon(new ImageIcon(Mahjongappgui.class.getResource("data/mahjongtiles/s1.jpg")));

            }
        });
        so2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        so3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }


    protected void updatePicture(String path) {
        //Get the icon corresponding to the image.
        ImageIcon icon = createImageIcon(path);
        tile1Label.setIcon(icon);

        if (icon == null) {
            tile1Label.setText("Missing Image");
        } else {
            tile1Label.setText(null);
        }
    }

    /**
     * Returns an ImageIcon, or null if the path was invalid.
     */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = Mahjongappgui.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

//    public settingicon(int i, ImageIcon image){
//
//    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("mahjongappgui");
        frame.setContentPane(new Mahjongappgui().mahjongPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
