/**
 * User: Administrator
 * Email:1144873128@qq.com
 * Date: 2019/6/29
 * Time: 18:17
 * Description:
 */
package com.steven.LCS;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {
    public static void main(String[] args) {

        String phoneNum1 = "138 1234 1234";


        String phoneNum2 = "13812345abc";


        String phoneNum3 = "13812345678";

        // 需要记录已经注册的数据，这里不做
        String phoneNum4 = "138 1234 5678";


        String phoneNum5 = "98765432101";
        System.out.println(signIn(phoneNum2));
    }

    public static String signIn(String phoneNum){
        String message = "";
        phoneNum = phoneNum.trim();
        char[] phoneNumChar = phoneNum.toCharArray();
        if(phoneNumChar.length != 11 && phoneNumChar.length != 13){
            return  message = "非法手机号";
        }
        if(phoneNumChar[0] != '1'){
            return message = " 此手机号码为中国大陆非法手机号码";
        }
        Pattern pattern = Pattern.compile("[0-9]*");
        if(phoneNumChar.length == 13){
            if (phoneNumChar[3] != ' ' || phoneNumChar[8] != ' '){
                return  message = "非法手机号";
            }else{
                phoneNum = phoneNum.replace(" ","");
            }
        }
        if(!pattern.matcher(phoneNum).matches()){
            return  message = "非法手机号";
        }


        return "通过此手机号注册成功";




    }
    public static boolean isMobilePhone(String phone) {
        boolean flag=true;
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        if (phone.length() != 11) {
            flag= false;
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            flag = m.matches();
        }

        return flag;
    }



}
