package day2;

class Phone {
    private String os;
    private String processor;
    private double screenSize;
    private int battery;
    private int camera;

    public Phone(String os, String processor, int screenSize, int battery, int camera) {
        super();
        this.os = os;
        this.processor = processor;
        this.screenSize = screenSize;
        this.battery = battery;
        this.camera = camera;

    }
    @Override
    public String toString() {
        return "Phone [os=" + os +
                ", processor=" + processor +
                ", screenSize=" + screenSize +
                ", battery=" + battery +
                ", camera=" + camera + "]";
    }

}
public class BuilderPattern {
    public static  void main(String[] args){
        Phone p = new PhoneBuilder().setOs("android").setCamera(12).getPhone();


 System.out.println(p);
    }

}

//Builderpatter:creational design pattern

class PhoneBuilder{
    private String os;
    private String processor;
    private int screenSize;
    private int battery;
    private int camera;

    public PhoneBuilder setOs(String os){
        this.os = os;
        return this;
    }
    public PhoneBuilder setProcessor(String processor){
        this.processor = processor;
        return this;
    }
    public PhoneBuilder setScreenSize(int screenSize){
        this.screenSize = screenSize;
        return this;
    }
    public PhoneBuilder setBattery(int battery){
        this.battery = battery;
        return this;
    }
    public PhoneBuilder setCamera(int camera){
        this.camera = camera;
        return this;
    }
    public Phone getPhone(){
        return new Phone(os,processor,screenSize,battery,camera);
    }


}