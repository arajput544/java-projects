package model;

public class bpvalues {
	
	int s;
	int d;
	String timeframe;
	
	
	public bpvalues(int s,int d, String timeframe) {
		
		this.s=s;
		this.d=d;
		this.timeframe= timeframe;
	}


	public int getS() {
		return s;
	}


	public void setS(int s) {
		this.s = s;
	}


	public int getD() {
		return d;
	}


	public void setD(int d) {
		this.d = d;
	}


	public String getTimeframe() {
		return timeframe;
	}


	public void setTimeframe(String timeframe) {
		this.timeframe = timeframe;
	}

}

