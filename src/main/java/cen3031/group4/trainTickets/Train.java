package cen3031.group4.trainTickets;

public class Train
{

	private String name;
	private int route;
	private int trainID;
	private boolean meals,isSleeper,express;
	private String seatingOption,sleeper,mealOption;
	private double price;
	
	
	Train()
	{
		name="John Doe";
		route=-1;
		trainID=-999;
		meals=false;
		isSleeper=false;
		express=false;
		seatingOption="Hard";
		sleeper="N/A";
		mealOption="N/A";
		price=0.00;
	}
	
	//-------------Getters----------------
	
	public String getName()
	{
		return this.name;
	}
	
	public int getRoute()
	{
		return this.route;
	}
	
	public int getID()
	{
		return this.trainID;
	}
	
	public boolean hasMeals()
	{
		return this.meals;
	}
	
	public boolean getIsSleeper()
	{
		return this.isSleeper;
	}
	
	public boolean getIsExpress()
	{
		return this.express;
	}
	
	public String getSeatingOption()
	{
		return this.seatingOption;
	}
	
	public String getSleeper()
	{
		return this.sleeper;
	}
	
	public String getMealOptions()
	{
		return this.mealOption;
	}
	
	public double getPrice()
	{
		return this.price;
	}
	
	//-------------Setters----------------
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public void setRoute(int route)
	{
		this.route=route;
	}
	
	public void setID(int trainID)
	{
		this.trainID=trainID;
	}
	
	public void setMeals(boolean meals)
	{
		this.meals=meals;
	}
	
	public void setSleeper(boolean isSleeper)
	{
		this.isSleeper=isSleeper;
	}
	
	public void setIsExpress(boolean express)
	{
		this.express=express;
	}
	
	public void setSeatingOption(String seatingOption)
	{
		this.seatingOption=seatingOption;
	}
	
	public void setSleeper(String sleeper)
	{
		this.sleeper=sleeper;
	}
	
	public void setMealOptions(String mealOptions)
	{
		this.mealOption=mealOptions;
	}
	

}
