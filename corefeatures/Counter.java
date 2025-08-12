package corefeatures;

class Counter {
    int count;

    //this synchronized method allows only one thread to operate like increment at a time not both the threads
    public synchronized void increment() {
        count++;
    }
}
