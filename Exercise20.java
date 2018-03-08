import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Exercise20 {

    /*
Write a modified version of the Vocabulary program developed in Chapter 10 that uses sets rather than
ArrayLists to store its words. (The program will be noticeably shorter and will run faster!)
     */

    // JEg har fået hjælp til denne her af min søsters kæreste. Men den virker stadig ikke :(


    public static void main(String[] args) throws FileNotFoundException {

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("t1.txt"), "utf-8"))) {
writer.write("Hej fra Set1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("t2.txt"), "utf-8"))) {
            writer.write("Hej fra Set2");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scanner input1 = new Scanner(new File("t1.txt"));
        Scanner input2 = new Scanner(new File("t2.txt"));

        Set sett1 = new HashSet();
        Set sett2 = new HashSet();

        sett1 = vocaProgramfrom10two(input1);
        sett2 = vocaProgramfrom10two(input2);

        System.out.println("Set 1: " + sett1);
        System.out.println("Set 2: " + sett2);
        System.out.println("Sammen er de således: " + vocaProgramFrom10(sett1,sett2));
    }

    public static Set<String> vocaProgramFrom10 (Set<String> set1, Set<String> set2)
    {
        Set<String> settet = new HashSet<>(set1);

        settet.retainAll(set2);
        return settet;
    }

    public static Set<String> vocaProgramfrom10two (Scanner input)
    {
        Set<String> temp = new HashSet<>();

        while (input.hasNext())
        {
            String next = input.next();
            temp.add(next);
        }
        return temp;
    }


}
