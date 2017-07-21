package com.sunh.dayup.java_design;

/**
 * Created by jpwen on 2017/7/18.
 * 简单工厂模式
 */

public class SimpleFactoryDesign {
    public static void main(String[] args){
        Factory factory = new Factory();
        try {
            factory.newProduct("A").show();

            factory.newProduct("B").show();

            factory.newProduct("C").show();

            factory.newProduct("D").show();
        }catch (Exception e){
            System.out.println("没找到此类产品");
        }

    }



}

//1.定义抽象产品类
abstract class Product{
    public abstract void show();
}

//2.定义产品继承Product
class ProductA extends Product{

    @Override
    public void show() {
        System.out.println("生产A产品");
    }
}
class ProductB extends Product{

    @Override
    public void show() {
        System.out.println("生产B产品");
    }
}
class ProductC extends Product{

    @Override
    public void show() {
        System.out.println("生产C产品");
    }
}

//3.创建工厂类，根据传入不同的参数，生产不同的产品
class Factory{
    public Product newProduct(String product){
        switch (product){
            case "A":
                return new ProductA();
            case "B":
                return new ProductB();
            case "C":
                return new ProductC();
            default:
                  return null;
        }
    }
}