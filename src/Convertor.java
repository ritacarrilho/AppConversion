/*
Réalisation d'une application de conversion au choix :
Fahrenheit => Celcius
Miles => Kilomètre/heure
Euro => Dollard
Euro => Livre sterling
Euro => Rouble
Proposer un moyen de pouvoir faire évoluer les taux de change
 */

import java.util.Scanner;

public class Convertor {
    private float fahrenheit;
    private float celcius;
    private int miles;
    private int km;
    private float euro;
    private float dollar;
    private float poundSterling;
    private float rouble;
    private float tax;
    private String conversionChoice;

    public static void main(String[] args) {
        Convertor convertor = new Convertor();
        convertor.makeConversion();
    }

    public void makeConversion() {
        // display choices
        Scanner choice = new Scanner(System.in);
        System.out.println("Choose a conversion  : \n" +
                "1: Fahrenheit => Celcius \n" +
                "2: Miles => Kilomètre/heure \n" +
                "3: Euro => Dollard \n" +
                "4: Euro => Livre sterling \n" +
                "5: Euro => Rouble \n"
        );

        conversionChoice = choice.nextLine();

        /* if (Integer.parseInt(conversionChoice) > 0 || Integer.parseInt(conversionChoice) >= 5) {
            System.out.println(conversionChoice);
         } else {
          System.out.println("Wrong choice");
        } */

        // choose one conversion
        switch (Integer.parseInt(conversionChoice)){
            case 1:
                System.out.println(conversionChoice);
                break;
            case 2:
                System.out.println(conversionChoice);
                break;
            case 3:
                System.out.println(conversionChoice);
                System.out.println("Choose a conversion tax : ");
                tax = Integer.parseInt(choice.nextLine());
                System.out.println(tax);
                break;
            case 4:
                System.out.println(conversionChoice);
                break;
            case 5:
                System.out.println(conversionChoice);
                break;
        }

        // choose first input
        // choose second input
        // choose taxes value
        // apply and display conversion
    }

    public void temperatureConversion(){

    }

    public void distanceConversion(){

    }

    public void CoinConversion(){

    }
}