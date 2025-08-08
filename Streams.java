//Streams API:

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Streams {
    public static void main(String[] args){
        List<Integer> nums = Arrays.asList(4,5,6,3,2,9);

//        Stream<Integer> data = nums.stream();
//        Stream<Integer> mappedData = data.map(n -> n*2);
//        mappedData.forEach(n->System.out.println(n));

//Stream cant be used once it is consumed like if i apply a count on one stream  then i need to put that into a another stream if i want to use it further.
//for example you can see in the above example where i use the data stream and process it by doubling it and then store it in mappeddata which i further use for printing.
//instead of mappeddata if i use data to print then i will get an error as data stream is been already used for applying map.

          Predicate<Integer> predi =  n-> n%2==1;

          //used lambda expressions here and reduced.

        int result = nums.stream()
                .filter(n-> n%2 ==1)
                .sorted()
                .map(n->n*2)
                .reduce(0,(c,e)->c+e);
        System.out.println(result);

//in the above code we use builder pattern and we reduce and optimize the code
//filter uses the function predicate
//reduce has a return type so i need to use the result variable inoder to store it
//reduce function takes two parameters starting one is from 0.


    }
}

