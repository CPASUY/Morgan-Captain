package ui;
import java.util.Scanner;
import java.time.LocalDate;
import java.io.IOException;
import model.Load;
import model.Company;
public class Main{
	//Atributos
		private Company mainCompany;	
	// variables globales
		public static Scanner lector;
		public static void main(String[] args) {
			Scanner lector = new Scanner (System.in);
			Main objMain=new Main();
			int option;
			objMain.createCompany();
			do{
				cls();
				System.out.println ("Options Menu"+
				"\n1.Register client"+
				"\n2.Add load"+
				"\n3.Show total boat weight"+
				"\n4.Show if it is possible for the ship to set sail"+
				"\n5.Unload ship"+
				"\n6.Show client report");
				System.out.println ("Choose the option you want");
				option=lector.nextInt();
				lector.nextLine();
				switch (option){
					case 1:
						objMain.enterClient();
						break;
					case 2:
						objMain.enterLoad();
						break;
					case 3:
						objMain.totalShip();
						break;
					case 4:
						objMain.verifiedLeave();
						break;
					case 5:
						objMain.unLoad();
						break;
					case 6:
						objMain.reportClient();
						break;
				}
				System.out.println("To return to the menu type 0");
				option=lector.nextInt();
			} while (option==0);
		}
		public static void cls(){
			try{
				new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
			}
			catch (Exception E){
				System.out.println (E);
			}
	}	
		 /** createCompany
	     *Method used create a new company
	     */
		public void createCompany(){
		Scanner lector = new Scanner (System.in);
			System.out.println("Enter the name of the company");
			String companyname=lector.nextLine();
			mainCompany=new Company (companyname.toUpperCase());
		}
			 /** enterClient
	     * Method used to enter the information of a client and register it
	     */
		public void enterClient(){
			Scanner lector = new Scanner (System.in);
			System.out.println("Type the name");
			String name=lector.nextLine();
			System.out.println("Enter the registration number");
			String numRegistration=lector.nextLine();
			LocalDate date=LocalDate.now();
			String message=mainCompany.addClient(name.toUpperCase(),numRegistration,date);
			System.out.println(message);
		}
		/** enterLoad
	     * Method used to type the information of a load and register it
	     */
		public void enterLoad(){
			String typeLoad="";
			Scanner lector = new Scanner (System.in);
			System.out.println("Enter the registration number");
			int num=lector.nextInt();
			String numRegistration= String.valueOf(num);
			System.out.println("How many boxes does the client ship?");
			int numberBoxes=lector.nextInt();
			double numBoxes=numberBoxes;
			System.out.println("What is the weight of those boxes");
			double weightBoxes=lector.nextDouble();
			System.out.println("What is the type of load.Type 1 for Dangerous, 2 for Perishable or 3 for Not Perishable");
			int option=lector.nextInt();
			if(option==1){
				typeLoad=Load.DANGEROUSNAME;
			}
			else if(option==2){
				typeLoad=Load.PERISHABLENAME;
			}
			else if(option==3){
				typeLoad=Load.NOTPERISHABLENAME;
			}
			String message=mainCompany.addLoad(numRegistration,numBoxes,weightBoxes,typeLoad);
			System.out.println(message);
		}
		/** totalShip
	     * Method used to order the entire weight of the ship.
	     */
		public void totalShip(){
			double totalShip=mainCompany.totalShip();
			System.out.println("The total weight of the ship is "+ totalShip);
		}
		/** totalShip
	     * Method to verify if the ship can set sail
	     */
		public void verifiedLeave(){
			String message=mainCompany.verifiedLeave();
			System.out.println(message);
		}
		/** unLoad
	     * Method that unloads all the loads from the ship
	     */
		public void unLoad(){
			String message=mainCompany.toUnloadShip();
			System.out.println(message);
		}
		/** reportClient
	     * Method that paints all customer information
	     */
		public void reportClient(){
			Scanner lector = new Scanner (System.in);
			System.out.println("Enter the registration number");
			String numRegistration=lector.nextLine();
			String message=mainCompany.reportClient(numRegistration);
			System.out.println(message);
		}
}
