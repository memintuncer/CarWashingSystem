package main;




import database.MyDataBase;
import manager.OutputWriter;
import manager.WashingManager;


public class Main {


	public static void main(String[] args){
		String resourceName = "/input.json";

		MyDataBase.getDefaultDAtabase().readJsonFile(resourceName);
		WashingManager.washVehicles();
		OutputWriter outputWriter = new OutputWriter();
		outputWriter.writeToJsonFile();
	}

}
