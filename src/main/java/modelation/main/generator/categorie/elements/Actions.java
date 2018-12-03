package modelation.main.generator.categorie.elements;

import java.util.HashMap;

public class Actions implements IElements {

	public String lastExecAction;
	public HashMap<Integer, String> actions = new HashMap<>();
	public HashMap<String, String> nextCategorie = new HashMap<>();
	public HashMap<String, Integer> actionExecCounter = new HashMap<>();
	private int actionID;
	int executionNumber = 1;

	public void addAction(String action, String nextState) {
		this.actions.put(actionID, action);
		this.nextCategorie.put(this.actions.get(actionID), nextState);
		this.actionExecCounter.put(this.actions.get(actionID), COUNTER);

		actionID++;
	}

	public void addDefaultAction(String action, String nextState) {
		this.actions.put(actionID, action);
		this.nextCategorie.put(this.actions.get(actionID), nextState);
		this.actionExecCounter.put(this.actions.get(actionID), DEFAULT_CRITERIA);

		actionID++;
	}

	public String getNextCategorie() {
		return nextCategorie.get(lastExecAction);
	}

	public String performActions() {
		String defaultKey = "(Insira uma acao default)";

		for (String key : actionExecCounter.keySet()) {
			int timesExecuted = actionExecCounter.get(key);

			if(timesExecuted < executionNumber) {
				actionExecCounter.replace(key, timesExecuted, timesExecuted + 1);
				lastExecAction = key;
				return key;
			} else if (timesExecuted == DEFAULT_CRITERIA) {
				defaultKey = key;
				executionNumber++;
			}
		}
		lastExecAction = defaultKey;
		return defaultKey;
	}

	public void incrementExecutionNumber() {
		executionNumber++;
	}
}
