package modelation.main.generator.categorie.elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import modelation.main.generator.logic.Backtracking;

public class Attributes implements IElements {

	private List<String> preconditions = new ArrayList<>();
	private HashMap<List<String>, Integer> preconditionExecCounter = new HashMap<>();
	private List<List<String>> preconditionsSet = new ArrayList<>();

	private HashMap<Integer, String> switchers = new HashMap<>();
	private HashMap<String, Integer> switcherExecCounter = new HashMap<>();
	private int switcherID;
	private int executionNumber = 1;

	public void addAttribute(String precondition) {
		this.preconditions.add(precondition);
		this.preconditionsSet = Backtracking.perform(this.preconditions);

		for (List<String> preconditions : preconditionsSet) {
			this.preconditionExecCounter.put(preconditions, 0);
		}
	}

	public void addSwitcher(String switcher) {
		this.switchers.put(switcherID, switcher);
		this.switcherExecCounter.put(this.switchers.get(switcherID), COUNTER);

		switcherID++;
	}

	public void addDefaultSwitcher(String switcher) {
		this.switchers.put(switcherID, switcher);
		this.switcherExecCounter.put(this.switchers.get(switcherID), DEFAULT_CRITERIA);

		switcherID++;
	}

	public String performSwitcher() {
		String defaultKey = "";

		for (String key : switcherExecCounter.keySet()) {
			int timesExecuted = switcherExecCounter.get(key);

			if(timesExecuted == DEFAULT) {
				switcherExecCounter.replace(key, timesExecuted, timesExecuted + 1);
				return key;
			} else if (timesExecuted == DEFAULT_CRITERIA)
				defaultKey = key;
		}
		return defaultKey;
	}

	public void addDefaultAttributes(List<String> preconditions) {
		this.preconditionExecCounter.put(preconditions, DEFAULT_CRITERIA);
	}

	public String performAttributes() {
		String defaultKeys = "(Insira um atributo default)";

		for (List<String> keys : preconditionExecCounter.keySet()) {
			int timesExecuted = preconditionExecCounter.get(keys);

			if(timesExecuted < executionNumber && !keys.isEmpty()) {
				preconditionExecCounter.replace(keys, timesExecuted, timesExecuted + 1);
				return listToString(keys);
			} else if (timesExecuted == DEFAULT_CRITERIA) {
				defaultKeys = listToString(keys);
			}
		}

		return defaultKeys;
	}
	
	private String listToString(List<String> keys) {
		String key = "";
		for (String auxKey : keys) {
			key = key.concat("\n");
			key = key.concat(auxKey);
		}
		return key;
	}
	
	public void incrementExecutionNumber() {
		executionNumber++;
	}
}
