package sim_only.project.controller;

import sim_only.project.model.Verbruik;

import java.util.Scanner;

public class SimOnlyLauncher {

    public static void main(String[] args) {
        System.out.println("Uitwerking van Gerke de Boer");
        // Variabelen declareren en initialiseren waar nodig
        int aantalMaanden = 4;
        Scanner input = new Scanner(System.in);
        Verbruik[] verbruiken = new Verbruik[aantalMaanden];
        verbruiken[0] = new Verbruik("Juli");
        verbruiken[1] = new Verbruik("Augustus");
        verbruiken[2] = new Verbruik("September");
        verbruiken[3] = new Verbruik("Oktober");

        for (int i = 0; i < aantalMaanden; i++) {
            System.out.println("Geef je dataverbruik in MB per maand:");
            System.out.print(verbruiken[i].getMaand() + ": ");
            verbruiken[i].setHoeveelheidMB(input.nextInt());
        }

        System.out.println();
        // Bereken voor alle maanden op basis van het verbruik de kosten
        for (int i = 0; i < aantalMaanden; i++) {
            verbruiken[i].berekenKosten();
        }

        System.out.printf("%-14s%5s%7s 
", "MAAND", "MB", "KOSTEN");
        for (int i = 0; i < aantalMaanden; i++) {
            verbruiken[i].toonVerbruik();
        }
    }
}
