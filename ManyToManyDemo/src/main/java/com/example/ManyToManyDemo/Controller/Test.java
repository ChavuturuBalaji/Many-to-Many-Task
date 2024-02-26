package com.example.ManyToManyDemo.Controller;


class A{
    public void show(){
        System.out.println("A");
    }
}
class B extends A{
    @Override
    public void show(){
        System.out.println("B");
    }
}
class C extends B{
    @Override
    public void show(){
        System.out.println("c");
    }
}
class D extends C{
    @Override
    public void show(){
        System.out.println("D");
    }
}
public class Test  {  //(int) "77";   Integer.parseInt("77");
    public static void main(String[] args) {
        C c1 = new C();
        c1.show();
    }
}
