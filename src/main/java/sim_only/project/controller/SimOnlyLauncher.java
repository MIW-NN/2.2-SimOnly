package sim_only.project.controller;

import sim_only.project.model.Consumption;

import java.util.Scanner;

public class SimOnlyLauncher {

    public static void main(String[] args) {
        System.out.println("Uitwerking van Gerke de Boer");
        // Variabelen declareren en initialiseren waar nodig
        int monthAmount = 4;
        Scanner input = new Scanner(System.in);
        Consumption[] consumptions = new Consumption[monthAmount];
        consumptions[0] = new Consumption("Juli");
        consumptions[1] = new Consumption("Augustus");
        consumptions[2] = new Consumption("September");
        consumptions[3] = new Consumption("Oktober");

        for (int i = 0; i < monthAmount; i++) {
            System.out.println("Geef je dataverbruik in MB per maand:");
            System.out.print(consumptions[i].getMonth() + ": ");
            consumptions[i].setMbQuantity(input.nextInt());
        }

        System.out.println();
        // Bereken voor alle maanden op basis van het verbruik de kosten
        for (int i = 0; i < monthAmount; i++) {
            consumptions[i].calculateCosts();
        }

        System.out.printf("%-14s%5s%7s \n", "MAAND", "MB", "KOSTEN");
        for (int i = 0; i < monthAmount; i++) {
            consumptions[i].showUsage();
        }
    }
}
