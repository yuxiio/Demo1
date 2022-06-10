package LabPractice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerFinish implements ActionListener {

    Window window;

    public void setWindow(Window window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        window.dispose();
    }
}
