import java.util.Scanner;

public class BudgetBreakdown extends BudgetInfo{
	private double amountExtra=0.0; 
	private double amountForEntertainment=0.0;
	private double amountForLeisure=0.0;
	private double amountForResturants=0.0;
	private double amountForShopping=0.0;
	private double percentExtra=0.0;
	
	Scanner keyboard = new Scanner(System.in);
	
	
	public double getPercentForEntertainment(){
		System.out.print("What percentage of your remining money would you like to spend towards entertainment?(ie.movies, games etc.");
		double percentForEntertainment = keyboard.nextDouble();
		while(percentForEntertainment < 0 || percentForEntertainment> 100){
			System.out.println("That is not a valid percent. Please re-enter a valid percent(between 0 and 100(inclusive)).");
			getPercentForEntertainment();
			percentForEntertainment = keyboard.nextDouble();
		}
		return percentForEntertainment;
	}

	public double getAmountForEntertainment(){
		amountForEntertainment = (getRemainingMoney()) * (getPercentForEntertainment()/100);
		return amountForEntertainment;
	}
	
		
	public double getPercentForShopping(){
		System.out.print("What percentage of your remining money would you like to spend towards shopping?(ie.clothes etc.");
		double percentForShopping = keyboard.nextDouble();
		while(percentForShopping < 0 || percentForShopping> 100-getPercentForEntertainment()){
			System.out.println("That is not a valid percent. Please re-enter a valid percent.");
			getPercentForShopping();
			percentForShopping = keyboard.nextDouble();
		}
		return percentForShopping;
	}
	public double getAmountForShopping(){
			amountForShopping = (getRemainingMoney()) * (getPercentForShopping()/100);
			return amountForShopping;	
	}
	
	public double getPercentForResturants(){
		System.out.print("What percentage of your remining money would you like to spend towards Resturants & FastFoods ?(ie.eating out etc.");
		double percentForResturants = keyboard.nextDouble();
		while(percentForResturants < 0 || percentForResturants> 100-getPercentForEntertainment()-getPercentForShopping()){
			System.out.println("That is not a valid percent. Please re-enter a valid percent.");
			getPercentForResturants();
			percentForResturants = keyboard.nextDouble();
		}
		return percentForResturants;
	}
	public double getAmountForResturants(){
			amountForResturants = (getRemainingMoney()) * (getPercentForResturants()/100);
			return amountForShopping;	
	}
	
	public double getPercentForLeisure(){
		System.out.print("What percentage of your remining money would you like to spend towards Resturants & FastFoods ?(ie.eating out etc.");
		double percentForLeisure= keyboard.nextDouble();
		while(percentForLeisure < 0 || percentForLeisure> 100-getPercentForEntertainment()-getPercentForShopping()-getPercentForResturants()){
			System.out.println("That is not a valid percent. Please re-enter a valid percent.");
			getPercentForResturants();
			percentForLeisure = keyboard.nextDouble();
		}
		return percentForLeisure;
	}
	public double getAmountForLeisure(){
			amountForLeisure = (getRemainingMoney()) * (getPercentForLeisure()/100);
			return amountForShopping;	
	}
	
	public double getPercentExtra(){
			percentExtra=100-getPercentForEntertainment()-getPercentForShopping()-getPercentForResturants()-getPercentForLeisure(); 
			return percentExtra;
	}
	public double getAmountExtra(){
			amountExtra = (getRemainingMoney()) * (getPercentExtra()/100);
			return amountExtra;	
	}
	}
	
	
	
	
	