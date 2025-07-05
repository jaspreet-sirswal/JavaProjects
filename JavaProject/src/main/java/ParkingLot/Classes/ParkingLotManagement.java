package main.java.ParkingLot.Classes;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotManagement {

    private ParkingLot parkingLot;
    private final Map<String, ParkingSlot> assignedSlotMap = new HashMap<>();

    public ParkingLotManagement(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingSlot parkVehicle(String vehicleNo) {

        for (ParkingFloor parkingFloor : parkingLot.getFloors()) {
            try {
                ParkingSlot parkedVehicleSlot = parkingFloor.allocateSlot(vehicleNo);
                assignedSlotMap.put(vehicleNo, parkedVehicleSlot);
                return parkedVehicleSlot;
            } catch (Exception e) {

            }
        }
        throw new RuntimeException("ALL Parking is full!!!");
    }

    public String removeVehicle(String vehicleNo) {
        ParkingSlot slot = assignedSlotMap.get(vehicleNo);
        if (!assignedSlotMap.containsKey(vehicleNo)) {
            return "Vehicle parking not found!!";
        }
        for (ParkingFloor parkingFloor : parkingLot.getFloors()) {
            if (!parkingFloor.getFreeSlots().contains(slot)) {
                assignedSlotMap.remove(vehicleNo);
                return parkingFloor.dellocateSlot(slot);
            }
        }
        return "Unexpected Error Occurs!!!";
    }
}
