package com.xftxyz.chapter1;

public class T11 {

    public static void main(String[] args) {

        int currentPopulation = 312032486;
        int secondsPerYear = 365 * 24 * 60 * 60;

        int birthPerYear = secondsPerYear / 7;
        int deathPerYear = secondsPerYear / 13;
        int immigrantPerYear = secondsPerYear / 45;

        int population = currentPopulation + birthPerYear - deathPerYear + immigrantPerYear;
        System.out.println("Population after 1 year: " + population);

        population = population + birthPerYear - deathPerYear + immigrantPerYear;
        System.out.println("Population after 2 years: " + population);

        population = population + birthPerYear - deathPerYear + immigrantPerYear;
        System.out.println("Population after 3 years: " + population);

        population = population + birthPerYear - deathPerYear + immigrantPerYear;
        System.out.println("Population after 4 years: " + population);

        population = population + birthPerYear - deathPerYear + immigrantPerYear;
        System.out.println("Population after 5 years: " + population);
    }
}
