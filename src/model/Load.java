package model;
public class Load {
	// Atributes
	private double numBoxes;
	private double weightBoxes;
	private String typeLoad;
	private Client theClient;
	// Constants
	public static final int DANGEROUS=390000;
	public static final int PERISHABLE=250000;
	public static final int NOTPERISHABLE=80000;
	public static final String DANGEROUSNAME="DANGEROUS";
	public static final String PERISHABLENAME="PERISHABLE";
	public static final String NOTPERISHABLENAME="NOT PERISHABLE";
	// Relations
	private Client client;
	//Methods
	/**Load builder
	*@param numBoxes != null
	*@param weightBoxes != null
	*@param typeLoad != null
	*/
	public Load(double numBoxes,double weightBoxes,String typeLoad,Client objClient){
		this.numBoxes=numBoxes;
		this.weightBoxes=weightBoxes;
		this.typeLoad=typeLoad;
		this.theClient=objClient;
	}
	/** getNumBoxes
	     * Method to provide the number of boxes
	     * @return double number of boxes
	     */
	public double getNumBoxes(){
		return numBoxes;
	}
	/** setNumBoxes
	     * Method to changes the number of boxes
	     * @param numBoxes -number of boxes of one load-!= null
	     */
	public void setNumBoxes(double numboxes){
		this.numBoxes=numBoxes;
	}
	/** getTypeLoad
	     * Method to provide the type of load
	     * @return String type of load
	     */
	public String getTypeLoad(){
		return typeLoad;
	} 
	/** setTypeLoad
	     * Method to changes type of load
	     * @param typeLoad -type of load-!= null
	     */
	public void setTypeLoad(String typeLoad){
		this.typeLoad=typeLoad;
	}
	/** getWeightBoxes
	     * Method to provide the weight of boxes
	     * @return double weight of boxes
	     */
	public double getWeightBoxes(){
		return weightBoxes;
	}
	/** setWeightBoxes
	     * Method to changes weight of the boxes
	     * @param weightBoxes -weight of the boxes-!= null
	     */
	public void setWeightBoxes(double weightBoxes){
		this.weightBoxes=weightBoxes;
	}
	/** getTheClient
	     * Method to provide client who belongs the load
	     * @return Client client
	     */
	public Client getTheClient(){
		return theClient;
	} 
	/** toString
	     * Method to provide the load information of the client
	     * @return String load information of the client
	     */
	public String toString(){
		return "Number of boxes: "+numBoxes+"\n"+"Boxes weight: "+weightBoxes/1000+"\n"+"Type of Load: "+typeLoad;
	}

}	