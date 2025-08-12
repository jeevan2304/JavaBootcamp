package advancedjava;

class ArrayListStackAdapter implements Stack {
    private ArraylistAdaptee adaptee;

    public ArrayListStackAdapter(ArraylistAdaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void push(int item) {
        adaptee.addItem(item);
    }

    @Override
    public int pop() {
        return adaptee.removeLastItem();
    }

    @Override
    public int peek() {
        return adaptee.getLastItem();
    }

    @Override
    public boolean isEmpty() {
        return adaptee.isListEmpty();
    }
}
