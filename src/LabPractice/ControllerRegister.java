package LabPractice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class ControllerRegister implements ActionListener {

    Window window;

    public void setWindow(Window window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        window.canCashOut1 = false;//先设定不可结账
        window.canCashOut2 = false;

        String name = window.fieldName.getText().trim();
        String phoneId = window.fieldPhoneid.getText().trim();
        Date date = new Date();
        String time = date.toString();
        if(name.isEmpty() || phoneId.isEmpty()){
            window.areaMain.setText("");
            window.areaMain.append("Name or phone number is not allowed to be empty\nError!\n");
            return;
        }
        if(!Tool.isDigit(phoneId)){
            window.areaMain.setText("");
            window.areaMain.append("Mobile numbers are only allowed to contain numbers\nError!\n");
            return;
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://175.24.187.55:3306/JAVALAB?useSSL=false&useUnicode=true&characterEncoding=utf-8";
            Connection connection = DriverManager.getConnection(url, "root", "");

            String sql = "INSERT INTO CashSystem_Member (name , phone_id , time) VALUES('"+name+"' , '"+phoneId+
                    "' , '"+ time +"' );";

            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            window.areaMain.setText("");
            window.areaMain.append("MemberName: "+ name + "\nPhoneId: " + phoneId + "\n"+"Register Success!\n");
            statement.close();
            connection.close();
//
//            System.out.println(sql);
        }
        catch (SQLException exception){
//            window.areaMain.setText(Integer.toString(exception.getErrorCode()));打印错误代码为1062
            if (exception.getErrorCode()==1062){//数据库执行sql语句时，捕捉错误代码，对应错误情况处理重复注册问题
                window.areaMain.setText("");
                window.areaMain.append("This PhoneId already exists.\n!!!Error!!!\n");
            }
            try {
                throw exception;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        catch (Exception exception){
            try {
                window.areaMain.setText("");
                window.areaMain.append(exception +"\n");
                throw exception;
            } catch (ClassNotFoundException ex) {
                window.areaMain.setText("");
                window.areaMain.append(ex +"\n");
                try {
                    throw ex;
                } catch (ClassNotFoundException exc) {
                    exc.printStackTrace();
                }
            }
        }
    }

}
