package org.example;

import org.example.service.EstateService;

public class Main {
    public static void main(String[] args) {

        EstateService estateService = new EstateService();

        int allHousePrice = estateService.getAllHousePrice();
        System.out.println("All house price: " + allHousePrice);

        int allVillaPrice = estateService.getAllVillaPrice();
        System.out.println("All villa price: " + allVillaPrice);

        int allSummeryPrice = estateService.getAllSummeryPrice();
        System.out.println("All summery price: " + allSummeryPrice);

        int allEstatePrice = estateService.getAllEstatePrice();
        System.out.println("All estate price: " + allEstatePrice);

        int allHouseM2 = estateService.getAllHouseM2();
        System.out.println("All house m2: " + allHouseM2);

        int allVillaM2 = estateService.getAllVillaM2();
        System.out.println("All villa m2: " + allVillaM2);

        int allSummeryM2 = estateService.getAllSummeryM2();
        System.out.println("All summery m2: " + allSummeryM2);

        double allEstateM2Average = estateService.getAllEstateM2Averege();
        System.out.println("All estate m2 averege: " + allEstateM2Average);

        System.out.println(estateService.filterEstatesByRoomsAndHalls(2,4));

    }
}