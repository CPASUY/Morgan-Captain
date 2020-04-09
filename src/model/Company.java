package model;
import java.time.LocalDate;
import java.util.ArrayList;
public class Company {
	//Atributes
	private String name;
	//Relations
	private Ship ship;
	private Client[] clients;
	//Methods
	/**
	*Company builder
	*@param name != null
	*/
	public Company(String name){
		this.name=name;
		ship=new Ship(name);
		clients=new Client[5];
	}
	 /** searchClient
	     *Method used to search for a client in the corresponding array.
	     * post:Client object created in the client array.
	     * @param numRegistration -client registration number-!= null
	     * @return Client searchClient null or not if find it.
	     */
	public Client searchClient(String numRegistration){
	Client searchClient=null;
	boolean find=false;
	for (int s=0;s<clients.length&&find==false;s++){
		if(clients[s]!=null){
			if (clients[s].getNumregistration().equals(numRegistration)){
			searchClient=clients[s];
			find=true;
			}
		}
	}

		return searchClient;
    }
    /** addClient
	     * Method used to create a new client. 
	     * pre: Existing client arrangement. 
	     * @param numRegistration - client registration number-!= null
	     * @param name - client name to enter - != null
	     * @return String with the operation message
	     */
	public String addClient(String name,String numRegistration,LocalDate date)
	{   String message="";
		boolean add=false;
	    Client search=searchClient(numRegistration);
	    if (search!=null){
	    	message="Error. Client already exists.";
	    }
	    else
	    {
	   		for (int m=0;m<clients.length && add==false;m++){
	    		if (clients[m]==null){
	    			clients[m]=new Client(name,numRegistration,date);
	    			add=true;
	    			message="The new client was successfully registered.";
	    	}
	    }
	    	if (add==false){
	    	message="Error.Cannot register more clients";
	    	}
	    }
        return message;
	}
	 /** addLoad
	     * Method used to add load, in addition to updating the client category each time add 
	     a load and get the total value to pay  
	     * @param numRegistration - client registration number-!= null
	     * @return String with the operation message
	     */
	public String addLoad(String numRegistration,double numBoxes,double weightBoxes,String typeLoad){
		String message="";
		boolean find=false;
		double rest=0;
		boolean s=ship.verifiedWeight(weightBoxes,numBoxes);
		double kilos=ship.convertion(weightBoxes,numBoxes);
		Client objClient=searchClient(numRegistration);
		double total=0;
		if(objClient==null){
			message="The client doesnt exist";
		}
		else if(s==true){
			message=ship.addLoad(numBoxes,typeLoad,weightBoxes,objClient);
			double valueBefore=objClient.getTotalValue();
			double kilosBefore=objClient.getTotalKilos();
			double beforeKilos=objClient.getTotalKilosFinal();
			objClient.setTotalKilos(kilosBefore+kilos);
			objClient.setTotalKilosFinal(beforeKilos+kilos);
			if(objClient.getTypeClient().equals(Client.NORMALNAME)){
				if(typeLoad.equals(Load.DANGEROUSNAME)){
					total=kilos*Load.DANGEROUS;
				}
				else if(typeLoad.equals(Load.PERISHABLENAME)){
					total=kilos*Load.PERISHABLE;
				}
				else if(typeLoad.equals(Load.NOTPERISHABLENAME)){
					total=kilos*Load.NOTPERISHABLE;
				}
				double beforeValue=objClient.getTotalValueFinal();
				objClient.setTotalValueFinal(beforeValue+total);
				objClient.setTotalValue(valueBefore+total);
			}
			else if(objClient.getTypeClient().equals(Client.SILVERNAME)){
				if(typeLoad.equals(Load.DANGEROUSNAME)){
					total=kilos*Load.DANGEROUS;
				}
				else if(typeLoad.equals(Load.PERISHABLENAME)){
					total=kilos*Load.PERISHABLE;
					rest=total*Client.SILVER;
					total=total-rest;
				}
				else if(typeLoad.equals(Load.NOTPERISHABLENAME)){
					total=kilos*Load.NOTPERISHABLE;
				}
				double beforeValue=objClient.getTotalValueFinal();
				objClient.setTotalValueFinal(beforeValue+total);
				objClient.setTotalValue(valueBefore+total);
			}
			else if(objClient.getTypeClient().equals(Client.GOLDNAME)){
				if(typeLoad.equals(Load.DANGEROUSNAME)){
					total=kilos*Load.DANGEROUS;
				}
				else if(typeLoad.equals(Load.PERISHABLENAME)){
					total=kilos*Load.PERISHABLE;
					rest=total*Client.GOLD;
					total=total-rest;
				}
				else if(typeLoad.equals(Load.NOTPERISHABLENAME)){
					total=kilos*Load.NOTPERISHABLE;
					rest=total*Client.GOLD;
					total=total-rest;
				}
				double beforeValue=objClient.getTotalValueFinal();
				objClient.setTotalValueFinal(beforeValue+total);
				objClient.setTotalValue(valueBefore+total);
			}
			else if(objClient.getTypeClient().equals(Client.PLATINUMNAME)){
				if(typeLoad.equals(Load.DANGEROUSNAME)){
					total=kilos*Load.DANGEROUS;
					rest=total*Client.PLATINUM;
					total=total-rest;
				}
				else if(typeLoad.equals(Load.PERISHABLENAME)){
					total=kilos*Load.PERISHABLE;
					rest=total*Client.PLATINUM;
					total=total-rest;
				}
				else if(typeLoad.equals(Load.NOTPERISHABLENAME)){
					total=kilos*Load.NOTPERISHABLE;
					rest=total*Client.PLATINUM;
					total=total-rest;
				}
				double beforeValue=objClient.getTotalValueFinal();
				objClient.setTotalValueFinal(beforeValue+total);
				objClient.setTotalValue(valueBefore+total);
			}
			double totalFinal=objClient.getTotalValueFinal();
			double kilosFinal=objClient.getTotalKilosFinal();
			if(kilosFinal>=35000 && kilosFinal<55000){
				objClient.setTypeClient(Client.SILVERNAME);
			}
			else if(kilosFinal>=55000 || totalFinal>=2000000 && totalFinal<5000000){
				objClient.setTypeClient(Client.GOLDNAME);
			}
			else if(totalFinal>=5000000){
				objClient.setTypeClient(Client.PLATINUMNAME);
			}
		}
		else if(s==false){
			message="The load could not be shipped";
		}
		return message;
	}
	 /** verifiedLeave.
	     * Method used to verify if the ship can set sail.  
	     * @return String with the operation message
	     */
	public String verifiedLeave(){
		String message="";
		boolean verified=ship.verifiedLeave();
		if (verified==true){
			message="The ship can set sail";
		}
		else{
			message="The ship can not set sail";
		}
		return message;
	}
	/** unLoadShip.
	     * Method used to unload the entire load of the ship whenever necessary 
	     * @return String with the operation message
	     */
	public String toUnloadShip(){
		String message="";
		ArrayList<Load> load;
		load=new ArrayList<Load>();
		load=ship.getLoads();
		ship.setTotalWeight(0);
		for (int s=0;s<clients.length;s++){
			if(clients[s]!=null){
				clients[s].setTotalValue(0);
				clients[s].setTotalKilos(0);
			}
		}
		load.clear();
		message="The ship has been completely unloaded";
		return message;
	}
	/** unLoadShip.
	     * Method used to return the total weight of the ship
	     * @return double total weight of the ship
	     */
	public double totalShip(){
		double totalShip=ship.totalShip();
		return totalShip;
	}
	/** unLoadShip.
	     * Method used to generate a customer report
	     * @param numRegistration - client registration number-!= null
	     * @return String with all client data
	     */
	public String reportClient(String numRegistration){
		String message="";
		Client objClient=searchClient(numRegistration);
		if(objClient==null){
			message="The client doesn exist";
		}
		else{
		message+=objClient.toString()+"\n";
		message+=ship.report(numRegistration);
		}
		return message;
	}
}
			