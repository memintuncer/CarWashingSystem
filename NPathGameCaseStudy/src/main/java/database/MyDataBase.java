package database;

import model.SoapType;
import model.Vehicle;
import model.WashingSystem;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import main.Main;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MyDataBase {

    private  static  MyDataBase MyDataBase=new MyDataBase();

    private  ArrayList<Vehicle>  vehicles=new ArrayList<>();
    private  ArrayList<WashingSystem>  washingSytems=new ArrayList<>();
    public  static  MyDataBase getDefaultDAtabase(){
        return  MyDataBase;
    }

    public  void  readJsonFile(String filePath){
        InputStream is = Main.class.getResourceAsStream(filePath);
        if (is == null) {
            throw new NullPointerException("Cannot find resource file " + filePath);
        }

        JSONTokener tokener = new JSONTokener(is);
        JSONObject object = new JSONObject(tokener);
        JSONArray jsonVehicles = object.getJSONArray("vehicles");
        JSONArray jsonWashingSystems = object.getJSONArray("washing_systems");

        if (jsonVehicles != null) {

            
            for (int i=0;i<jsonVehicles.length();i++){

                JSONObject jsonObject=jsonVehicles.getJSONObject(i);

                Vehicle vehicle = new Vehicle(jsonObject.getInt("id"),jsonObject.getFloat("dirtiness"));
                JSONObject soapRate=jsonObject.getJSONObject("soap_rates");
                SoapType soapType=new SoapType();
                soapType.addSoapType("foam",soapRate.getFloat("foam"));
                soapType.addSoapType("watery",soapRate.getFloat("watery"));
                vehicle.setSoapType(soapType);
                vehicles.add(vehicle);
                
            }
        }

        if(jsonWashingSystems!=null){
            for (int i=0;i<jsonWashingSystems.length();i++){

                JSONObject jsonObject=jsonWashingSystems.getJSONObject(i);
                WashingSystem washingSystem = new WashingSystem(jsonObject.getInt("id"),jsonObject.getString("soap_type"),jsonObject.getString("type"));
                washingSytems.add(washingSystem);


            }
        }
    }

    public List<Vehicle> getAllVehicles(){

        return  vehicles;
    }
    public List<WashingSystem> getAllWashingSystems(){

        return  washingSytems;
    }


}
