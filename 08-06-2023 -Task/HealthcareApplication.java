package abfacdp;

//Abstract Product A
//The Appointment interface defines the abstract product A, which represents the concept of scheduling an appointment.
//It declares a single method schedule() that concrete appointment classes must implement.
interface Appointment {
 void schedule();
}


//The DoctorAppointment and DentistAppointment classes are concrete implementations of the Appointment interface. 
//They provide specific functionality for scheduling appointments with doctors and dentists, respectively. 
//Each class overrides the schedule() method to define its unique behavior

//Concrete Product A1
class DoctorAppointment implements Appointment {
 @Override
 public void schedule() {
     System.out.println("Scheduling a doctor's appointment.");
 }
}

//Concrete Product A2
class DentistAppointment implements Appointment {
 @Override
 public void schedule() {
     System.out.println("Scheduling a dentist appointment.");
 }
}

//Abstract Product B
//The Prescription interface defines the abstract product B, which represents the concept of issuing a prescription. 
//It declares a single method issue() that concrete prescription classes must implement.
interface Prescription {
 void issue();
}

//Concrete Product B1
class DoctorPrescription implements Prescription {
 @Override
 public void issue() {
     System.out.println("Issuing a doctor's prescription.");
 }
}

//Concrete Product B2
//he DoctorPrescription and DentistPrescription classes are concrete implementations of the Prescription interface. They provide specific functionality for issuing prescriptions from doctors and dentists, respectively. 
//Each class overrides the issue() method to define its unique behavior.
class DentistPrescription implements Prescription {
 @Override
 public void issue() {
     System.out.println("Issuing a dentist prescription.");
 }
}

//Abstract Factory
interface HealthcareFactory {
 Appointment createAppointment();
 Prescription createPrescription();
}

//The DoctorFactory and DentistFactory classes are concrete implementations of the HealthcareFactory
//Concrete Factory 1
class DoctorFactory implements HealthcareFactory {
 @Override
 public Appointment createAppointment() {
     return new DoctorAppointment();
 }

 @Override
 public Prescription createPrescription() {
     return new DoctorPrescription();
 }
}

//Concrete Factory 2
class DentistFactory implements HealthcareFactory {
 @Override
 public Appointment createAppointment() {
     return new DentistAppointment();
 }

 @Override
 public Prescription createPrescription() {
     return new DentistPrescription();
 }
}

//Client code
//The HealthcareApplication class represents the client code that utilizes the abstract factory and the created products. It takes a HealthcareFactory object in its constructor and creates instances of the abstract products (appointment and prescription) using the factory's creation methods. 
//The scheduleAppointment() and issuePrescription() methods are used to invoke the respective behaviors on the created objects.
public class HealthcareApplication {
 private Appointment appointment;
 private Prescription prescription;

 public HealthcareApplication(HealthcareFactory factory) {
     appointment = factory.createAppointment();
     prescription = factory.createPrescription();
 }

 public void scheduleAppointment() {
     appointment.schedule();
 }

 public void issuePrescription() {
     prescription.issue();
 }
 
 //In the main() method, the client code demonstrates the usage of the abstract factory and concrete factories by creating instances of the HealthcareApplication.
 //It creates a doctor appointment and prescription using the DoctorFactory, and a dentist appointment and prescription using the DentistFactory. The scheduleAppointment() and issuePrescription() methods are called on each instance, resulting in the appropriate behavior being executed for each type of appointment and prescription.

 public static void main(String[] args) {
     HealthcareFactory doctorFactory = new DoctorFactory();
     HealthcareApplication doctorApp = new HealthcareApplication(doctorFactory);
     doctorApp.scheduleAppointment();
     doctorApp.issuePrescription();

     HealthcareFactory dentistFactory = new DentistFactory();
     HealthcareApplication dentistApp = new HealthcareApplication(dentistFactory);
     dentistApp.scheduleAppointment();
     dentistApp.issuePrescription();
 }
}





