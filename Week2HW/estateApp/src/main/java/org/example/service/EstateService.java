package org.example.service;

import org.example.model.Estate;
import org.example.model.House;
import org.example.model.Summery;
import org.example.model.Villa;
import org.example.repository.EstateRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EstateService {

    EstateRepository estateRepository = new EstateRepository();

    List<Estate> estateList = new ArrayList<>();

    public int getAllHousePrice() {
        return estateRepository.getHouseList().stream()
                .mapToInt(House::getPrice)
                .sum();
    }

    public int getAllVillaPrice() {
        return estateRepository.getVillaList().stream()
                .mapToInt(Villa::getPrice)
                .sum();
    }

    public int getAllSummeryPrice() {
        return estateRepository.getSummeryList().stream()
                .mapToInt(Summery::getPrice)
                .sum();
    }


    public int getAllEstatePrice() {
        return getAllHousePrice()+getAllVillaPrice()+getAllSummeryPrice();
    }

    public int getAllHouseM2() {
        return estateRepository.getHouseList().stream()
                .mapToInt(House::getM2)
                .sum();
    }

    public int getAllVillaM2() {
        return estateRepository.getVillaList().stream()
                .mapToInt(Villa::getM2)
                .sum();
    }

    public int getAllSummeryM2() {
        return estateRepository.getSummeryList().stream()
                .mapToInt(Summery::getM2)
                .sum();
    }

    public double getAllEstateM2Averege() {
        return (getAllHouseM2()+getAllVillaM2()+getAllSummeryM2()) /
                (estateRepository.getHouseList().size()+estateRepository.getVillaList().size()+estateRepository.getSummeryList().size());
    }

    public List<Estate> getAllEstates() {
        return Stream.concat(
                Stream.concat(estateRepository.getHouseList().stream(), estateRepository.getVillaList().stream()),
                estateRepository.getSummeryList().stream()
        ).collect(Collectors.toList());
    }

    public List<Estate> filterEstatesByRoomsAndHalls(int minRooms, int minHalls) {
        List<Estate> estateList = new ArrayList<>(getAllEstates());  // Convert immutable list to mutable list
        return estateList.stream()
                .filter(estate -> estate.getNumOfRoom() >= minRooms && estate.getNumOfHall() >= minHalls)
                .collect(Collectors.toList());
    }









}
