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


class appointmentServiceTest {

	private String id, description, tooLongDescription;
	  private Date date, pastDate;

	  @SuppressWarnings("deprecation")
	  @BeforeEach
	  void setUp() {
	    id = "2163593393";
	    description = "Tragedy of Darth Plagueis The Wise? No? I though.";
	    date = new Date(2033, Calendar.MARCH, 3);
	    tooLongDescription = "At this point you must realize you are doomed, the description is tooo long bruh, gotta chill with that ya?";
	    pastDate = new Date(0);
	  }
	  
	  @Test
	  void deleteTHEAppointment() throws Exception {
	    appointmentService service = new appointmentService();

	    service.newAppointment();
	    service.newAppointment();
	    service.newAppointment();

	    String firstId = service.getAppointmentList().get(0).getAppointmentId();
	    String secondId = service.getAppointmentList().get(1).getAppointmentId();
	    String thirdId = service.getAppointmentList().get(2).getAppointmentId();

	    assertNotEquals(firstId, secondId);
	    assertNotEquals(firstId, thirdId);
	    assertNotEquals(secondId, thirdId);
	    assertNotEquals(id, firstId);
	    assertNotEquals(id, secondId);
	    assertNotEquals(id, thirdId);

	    assertThrows(Exception.class, () -> service.deleteTheAppointment(id));

	    service.deleteTheAppointment(firstId);
	    assertThrows(Exception.class, () -> service.deleteTheAppointment(firstId));
	    assertNotEquals(firstId,
	                    service.getAppointmentList().get(0).getAppointmentId());
	  }

	  @Test
	  void testNewAppointment() {
	    appointmentService service = new appointmentService();

	    service.newAppointment();
	    assertNotNull(service.getAppointmentList().get(0).getAppointmentId());
	    assertNotNull(service.getAppointmentList().get(0).getAppointmentDate());
	    assertNotNull(service.getAppointmentList().get(0).getDescription());

	    service.newAppointment(date);
	    assertNotNull(service.getAppointmentList().get(1).getAppointmentId());
	    assertEquals(date,
	                 service.getAppointmentList().get(1).getAppointmentDate());
	    assertNotNull(service.getAppointmentList().get(1).getDescription());

	    service.newAppointment(date, description);
	    assertNotNull(service.getAppointmentList().get(2).getAppointmentId());
	    assertEquals(date,
	                 service.getAppointmentList().get(2).getAppointmentDate());
	    assertEquals(description,
	                 service.getAppointmentList().get(2).getDescription());

	    assertNotEquals(service.getAppointmentList().get(0).getAppointmentId(),
	                    service.getAppointmentList().get(1).getAppointmentId());
	    assertNotEquals(service.getAppointmentList().get(0).getAppointmentId(),
	                    service.getAppointmentList().get(2).getAppointmentId());
	    assertNotEquals(service.getAppointmentList().get(1).getAppointmentId(),
	                    service.getAppointmentList().get(2).getAppointmentId());

	    assertThrows(IllegalArgumentException.class,
	                 () -> service.newAppointment(pastDate));
	    assertThrows(IllegalArgumentException.class,
	                 () -> service.newAppointment(date, tooLongDescription));
	  }
}
