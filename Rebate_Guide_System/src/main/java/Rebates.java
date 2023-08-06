

public class Rebates {
	
	protected int rebate_id;
	protected String rebate_name;
	protected int rebate_amnt;
	protected String rebate_details;
	
	
	public Rebates(int rebate_id, String rebate_name, int rebate_amnt, String rebate_details) {
		super();
		this.rebate_id = rebate_id;
		this.rebate_name = rebate_name;
		this.rebate_amnt = rebate_amnt;
		this.rebate_details = rebate_details;
	}


	public int getRebate_id() {
		return rebate_id;
	}


	public void setRebate_id(int rebate_id) {
		this.rebate_id = rebate_id;
	}


	public String getRebate_name() {
		return rebate_name;
	}


	public void setRebate_name(String rebate_name) {
		this.rebate_name = rebate_name;
	}


	public int getRebate_amnt() {
		return rebate_amnt;
	}


	public void setRebate_amnt(int rebate_amnt) {
		this.rebate_amnt = rebate_amnt;
	}


	public String getRebate_details() {
		return rebate_details;
	}


	public void setRebate_details(String rebate_details) {
		this.rebate_details = rebate_details;
	}
	
    @Override
    public String toString()
    {
        return rebate_id + ", " + rebate_name + ", " + rebate_amnt + ", " + rebate_details + "\r";
    }
	
	
}
