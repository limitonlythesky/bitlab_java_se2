package MiniProject;

import java.io.*;
import java.util.ArrayList;

public class PackageData implements Serializable {
    private String operationType;
    private ArrayList <Student> students;
    private Student student;

    public PackageData() {
    }

    public PackageData(String operationType, Student student) {
        this.operationType = operationType;
        this.student = student;
    }

    public PackageData(String operationType) {
        this.operationType = operationType;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "PackageData{" +
                "operationType='" + operationType + '\'' +
                ", students=" + students +
                ", student=" + student +
                '}';
    }

    public static ArrayList<Student> getStudentList(){
        ArrayList <Student> students = new ArrayList<>();
        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("test2.txt"));
            students = (ArrayList<Student>)inputStream.readObject();
            inputStream.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return students;
    }

    public static void saveUserList(ArrayList <Student> students){
        try{
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("test2.txt"));
            outputStream.writeObject(students);
            outputStream.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
