package main.java.ParkingLot.Classes;

import lombok.Data;

import java.util.List;

@Data
public class ParkingLot {
    List<ParkingFloor> floors;
    public ParkingLot (List<ParkingFloor> floors){
        this.floors=floors;
    }
}
