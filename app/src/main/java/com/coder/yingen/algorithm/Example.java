package com.coder.yingen.algorithm;

/**
 * PackageName: com.coder.yingen.algorithm
 * ClassName: classExample
 * Author: chuyingen
 * Date: 2019-05-08 11:37
 * Description:
 */
public class Example {
    String str = new String("good");
    char[] ch = {'a', 'b', 'c'};

    public static void main(String args[]) {
        Example ex = new Example();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");
        System.out.print(ex.ch);
    }

    public void change(String str, char ch[]) {
        str = "test ok";
    }
}
