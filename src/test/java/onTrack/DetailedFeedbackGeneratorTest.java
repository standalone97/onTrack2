package onTrack;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import onTrack.models.Task;

public class DetailedFeedbackGeneratorTest {

    @Test
    public void testGenerateDetailedFeedback() {
        DetailedFeedbackGenerator generator = new DetailedFeedbackGenerator();

        Task taskWithErrorsAndMissingComponents = new Task("1", "This task has an error and is missing parts.");
        String feedback = generator.generateFeedback(taskWithErrorsAndMissingComponents);
        assertEquals("Your task contains errors. Your task is missing some components. ", feedback);
    }
}
