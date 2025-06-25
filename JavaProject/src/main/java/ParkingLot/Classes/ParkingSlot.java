package main.java.ParkingLot.Classes;

import lombok.Data;

@Data
public class ParkingSlot {
    Boolean isOccupied;
    String parkedVehicle;
    ParkingSlot assignSlot(String vehicleNo){
        this.isOccupied=true;
        this.parkedVehicle= vehicleNo;
        return this;
    }
    void removeSlot (){
        this.isOccupied=false;
        this.parkedVehicle=null;
    }
}
