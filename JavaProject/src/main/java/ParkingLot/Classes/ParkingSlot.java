package main.java.ParkingLot.Classes;

import lombok.Data;

@Data
public class ParkingSlot {
    Boolean isOccupied = false;
    String parkedVehicle = null;
    void assignSlot(String vehicleNo){
        this.isOccupied=true;
        this.parkedVehicle= vehicleNo;
    }
    void removeSlot (){
        this.isOccupied=false;
        this.parkedVehicle=null;
    }
}
