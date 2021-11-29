import java.util.*;

public class Launcher {

    public static void main(String[] args){

        System.out.println("un texte de bienvenue");
        Scanner variable = new java.util.Scanner(System.in);
        String mot = variable.nextLine();

        while (!mot.equals("quit")) {
            System.out.println("Unknown command");
            variable = new java.util.Scanner(System.in);
            mot = variable.nextLine();
        }
    }
}
