import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

class Test{
    public static void main(String[] args) {
        String s="GuruKripahiKebalam";
        String[] s1=s.split("");
        System.out.println(Arrays.asList(s1).stream().collect
        (Collectors.groupingBy(Function.identity(),Collectors.counting())));

    }
}