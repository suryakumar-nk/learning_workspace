import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Mary");
        names.add("Bob");
        
        Consumer<String> printName = name -> System.out.println(name);
        names.forEach(printName);
    }
}
