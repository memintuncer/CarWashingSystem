package model;

import java.util.HashMap;
import java.util.Map;

public   class SoapType {

   private Map<String,Float> rates=new HashMap<>();

   public void addSoapType(String type, Float rate) {
      rates.put(type,rate);
   }
   
   public Map<String,Float> getRates() {
	   return rates;
	   
   }

   @Override
   public String toString() {

      return rates.entrySet().toString();
   }
}
