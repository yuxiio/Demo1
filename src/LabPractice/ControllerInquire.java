package LabPractice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ControllerInquire implements ActionListener {
    Window window;

    public void setWindow(Window window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        window.canCashOut1 = false;//先设定不可结账
        window.canCashOut2 = false;

        String phoneId = window.fieldPhoneid.getText().trim();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if(!Tool.isDigit(phoneId)){
            window.areaMain.setText("");
            window.areaMain.append("Mobile numbers are only allowed to contain numbers\nError!\n");
            return;
        }
        if(phoneId.isEmpty()) {
            window.areaMain.setText("");
            window.areaMain.append("Phone number is not allowed to be empty\nError!\n");
            return;
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://175.24.187.55:3306/JAVALAB?useSSL=false&useUnicode=true&characterEncoding=utf-8";
            Connection connection = DriverManager.getConnection(url, "root", "");
            String sql1 = "SELECT * FROM CashSystem_Member WHERE phone_id = '" + phoneId + "' ;";
            String sql2 = "select * from `Order` where phone_id = '" + phoneId + "' ;";

            preparedStatement = connection.prepareStatement(sql1);
            // 执行查询用户Member语句
            resultSet = preparedStatement.executeQuery();


            //如果没查到记录，这该用户不存在，直接退出了，省点资源
            if(resultSet.isLast()){
                window.areaMain.setText("This Member and PhoneId are not registered\n!!!Error!!!\n");
                preparedStatement.close();
                connection.close();
                return;
            }

            while (resultSet.next()){//当然这个循环其实不必要啦，恒久只能循环一次，因此取消就行，我就不动了，好懒。
                String name = resultSet.getString("name");
                String time = resultSet.getString("time");
                int consume = resultSet.getInt("total_consumption");
                window.areaMain.setText("");
                window.areaMain.append("Name:  " + name + "\nConsumption:  " + consume + "\nRegistrationTime:  " + time);
            }
            window.areaMain.append("\n\n");
            preparedStatement = connection.prepareStatement(sql2);
            // 执行查询订单Order语句
            resultSet = preparedStatement.executeQuery();

            int i = 1;
            while (resultSet.next()){
                String amount = resultSet.getString("amount");
                String time = resultSet.getString("time");
                String payMethod = resultSet.getString("pay_method");
                window.areaMain.append(i + ".  " +"pay method:  "+ payMethod +
                        "\t\tamount:  " + amount + "\t\ttime:  " + time + "\n\n");
                i++;
            }
//            System.out.println(sql1);
            preparedStatement.close();
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
