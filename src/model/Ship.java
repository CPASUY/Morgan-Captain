package model;
public class Ship {
	// atributes
	private String name;
	private double totalweight;
	// constants
	public static final int Maxweigth=28000;
	public static final int Minweigth=12000;
	public static final int Maxcapacity=2000;
	//Relations
	private Load[] capacity;
	//Methods
	/**
	*Ship builder
	*@param name != null
	*/
	public Ship(String name,int totalweight){
		this.name=name;
		this.totalweight=totalweight;
		capacity=new Load [Maxcapacity];
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public double getTOTALweigth(){
		return totalweight;
	}
	public void setTOTALweigth (){
		this.totalweight=totalweight;
	}
	public int calculatenumload(){
		int num=0;
		for(int s=0; s<Maxcapacity;s++){
			if(capacity[s]!=null){
				num++;
			}
		}
		return num;
	}
}	