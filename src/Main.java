import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("src/data.txt"))){
            ArrayList<String> stringList = new ArrayList<>();
            String text;
            while (scanner.hasNext()){
                text = scanner.nextLine();
                Pattern p = Pattern.compile("\\d+");
                Matcher m = p.matcher(text);
                while (m.find()){
                    if (Integer.parseInt(m.group()) >9){
                        stringList.add(text);
                    }
                }
            }
            print(stringList);

        } catch (IOException ex) {
            System.out.println("Bad file format or file not found");
            System.out.println(ex.getMessage());
        }
    }

    private static void print (ArrayList<String> stringList){
        for (String string : stringList){
            System.out.println(string);
        }
    }
}
