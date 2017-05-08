package rahul.assingment1.model;

import java.util.HashMap;
import java.util.Map;

public class Galaxy {
	private Map<String,Double> minerals = new HashMap<>();
	private Map<String,Character> mapping = new HashMap<>();
	
	public Map<String, Double> getMinerals() {
		return minerals;
	}
	public void setMinerals(Map<String, Double> minerals) {
		this.minerals = minerals;
	}
	public Map<String, Character> getMapping() {
		return mapping;
	}
	public void setMapping(Map<String, Character> mapping) {
		this.mapping = mapping;
	}
	
}
