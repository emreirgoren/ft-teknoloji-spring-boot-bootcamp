package org.example.repository;

import org.example.model.House;
import org.example.model.Summery;
import org.example.model.Villa;

import java.util.ArrayList;
import java.util.List;

public class EstateRepository {

    List<House> houseList = new ArrayList<>();
    List<Villa> villaList = new ArrayList<>();
    List<Summery> summeryList = new ArrayList<>();

    public EstateRepository(){
        houseList.add(new House("house1",100,2,1,100));
        houseList.add(new House("house2",200,3,1,200));
        houseList.add(new House("house3",300,4,1,300));
        villaList.add(new Villa("villa1", 400,5,2,400));
        villaList.add(new Villa("villa2",500,6,2,500));
        villaList.add(new Villa("villa3",600,7,2,600));
        summeryList.add(new Summery("summery1",700,8,3,700));
        summeryList.add(new Summery("summery2",800,9,3,800));
        summeryList.add(new Summery("summery3",900,10,3,900));
    }


    public List<House> getHouseList() {
        return houseList;
    }

    public List<Villa> getVillaList() {
        return villaList;
    }

    public List<Summery> getSummeryList() {
        return summeryList;
    }

}
