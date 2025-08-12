package corefeatures;

public class DemoExceptionHandling {
    public static void main(String[] args){
        User obj = new User();
        try {
            obj.show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
        int i = 0;
        int j = 0;
        String str = null;
        int nums[]=new int[5];
        try {
            j = 10 / i;
            if(j==0)
                throw new MyException("I dont want to print zero");
            System.out.println(str.length());
            System.out.println(nums[1]);
            System.out.println(nums[5]);
        }
        catch(MyException e){
            System.out.println("THats the default output" +e);
        } catch(IndexOutOfBoundsException e){
            System.out.println("stay in the array limit ");
        } catch(ArithmeticException e){
            System.out.println("cannot divide by zero");
        } catch(Exception e){
            System.out.println("Something went wrong");
        }
        System.out.println(j);
        System.out.println("continued");
    }
}
