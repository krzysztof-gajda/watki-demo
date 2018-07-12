package pl.time4it;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Integer> numbers=new ArrayList<>();

    public static void main(String[] args) {

        userConsole();
    }
    private static void userConsole(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Podaj maxymalnie 5 liczb:\n");

        boolean flag=true;

        while(flag){
            flag=false;
            System.out.println("Dodać liczbe? T/N");
            String s=scanner.next();
            switch(s.toUpperCase()){
                case "T":

                    flag=true;
                    System.out.println("Podaj "+numbers.size()+" liczbe:\n");

                    try{
                        numbers.add(scanner.nextInt());

                    }catch (InputMismatchException e){
                        System.err.println("Podaj liczbe zamiast litery\n");
                        userConsole();
                    }
                    break;
                case "N":
                    if(numbers.size()>0){
                        try{
                            fiveNumberTab(numbers.toArray());
                        }catch (ArrayIndexOutOfBoundsException e){
                            System.err.println("Podaj maksymalnie 5 liczb");
                        }finally {
                            System.out.println("Sprzatam po zakonczonej pracy");
                            scanner.close();
                            numbers.clear();
                        }
                    }
                    else{
                        System.out.println("Nie podales zadnych liczb program konczy prace.");
                    }
                    break;
                    default:
                        System.out.println("Podaj wlasciwa odpowiedz");
                        flag=true;
                        break;
            }
        }
    }

    private static int[] fiveNumberTab(Object[] objects){

        int[] tab=new int[5];
        for(int i=0;i<objects.length;i++)
        {
            tab[i]=(int)objects[i];
            System.out.println(tab[i]+", ");
        }

        return tab;
    }
}
