package com.workshop;

public class Weather {

	private int hour;
	private double temp;
	private String wfkor;
	private int reh;
	@Override
	public String toString() {
		return "Weather [hour=" + hour + ", temp=" + temp + ", wfkor=" + wfkor + ", reh=" + reh + "]";
	}
	public Weather(int hour, double temp, String wfkor, int reh) {
		this.hour = hour;
		this.temp = temp;
		this.wfkor = wfkor;
		this.reh = reh;
	}
	
	public Weather()
	{
		
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public double getTemp() {
		return temp;
	}
	public void setTemp(double temp) {
		this.temp = temp;
	}
	public String getWfkor() {
		return wfkor;
	}
	public void setWfkor(String wfkor) {
		this.wfkor = wfkor;
	}
	public int getReh() {
		return reh;
	}
	public void setReh(int reh) {
		this.reh = reh;
	}
	
}
