package LabPractice;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    boolean canCashOut1 = false;
    boolean canCashOut2 = false;//记录按钮是否在前一个操作中被按过
//    Product product;

    Window(){
        init();
        draw();
//        member = new Member();
        setController();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    void setController(){
        //为注册按钮添加监视器
        ControllerRegister controllerRegister = new ControllerRegister();
        controllerRegister.setWindow(this);
        this.buttonRegister.addActionListener(controllerRegister);
        //为查询按钮添加监视器
        ControllerInquire controllerInquire = new ControllerInquire();
        controllerInquire.setWindow(this);
        this.buttonInquire.addActionListener(controllerInquire);
        //为结束按钮添加监视器
        ControllerFinish controllerFinish = new ControllerFinish();
        controllerFinish.setWindow(this);
        this.buttonFinish.addActionListener(controllerFinish);
        //为收银按钮添加监视器
        ControllerCashing controllerCashing = new ControllerCashing();
        controllerCashing.setWindow(this);
        this.buttonCashing.addActionListener(controllerCashing);
        //为确定按钮添加监视器
        ControllerCatch controllerCatch = new ControllerCatch();
        controllerCatch.setWindow(this);
        this.buttonCatch.addActionListener(controllerCatch);
        //为结账按钮添加监视器
        ControllerCashOut controllerCashOut = new ControllerCashOut();
        controllerCashOut.setWindow(this);
        this.buttonCashOut.addActionListener(controllerCashOut);

        validate();
    }

//    Member member; 好像不需要Member类，都是面向数据库编程，感觉有点多余

    JTextField fieldName;
    JTextField fieldPhoneid;
    JTextField fieldProductId;
    JTextField fieldShowAmount;

    JTextArea areaMain;
    JScrollPane jScrollPane;//设定主文本区的滚动条

    JButton buttonCatch;
    JButton buttonRegister;
    JButton buttonInquire;
    JButton buttonCashing;
    JButton buttonCashOut;
    JButton buttonFinish;

    JRadioButton radiobuttonWeChat;
    JRadioButton radiobuttonAlipay;
    JRadioButton radiobuttonCash;
    JRadioButton radiobuttonCard;

    ButtonGroup buttonGroup;

    void init(){
        fieldName = new JTextField(13);
        fieldPhoneid = new JTextField(13);
        fieldProductId = new JTextField(13);
        fieldShowAmount = new JTextField(10);
        areaMain = new JTextArea(200,64);
        buttonCatch = new JButton("");
        buttonCashing = new JButton("Cashing");
        buttonFinish = new JButton("Finish");
        buttonInquire = new JButton("Inquire");
        buttonRegister = new JButton("Register");
        buttonCashOut = new JButton("CashOut");
        radiobuttonAlipay = new JRadioButton();
        radiobuttonCard = new JRadioButton();
        radiobuttonCash = new JRadioButton();
        radiobuttonWeChat = new JRadioButton();
        //定义单选按钮组，并添加上去
        buttonGroup = new ButtonGroup();
        buttonGroup.add(radiobuttonAlipay);
        buttonGroup.add(radiobuttonWeChat);
        buttonGroup.add(radiobuttonCard);
        buttonGroup.add(radiobuttonCash);
    }

    void draw(){
        this.setLayout(null);//设计布局为null，便于设定布局

        //设计JLabel字体
        Font font=new Font("Montserrat",Font.PLAIN,14);

        //定义标签和文本框（名字和手机号）
        JLabel labelName = new JLabel("MemberName:");
        JLabel labelPhoneId = new JLabel("MemberPhoneId:");
        labelName.setFont(font);
        labelPhoneId.setFont(font);
        labelName.setBounds(150,10,150,30);
        this.add(labelName);
        fieldName.setBounds(300,10,150,30);
        this.add(fieldName);
        labelPhoneId.setBounds(150,45,150,30);
        this.add(labelPhoneId);
        fieldPhoneid.setBounds(300,45,150,30);
        this.add(fieldPhoneid);

        //定义三个功能按钮（注册、查询、收银）
        buttonRegister.setBounds(150,85,100,30);
        this.add(buttonRegister);
        buttonInquire.setBounds(300,85,100,30);
        this.add(buttonInquire);
        buttonCashing.setBounds(450,85,100,30);
        this.add(buttonCashing);

        //定义主文本区和其大小
//        areaMain.setSize(400,250);
//        areaMain.setBounds(150, 120,400,250);
        areaMain.setLineWrap(true);
//        this.add(areaMain);
        this.areaMain.setDisabledTextColor(Color.black);//设定不可选定时主文本区内字体的颜色（原浅蓝色）
        this.areaMain.setEnabled(false);//永久设定主文本区不可选定
        jScrollPane = new JScrollPane(areaMain);//把主文本区添加滚动条
        jScrollPane.setSize(400,250);
        jScrollPane.setBounds(150, 120,400,250);
        jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(jScrollPane);

        //定义结账按钮
        buttonCashOut.setBounds(150,375,150,30);
        this.add(buttonCashOut);

        //定义结账时，接收商品id的文本框
        fieldProductId.setBounds(330,375,150,30);
        this.add(fieldProductId);

        //定义选商品时的确定按钮
        buttonCatch.setSize(30,30);
        buttonCatch.setBounds(490,375,30,30);
        this.add(buttonCatch);

        //定义结账时的总金额显示框
        fieldShowAmount.setBounds(550,375,100,30);
        fieldShowAmount.setDisabledTextColor(Color.black);
        fieldShowAmount.setEnabled(false);
        this.add(fieldShowAmount);

        //定义结账方式的标签和按钮
        JLabel labelPay = new JLabel("payment method : ");
        JLabel labelPay1 = new JLabel("Alipay");
        JLabel labelPay2 = new JLabel("Cash");
        JLabel labelPay3 = new JLabel("Card");
        JLabel labelPay4 = new JLabel("WeChatPay");

        labelPay.setFont(font);
        labelPay1.setFont(font);
        labelPay2.setFont(font);
        labelPay3.setFont(font);
        labelPay4.setFont(font);

        labelPay.setBounds(150,420,120,20);

        radiobuttonAlipay.setBounds(270,420,20,20);
        labelPay1.setBounds(290,420,40,20);
        radiobuttonCash.setBounds(370,420,20,20);
        labelPay2.setBounds(390,420,40,20);

        radiobuttonCard.setBounds(270,450,20,20);
        labelPay3.setBounds(290,450,40,20);
        radiobuttonWeChat.setBounds(370,450,20,20);
        labelPay4.setBounds(390,450,80,20);

        this.add(labelPay);
        this.add(labelPay1);
        this.add(labelPay2);
        this.add(labelPay3);
        this.add(labelPay4);
        this.add(radiobuttonAlipay);
        this.add(radiobuttonCard);
        this.add(radiobuttonWeChat);
        this.add(radiobuttonCash);

        buttonFinish.setBounds(550, 490, 100, 30);
        this.add(buttonFinish);
    }
}


