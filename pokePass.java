import java.util.Random;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.util.concurrent.ThreadLocalRandom;



public class PokePass {
    private ArrayList < String > list;

    /* Constructor
     *
     */
    public PokePass() {}

    /* generatePassword builds the format section of the password. 
     *
     */
    public static String generatePassword(int len) {
        String charsCaps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String chars = "abcdefghijklmnopqrstuvwxyz";
        String nums = "0123456789";
        String symbols = "!@#$%^&*_=+-/.?<>)";

        String passSymbols = charsCaps + chars + nums + symbols;
        Random rnd = new Random();

        char[] password = new char[len]; //len is the given length of the password.
        
        //this loop randomly selects an element from one of the symbols and adds it to 
        //an array.
        for (int i = 0; i < len; i++) {
            password[i] = passSymbols.charAt(rnd.nextInt(passSymbols.length()));
        }

        //this loop converts the array into a String
        String passString = "";
        for (int j = 0; j < password.length; j++) {
            passString += password[j];

        }
        return passString;
    }

    /* pokeArray creates the arraylist that contains all the pokemon in String format
     *
     */
    public void pokeArray() {

        try {
            BufferedReader br = new BufferedReader(new FileReader("poke.txt"));
            list = new ArrayList < String > ();

            String line = br.readLine();
            while (line != null) {
                list.add(line);
                line = br.readLine();
            }

            br.close();
        } catch (IOException e) {
          System.out.println("There was issues with the file");
        }

    }

    public String finalPassword() {
        int randomInt = ThreadLocalRandom.current().nextInt(0, list.size());
        String fin = list.get(randomInt) + generatePassword(4);
        return "Your new Poke-Pass is: " + fin;
    }









}
