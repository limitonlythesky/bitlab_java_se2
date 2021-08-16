package Task2;

import javax.swing.*;

public class MainFrame extends JFrame {
    private MainMenu mainMenu;
    private FirstPage firstPage;
    private SecondPage secondPage;
    private int sizeOfStudent = 0;

    private Student[] students = new Student[150];

    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setTitle("Student Application");
        setLayout(null);

        mainMenu = new MainMenu(this);
        mainMenu.setVisible(true);
        add(mainMenu);

        firstPage = new FirstPage(this);
        firstPage.setVisible(false);
        add(firstPage);

        secondPage = new SecondPage(this);
        secondPage.setVisible(false);
        add(secondPage);

    }

    public MainMenu getMainMenu(){
        return mainMenu;
    }

    public FirstPage getFirstPage() {
        return firstPage;
    }

    public SecondPage getSecondPage() {
        return secondPage;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public int getSizeOfStudent() {
        return sizeOfStudent;
    }

    public void addStudent(Student student){
        students[sizeOfStudent] = student;
        sizeOfStudent++;
    }
}