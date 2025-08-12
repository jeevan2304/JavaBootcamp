package advancedjava;

enum instance {//special type of class means it has private constructor
    INSTANCE; //public static abc getinstance
    int i;

    public void show() {
        System.out.println(i);
    }
}
