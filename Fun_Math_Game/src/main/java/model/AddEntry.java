package model;

import java.util.List;

public class AddEntry {
	static int idSeed = 1;
	private int id;
	private String name;
	public List<String> optionname;
	
	
	public AddEntry(String name) {
		this.id=idSeed++;	
		this.name=name;
		}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<String> getOptionname() {
		return optionname;
	}


	public void setOptionname(List<String> optionname) {
		this.optionname = optionname;
	}
	

}
