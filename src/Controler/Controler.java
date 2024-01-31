package Controler;

import Data.Teacher;
import Data.Type;
import Data.User;
import Data.Student;
import Service.DataService;
import Service.StudyGroupService;
import View.StudentView;
import View.StudyGroupView;
import View.TeacherView;
import Data.StudyGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controler {
    private final DataService service = new DataService();
    private final StudentView studentView = new StudentView();
    private final TeacherView teacherView = new TeacherView();
    private final StudyGroupView studyGroupView = new StudyGroupView();
    private final StudyGroupService studyGroupService = new StudyGroupService();



    public void createStudent(String firstName, String secondName,
                              String lastName) {
        service.create(firstName, secondName, lastName, Type.STUDENT);
    }

    public void createTeacher(String firstName, String secondName, String lastName) {
        service.create(firstName, secondName, lastName, Type.TEACHER);
    }

    public void getAllStudent(){
        List<User> userList = service.getAllStudent();
        for (User user: userList){
            studentView.printOnConsole((Student) user);
        }
    }

    public void getAllTeacher(){
        List<User> userList = service.getAllTeacher();
        for (User user: userList){
            teacherView.printOnConsole((Teacher) user);
        }
    }

    public Integer getGroupNumber() {                               // присвоение  номера группе
        int number;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер группы");
        number = scanner.nextInt();
        return number;

    }

    public User getGroupTeacher() {                             // назначение преподавателя группе
        int id;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ID преподавателя");
        id = scanner.nextInt();

        // scanner.close();
        return service.getUserById(Type.TEACHER, id);

    }

    public List<User> studentsInGroup() {                       // подбор студентов в группу

        List<User> studentsGroup = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ID студентов, для окончания - введите 0");

        while (true) {

            int number = scanner.nextInt();

            studentsGroup.add(service.getUserById(Type.STUDENT, number));

            if (number == 0) {

                break;
            }

        }

        return studentsGroup;
    }

    public void createStudyGroup() {
        int numberGroup = getGroupNumber();
        User teacherGroup = getGroupTeacher();
        List<User> students = studentsInGroup();
        StudyGroup studyGroup = studyGroupService.createStudyGroup(numberGroup, teacherGroup, students);
        studyGroupView.printOnConsole(studyGroup);

    }

    }
