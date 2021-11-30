
import java.util.*;
import java.nio.file.*;
import java.io.IOException;

public class Launcher {

    public static void main(String[] args) throws IOException {

        System.out.println("un texte de bienvenue");
        Scanner variable = new Scanner(System.in);
        String mot = variable.nextLine();

        while (!mot.equals("quit") && !mot.equals("fibo") && !mot.equals("freq")) {
            System.out.println("Unknown command");
            variable = new Scanner(System.in);
            mot = variable.nextLine();
        }

        if (mot.equals("fibo")){
            System.out.println("Donnez le nombre d'itérations de la suite de fibonachi que vous souhaitez faire : ");
            variable = new Scanner(System.in);
            String tmp = variable.nextLine();
            int n = Integer.parseInt(tmp);
            int fo = 0;
            int fl = 1;
            int fn = 0;
            int tmp1 = fo;
            int tmp2 = fl;
            int i = 2;
            if (n == 0) {
                System.out.println(fo);
            }
            else if (n == 1){
                System.out.println(fl);
            }
            else{
                while (i <= n){


                    fn = tmp1 + tmp2;
                    tmp1 = tmp2;
                    tmp2 = fn;
                    i = i+1;
                }
                System.out.println(fn);
            }

        }

        else if (mot.equals("freq")){
            System.out.println("Donnez un chemin de fichier : ");
            variable = new Scanner(System.in);
            String tmp = variable.nextLine();
            Path chemin = Paths.get(tmp);

            try {
                String fichier = Files.readString(chemin);
                fichier = fichier.toLowerCase(Locale.ROOT);
                fichier = fichier.replaceAll(",", " ");
                fichier = fichier.replaceAll("\\?", " ");
                fichier = fichier.replaceAll(";", " ");
                fichier = fichier.replaceAll("\\.", " ");
                fichier = fichier.replaceAll(":", " ");
                fichier = fichier.replaceAll("/", " ");
                fichier = fichier.replaceAll("!", " ");
                fichier = fichier.replaceAll("\"", " ");
                fichier = fichier.replaceAll("\\(", " ");
                fichier = fichier.replaceAll("\\)", " ");
                fichier = fichier.replaceAll("-", " ");
                fichier = fichier.replaceAll("\'", " ");
                String[] tab = fichier.split(" ");

                for (int i = 0; i < tab.length; i++){
                    tab[i] = tab[i].replaceAll(" ", "");
                }
                String[][] end = new String[tab.length][2];
                for (int i = 0; i < end.length; i ++){
                    end[i][0] = "";
                    end[i][1] = "0";
                }
                int cmpt = 0;

                for (int i = 0; i < tab.length; i++){

                    for (int j = 0; j < end.length; j++){

                        if (tab[i].equals(end[j][0])){
                            cmpt = cmpt+1;

                            end[j][1] = String.valueOf(Integer.parseInt(end[j][1]) + 1);

                        }
                        else if (end[j][0].equals("") && cmpt == 0){
                            end[j][0] = tab[i];
                            end[j][1] = "1";
                            cmpt = cmpt + 1;
                        }
                    }
                    cmpt = 0;
                }

                int tmp2 = 0;
                String word = "";
                for (int i = 0; i < end.length; i++){

                    if (Integer.parseInt(end[i][1]) > tmp2 && !end[i][0].equals("")){
                        tmp2 = Integer.parseInt(end[i][1]);
                        word = end[i][0];
                    }
                }

                System.out.println("Le mot le plus présent est : " + word);

            }
            catch (IOException e) {

                System.out.println("Unreadable file: ");
                e.printStackTrace();
            }



        }
    }
}
