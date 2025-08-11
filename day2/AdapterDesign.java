package day2;

import java.util.ArrayList;

interface Stack{
    void push(int item);
    int pop();
    int peek();
    boolean isEmpty();
}

class ArraylistAdaptee {
    private ArrayList<Integer> list = new ArrayList<>();

    public void addItem(int item){
        list.add(item);
    }
    public int removeLastItem(){
        if(list.isEmpty()) throw new RuntimeException("Stack is empty");
        return list.remove(list.size()-1);
    }
    public int getLastItem() {
        if (list.isEmpty()) throw new RuntimeException("Stack is empty");
        return list.get(list.size() - 1);
    }

    public boolean isListEmpty() {
        return list.isEmpty();
    }
}

//adapter :bridges ArrayListAdaptee to stack interface

class ArrayListStackAdapter implements Stack{
    private ArraylistAdaptee adaptee;

    public ArrayListStackAdapter(ArraylistAdaptee adaptee){
        this.adaptee = adaptee;
    }
    @Override
    public void push(int item){
        adaptee.addItem(item);

    }

    @Override
    public int pop(){
        return  adaptee.removeLastItem();
    }
    @Override
    public int peek(){
        return adaptee.getLastItem();
    }
    @Override
    public boolean isEmpty(){
        return adaptee.isListEmpty();
    }
}
public class AdapterDesign {
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

