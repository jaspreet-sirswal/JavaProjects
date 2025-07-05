package main.java.ParkingLot.Classes;

import lombok.Data;

import java.util.List;

@Data
public class ParkingFloor {

    public List<ParkingSlot> freeSlots;
    public ParkingFloor(List<ParkingSlot> slots){
        this.freeSlots=slots;
    }
    ParkingSlot allocateSlot(String vehicleNo){
        if(!freeSlots.isEmpty()){
            int n= freeSlots.size();
            ParkingSlot freeSlot = freeSlots.get(n-1);
            freeSlot.assignSlot(vehicleNo);
            freeSlots.remove(freeSlot);
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
