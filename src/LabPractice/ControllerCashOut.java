package LabPractice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

public class ControllerCashOut implements ActionListener {

    Window window;

    public void setWindow(Window window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!window.canCashOut1 && !window.canCashOut2) return;//如果没按过Cashing和Catch按钮，不允许执行这个方法

        int amount = Integer.parseInt(window.fieldShowAmount.getText());
        String payMethod = " ";
        String phoneId = window.fieldPhoneid.getText().trim();
        Date date = new Date();
        String time = date.toString();
        if(phoneId.isEmpty()){
            window.areaMain.setText("");
            window.areaMain.append("Phone number is not allowed to be empty\nError!\n");
            return;
        }
        if(!Tool.isDigit(phoneId)){
            window.areaMain.setText("");
            window.areaMain.append("Mobile numbers are only allowed to contain numbers\nError!\n");
        }
        if(!(window.radiobuttonWeChat.isSelected() || window.radiobuttonCash.isSelected()
            || window.radiobuttonCard.isSelected() || window.radiobuttonAlipay.isSelected())){

            window.areaMain.append("\n!!!Payment method buttons are not selected!!!");
            return;
        }else {
            if(window.radiobuttonWeChat.isSelected()) payMethod = "WeChatPay";
            if(window.radiobuttonCard.isSelected()) payMethod = "Card";
            if(window.radiobuttonCash.isSelected()) payMethod = "Cash";
            if(window.radiobuttonAlipay.isSelected()) payMethod = "AliPay";
        }

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://175.24.187.55:3306/JAVALAB?useSSL=false&useUnicode=true&characterEncoding=utf-8";
            Connection connection = DriverManager.getConnection(url, "root", "");
            String sql = "INSERT INTO `Order` (amount , phone_id , time , pay_method) VALUES("+ amount +
                    " , '"+phoneId+
                    "' , '"+ time + "' , '" + payMethod + "' );";

            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

//            statement.close();
//            connection.close();

            String sql1 = "select total_consumption from CashSystem_Member where phone_id = '" + phoneId + "';";
            PreparedStatement preparedStatement = connection.prepareStatement(sql1);
            ResultSet resultSet = preparedStatement.executeQuery();

            int a = 0;
            if(resultSet.next()) a = resultSet.getInt("total_consumption");
            a += amount;
            String sql2 = "update CashSystem_Member set total_consumption = "+ a +" where phone_id = '"+ phoneId +"';";
            statement.executeUpdate(sql2);
            window.areaMain.setText("");
            window.areaMain.append("Consumption success!\n\nThanks!\n");
            resultSet.close();
            preparedStatement.close();
            statement.close();
            connection.close();
        }
        catch (Exception exception){
            try {
                window.areaMain.setText("");
                window.areaMain.append(exception +"\n");
                throw exception;
            } catch (ClassNotFoundException | SQLException ex) {
                window.areaMain.setText("");
                window.areaMain.append(ex +"\n");
                ex.printStackTrace();
            }
        }

    }
}
