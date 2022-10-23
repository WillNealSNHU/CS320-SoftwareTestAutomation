package Main;
import java.util.UUID;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Main.contact;
import org.junit.jupiter.api.BeforeEach;

public class Task {
	public String taskId;
	public String name;
	public String description;

	  public Task() {
	    taskId = "INITIAL";
	    name = "INITIAL";
	    description = "INITIAL DESCRIPTION";
	  }

	  public Task(String taskId) {
	    checkTaskId(taskId);
	    name = "INITIAL";
	    description = "INITIAL DESCRIPTION";
	  }

	  public Task(String taskId, String name) {
	    checkTaskId(taskId);
	    setName(name);
	    description = "INITIAL DESCRIPTION";
	  }

	  public Task(String taskId, String name, String desc) {
	    checkTaskId(taskId);
	    setName(name);
	    setDescription(desc);
	  }

	  public final String getDescription() { return description; }
	  
	  public final String getName() { return name; }
	  
	  public final String getTaskId() { return taskId; }
	  
	  public void checkTaskId(String taskId) {
		    if (taskId == null || taskId.length() > 10) {
		      throw new IllegalArgumentException(
		          "Task ID is longer than 10 characters or null bruh");
		    } else {
		      this.taskId = taskId;
		    }
		  }

	  public void setName(String name) {
	    if (name == null || name.length() > 20) {
	      throw new IllegalArgumentException(
	          "Task name is longer than 20 characters or null bruh");
	    } else {
	      this.name = name;
	    }
	  }

	  public void setDescription(String taskDescription) {
	    if (taskDescription == null || taskDescription.length() > 50) {
	      throw new IllegalArgumentException(
	          "Task description is longer than 50 characters or null bruh");
	    } else {
	      this.description = taskDescription;
	    }
	  }
}
