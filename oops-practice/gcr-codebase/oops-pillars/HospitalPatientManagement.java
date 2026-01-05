package oops_pillars;
import java.util.*;

//interface
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

//abstract class
abstract class Patient {
    //encapsulated fields
    private int patientId;
    private String name;
    private int age;

    //constructor
    public Patient(int patientId,String name,int age){
        this.patientId=patientId;
        this.name=name;
        this.age=age;
    }

    //abstract method
    public abstract double calculateBill();

    //concrete method
    public void getPatientDetails(){
        System.out.println("Patient ID : "+patientId);
        System.out.println("Name       : "+name);
        System.out.println("Age        : "+age);
        System.out.println("Bill       : "+calculateBill());
        System.out.println("------------------------------");
    }
}

//in-patient
class InPatient extends Patient implements MedicalRecord {
    private List<String> records = new ArrayList<>();

    public InPatient(int patientId,String name,int age){
        super(patientId,name,age);
    }
    @Override
    public double calculateBill(){
        return 5000 + 1500;
    }
    @Override
    public void addRecord(String record){
        records.add(record);
    }
    @Override
    public void viewRecords(){
        System.out.println(records);
    }
}

//out-patient
class OutPatient extends Patient implements MedicalRecord {
    private List<String> records = new ArrayList<>();

    public OutPatient(int patientId,String name,int age){
        super(patientId,name,age);
    }
    @Override
    public double calculateBill(){
        return 800;
    }
    @Override
    public void addRecord(String record){
        records.add(record);
    }
    @Override
    public void viewRecords(){
        System.out.println(records);
    }
}

public class HospitalPatientManagement {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();
        patients.add(new InPatient(101,"Maxwell",30));
        patients.add(new OutPatient(102,"Hanery",22));

        //polymorphism
        for(Patient p : patients){
            p.getPatientDetails();
        }
    }
}
