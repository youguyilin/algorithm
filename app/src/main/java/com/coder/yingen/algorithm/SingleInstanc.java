package com.coder.yingen.algorithm;

public class SingleInstanc {

    private  SingleInstanc(){

    }

    public static SingleInstanc getInstance(){
        return InstanceHolder.SINGLE_INSTANC;
    }

    private static class InstanceHolder{
        private static final SingleInstanc SINGLE_INSTANC= new SingleInstanc();
    }
}
