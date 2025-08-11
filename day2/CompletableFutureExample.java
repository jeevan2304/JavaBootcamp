package day2;

import java.util.concurrent.CompletableFuture;
public class CompletableFutureExample {
    public static void main(String[] args) {

        //declaratrion of completable future for asynchronous tasks:
        CompletableFuture<Void> test  = CompletableFuture.runAsync(()->{

        });

        CompletableFuture<Void> task = CompletableFuture.runAsync(() -> {
            System.out.println("Task running in: " + Thread.currentThread().getName());
        });


        CompletableFuture<String> greeting = CompletableFuture.supplyAsync(() -> {
            return "Hello, ";
        }).thenApply(name -> name + "Jeevan");


        CompletableFuture<String> first = CompletableFuture.supplyAsync(() -> "Completable");
        CompletableFuture<String> second = CompletableFuture.supplyAsync(() -> "Future");
        CompletableFuture<String> combined = first.thenCombine(second, (a, b) -> a + " " + b);


        greeting.thenAccept(result -> System.out.println("Greeting: " + result));
        combined.thenAccept(result -> System.out.println("Combined: " + result));


        CompletableFuture<String> faulty = CompletableFuture.supplyAsync(() -> {
            if (true) throw new RuntimeException("Oops!");
            return "This won't return";
        }).exceptionally(e -> "Recovered from error: " + e.getMessage());

        faulty.thenAccept(System.out::println);

        // Wait for all to complete
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
    }
}