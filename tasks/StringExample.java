package tasks;

import java.util.*;

public class StringExample {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String:");
        String sentence = sc.nextLine();

        String[] words = sentence.split("\\s+");

        //maintain the word with its count(ascii)
        Map<String,Integer> wordAsciiSum = new HashMap<>();

        for(String word :words){
            int sum = 0;
            for(char ch : word.toCharArray()){
                sum += (int)ch;
            }
            wordAsciiSum.put(word,sum);
        }

        List<Map.Entry<String,Integer>> entries = new ArrayList<>(wordAsciiSum.entrySet());
        entries.sort(Map.Entry.comparingByValue());


        for(Map.Entry<String,Integer> entry : entries){
            System.out.print(entry.getKey()+ " ");
        }

    }
}
