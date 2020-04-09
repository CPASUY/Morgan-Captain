package model;
import java.time.LocalDate;
public class Client {
	// Atributes
	private String name;
	private String numRegistration;
	private LocalDate date;
	private String typeClient;
	private double totalValue;
	private double totalKilos;
	// Constants
	public static final double NORMAL=0;
	public static final double SILVER=0.015;
	public static final double GOLD=0.03;
	public static final double PLATINUM=0.05;
	public static final String NORMALNAME="Normal";
	public static final String SILVERNAME="Silver";
	public static final String GOLDNAME="Gold";
	public static final String PLATINUMNAME="Platinum";
	//Methods
	/**Client builder
	*@param numRegistration != null
	*@param name != null
	*/
	public Client(String name,String numRegistration,LocalDate date){
		this.name=name;
		this.numRegistration=numRegistration;
		this.date=date;
		this.typeClient="Normal";
		this.totalValue=0;
		this.totalKilos=0;
	}
/** getName
	     * Method to provide the name of the client
	     * @return String name of the client
	     */
	public String getName(){
		return name;
	}
/** getNumBoxes
	     * Method to provide the number of boxes of the client
	     * @return double number of boxes
	     */
	public 	String getNumregistration(){
		return numRegistration;
	}
/** getDate
	     * Method to provide the registration date of the client
	     * @return LocalDate date
	     */
	public LocalDate getDate(){
		return date;
	}
/** getTotalValue
	     * Method to provide the total value to paid of the client
	     * @return double of the total value
	     */
	public double getTotalValue(){
		return totalValue;
	}
/** setTotalValue
	     * Method to changes the total value to paid of the client
	     * @param totalValue -client total value-!= null
	     */
	public void setTotalValue(double totalValue){
		this.totalValue=totalValue;
	}
/** getTypeClient
	     * Method to provide the type of client
	     * @return String of the type client
	     */
	public String getTypeClient(){
		return typeClient;
	}
/** setTypeClient
	     * Method to changes the type of client
	     * @param typeClient -client type-!= null
	     */
	public void setTypeClient(String typeClient){
		this.typeClient=typeClient;
	}
/** getTotalKilos
	     * Method to provide the total of kilos of the client
	     * @return double total kilos
	     */
	public double getTotalKilos(){
		return totalKilos;
	}
/** setTotalKilos
	     * Method to changes the total of kilos of the client
	     * @param totalKilos -client total kilos-!= null
	     */
	public void setTotalKilos(double totalKilos){
		this.totalKilos=totalKilos;
	}
	/** toString
	     * Method to provide the information of the client
	     * @return String information of the client
	     */
	public String toString(){
		return "Name: "+name+"\n"+"Registry number: "+numRegistration+"\n"+"Type of Client: "+typeClient+"\n"+"Total kilos transported: "+totalKilos+"\n"+"Valued to paid: "+totalValue;
	}

}
