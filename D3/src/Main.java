import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Time;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {
        LocalTime time = java.time.LocalTime.now();
        final String dir = System.getProperty("user.dir");
        ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(Paths.get(dir+"/src/input.txt"));
        ArrayList<String> oxygen = new ArrayList<String>();
        ArrayList<String> scrubber = new ArrayList<String>();
        int[] gamma = new int[lines.get(1).length()];
        int[] epsilon = new int[lines.get(1).length()];
        String currentString;

        updateVal(lines, gamma, epsilon);
        //Part two
        scrubber = skim(lines, epsilon[0], 0);
        oxygen = skim(lines, gamma[0], 0);
        for (int i = 1; i < gamma.length; i++){
            if (oxygen.size() > 1){
                updateVal(oxygen, gamma, epsilon);
                oxygen = skim(oxygen, gamma[i], i);
            }
            if (scrubber.size() > 1){
                updateVal(scrubber, gamma, epsilon);
                scrubber = skim(scrubber, epsilon[i], i);
            }
        }
        System.out.println(oxygen);
        System.out.println(scrubber);
        System.out.println(time.until(java.time.LocalTime.now(), ChronoUnit.MILLIS));
    }

    public static void updateVal(ArrayList<String> arrayList, int[] gamma, int[] epsilon){
        String currentString;
        for (Iterator<String> s = arrayList.iterator(); s.hasNext();){
            currentString = s.next();
            for (int i = 0; i < gamma.length; i++){
                if (currentString.charAt(i) == '0')
                    gamma[i] -= 1;
                else
                    gamma[i] += 1;

            }

        }

        for (int i = 0; i < gamma.length; i++){
            if (gamma[i] >= 0){
                gamma[i] = 1;
                epsilon[i] = 0;
            }
            else {
                gamma[i] = 0;
                epsilon[i] = 1;
            }
        }
        return;
    }

    public static ArrayList<String> skim(ArrayList<String> arrayList, int b, int pos){
        String string;
        ArrayList<String> skimmedList = new ArrayList<String>();
        for (Iterator<String> s = arrayList.iterator(); s.hasNext();){
            string = s.next();
            if (string.charAt(pos) == ( (char) b + '0' ))
                skimmedList.add(string);
        }
        return skimmedList;
    }
}
