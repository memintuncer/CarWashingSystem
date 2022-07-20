package model;


public class WashingSystem {
    private int id;
    private float power;
    private  String soapType;
    public  enum  Type{
        fifo,
        random
    }

    private  Type type;

    private  float powerDropRate;

    public  WashingSystem(int id,String soapType,String type){
        this.id=id;
        this.soapType=soapType;
        this.power=100;
        
        this.type = Enum.valueOf(WashingSystem.Type.class,type);
        
        switch (this.type) {
	        case fifo:
	        	this.powerDropRate =10;
	        	break;   
	        case random:
	        	this.powerDropRate = 20;
	        	break;
	        }

    }
    
    public float getPower() {
    	return power;
    }
    
    public void setPower(float power) {
    	this.power=power;
    }
    
    
    public float getPowerDropRate() {
    	return powerDropRate;
    }
    
    public void setPowerDropRate(float powerDropRate) {
    	this.powerDropRate=powerDropRate;
    }
    
    
    public Type getType() {
    	
    	return this.type;
    }
    
    public void setType(Type type) {
    	
    	this.type=type;
    }
    
    public String getSoapType() {
    	return this.soapType;
    }
    
    public void setSoapType(String soapType) {
    	this.soapType = soapType ;
    }
    
    
    @Override
    public String toString() {
        return "WashingSytem{" +
                "id=" + id +
                ", power=" + power +
                ", soapType='" + soapType + '\'' +
                ", type=" + type +
                ", powerDropRate=" + powerDropRate +
                '}';
    }
}
