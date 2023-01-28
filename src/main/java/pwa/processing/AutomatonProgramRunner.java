package pwa.processing;
import java.util.ArrayList;
import java.util.List;

import pwa.enums.AutomatonInstruction;
import pwa.exceptions.AutomatonException;
import pwa.models.AutomatonPosition;
import pwa.models.Warehouse;

public class AutomatonProgramRunner {

	private Warehouse warehouse;
	private AutomatonPosition automatonPosition;
	private List<AutomatonInstruction> instructions;

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public void setAutomatonPosition(AutomatonPosition automatonPosition) {
		this.automatonPosition = automatonPosition;
	}

	public void setInstructions(List<AutomatonInstruction> pInstructions) {
		this.instructions = pInstructions;
		if(pInstructions == null){
			instructions = new ArrayList<AutomatonInstruction>();
		}
	}

	public void runAutomatonInstructions() throws AutomatonException {
		for(AutomatonInstruction instruction : instructions){
		    AutomatonInstructionRunner.runOneAutomatonInstruction(automatonPosition,
		            instruction,
		            this.warehouse.getPositionMax());
		}
	}

	@Override
    public String toString(){
		return 	automatonPosition.getAutomatonCoordinates().getX()
				+ " "
				+ automatonPosition.getAutomatonCoordinates().getY()
				+ " "
				+ automatonPosition.getAutomatonOrientation().getCodeOrientation() ;
	}
}