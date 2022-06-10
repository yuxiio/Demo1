package LabPractice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Tool {//存放工具函数和变量的类
    // 判断一个字符串是否是数字串
    public static boolean isDigit(String content) {
        boolean flag = false;
        Pattern p = Pattern.compile("^\\d{1,15}$");
        Matcher m = p.matcher(content);
        if (m.matches()) {
            flag = true;
        }
        return flag;
    }
}
