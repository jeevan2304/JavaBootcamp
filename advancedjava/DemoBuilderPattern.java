package advancedjava;

public class DemoBuilderPattern {
    public static  void main(String[] args){
        Phone p = new PhoneBuilder().setOs("android").setCamera(12).getPhone();
        System.out.println(p);
    }
}

//Builderpatter:creational design pattern

