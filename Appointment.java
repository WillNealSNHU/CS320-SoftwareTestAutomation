package Main;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Appointment {
	final public byte APPOINTMENT_ID_LENGTH;
	  final public byte APPOINTMENT_DESCRIPTION_LENGTH;
	  final public String INITIALIZER;
	  public String appointmentId;
	  public Date appointmentDate;
	  public String description;

	  {
	    APPOINTMENT_ID_LENGTH = 10;
	    APPOINTMENT_DESCRIPTION_LENGTH = 50;
	    INITIALIZER = "INITIAL";
	  }

	  public Appointment() {
	    Date today = new Date();
	    appointmentId = INITIALIZER;
	    appointmentDate = today;
	    description = INITIALIZER;
	  }

	  public Appointment(String id) {
	    Date today = new Date();
	    updateTheAppointmentId(id);
	    appointmentDate = today;
	    description = INITIALIZER;
	  }

	  public Appointment(String id, Date date) {
		  updateTheAppointmentId(id);
	    updateDate(date);
	    description = INITIALIZER;
	  }

	  public Appointment(String id, Date date, String description) {
	    updateTheAppointmentId(id);
	    updateDate(date);
	    updateDescription(description);
	  }

	  public void updateTheAppointmentId(String id) {
	    if (id == null) {
	      throw new IllegalArgumentException("appointment ID cant be null bruuh.");
	    } else if (id.length() > APPOINTMENT_ID_LENGTH) {
	      throw new IllegalArgumentException("appointment ID is " +
	                                         APPOINTMENT_ID_LENGTH +
	                                         " characters, shorten it bruh");
	    } else {
	      this.appointmentId = id;
	    }
	  }

	  public String getAppointmentId() { return appointmentId; }

	  public void updateDate(Date date) {
	    if (date == null) {
	      throw new IllegalArgumentException("Appointment date cant be null broski.");
	    } else if (date.before(new Date())) {
	      throw new IllegalArgumentException(
	          "Cant make appointment in the past, this aint back to the future");
	    } else {
	      this.appointmentDate = date;
	    }
	  }

	  public Date getAppointmentDate() { return appointmentDate; }

	  public void updateDescription(String description) {
	    if (description == null) {
	      throw new IllegalArgumentException(
	          "appointment description cant be null broski.");
	    } else if (description.length() > APPOINTMENT_DESCRIPTION_LENGTH) {
	      throw new IllegalArgumentException(
	          "appointment description is " +
	          APPOINTMENT_DESCRIPTION_LENGTH + " characters. you need to shorten it");
	    } else {
	      this.description = description;
	    }
	  }

	  public String getDescription() { return description; }
	
}
