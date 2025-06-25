package main.java.ParkingLot.Classes;

import lombok.Data;

import java.util.List;

@Data
public class ParkingLot {
    List<ParkingFloor> floors;
    int parkingLotId;

}
