package pwa.processing;

import pwa.enums.AutomatonInstruction;
import pwa.enums.Orientation;
import pwa.exceptions.AutomatonException;
import pwa.models.AutomatonPosition;
import pwa.models.Coordinates;


public  class AutomatonInstructionRunner {

	private AutomatonInstructionRunner(){

	}

	public static Coordinates moveForward(AutomatonPosition automatonPosition, Coordinates maxCoordinates) throws AutomatonException{

		int x, y;

		switch (automatonPosition.getAutomatonOrientation()) {
		case NORTH:
			x = automatonPosition.getAutomatonCoordinates().getX();
			y = automatonPosition.getAutomatonCoordinates().getY() + 1;
			break;
		case EAST:
			x = automatonPosition.getAutomatonCoordinates().getX() + 1;
			y = automatonPosition.getAutomatonCoordinates().getY();
			break;
		case SOUTH:
			x = automatonPosition.getAutomatonCoordinates().getX();
			y = automatonPosition.getAutomatonCoordinates().getY() - 1;
			break;
		case WEST:
			x = automatonPosition.getAutomatonCoordinates().getX() - 1;
			y = automatonPosition.getAutomatonCoordinates().getY();
			break;
		default:
			throw new AutomatonException(AutomatonException.POSITION_INCORRECTE);
		}

		Coordinates nextCoordinates = new Coordinates(x, y);

		if (maxCoordinates.isTheMoveStillInTheWarehouse(nextCoordinates)) {
			return nextCoordinates;
		} else {
			return automatonPosition.getAutomatonCoordinates();
		}
	}

	public static Orientation rotateRight(Orientation orientation) throws AutomatonException{

		Orientation nextOrientation = null ;
		switch (orientation){
			case NORTH :
				nextOrientation =  Orientation.EAST;
				break;
			case EAST :
				nextOrientation =  Orientation.SOUTH;
				break;
			case SOUTH :
				nextOrientation =  Orientation.WEST;
				break;
			case WEST :
				nextOrientation =  Orientation.NORTH;
				break;
			default :
				throw new AutomatonException(AutomatonException.ORIENTATION_INCORRECTE);
		}
		return nextOrientation;
	}

	public static Orientation rotateLeft(Orientation orientation) throws AutomatonException{

	    Orientation nextOrientation = null ;
		switch (orientation){
			case NORTH :
				nextOrientation =  Orientation.WEST;
				break;
			case EAST :
				nextOrientation =  Orientation.NORTH;
				break;
			case SOUTH :
				nextOrientation =  Orientation.EAST;
				break;
			case WEST :
				nextOrientation =  Orientation.SOUTH;
				break;
			default :
				throw new AutomatonException(AutomatonException.ORIENTATION_INCORRECTE);
		}
		return nextOrientation;
	}

	public static void runOneAutomatonInstruction(AutomatonPosition automatonPosition,
	        AutomatonInstruction instruction,
	        Coordinates maxCoordinates) throws AutomatonException{

		switch (instruction){
			case AVANCER :
				automatonPosition.setAutomatonCoordinates(moveForward(automatonPosition, maxCoordinates));
				break;
			case DROITE :
				automatonPosition.setAutomatonOrientation(rotateRight(automatonPosition.getAutomatonOrientation()));
				break;
			case GAUCHE :
				automatonPosition.setAutomatonOrientation(rotateLeft(automatonPosition.getAutomatonOrientation()));
				break;
			default: throw new AutomatonException(AutomatonException.INSTRUCTION_INCORRECTE);
		}
	}
}