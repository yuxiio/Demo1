package Lab12;

import java.awt.event.*;
public class Controller implements ActionListener {
    Window win;
    public void setWindow(Window win){
        this.win = win;
    }
    public void actionPerformed(ActionEvent e) {
     try{  
        double a = Double.parseDouble(win.Math.getText().trim());
        double b = Double.parseDouble(win.English.getText().trim());
        win.stu.setName(win.Name.getText().trim());
        win.stu.setMathScore(a);
        win.stu.setEnglishScore(b);
        double sum = win.stu.sum();
        win.textArea1.append(win.stu.getName() + " 's math score is : " + win.stu.getMathScore());
        win.textArea1.append(" and english score is : " + win.stu.getEnglishScore());
        win.textArea1.append(" and the sum of scores is : " + sum + "\n");
     }
     catch(Exception exp) {
        win.textArea1.append("\n"+exp+"\n");
     }
   }
}