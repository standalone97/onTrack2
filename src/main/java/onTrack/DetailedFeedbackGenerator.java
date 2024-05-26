package onTrack;

import java.util.regex.Pattern;

import onTrack.models.Task;

public class DetailedFeedbackGenerator extends FeedbackGenerator {

    @Override
    public String generateFeedback(Task task) {
        if (task.getContent() == null || task.getContent().trim().isEmpty()) {
            return "Your task content is empty.";
        }

        String content = task.getContent().toLowerCase();
        StringBuilder feedback = new StringBuilder();

        if (Pattern.compile(Pattern.quote("error"), Pattern.CASE_INSENSITIVE).matcher(content).find()) {
            feedback.append("Your task contains errors. ");
        }
        if (Pattern.compile(Pattern.quote("missing"), Pattern.CASE_INSENSITIVE).matcher(content).find()) {
            feedback.append("Your task is missing some components. ");
        }
        if (Pattern.compile(Pattern.quote("incorrect"), Pattern.CASE_INSENSITIVE).matcher(content).find()) {
            feedback.append("Your task contains incorrect information. ");
        }

        if (feedback.length() == 0) {
            return "Your task is correct.";
        } else {
            return feedback.toString();
        }
    }
}

