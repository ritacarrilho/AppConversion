/*
Réalisation d'une application de conversion au choix :
Fahrenheit => Celsius
Miles => Kilomètre/heure
Euro => Dollard
Euro => Livre sterling
Euro => Rouble
Proposer un moyen de pouvoir faire évoluer les taux de change
 */

import java.util.Scanner;

public class Convertor {
    private double fahrenheit;
    private double celsius;
    private float miles;
    private float km;
    private float coin;
    private float tax;
    private float convertedCoin;
    private String conversionChoice;
    private boolean validChoice = false;

//    public static void main(String[] args) {
//        Convertor convertor = new Convertor();
//        convertor.makeConversion();
//    }

    public void makeConversion() {
        System.out.println(" FABULOUS CONVERTER \n");
        do {
            Scanner choice = new Scanner(System.in);
            // display choices
            System.out.println("Choose an option  : \n" +
                    "1: Fahrenheit => Celsius \n" +
                    "2: Miles => Kilometers/hour \n" +
                    "3: Euro => Dollar \n" +
                    "4: Euro => Pound sterling \n" +
                    "5: Euro => Rouble \n" +
                    "6: Exit \n"
            );

            conversionChoice = choice.nextLine();

            if(!conversionChoice.matches("-?\\d+") || Integer.parseInt(conversionChoice) > 6){
                System.out.println("Invalid choice");
            } else if (Integer.parseInt(conversionChoice) > 0 || Integer.parseInt(conversionChoice) >= 6) {
                // choose one conversion option
                switch (Integer.parseInt(conversionChoice)){
                    case 1:
                        System.out.println("Insert fahrenheit value : ");
                        fahrenheit = Float.parseFloat(choice.nextLine()); // fahrenheit value to convert to celsius
                        temperatureConversion(fahrenheit);
                        break;
                    case 2:
                        System.out.println("Insert miles value : ");
                        miles = Float.parseFloat(choice.nextLine()); // fahrenheit value to convert to celsius
                        distanceConversion(miles);
                        break;
                    case 3:
                        System.out.println("Euro => Dollar");
                        System.out.println("Insert euro value : ");
                        coin = Float.parseFloat(choice.nextLine());
                        System.out.println("Choose a conversion tax : ");
                        tax = Float.parseFloat(choice.nextLine());
                        coinConversion(coin, tax);
                        break;
                    case 4:
                        System.out.println("Euro => Livre sterling");
                        System.out.println("Insert euro value : ");
                        coin = Float.parseFloat(choice.nextLine());
                        System.out.println("Choose a conversion tax : ");
                        tax = Float.parseFloat(choice.nextLine());
                        coinConversion(coin, tax);
                        break;
                    case 5:
                        System.out.println("Euro => Rouble");
                        System.out.println("Insert euro value : ");
                        coin = Float.parseFloat(choice.nextLine());
                        System.out.println("Choose a conversion tax : ");
                        tax = Float.parseFloat(choice.nextLine());
                        coinConversion(coin, tax);
                        break;
                    case 6:
                        validChoice = true; // exit program
                        System.out.println("Goodbye !");
                        break;
                }
            }
        } while (!validChoice);
    }

    public double temperatureConversion(double fahrenheitInput){
        celsius = ((fahrenheitInput-32)*5)/9; // convert fahrenheit to celsius
        System.out.println(celsius);
        return celsius;
    }

    public float distanceConversion(float milesInput){
        // multiplying the distance in miles by 1.609344
        km = (float) (milesInput * 1.609344);
        System.out.println(km);
        return km;
    }

    public float coinConversion(double coin, float taxInput){
        convertedCoin = (float)coin * taxInput;
        System.out.println(convertedCoin);
        return convertedCoin;
    }
}