package com.coder.yingen.algorithm;

/**
 * Create by Alex Chu on
 */
public class IntegerToRoman {

    public String intTobuilder(int num) {
        StringBuilder builder = new StringBuilder();
        while (num > 0) {
            if (num <= 3) {
                builder.append("I");
                num-=1;
            }else if (num <= 8) {
                if (num == 4) {
                    builder.append("IV");
                    num -= 4;
                } else {
                    builder.append("V");
                    num-=5;
                }
            }else if (num <= 39) {
                if (num ==9) {
                    builder.append("IX");
                    num-=9;
                }else {
                    builder.append("X");
                    num-= 10;
                }
            }else if(num <= 89){
                if(num <= 49){
                    builder.append("XL");
                    num -= 40;
                }
                else{
                    builder.append("L");
                    num -= 50;
                }
            }
            else if(num <= 399){
                if(num <= 99){
                    builder.append("XC");
                    num -= 90;
                }
                else{
                    builder.append("C");
                    num -= 100;
                }
            }
            else if(num <= 899){
                if(num <= 499){
                    builder.append("CD");
                    num -= 400;
                }
                else{
                    builder.append("D");
                    num -= 500;
                }
            }
            else{
                if(num <= 999){
                    builder.append("CM");
                    num -= 900;
                }
                else{
                    builder.append("M");
                    num -= 1000;
                }
            }
        }
        return builder.toString();
    }
}
