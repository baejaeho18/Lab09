package edu.handong.csee.java.lab09;
import java.util.Scanner;

public class SalesReporter {

	private double highestSales;
	private double averageSales;
	private Salesman[] team;		//name:team(salesman;class type) declare
	private int numberOfSalesman;
	private Scanner scanner;		//should be import
	
	public static void main(String[] args) {
		SalesReporter reporter = new SalesReporter();	//¼±¾ð classtype name = "new" instanced name();	
		reporter.execute();
	}
	
	public void getData() {
		System.out.println("Enter number of sales associates: ");	//system.out.println(=printf)
		scanner = new Scanner(System.in);		//(System.in):for scanner
		numberOfSalesman = scanner.nextInt();	//after instanced by "new", 'instancd name''.''action'
		scanner.nextLine();
		
		team = new Salesman[numberOfSalesman];	//array; Salesman[number...}
		
		for(int i=0;i<numberOfSalesman;i++) {
			System.out.println("Enter data of sales associates: " + (i+1) );//print:"~"+"(~)"
			
			System.out.println("Enter name of sales associates: ");
			String name = scanner.nextLine();	//how to get all line
			System.out.println("Enter associates's sales: $");
			double sales = scanner.nextDouble();
			scanner.nextLine();
			
			team[i] = new Salesman();	//team[i]: Salesman instanced
			//what's different with 23 and 33?
			team[i].setName(name); 		//instance name.public method
			team[i].setSales(sales);	//this.sales = sales
		}				
	}
	public void computeStats() {
		for(int i=0;i<numberOfSalesman;i++) {
			double highestSales = 0;
			if(highestSales<team[i+1].getSales())
				highestSales = team[i+1].getSales();
			this.highestSales = highestSales;
		
		averageSales=team[i].getSales()+averageSales;
		}
	}
	public void displayResults() {
		System.out.println("Average slaes per assoicaite is &" + averageSales);
		
		for(int i=0;i<numberOfSalesman;i++) {
			if(team[i].getSales() == highestSales) {
				System.out.println("The highest sales figure is $" + highestSales);
				System.out.println("The following had the highest sales: ");
				System.out.println("Name: " + team[i].getName());
				System.out.println("Sales: $" + team[i].getSales());
				System.out.println((team[i].getSales()-averageSales) + "above the average.");
			}
			if(team[i].getSales() != highestSales) {
				System.out.println("Name: " + team[i].getName());
				System.out.println("Sales: $" + team[i].getSales());
				if(team[i].getSales()<averageSales)
					System.out.println((averageSales-team[i].getSales()) + "below the average.");
				if(team[i].getSales()>averageSales)
					System.out.println((team[i].getSales()-averageSales) + "above the average.");
			}
		}		
	}
	public void execute() {
		getData();
		computeStats();
		displayResults();
	}
}