import java.util.*;

public class Launcher {

    public static void main(String[] args){

        System.out.println("un texte de bienvenue");
        Scanner variable = new java.util.Scanner(System.in);
        String mot = variable.nextLine();

        while (!mot.equals("quit") && !mot.equals("fibo")) {
            System.out.println("Unknown command");
            variable = new java.util.Scanner(System.in);
            mot = variable.nextLine();
        }

        if (mot.equals("fibo")){
            System.out.println("Donnez le nombre d'itérations de la suite de fibonachi que vous souhaitez faire : ");
            variable = new java.util.Scanner(System.in);
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
    }
}
