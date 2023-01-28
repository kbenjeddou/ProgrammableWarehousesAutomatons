package pwa;

import static org.fest.assertions.Assertions.assertThat;

import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import pwa.exceptions.AutomatonException;

public class MainProcessorTest {

	final String RESOURCES_PATH = "./src/test/resources/";

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test(expected = IllegalArgumentException.class)
	public void main_file_error_args() throws AutomatonException, IOException {
		MainProcessor.main("1", "2");
	}

	@Test
	public void main_file_error_file_not_found() throws AutomatonException, IOException {
		expectedException.expect(AutomatonException.class);
		expectedException.expectMessage(AutomatonException.ERREUR_FICHIER_INEXISTANT);
		MainProcessor.main("fichierinexistant");
	}

	@Test
	public void main_file_processed() throws AutomatonException, IOException {
		MainProcessor.main(RESOURCES_PATH + "sample_file.txt");
		assertThat(MainProcessor.processingResults).isNotNull();
		assertThat(MainProcessor.processingResults).hasSize(2)
		                                           .contains("1 3 N")
		                                           .contains("5 1 E");

	}
}