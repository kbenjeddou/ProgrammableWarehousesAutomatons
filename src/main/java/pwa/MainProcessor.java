package pwa;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pwa.enums.AutomatonInstruction;
import pwa.exceptions.AutomatonException;
import pwa.models.AutomatonPosition;
import pwa.models.Warehouse;
import pwa.processing.AutomatonProgramRunner;
import pwa.processing.ProgramLinesParser;
import pwa.validators.AutomatonProgramValidator;

public class MainProcessor {

	protected static List<String> processingResults;

	public static void main(String... args) throws AutomatonException, IOException {

		if (args.length == 1) {

			File file = new File(args[0]);
			MainProcessor mainProcessor = new MainProcessor();
			processingResults = mainProcessor.startProcessing(file);

		} else {
			throw new IllegalArgumentException();
		}
	}


	private List<String> startProcessing(File file) throws AutomatonException, IOException {

		if (!file.isFile()) {
			throw new AutomatonException(AutomatonException.ERREUR_FICHIER_INEXISTANT);

		} else {

			AutomatonProgramValidator automatonProgramValidator = new AutomatonProgramValidator();
			Scanner scanner = new Scanner(file);

			try {

				processFirstLine(automatonProgramValidator, scanner);
				return processNextLines(automatonProgramValidator, scanner);

			} finally {
				if (scanner != null) {
					scanner.close();
				}
			}
		}
	}

	private void processFirstLine(AutomatonProgramValidator automatonProgramValidator, Scanner scanner)
			throws AutomatonException {

		if (scanner.hasNext()) {
			automatonProgramValidator.setWarehouse(scanner.nextLine());
		}
		if (!scanner.hasNext()) {
			throw new AutomatonException(
			        AutomatonException.ERREUR_DONNEES_INCORRECTES);
		}
	}


	private List<String> processNextLines(AutomatonProgramValidator automatonProgramValidator,
			Scanner scanner) throws AutomatonException {

		List<String> positions = new ArrayList<String>();

		while (scanner.hasNext()) {

			automatonProgramValidator.setAutomaton(scanner.nextLine());

			if (scanner.hasNext()) {

				automatonProgramValidator.setInstructions(scanner.nextLine());
				positions.add(run(automatonProgramValidator));

			} else {
				throw new AutomatonException(AutomatonException.ERREUR_DONNEES_INCORRECTES);
			}
		}

		return positions;
	}


	private String run(AutomatonProgramValidator automatonProgramValidator)
			throws AutomatonException {

		if (!automatonProgramValidator.isAutomatonProgramRunnable()) {
			throw new AutomatonException(AutomatonException.ERREUR_DONNEES_INCORRECTES);

		} else {
			AutomatonProgramRunner automatonProgramRunner = new AutomatonProgramRunner();

			Warehouse warehouse = ProgramLinesParser.extractWarehouseCoordinates(automatonProgramValidator.getWarehouse());
			automatonProgramRunner.setWarehouse(warehouse);

			AutomatonPosition automatonPosition = ProgramLinesParser.extractAutomatonPosition(automatonProgramValidator.getAutomaton());
			automatonProgramRunner.setAutomatonPosition(automatonPosition);

			List<AutomatonInstruction> instructions = ProgramLinesParser.extractAutomatonInstructions(automatonProgramValidator.getInstructions());
			automatonProgramRunner.setInstructions(instructions);

			automatonProgramRunner.runAutomatonInstructions();
			System.out.println(automatonProgramRunner);

			return automatonProgramRunner.toString();
		}
	}
}