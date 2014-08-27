package com.github.begleyalan.chp02;

/**
 * Created by abegley on 27/08/2014.
 */
public class MeaningOfThis {
    public final int value = 4;
    public void doIt(){
        int value =6;
        Runnable r = new Runnable(){
            public final int value = 5;
            @Override
            public void run() {
                int value = 10;  //belongs to the method, not the instance
                System.out.println(this.value);
            }
        };

        r.run();
    }
    public static void main(String ... args){
        MeaningOfThis m = new MeaningOfThis();
        m.doIt();
    }
}
