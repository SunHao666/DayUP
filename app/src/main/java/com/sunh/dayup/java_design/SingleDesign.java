package com.sunh.dayup.java_design;

import android.util.Log;
import android.widget.Toast;

/**
 * Created by jpwen on 2017/7/17.
 * 单例模式
 * ps：工人搬仓库物品
 * 实现一个类只有一个实例化对象，并提供一个全局访问点
 */
public class SingleDesign {

    public static void main(String[] args) {
//        StoreHouse s1 = new StoreHouse();
//        StoreHouse s2 = new StoreHouse();
        SingleHouse s1 = SingleHouse.newInstance();
        SingleHouse s2 = SingleHouse.newInstance();

        Carrier c1 = new Carrier(s1);
        Carrier c2 = new Carrier(s2);
        System.out.println("两个是同一个？");
        if (s1.equals(s2)) {
            System.out.println("两个是同一个");
        } else {
            System.out.println("两个不是同一个");
        }
        c1.moveIn(50);
        System.out.println("amount=" + s1.getAmount());
        c2.moveOut(50);
        System.out.println("amount=" + s2.getAmount());
    }

}

/**
 * 仓库类
 */
class StoreHouse {
    public int amount = 100;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

class SingleHouse {
    public static SingleHouse instance = null;

    public SingleHouse() {
    }

    public static SingleHouse newInstance() {
        if (instance == null) {
            //并发访问 防止创建多个实例
            synchronized (SingleHouse.class) {
                if (instance == null) {
                    instance = new SingleHouse();
                }
            }
        }
        return instance;
    }


    public int amount = 100;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

/**
 * 工人类
 */
class Carrier {


    public SingleHouse storeHouse;

    public Carrier(SingleHouse storeHouse) {
        this.storeHouse = storeHouse;
    }

    //搬进仓库
    public void moveIn(int amount) {
        storeHouse.setAmount(storeHouse.amount + amount);
    }

    //搬出仓库
    public void moveOut(int amount) {
        storeHouse.setAmount(storeHouse.amount - amount);
    }
}