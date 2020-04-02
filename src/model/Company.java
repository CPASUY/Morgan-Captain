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
	/** searchEmployee
	     * Método usado para buscar un empleado. <br>
	     * @param numregistration - cedula del empleado a buscar - pCedula != null
	     * @return Empleado si la cedula existe, null de lo contrario
	     */
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
	    /** addEmployee
	     * Método usado para crear un nuevo empleado. <br>
	     * <b>pre: </b> Arreglo de empleados ya existe. list!=null
	     * <b>post: </b> Objeto Empleado creado en el arreglo de empleados. <br>
	     * @param pCedula - cedula del empleado a ingresar - pCedula != null
	     * @param nomEmpleado - nombre del empleado a ingresar - nomEmpleado != null
	     * @param apelEmpleado - nombre del empleado a ingresar - apelEmpleado != null
	     * @return String con el mensaje de la operación
	     */
	public String addClient(String name,int numRegistration,LocalDate date)
	{   String message="";
		boolean add=false;
	    Client search=searchClient(numRegistration);
	    if (search!=null)
	    	message="Error. Client already exists.";
	    else
	    {
	    	for (int m=0;m<clients.length && !add;m++){
	    		if (clients[m]== null){
	    			clients[m]=new Client(name,numRegistration,date,type);
	    			add=true;
	    			message="The new client was successfully registered.";
	    		}
	    	}
	    	if (add==false)
	    		message="Error. El arreglo de empleados ha llegado a su maxima capacidad";
	    }
        return message;
	}
	public String addLoad(String numRegistration, int numboxes,String type,double weightboxes){
		String message="";
		double kilos= numBoxes*(weightboxes/1000);
		double shipWeight=ship.getTotalWeigth();
		Arraylist<Load>loads=ship.getLoads();
		if(shipWeight+kilos<Ship.MAXWEIGHT){
			if(type==Load.DANGEROUSNAME){
				for(int s=0,s<loads.size(),s++){
					if(loads.get(s).getType())
				}
			}	
		}
		return message;
	}
	public String verifiedLeave(int numBoxes,double weightBoxes,int type){
		String message="";

		boolean add=false;
		Load 
	}