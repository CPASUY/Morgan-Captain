package model;
public class Load {
	// atributes
	private int Numboxes;
	private double Weightboxes;
	private String Theclient;
	private int Type;
	// constants
	public static final int Dangerous=390000;
	public static final int Perishable=250000;
	public static final int Notperishable=80000;
	//Methods
	public Load(int numboxes,double weightboxes,String theclient,int type){
		this.numboxes=numboxes;
		this.weightboxes=weightboxes;
		this.theclient=theclient;
		this.type=type;
	}
	public int getNumboxes(){
		return numboxes;
	}
	public void setNumboxes(int numboxes){
		this.numboxes=numboxes;
	}
	public String getType(){
		return type;
	} 
	public void setType(String type){
		this.type=type;
	}
	public double getWeightboxes()){
		return weightboxes;
	}
	public void setWeightboxes(double weightboxes){
		this.weightboxes=weightboxes;
	}
	public String getTheclient(){
		return theclient;
	} 
	public void setTheclient(String theclient){
		this.theclient=theclient;
	}
}	