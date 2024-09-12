import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        int d = 4;

        rotLeft(a, d);
        System.out.println(a);
    }

    public static void rotLeft(List<Integer> a, int d) {
        int n = a.size();
        d = d % n;  // Ajusta d se for maior que o tamanho da lista

        // Reverter a primeira parte da lista
        Collections.reverse(a.subList(0, d));
        // Reverter a segunda parte da lista
        Collections.reverse(a.subList(d, n));
        // Reverter a lista inteira
        Collections.reverse(a);
    }
}
