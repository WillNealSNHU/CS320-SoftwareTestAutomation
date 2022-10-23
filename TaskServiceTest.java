package Test;

import org.junit.jupiter.api.Test;
import Main.Task;
import Main.TaskService;
import Main.contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.RepeatedTest;


class TaskServiceTest {


	  private String id, name, description;
	  private String tooLongName, tooLongDescription;

	  @BeforeEach
	  void setUp() {
	    id = "216359339";
	    name = "Did you ever hear th";
	    description = "e tragedy of Darth Plagueis The Wise? No? I though";	    
	    tooLongName = "Whats up? Your task name is too long bruh, take it back a notch ya?";
	    tooLongDescription =
	        "At this point you must realize you are doomed, the description is tooo long bruh, gotta chill with that ya?";
	  }
	  
	  @Test
	  void deleteTheTaskTest() throws Exception {
	    TaskService service = new TaskService();
	    service.newTask();
	    assertEquals(1, service.getTaskList().size());
	    service.deleteTheTask(service.getTaskList().get(0).getTaskId());
	    assertEquals(0, service.getTaskList().size());
	  }

	  @Test
	  void deleteTheTaskNotFoundTest() throws Exception {
	    TaskService service = new TaskService();
	    service.newTask();
	    assertEquals(1, service.getTaskList().size());
	    assertThrows(Exception.class, () -> service.deleteTheTask(id));
	    assertEquals(1, service.getTaskList().size());
	  }
	  
	  @Test
	  void newTaskTest() {
	    TaskService service = new TaskService();
	    service.newTask();
	    Assertions.assertNotNull(service.getTaskList().get(0).getTaskId());
	    Assertions.assertNotEquals("INITIAL",
	                               service.getTaskList().get(0).getTaskId());
	  }

	  @Test
	  void newTaskNameTest() {
	    TaskService service = new TaskService();
	    service.newTask(name);
	    Assertions.assertNotNull(service.getTaskList().get(0).getName());
	    Assertions.assertEquals(name, service.getTaskList().get(0).getName());
	  }

	  @Test
	  void newTaskDescriptionTest() {
	    TaskService service = new TaskService();
	    service.newTask(name, description);
	    Assertions.assertNotNull(service.getTaskList().get(0).getDescription());
	    Assertions.assertEquals(description,
	                            service.getTaskList().get(0).getDescription());
	  }
	  
	  @RepeatedTest(4)
	  void UuidTestingintact() {
	    TaskService service = new TaskService();
	    service.newTask();
	    service.newTask();
	    service.newTask();
	    assertEquals(3, service.getTaskList().size());
	    assertNotEquals(service.getTaskList().get(0).getTaskId(),
	                    service.getTaskList().get(1).getTaskId());
	    assertNotEquals(service.getTaskList().get(0).getTaskId(),
	                    service.getTaskList().get(2).getTaskId());
	    assertNotEquals(service.getTaskList().get(1).getTaskId(),
	                    service.getTaskList().get(2).getTaskId());
	  }
	  @Test
	  void newTaskTooLongNameTest() {
	    TaskService service = new TaskService();
	    Assertions.assertThrows(IllegalArgumentException.class,
	                            () -> service.newTask(tooLongName));
	  }

	  @Test
	  void newTaskTooLongDescriptionTest() {
	    TaskService service = new TaskService();
	    assertThrows(IllegalArgumentException.class,
	                 () -> service.newTask(name, tooLongDescription));
	  }

	  @Test
	  void newTaskNameNullTest() {
	    TaskService service = new TaskService();
	    assertThrows(IllegalArgumentException.class, () -> service.newTask(null));
	  }

	  @Test
	  void newTaskDescriptionNullTest() {
	    TaskService service = new TaskService();
	    assertThrows(IllegalArgumentException.class,
	                 () -> service.newTask(name, null));
	  }

	  @Test
	  void updateTheNameTest() throws Exception {
	    TaskService service = new TaskService();
	    service.newTask();
	    service.updateTaskName(service.getTaskList().get(0).getTaskId(), name);
	    assertEquals(name, service.getTaskList().get(0).getName());
	  }

	  @Test
	  void updateTheDescriptionTest() throws Exception {
	    TaskService service = new TaskService();
	    service.newTask();
	    service.updateTaskDescription(service.getTaskList().get(0).getTaskId(),
	                              description);
	    assertEquals(description, service.getTaskList().get(0).getDescription());
	  }

	  @Test
	  void updateTheNameNotFoundTest() throws Exception {
	    TaskService service = new TaskService();
	    service.newTask();
	    assertThrows(Exception.class, () -> service.updateTaskName(id, name));
	  }

	  @Test
	  void updateTheDescriptionNotFoundTest() throws Exception {
	    TaskService service = new TaskService();
	    service.newTask();
	    assertThrows(Exception.class,
	                 () -> service.updateTaskDescription(id, description));
	  }
}
