package LabPractice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerCatch implements ActionListener {

    Window window;

    public void setWindow(Window window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!window.canCashOut1) return;//没点击Cashing就滚蛋！
        window.canCashOut2 = true;
        String id = window.fieldProductId.getText().trim();
        if(!Tool.isDigit(id)){
            window.areaMain.append("!!!Product id format is incorrect!!!\n");
            return;
        }
//        Integer integer = Integer.valueOf(id);
        int Id = Integer.parseInt(id);
        if(Id>=Product.arr1.length) return;//id超过了当前的商品目录，则终止
        int n = Integer.parseInt(window.fieldShowAmount.getText());
        n += Product.arr1[Id];
        window.fieldShowAmount.setText(Integer.toString(n));
        window.fieldProductId.setText("");
    }

}
