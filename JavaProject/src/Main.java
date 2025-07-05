import main.java.ParkingLot.Classes.ParkingFloor;
import main.java.ParkingLot.Classes.ParkingLot;
import main.java.ParkingLot.Classes.ParkingLotManagement;
import main.java.ParkingLot.Classes.ParkingSlot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Move this class inside src.main.java.packageName
public class Main {

    public static void main(String[] args) {
        List<ParkingSlot> parkingSlots1 = new ArrayList<>(Arrays.asList(new ParkingSlot(), new ParkingSlot()));
        List<ParkingSlot> parkingSlots2 = new ArrayList<>(Arrays.asList(new ParkingSlot(), new ParkingSlot()));
        ParkingFloor parkingFloor1 = new ParkingFloor(parkingSlots1);
        ParkingFloor parkingFloor2 = new ParkingFloor(parkingSlots2);
        ParkingLot parkingLot = new ParkingLot(Arrays.asList(parkingFloor1, parkingFloor2));

        ParkingLotManagement parkingLotManagement = new ParkingLotManagement(parkingLot);
        ParkingSlot parkingSlot = parkingLotManagement.parkVehicle("MH02GD6110");
        System.out.println("Vehicle is parked at parkingSlot:: " + parkingSlot);
        ParkingSlot parkingSlot2 = parkingLotManagement.parkVehicle("PB65K2120");
        System.out.println("Vehicle is parked at parkingSlot:: " + parkingSlot2);
        ParkingSlot parkingSlot3 = parkingLotManagement.parkVehicle("PB65K2121");
        System.out.println("Vehicle is parked at parkingSlot:: " + parkingSlot3);
        ParkingSlot parkingSlot4 = parkingLotManagement.parkVehicle("PB65K2122");
        System.out.println("Vehicle is parked at parkingSlot:: " + parkingSlot4);
//
//        ParkingSlot parkingSlot5 =  parkingLotManagement.parkVehicle("PB65K2123");
//        System.out.println("Vehicle is parked at parkingSlot:: " + parkingSlot5);
        String parkingSlot5 = parkingLotManagement.removeVehicle("PB65K2121");
        System.out.println("Vehicle is parked at parkingSlot:: " + parkingSlot5);

        ParkingSlot parkingSlot6 =  parkingLotManagement.parkVehicle("PB65K2123");
        System.out.println("Vehicle is parked at parkingSlot:: " + parkingSlot6);

    }
}