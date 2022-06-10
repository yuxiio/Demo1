package Test;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import java.awt.*;
import java.util.Scanner;

class Win extends JFrame implements DocumentListener {

    public static void main(String[] args) {
        Win win = new Win();
    }

    JTextArea area1;
    JTextArea area2;


    public Win() {
        setTitle("计算");
        area1 = new JTextArea();
        area2 = new JTextArea();
        add(area1,BorderLayout.WEST);
        add(area2, BorderLayout.EAST);
        Document document = area1.getDocument();
        document.addDocumentListener(this);
        this.setVisible(true);
        this.setSize(500, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        compute();
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        compute();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        compute();
    }

    public void compute() {
        String a = this.area1.getText().trim();
        Scanner scanner = new Scanner(a);
        scanner.useDelimiter("[^0123456789.]+");
        double sum = 0;
        int count = 0;
        while (scanner.hasNext()) {
            double score = scanner.nextDouble();
            count++;
            sum = sum + score;
        }
        this.area2.append("sum = " + sum + "   average = " + (sum / count) + "\n");
    }
}