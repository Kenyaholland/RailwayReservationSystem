package cen3031.group4.trainTickets;

public class Train
{

	private String to, from;
	private int distance;
	private int trainID, isSleeper,express, breakfast, lunch, dinner, capacity, days, softSeat, hardSeat, hardSleeper, softSleeper;
	private double price;
	
	
	Train()
	{
		this.distance=-1;
		this.trainID=-999;
		this.isSleeper= 0;
		this.express= 0;
		this.breakfast= 0;
		this.lunch= 0;
		this.dinner= 0;
		this.price=0.00;
	}
	
//	Train(int distance, int trainID, int isSleeper, int isExpress, String seatingOption, String sleeper, int breakfast, int lunch, int dinner,double price){
//		this.distance = distance;
//		this.trainID = trainID;
//		this.isSleeper = isSleeper;
//		this.express = isExpress;
//		this.seatingOption=seatingOption;
//		this.sleeper=sleeper;
//		this.breakfast= breakfast;
//		this.lunch = lunch;
//		this.dinner = dinner;
//		this.price=price;
//		
//	}
	
	//-------------Getters----------------
	
	public int getDistance()
	{
		return this.distance;
	}
	
	public int getID()
	{
		return this.trainID;
	}
	
	public int getIsSleeper()
	{
		return this.isSleeper;
	}
	
	public int getIsExpress()
	{
		return this.express;
	}
	
	public double getPrice()
	{
		return this.price;
	}
	
	public int getDinner() {
		return dinner;
	}	
	
	public int getLunch() {
		return lunch;
	}
	
	public int getBreakfast() {
		return breakfast;
	}	
	
	public String getTo() {
		return to;
	}	
	
	public String getFrom() {
		return from;
	}
	
	public int getCapacity() {
		return capacity;
	}	
	
	public int getDays() {
		return days;
	}
	//-------------Setters----------------
	
	public void setDistance(int route)
	{
		this.distance=route;
	}
	
	public void setID(int trainID)
	{
		this.trainID=trainID;
	}
	
	public void setSleeper(int isSleeper)
	{
		this.isSleeper=isSleeper;
	}
	
	public void setIsExpress(int express)
	{
		this.express=express;
	}

	public void setDinner(int dinner) {
		this.dinner = dinner;
	}

	public void setLunch(int lunch) {
		this.lunch = lunch;
	}

	public void setBreakfast(int breakfast) {
		this.breakfast = breakfast;
	}

	public void setTo(String destination) {
		this.to = destination;
	}

	public void setFrom(String start) {
		this.from = start;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public int getHardSeat() {
		return hardSeat;
	}

	public void setHardSeat(int hardSeat) {
		this.hardSeat = hardSeat;
	}

	public int getSoftSleeper() {
		return softSleeper;
	}

	public void setSoftSleeper(int softSleeper) {
		this.softSleeper = softSleeper;
	}

	public int getHardSleeper() {
		return hardSleeper;
	}

	public void setHardSleeper(int hardSleeper) {
		this.hardSleeper = hardSleeper;
	}

	public int getSoftSeat() {
		return softSeat;
	}

	public void setSoftSeat(int softSeat) {
		this.softSeat = softSeat;
	}
	
	

}
