package manager;

import java.util.ArrayList;
import java.util.List;

import database.MyDataBase;
import model.Vehicle;
import model.WashingSystem;

public class WashingManager {
	
	public static void washVehicles() {
		for(WashingSystem washing_system: MyDataBase.getDefaultDAtabase().getAllWashingSystems()) {
			
			
			switch(washing_system.getType()) {
	    	case fifo:
	    		WashTheVehiclesFIFO(washing_system,MyDataBase.getDefaultDAtabase().getAllVehicles());
	    		break;
	    	case random:
	    		WashTheVehiclesRandomly(washing_system,MyDataBase.getDefaultDAtabase().getAllVehicles());
	    		break;
	    	}
			
		}
	}
	
	
	 private static void WashTheVehiclesRandomly(WashingSystem washingSystem,List<Vehicle>  vehicles) {
	    	
	    	
	    	List<Vehicle> tempVehicles = new ArrayList<>(vehicles);
	    	int vehicle_count = vehicles.size();
	    	for(int i =0;i<vehicle_count;i++) {
	    		
	    		int randomVehicleIndex = (int) (Math.random() * (tempVehicles.size()));
	    		cleanVehicle(washingSystem,tempVehicles.get(randomVehicleIndex));
	    		float newPower = washingSystem.getPower()-washingSystem.getPowerDropRate();
	    		washingSystem.setPower(newPower);
	    		
	    		tempVehicles.remove(randomVehicleIndex);
	    		
	    	}
	    	
	    	
	    }
	 
	private static void WashTheVehiclesFIFO(WashingSystem washingSystem, List<Vehicle>  vehicles) {
		for(Vehicle vehicle : vehicles ) {
			cleanVehicle(washingSystem,vehicle);
    		float newPower = washingSystem.getPower()-washingSystem.getPowerDropRate();
    		washingSystem.setPower(newPower);
    	}
	}
	
		
	private static  void cleanVehicle(WashingSystem washingSystem,Vehicle vehicle) {
		float new_dirtiness = vehicle.getDirtiness()-vehicle.getSoapType().getRates().get(washingSystem.getSoapType())*washingSystem.getPower();
		vehicle.setDirtiness(new_dirtiness);
	}
}
