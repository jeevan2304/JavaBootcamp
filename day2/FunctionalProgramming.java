import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FunctionalProgramming {
    public static void main(String[] args){

        List<String> names = Arrays.asList("Jeevan","Prajwal","Madhu","Mohith");

        names.forEach(name->System.out.println(name));
//method reference used here:
        names.forEach(System.out::println);

        System.out.println("\n");


        //lambda expressions:
        Predicate<String> startwithM = name->name.startsWith("M");
        System.out.println(startwithM.test("jeevan"));
        //method reference:
        Function<String,String> toUpper = String::toUpperCase;
        Consumer<String> printer = System.out::println;
        Supplier<LocalDateTime> currentTimeSupplier = ()->LocalDateTime.now();
        System.out.println(currentTimeSupplier.get());


        //Streams:
        names.stream()
                .filter(startwithM)
                .map(toUpper)
                .forEach(printer);





    }
}
