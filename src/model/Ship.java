package model;
import java.util.Arraylist;
public class Ship {
	// atributes
	private String name;
	private double totalweight;
	private int numloads;
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
		this.numloads=0,
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
	public String addLoad(int numboxes,String type,double weightboxes,Client objClient){
		String message="";
		double kilo=convertion(weightboxes);
		double kilos= numBoxes*kilo;
		int num=ship.getNumloads();	
		double shipWeight=ship.getTotalWeigth();
		Arraylist<Load>loads=ship.getLoads();
		if(shipWeight+kilos<Ship.MAXWEIGHT){
			if(type==Load.DANGEROUSNAME){
				for(int s=0,s<loads.size(),s++){
					if(loads.get(s).getType()!=Load.PERISHABLENAME){
						ship.setNumloads(num+1);
						Load loads=new Load(int numboxes,double weightboxes,int type,objClient);
						loads.add(load);
						ship.setTotalWeight(shipWeight+kilos);
						;

					}
				}
			}					
			else if(type==Load.PERISHABLENAME){
				for(int s=0,s<loads.size(),s++){
					if(loads.get(s).getType()!=Load.DANGEORUSNAME){
						message="The load has been successfully shipped";
						ship.setNumloads(num+1);
						Load loads=new Load(int numboxes,double weightboxes,int type,objClient);
						loads.add(load);
						ship.setTotalWeight(shipWeight+kilos);
					}
				}
			}
		else
			{
			message="Load could not be shipped";
			}
		}	
		return message;
	}
	public boolean verifiedWeight(double w){
		boolean load=false;
		double kilos=convertion(w);
		double total=kilos+totalWeight;
		if (total<= MAXWEIGHT){
			load=true;
		}
		return load;
	}
	public boolean verifiedLeave(int numloads,int numBoxes,double weightBoxes){
		boolean verified;
		int num=ship.getNumLoads();
		double total=ship.getTotalWeigth();
		if(num>2 || total>12000){
			verified=true;
		}
		else{
			verified=false,
		}
		return verified;
	}
	public double Convertion(double weightboxes){
		kilos=weightboxes/1000;
		return kilos;
	}
	public double TotalValue(int,numregistration,int numBoxes,double weightboxes,String typeload,){
		double kilos=convertion(weightboxes);
		double totalValue=0;
		if(type.equals(Load.DANGEORUSNAME)){
			totalValue=kilos*Load.DANGEORUS;
		}
		else if(type.equals(Load.PERISHABLENAME)){
			totalValue=kilos*Load.PERISHABLE;
		}
		else(type.equals(Load.NOTPERISHABLE)){
			totalValue=kilos*Load.NOTPERISHABLE;
		} 
		return totalValue;
	}	
}	