package model;
import java.util.ArrayList;
public class Ship {
	// Atributes
	private String name;
	private double totalWeight;
	private int numLoads;
	// Constants
	public static final int MAXWEIGHT=28000;
	public static final int MINWEIGHT=12000;
	public static final int MINLOAD=2;
	//Relations
	private ArrayList<Load> loads;
	//Methods
	/**
	*Ship builder
	*@param name != null
	*/
	public Ship(String name){
		this.name=name;
		this.totalWeight=0;
		this.numLoads=0;
		loads=new ArrayList<Load>();
	}
	/** getName
	     * Method to provide the name of the ship
	     * @return String name of the ship
	     */
	public String getName(){
		return name;
	}
	/** getTotalWeight
	     * Method to provide the loads total weight of the ship
	     * @return double total weight
	     */
	public double getTotalWeigth(){
		return totalWeight;
	}
	/** setTotalVWeight
	     * Method to changes the total weight of the ship
	     * @param totalWeight -ship total weight-!= null
	     */
	public void setTotalWeight(double totalWeight){
		this.totalWeight=totalWeight;
	}
	/** getLoads
	     * Method to provide loads of the ship
	     * @return Load loads of the ship
	     */
	public ArrayList<Load> getLoads(){
		return loads;
	}
	/** addLoad
	     * Method used to add a new load to the Load ArrayList
	     * @param typeLoad -type of load of the client to enter != null
	     * @return String with the operation message
	     */
	public String addLoad(double numBoxes,String typeLoad,double weightBoxes,Client objClient){
		String message="";
		boolean yeah=false;
		double kilos=convertion(weightBoxes,numBoxes);	
		double totalValue=objClient.getTotalValue();
			if(typeLoad.equals(Load.DANGEROUSNAME)){
				for(int s=0;s<loads.size();s++){
					if(loads.get(s).getTypeLoad().equals(Load.PERISHABLENAME)){
						yeah=true;
						;
					}
				}
				if(yeah==true){
					message="The load could not be shipped";
				}
				else{
				message="The load has been successfully shipped";
						numLoads=numLoads+1;
						Load loads=new Load(numBoxes,weightBoxes,typeLoad,objClient);
						this.loads.add(loads);
						totalWeight=totalWeight+kilos;
						double kilosBefore=objClient.getTotalKilos();
						objClient.setTotalKilos(kilosBefore+kilos);
						message="The load has been successfully shipped";
				}
			}					
			else if(typeLoad.equals(Load.PERISHABLENAME)){
				for(int s=0;s<loads.size();s++){
					if(loads.get(s).getTypeLoad().equals(Load.DANGEROUSNAME)){
						yeah=true;
					}
				}
				if(yeah==true){
					message="The load could not be shipped";
				}
				else{
					message="The load has been successfully shipped";
					numLoads=numLoads+1;
					Load loads=new Load(numBoxes,weightBoxes,typeLoad,objClient);
					this.loads.add(loads);
					totalWeight=totalWeight+kilos;
					double kilosBefore=objClient.getTotalKilos();
					objClient.setTotalKilos(kilosBefore+kilos);
				}
			}
			else if(typeLoad.equals(Load.NOTPERISHABLENAME)){
				message="The load has been successfully shipped";
				numLoads=numLoads+1;
				Load loads=new Load(numBoxes,weightBoxes,typeLoad,objClient);
				this.loads.add(loads);
				totalWeight=totalWeight+kilos;
				double kilosBefore=objClient.getTotalKilos();
				objClient.setTotalKilos(kilosBefore+kilos);
			}
		return message;
	}
	/** verifiedWeight
	     *Method used to verify if the load is less than the total weight of the ship. 
	     * @return boolean true if it can be shipped, false if not
	     */
	public boolean verifiedWeight(double weightboxes, double numBoxes){
		boolean load=false;
		double kilos=convertion(weightboxes,numBoxes);
		double total=kilos+totalWeight;
		if (total<= MAXWEIGHT){
			load=true;
		}
		return load;
	}
	/** verifiedLeave
	     * Method used to verify if the ship can set sail.
	     * @return boolean true if can set sail, false if not.
	     */
	public boolean verifiedLeave(){
		boolean verified;
		if(MINLOAD>2 || totalWeight>12000){
			verified=true;
		}
		else{
			verified=false;
		}
		return verified;
	}
	/** convertion
	     * Method used to convert the weight of the boxes into kilos.
	     * @return double with the weight in kilos
	     */
	public double convertion(double weightboxes,double numBoxes){
		double kilos=(weightboxes/1000)*numBoxes;
		return kilos;
	}
	/** totalShip
	     * Method used to return the total weight of the ship
	     * @return double total weight of the ship
	     */
	public double totalShip(){
		return totalWeight;
	}
	/** unLoadShip.
	     * Method used to find the owner of the load and used to generate a report of that client 
	     * @param numRegistration - client registration number-!= null
	     * @return String with all client load data
	     */
	public String report(String numRegistration){
		String message="";
		for(int s=0;s<loads.size();s++){
			String num=loads.get(s).getTheClient().getNumregistration();
			if(numRegistration.equals(num)){
				message+=loads.get(s).toString();
			}
		}
		return message;
	}
}	

