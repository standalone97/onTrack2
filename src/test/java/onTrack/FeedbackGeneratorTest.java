package onTrack;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import onTrack.models.Task;

public class FeedbackGeneratorTest {


    @Test
    public void testGenerateFeedbackWithError() {
        FeedbackGenerator generator = new FeedbackGenerator();
        Task taskWithErrors = new Task("1", "This task has an error.");
        String feedback = generator.generateFeedback(taskWithErrors);
        assertEquals("Your task contains errors.", feedback);
    }

    @Test
    public void testGenerateFeedbackWithNoError() {
        FeedbackGenerator generator = new FeedbackGenerator();
        Task correctTask = new Task("2", "This task is correct.");
        String feedback = generator.generateFeedback(correctTask);
        assertEquals("Your task is correct.", feedback);
    }

    @Test
    public void testGenerateFeedbackWithEmptyContent() {
        FeedbackGenerator generator = new FeedbackGenerator();
        Task emptyTask = new Task("3", "");
        String feedback = generator.generateFeedback(emptyTask);
        assertEquals("Your task content is empty.", feedback);
    }

    @Test
    public void testGenerateFeedbackWithMissingComponents() {
        FeedbackGenerator generator = new FeedbackGenerator();
        Task taskWithMissingComponents = new Task("4", "This task is missing parts.");
        String feedback = generator.generateFeedback(taskWithMissingComponents);
        assertEquals("Your task is missing some components.", feedback);
    }

    @Test
    public void testGenerateFeedbackWithIncorrectInfo() {
        FeedbackGenerator generator = new FeedbackGenerator();
        Task taskWithIncorrectInfo = new Task("5", "This task contains incorrect info.");
        String feedback = generator.generateFeedback(taskWithIncorrectInfo);
        assertEquals("Your task contains incorrect information.", feedback);
    }
}