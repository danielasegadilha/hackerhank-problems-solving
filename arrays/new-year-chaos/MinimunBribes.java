import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
        int bribe, countBribe = 0;
        
        if (q == null || q.isEmpty()) {
            System.out.println("Invalid input");
        return;
}    
        for(int i=0; i < q.size() - 1; i++) {
            bribe = q.get(i) - i -1;
            if(bribe > 2) {
                System.out.println("Too chaotic");
                return;
            } else if(bribe > 0) {
                countBribe += bribe;
                
            } else if(bribe == 0 && i != 0) {
                if(q.get(i-1) > q.get(i)) {
                    countBribe += 1;
                }
            } else {
                if(q.get(i+1) < q.get(i)) {
                    countBribe += 1;
                }
            }
        }
            System.out.println(countBribe);
            return;
        }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
