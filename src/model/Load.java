package model;
public class Load {
	// atributes
	private int numboxes;
	private double weightboxes;
	private String type;
	// constants
	public static final int DANGEROUS=390000;
	public static final int PERISHABLE=250000;
	public static final int NOTPERISHABLE=80000;
	public static final String DANGEROUSNAME="dangerous";
	public static final String PERISHABLENAME="perishable";
	public static final String NOTPERISHABLENAME="not Perishable";
	// relations
	private Client client;
	//Methods
	public Load(int numboxes,double weightboxes,int type,objClient){
		this.numboxes=numboxes;
		this.weightboxes=weightboxes;
		this.type=type;
		owner=objClient;
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
	public double getWeightboxes(){
		return weightboxes;
	}
	public void setWeightboxes(double weightboxes){
		this.weightboxes=weightboxes;
	}
	public String getTheclient(){
		return theclient;
	} 

}	