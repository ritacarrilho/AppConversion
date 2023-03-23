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
    private double celsius;
    private float km;
    private float convertedCoin;

    public double temperatureConversion(double fahrenheitInput){
        celsius = ((fahrenheitInput-32)*5)/9; // convert fahrenheit to celsius
        return celsius;
    }

    public float distanceConversion(float milesInput){
        km = (float) (milesInput * 1.609344);
        return km;
    }

    public float coinConversion(double coin, float taxInput){
        convertedCoin = (float)(coin * taxInput);
        return convertedCoin;
    }
}