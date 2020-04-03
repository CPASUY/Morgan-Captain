package model;
public class Company {
	// atributes
	private name;
	//Relations
	private Ship ship;
	private Client[] clients;
	//Methods
	public Company(String name){
		this.name=name;
		ship=new Ship(name);
		clients=new Client[5];
	}
	public Clients searchClient(String numregistration){
	Client searchemployee=null;
	boolean find=false;
	for (int s=0;s<clients.length&&find;s++){
		if (clients[s].getNumregistration().equals(numregistration)){
			searchemployee=clients[s];
			find=true;
		}
	}
		return searchemployee;
    }
	public String addClient(String name,int numRegistration,LocalDate date)
	{   String message="";
		boolean add=false;
	    Client search=searchClient(numRegistration);
	    if (search!=null){
	    	message="Error. Client already exists.";
	    }
	    else
	    {
	    for (int m=0;m<clients.length && add;m++){
	    	if (clients[m]== null){
	    		clients[m]=new Client(name,numRegistration,date,type);
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
	public String addLoad(String numRegistration, int numboxes,String type,double weightboxes){
		String message="";
		Client objClient=searchClient(numRegistration);
		if(objClient==null){
			message="The client doesnt exist"
			boolean freight=ship.verifiedWeight(weightboxes*numboxes);
			if(freight==false){
				message="Load could not be shipped";
			}
			else{
				message=ship.addLoad(numboxes,type,weightboxes,objClient);
			}
		}
	}
	public String verifiedLeave(){
		String message="";
		boolean verified=ship.verifiedLeave(numloads,numBoxes,weightBoxes);
		if (verified==true){
			message="The ship can set sail";
		}
		else{
			message="The ship can set sail";
		}
	}
}