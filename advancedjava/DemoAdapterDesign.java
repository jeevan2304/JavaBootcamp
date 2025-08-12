package advancedjava;

//adapter :bridges ArrayListAdaptee to stack interface

public class DemoAdapterDesign {
    public static void main(String[] args){
        Stack stack = new ArrayListStackAdapter(new ArraylistAdaptee());

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top Element:" +stack.peek());
        System.out.println("Pop Element:" +stack.pop());
        System.out.println("Top after pop:" +stack.peek());
        System.out.println("Is Stack empty:" +stack.isEmpty());

        stack.pop();
        stack.pop();

        System.out.println("Is stack empty:" +stack.isEmpty());

    }
}

