package onTrack.models;

public class Task {

	    private String id;
	    private String content;

	    public Task(String id, String content) {
	        this.id = id;
	        this.content = content;
	    }

	    public String getId() {
	        return id;
	    }

	    public String getContent() {
	        return content;
	    }
	}
