package ru.x5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

/*
    7. Написать программу, вычисляющую стоимость 10
    минутного междугороднего разговора в зависимости
    от кода города.
*/
public class LandlinePhone {
    public static Map<String, Double> tariff = Map.of(
            "905", 4.15,
            "194", 1.98,
            "491", 2.69,
            "800", 5.00);

    public static void main(String[] args) {

        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            String code;
            int talkTime = 10;

            do {
                System.out.println("Enter city code: 905(Moscow), 194(Rostov), 491(Krasnodar), 800(Kirov)");
                code = reader.readLine();

            } while (!tariff.containsKey(code));

            System.out.println(tariff.get(code) * talkTime);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
