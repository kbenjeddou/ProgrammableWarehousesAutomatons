package pwa.processing;

import java.util.ArrayList;
import java.util.List;

import pwa.enums.AutomatonInstruction;
import pwa.enums.Orientation;
import pwa.models.AutomatonPosition;
import pwa.models.Coordinates;
import pwa.models.Warehouse;


public class ProgramLinesParser {

	private static final String SPACE = " ";

	private ProgramLinesParser(){

	}

	public static AutomatonPosition extractAutomatonPosition(String automatonLine){
		String[] array = automatonLine.split(SPACE);
		Coordinates pCoordonneesAutomaton = new Coordinates(Integer.valueOf(array[0]), Integer.valueOf(array[1]));
		Orientation orientationAutomaton = getOrientationEnum(array[2].charAt(0));
		return new AutomatonPosition(pCoordonneesAutomaton, orientationAutomaton);
	}

	public static Warehouse extractWarehouseCoordinates(String warehouseLine){
		String[] array = warehouseLine.split(SPACE);
		Coordinates coordinates = new Coordinates(Integer.valueOf(array[0]), Integer.valueOf(array[1]));
		return new Warehouse(coordinates);
	}

	public static List<AutomatonInstruction> extractAutomatonInstructions(String instructionsLine){
		List<AutomatonInstruction> automatonInstructions = new ArrayList<AutomatonInstruction>();
		for(char instruction : instructionsLine.toCharArray()){
			automatonInstructions.add(getAutomatonInstructionEnum(instruction));
		}
		return automatonInstructions;
	}

	public static Orientation getOrientationEnum(char cOrientation){
		for(Orientation orientation : Orientation.values()) {
			if (orientation.getCodeOrientation() == cOrientation){
				return orientation;
			}
		}
		return null;
	}

	public static AutomatonInstruction getAutomatonInstructionEnum(char cInstruction){
		for(AutomatonInstruction instruction : AutomatonInstruction.values()) {
			if (instruction.getCodeInstruction() == cInstruction) {
				return instruction;
			}
		}
		return null;
	}
}