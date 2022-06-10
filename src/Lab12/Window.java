package Lab12;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    Student stu;
    JTextField Name;
    JTextField Math;
    JTextField English;
    JTextArea textArea1;
    JButton updateButton;

    Window() {
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    void init(){
        stu = new Student();
        Name = new JTextField(5);
        Math = new JTextField(5);
        English = new JTextField(5);
        textArea1 = new JTextArea();
        updateButton = new JButton("update");

        JPanel top = new JPanel();
        top.add(new JLabel("Name"));
        top.add(Name);
        top.add(new JLabel("Math"));
        top.add(Math);
        top.add(new JLabel("English"));
        top.add(English);


        add(top, BorderLayout.NORTH);
        add(updateButton,BorderLayout.AFTER_LAST_LINE);
        add(textArea1,BorderLayout.CENTER);

        Controller controller = new Controller();
        controller.setWindow(this);
        this.updateButton.addActionListener(controller);
        validate();
    }

}
