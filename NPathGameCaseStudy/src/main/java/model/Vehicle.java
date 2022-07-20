package model;

public class Vehicle {
	
	private Integer id; 
	private float dirtiness;

	private  SoapType  soapType;
	
	public Vehicle(int id,float dirtiness) {
		this.id=id;
		this.dirtiness=dirtiness;
	}


	public SoapType getSoapType() {
		return soapType;
	}

	public void setSoapType(SoapType soapType) {
		this.soapType = soapType;
	}

	public float getDirtiness() {
		return dirtiness;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setDirtiness(float dirtiness) {
		if(dirtiness>0) {
			this.dirtiness = dirtiness;
		}
		else {
			this.dirtiness = 0;
		}
		
	}


	@Override
	public String toString() {
		return "Vehicle{" +
				"id=" + id +
				", dirtiness=" + dirtiness +
				", soapType=" + soapType +
				'}';
	}


}
