package pwa.validators;

public class AutomatonProgramValidator {

	private String warehouse;
	private String automaton;
	private String instructions;

	public AutomatonProgramValidator(){
		this.warehouse = "";
		this.automaton = "";
		this.instructions = "";
	}

	public boolean isAutomatonProgramRunnable(){
		return InputDataValidator.isAutomatonPositionValid(automaton)
				&& InputDataValidator.isWarehousePositionValid(warehouse)
				&& InputDataValidator.isAutomatonInstructionValid(instructions);
	}

	public String getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}

	public String getAutomaton() {
		return automaton;
	}

	public void setAutomaton(String automaton) {
		this.automaton = automaton;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
}