import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        final String dir = System.getProperty("user.dir");
        ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(Paths.get(dir+"/src/input.txt"));
        int[] res = new int[lines.size()-2];
        int count = 0;
        for (int i = 0; i <= lines.size() - 3; i++) {
            res[i] = Integer.parseInt(lines.get(i)) + Integer.parseInt(lines.get(i+1)) + Integer.parseInt(lines.get(i+2));
        }

        for (int i = 1; i < res.length; i++)
            if (res[i] > res[i-1])
                count += 1;


        System.out.println("The number of times a depth measurement increases is " + count);
    }
}
