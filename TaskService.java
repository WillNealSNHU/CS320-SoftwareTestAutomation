package Main;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Main.contact;
import org.junit.jupiter.api.BeforeEach;


public class TaskService {
	
	public List<Task> getTaskList() { return taskList; }
	public final List<Task> taskList = new ArrayList<>();

	public String newUniqueId() {
	    return UUID.randomUUID().toString().substring(
	        0, Math.min(toString().length(), 10));
	  }

	public Task searchForTheTask(String id) throws Exception {
	    int index = 0;
	    while (index < taskList.size()) {
	      if (id.equals(taskList.get(index).getTaskId())) {
	        return taskList.get(index);
	      }
	      index++;
	    }
	    throw new Exception("Bruh its not real");
	  }

	  public void newTask() {
	    Task task = new Task(newUniqueId());
	    taskList.add(task);
	  }

	  public void newTask(String name) {
	    Task task = new Task(newUniqueId(), name);
	    taskList.add(task);
	  }

	  public void newTask(String name, String description) {
	    Task task = new Task(newUniqueId(), name, description);
	    taskList.add(task);
	  }

	  public void updateTaskName(String id, String name) throws Exception {
		  searchForTheTask(id).setName(name);
	  }

	  public void updateTaskDescription(String id, String description)
	      throws Exception {
		  searchForTheTask(id).setDescription(description);
	  }
	  
	  public void deleteTheTask(String id) throws Exception {
		    taskList.remove(searchForTheTask(id));
		  }
}
