import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {
        final String dir = System.getProperty("user.dir");
        ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(Paths.get(dir+"/src/input.txt"));
        int forward = 0, depth = 0, aim = 0;
        String[] divided;
        String line;
        for (Iterator<String> s = lines.iterator(); s.hasNext();){
            line = s.next();
            divided = line.split("(?<=\\D) (?=\\d)");
            if (divided[0].equals("forward")){
                depth += aim * Integer.valueOf(divided[1]);
                forward += Integer.valueOf(divided[1]);
            }
            else if (divided[0].equals("down"))
                aim += Integer.valueOf(divided[1]);
            else if (divided[0].equals("up"))
                aim -= Integer.valueOf(divided[1]);
        }
        System.out.println("forward: "+forward+", depth: "+depth+", aim: "+aim);
    }
}
