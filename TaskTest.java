package Test;
import org.junit.jupiter.api.Test;
import Main.Task;
import Main.contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;


public class TaskTest {
	public String id, name, description;
	public String tooLongId, tooLongName, tooLongDescription;

	  @BeforeEach
	  public void setUp() {
	    id = "216359339";
	    name = "Did you ever hear th";
	    description = "e tragedy of Darth Plagueis The Wise? No? I though";
	    tooLongId = "369369369369369369369369";
	    tooLongName = "Whats up? Your task name is too long bruh, take it back a notch ya?";
	    tooLongDescription =
	        "At this point you must realize you are doomed, the description is tooo long bruh, gotta chill with that ya?";
	  }
	  
	  @Test
	  void TaskIdNullTest() {
	    Assertions.assertThrows(IllegalArgumentException.class,
	                            () -> new Task(null));
	  }

	  @Test
	  void TaskNameNullTest() {
	    Task task = new Task();
	    Assertions.assertThrows(IllegalArgumentException.class,
	                            () -> task.setName(null));
	  }

	  @Test
	  void TaskDescriptionNullTest() {
	    Task task = new Task();
	    Assertions.assertThrows(IllegalArgumentException.class,
	                            () -> task.setDescription(null));
	  }
	  
	  // I want to complete the null tests first, the reason for this is because too many times have I ran tests, seen they are failing
	  // only to go back after debugging for awhile to find they are null. Better to throw these up front
	  
	  @Test
	  void getTheTaskIdTest() {
	    Task task = new Task(id);
	    Assertions.assertEquals(id, task.getTaskId());
	  }

	  @Test
	  void getTheNameTest() {
	    Task task = new Task(id, name);
	    Assertions.assertEquals(name, task.getName());
	  }

	  @Test
	  void getTheDescriptionTest() {
	    Task task = new Task(id, name, description);
	    Assertions.assertEquals(description, task.getDescription());
	  }
	  // just like in my contactTest and contactServiceTest I wanna make sure everything is lining up

	  @Test
	  void setTheNameTest() {
	    Task task = new Task();
	    task.setName(name);
	    Assertions.assertEquals(name, task.getName());
	  }

	  @Test
	  void setTheDescriptionTest() {
	    Task task = new Task();
	    task.setDescription(description);
	    Assertions.assertEquals(description, task.getDescription());
	  }

	  @Test
	  void TaskIdTooLongTestBruh() {
	    Assertions.assertThrows(IllegalArgumentException.class,
	                            () -> new Task(tooLongId));
	  }

	  @Test
	  void setTheTooLongNameTest() {
	    Task task = new Task();
	    Assertions.assertThrows(IllegalArgumentException.class,
	                            () -> task.setName(tooLongName));
	  }

	  @Test
	  void setTheTooLongDescriptionTest() {
	    Task task = new Task();
	    Assertions.assertThrows(IllegalArgumentException.class,
	                            () -> task.setDescription(tooLongDescription));
	  }
}
