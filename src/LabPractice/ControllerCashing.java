package LabPractice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerCashing implements ActionListener {
    Window window;

    public void setWindow(Window window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        print();
        window.canCashOut1 = true;
        window.fieldShowAmount.setText("0");
    }

    void print(){
        window.areaMain.setText("");
        window.areaMain.append("1.  Apple             2\n");
        window.areaMain.append("2.  Apple Juice       10\n");
        window.areaMain.append("3.  Apple Chocolate   15\n");
        window.areaMain.append("4.  Apple (Christmas) 25\n");
        window.areaMain.append("5.  Apple Phone       2000\n");
        window.areaMain.append("6.  Apple Pad         2500\n");
        window.areaMain.append("7.  Apple Mac         4000\n");
        window.areaMain.append("\n\nPlease input the product id in the textfield below\n");
        window.areaMain.append("Entering another id is invalid !!!\n");
    }
}
