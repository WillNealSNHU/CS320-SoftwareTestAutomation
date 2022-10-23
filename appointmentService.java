package Main;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class appointmentService {
	
	final public List<Appointment> appointmentList = new ArrayList<>();

	  public void newAppointment() {
	    Appointment apptBruh = new Appointment(newUniqueId());
	    appointmentList.add(apptBruh);
	  }

	  public void newAppointment(Date date) {
	    Appointment apptBruh = new Appointment(newUniqueId(), date);
	    appointmentList.add(apptBruh);
	  }

	  public void newAppointment(Date date, String description) {
	    Appointment apptBruh = new Appointment(newUniqueId(), date, description);
	    appointmentList.add(apptBruh);
	  }

	  public void deleteTheAppointment(String id) throws Exception {
	    appointmentList.remove(searchForTheAppointment(id));
	  }

	  public List<Appointment> getAppointmentList() { return appointmentList; }

	  public Appointment searchForTheAppointment(String id) throws Exception {
	    int indexS = 0;
	    while (indexS < appointmentList.size()) {
	      if (id.equals(appointmentList.get(indexS).getAppointmentId())) {
	        return appointmentList.get(indexS);
	      }
	      indexS++;
	    }
	    throw new Exception("The appointment, like the nature of our reality, doesnt exist.");
	  }
	  
	  public String newUniqueId() {
		    return UUID.randomUUID().toString().substring(
		        0, Math.min(toString().length(), 10));
		  }
}
