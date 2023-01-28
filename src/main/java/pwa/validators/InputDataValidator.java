package pwa.validators;

import pwa.enums.AutomatonInstruction;
import pwa.enums.Orientation;


public class InputDataValidator {

	private InputDataValidator(){

	}

	public static boolean isAutomatonPositionValid(String automatonPosition){
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append(Orientation.NORTH.getCodeOrientation())
		             .append("|").append(Orientation.SOUTH.getCodeOrientation())
		             .append("|").append(Orientation.EAST.getCodeOrientation())
		             .append("|").append(Orientation.WEST.getCodeOrientation());
		return automatonPosition.matches("(\\d+) (\\d+) (" + stringBuilder.toString()+")");
	}

	public static boolean isAutomatonInstructionValid(String instructions){
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append("(")
		             .append(AutomatonInstruction.AVANCER.getCodeInstruction())
		             .append("|").append(AutomatonInstruction.DROITE.getCodeInstruction())
		             .append("|").append(AutomatonInstruction.GAUCHE.getCodeInstruction())
		             .append(")+");

		return instructions.matches(stringBuilder.toString());
	}

	public static boolean isWarehousePositionValid(String warehousePosition){
		return warehousePosition.matches("(\\d+) (\\d+)");
	}
}