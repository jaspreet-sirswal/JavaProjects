package main.java.ParkingLot.Classes;

import lombok.Data;

import java.util.List;

@Data
public class ParkingFloor {
    //List<ParkingSlot> slots;
    List<ParkingSlot> freeSlots;
    public ParkingFloor(List<ParkingSlot> slots){
        this.freeSlots=slots;
    }
    ParkingSlot allocateSlot(String vehicleNo){
        if(!freeSlots.isEmpty()){
            ParkingSlot freeSlot = freeSlots.get(freeSlots.size()-1);
            freeSlots.remove(freeSlots.size()-1);
            freeSlot.assignSlot(vehicleNo);
            return freeSlot;
        }
        else throw new RuntimeException("No FreeSlots Are available, Parking is Full !!!!");
    }
    String dellocateSlot(ParkingSlot slot){
        if(slot.isOccupied){
            slot.removeSlot();
            freeSlots.add(slot);
            return "Slot Deallocated Successfully!!!";
        }
        return "Slot is already empty";
    }
}
