package ui;

import model.EventLog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
// window event listeners
public class WindowEvent extends JFrame implements WindowListener {
    //Modify this
    // EFFECT construct a window event
    public WindowEvent() {
        super();
    }
    //Modify this
    // EFFECT listens and perform action for a window open event
    @Override
    public void windowOpened(java.awt.event.WindowEvent e) {

    }
    //Modify this
    // EFFECT listens and perform action for a window closing event
    @Override
    public void windowClosing(java.awt.event.WindowEvent e) {


        System.out.println(new LogPrinter().gatherlogtext(EventLog.getInstance()));


    }
    //Modify this
    // EFFECT listens and perform action for a window closed event
    @Override
    public void windowClosed(java.awt.event.WindowEvent e) {

    }
    //Modify this
    // EFFECT listens and perform action for a window iconified event
    @Override
    public void windowIconified(java.awt.event.WindowEvent e) {

    }
    //Modify this
    // EFFECT listens and perform action for a window deiconified event
    @Override
    public void windowDeiconified(java.awt.event.WindowEvent e) {

    }
    //Modify this
    // EFFECT listens and perform action for a window activated event
    @Override
    public void windowActivated(java.awt.event.WindowEvent e) {

    }
    //Modify this
    // EFFECT listens and perform action for a window deactivated event
    @Override
    public void windowDeactivated(java.awt.event.WindowEvent e) {

    }
}
