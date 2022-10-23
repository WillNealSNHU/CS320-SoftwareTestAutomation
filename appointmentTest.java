package Test;

import org.junit.jupiter.api.Test;
import Main.Task;
import Main.TaskService;
import Main.contact;
import Main.appointmentService;
import Main.Appointment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.RepeatedTest;
import java.util.Date;
import java.util.Calendar;

class appointmentTest {
	  private String id, description;
	  private String tooLongId, tooLongDescription;
	  private Date date, pastDate;

	  @SuppressWarnings("deprecation")
	  @BeforeEach
	  void setUp() {
	    id = "2163593393";
	    description = "Tragedy of Darth Plagueis The Wise? No? I though.";
	    date = new Date(2033, Calendar.MARCH, 3);
	    tooLongId = "314159265358979323";
	    tooLongDescription = "At this point you must realize you are doomed, the description is tooo long bruh, gotta chill with that ya?";
	    pastDate = new Date(0);
	  }

	  @Test
	  void testUpdateTheAppointmentId() {
	    Appointment apptBruh = new Appointment();
	    assertThrows(IllegalArgumentException.class,
	                 () -> apptBruh.updateTheAppointmentId(null));
	    assertThrows(IllegalArgumentException.class,
	                 () -> apptBruh.updateTheAppointmentId(tooLongId));
	    apptBruh.updateTheAppointmentId(id);
	    assertEquals(id, apptBruh.getAppointmentId());
	  }

	  @Test
	  void testGetTheAppointmentId() {
	    Appointment apptBruh = new Appointment(id);
	    assertNotNull(apptBruh.getAppointmentId());
	    assertEquals(apptBruh.getAppointmentId().length(), 10);
	    assertEquals(id, apptBruh.getAppointmentId());
	  }
	  
	  @Test
	  void testUpdateTheDescription() {
	    Appointment apptBruh = new Appointment();
	    assertThrows(IllegalArgumentException.class,
	                 () -> apptBruh.updateDescription(null));
	    assertThrows(IllegalArgumentException.class,
	                 () -> apptBruh.updateDescription(tooLongDescription));
	    apptBruh.updateDescription(description);
	    assertEquals(description, apptBruh.getDescription());
	  }

	  @Test
	  void testGetTheDescription() {
	    Appointment apptBruh = new Appointment(id, date, description);
	    assertNotNull(apptBruh.getDescription());
	    assertTrue(apptBruh.getDescription().length() <= 50);
	    assertEquals(description, apptBruh.getDescription());
	  }
	  @Test
	  void testUpdateTheDate() {
	    Appointment apptBruh = new Appointment();
	    assertThrows(IllegalArgumentException.class, () -> apptBruh.updateDate(null));
	    assertThrows(IllegalArgumentException.class,
	                 () -> apptBruh.updateDate(pastDate));
	    apptBruh.updateDate(date);
	    assertEquals(date, apptBruh.getAppointmentDate());
	  }

	  @Test
	  void testGetTheAppointmentDate() {
	    Appointment apptBruh = new Appointment(id, date);
	    assertNotNull(apptBruh.getAppointmentDate());
	    assertEquals(date, apptBruh.getAppointmentDate());
	  }
}
