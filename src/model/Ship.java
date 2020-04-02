package model;
import java.util.Arraylist;
public class Ship {
	// atributes
	private String name;
	private double totalweight;
	ArrayList<Load> loads;
	// constants
	public static final int MAXWEIGHT=28000;
	public static final int MINWEIGHT=12000;
	public static final int MAXCAPACITY=2000;
	//Relations
	private ArrayList<Load> loads;
	//Methods
	/**
	*Ship builder
	*@param name != null
	*/
	public Ship(String name){
		this.name=name;
		this.totalweight=0;
		capacity=new Arraylist<Load>();
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public double getTotalWeigth(){
		return totalweight;
	}
	public void setTotalWeigth (){
		this.totalweight=totalweight;
	}
	public Arraylist<Load> getLoads(){
		return loads;
	}
}	