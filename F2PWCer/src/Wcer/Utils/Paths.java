package Wcer.Utils;

import org.osbot.rs07.api.map.Area;

import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.map.Position;

import java.util.ArrayList;


public class Paths {
    private ArrayList<Position[]> pathways;
    Position[] p1;
    Position[] p2;
    Position[] p3;
    Position[] p4;
    private Area location;
    private Area bank;
    public Paths(Position[] posArray1, Position[] posArray2, Position[] posArray3, Position[] posArray4, Area location, Area bank){
        this.location = location;
        this.bank = bank;
        this.p1 = posArray1;
        this.p2 = posArray2;
        this.p3 = posArray3;
        this.p4 = posArray4;
    }

//    getPaths(Area location, Area bank){
//        pathways = new ArrayList<>()
//    }



    //private String area;
    //private String bank;


//    Paths(Area area, Area bank) {
//        this.location = area;
//        this.bank = bank;
//    }
    public Area getArea(){
        return location;
    }

    public Area getTreeNames() {
        return bank;
    }

}
