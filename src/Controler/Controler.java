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

import java.util.List;

public class Controler {
    private final DataService service = new DataService();
    private final StudentView studentView = new StudentView();
    private final TeacherView teacherView = new TeacherView();
    private final StudyGroupView studygroupView = new StudyGroupView();
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
}
