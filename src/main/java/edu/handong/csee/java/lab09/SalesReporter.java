package edu.handong.csee.java.lab09;
import java.util.Scanner;
import java.util.ArrayList;

public class SalesReporter {

	private double highestSales;
	private double averageSales;
	private Salesman[] list;		//name:arrayList(salesman;class type) declare
	private int numberOfSalesman=0;
	private Scanner scanner;		//should be import

	public static void main(String[] args) {
		SalesReporter reporter = new SalesReporter();	// classtype name = "new" instanced name();	
		reporter.execute();

		//reporter.getData();
		//reporter.computeStats();
		//reporter.displayResults();

	}

	public void getData() {
//		System.out.println("Enter number of sales associates: ");	//system.out.println(=printf)
//		numberOfSalesman = scanner.nextInt();	//after instanced by "new", 'instancd name''.''action'
		
		do {
			scanner = new Scanner(System.in);		//(System.in):for scanner

			System.out.println("Enter data of sales associates" + (numberOfSalesman +1) );//print:"~"+"(~)"

			System.out.println("Enter name of sales associates: ");
			String name = scanner.nextLine();	//how to get all line
			System.out.println("Enter associates's sales: $");
			double sales = scanner.nextDouble();
			scanner.nextLine();
			System.out.println("More salesassociates for the list?");
			String ask = scanner.nextLine(); 	//choice to go or not
			scanner.nextLine();
			
			list[numberOfSalesman] = new Salesman();	//team[i]: Salesman instanced
			list[numberOfSalesman].setName(name); 		//instance name.public method
			list[numberOfSalesman].setSales(sales);	//this.sales = sales
			list[numberOfSalesman].setAsk(ask);		//this.ask = ask

			numberOfSalesman = numberOfSalesman + 1;//count how many salesman inputed
		} while(list[numberOfSalesman].getAsk() == "Yes");		
	}
	public void computeStats() {
		for(int i=0;i<numberOfSalesman;i++) {
			double highestSales = 0;
			if(highestSales<list[i].getSales())
				highestSales = list[i].getSales();
			this.highestSales = highestSales;

			averageSales=list[i].getSales()+averageSales;
		}
	}

	public void displayResults() {
		System.out.println("Average slaes per assoicaite is $" + averageSales);

		for(int i=0;i<numberOfSalesman;i++) {
			if(list[i].getSales() == highestSales) {
				System.out.println("The highest sales figure is $" + highestSales);
				System.out.println("The following had the highest sales: ");
				System.out.println("Name: " + list[i].getName());
				System.out.println("Sales: $" + list[i].getSales());
				System.out.println((list[i].getSales()-averageSales) + "above the average.");
			}
		}

		for(int i=0;i<numberOfSalesman;i++) {
			if(list[i].getSales() != highestSales) {
				System.out.println("Name: " + list[i].getName());
				System.out.println("Sales: $" + list[i].getSales());
				if(list[i].getSales()<averageSales) {
					System.out.println( (averageSales-list[i].getSales()) + "below the average.");
				}
				if(list[i].getSales()>averageSales)
					System.out.println( (list[i].getSales()-averageSales) + "above the average.");
			}
		}
	}
	
	public void execute() {
		getData();
		computeStats();
		displayResults();
	}
}