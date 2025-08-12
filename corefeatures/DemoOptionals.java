package corefeatures;
import java.util.Optional;

public class DemoOptionals {
    public static void main(String[] args){
        Item item = null;
        Optional<Item> optionalItem = Optional.ofNullable(item);
        String name = optionalItem.map(items->item.getName()).orElse("no item found");
        System.out.println(name);
    }
}
//nullpointerexceptipon
