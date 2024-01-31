import Controler.Controler;

public class Main {
    public static void main(String[] args) {
        Controler controler = new Controler();
        controler.createStudent("1", "1","1");
        controler.createStudent("2", "2","2");
        controler.createStudent("3", "3","3");
        controler.createStudent("4", "4","4");
        controler.getAllStudent();
        System.out.println();

        controler.createTeacher("1", "1","1");
        controler.createTeacher("2", "2","2");
        controler.getAllTeacher();

        controler.createStudyGroup();
    }


}