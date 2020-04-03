package model;
import java.time.LocalDate;
public class Client {
	// atributes
	private String name;
	private int numregistration;
	private LocalDate date;
	private String type;
	// constants
	public static final double NORMAL=0;
	public static final double SILVER=0.015;
	public static final double GOLD=0.03;
	public static final double PLATINUM=0.05;
	public static final String NORMALNAME="Normal";
	public static final String SILVERNAME="Silver";
	public static final String GOLDNAME="Gold";
	public static final String PLATINUMNAME="Platinum";
	//Methods
	public Clients(String name,int numregistration,LocalDate date,String type){
		this.name=name;
		this.numregistration=numregistration;
		this.date=date;
		this.type="normal";
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public int getNumregistration(){
		return numregistration;
	}
	public void setNumregistration(int numregistration){
		this.numregistration=numregistration;
	}
	public int getDate(){
		return date;
	}
	public void setDate(LocalDate date){
		this.date=date;
	}
	public String getType(){
		return type;
	}
	public void setType(String type){
		this.type=type;
	}
}
