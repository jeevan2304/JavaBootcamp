package advancedjava;

import java.util.ArrayList;

class ArraylistAdaptee {
    private ArrayList<Integer> list = new ArrayList<>();

    public void addItem(int item) {
        list.add(item);
    }

    public int removeLastItem() {
        if (list.isEmpty()) throw new RuntimeException("Stack is empty");
        return list.remove(list.size() - 1);
    }

    public int getLastItem() {
        if (list.isEmpty()) throw new RuntimeException("Stack is empty");
        return list.get(list.size() - 1);
    }

    public boolean isListEmpty() {
        return list.isEmpty();
    }
}
