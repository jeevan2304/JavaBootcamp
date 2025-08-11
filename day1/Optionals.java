package day1;
import java.util.Optional;


class item {
    String name ;

    public item(String name){
        this.name = name;

    }

    public String getName() {
        return name;
    }
}
public class Optionals {
    public static void main(String[] args){
        item Item = null;

        Optional<item> optionalItem = Optional.ofNullable(Item);

        String name = optionalItem.map(items->Item.getName()).orElse("no item found");

        System.out.println(name);


    }
}

//nullpointerexceptipon
