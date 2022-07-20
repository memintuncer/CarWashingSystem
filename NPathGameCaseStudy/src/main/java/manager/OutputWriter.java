package manager;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import database.MyDataBase;
import model.Vehicle;

import java.io.FileWriter;
import java.io.PrintWriter;

public class OutputWriter {
	
	
	public void writeToJsonFile() {
		 String path = "src/main/resources/output.json";
		    
		 JSONObject json = new JSONObject();
		 JSONArray jsonArray = new JSONArray(); 
		 json.put("vehicles", jsonArray);
		    for(Vehicle vehicle : MyDataBase.getDefaultDAtabase().getAllVehicles()) {
		    	
		    	try {
		    		JSONObject vehicleJsonObject = new JSONObject();
		    		vehicleJsonObject.put("final_dirtiness", vehicle.getDirtiness());
		    		vehicleJsonObject.put("id", vehicle.getId());
			    	jsonArray.put(vehicleJsonObject);
			    	
		    	}
		    	catch (JSONException e) {
		            e.printStackTrace();
		        }
		    	
		    }
	        
	 
	        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
	            out.write(json.toString());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}

}
