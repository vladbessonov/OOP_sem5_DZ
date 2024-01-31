package Service;

import java.util.ArrayList;
import java.util.List;
import Data.User;
import Data.Type;
import Data.Teacher;
import Data.Student;
public class DataService {
    private List<User> userList;

    public DataService() {
        this.userList = new ArrayList<>();
    }

    public void create(String firstName, String secondName,
                       String lastName, Type type){
        int id = getFreeId(type);
        if(Type.STUDENT == type){
            Student student = new Student(firstName,secondName,lastName,id);
            userList.add(student);
        }
        else if(Type.TEACHER == type){
            Teacher teacher = new Teacher(firstName,secondName,lastName,id);
            userList.add(teacher);
        }
    }

    private int getFreeId(Type type){
        boolean itsStudent = Type.STUDENT == type;
        int lastId = 1;
            for (User user : userList) {
                if(user instanceof Teacher && !itsStudent){
                    lastId = ((Teacher) user).getTeacherId() + 1;
                }
                if(user instanceof Student && itsStudent){
                    lastId = ((Student) user).getStudentId() + 1;
                }

            }
        return lastId;
    }

    public User getUserById(Type type, int id){
        boolean itsStudent = Type.STUDENT == type;
        for(User user: userList){
            if(user instanceof Teacher && !itsStudent && ((Teacher) user).getTeacherId() == id){
                return user;
            }
            if(user instanceof Student && itsStudent && ((Student) user).getStudentId() == id){
                return user;
            }
        }
        return null;
    }
    public List<User> getAllUser(){
        return userList;
    }

    public List<User> getAllStudent(){
        List<User> resultList = new ArrayList<>();
        for(User user : userList){
            if (user instanceof Student){
                resultList.add(user);
            }
        }
        return resultList;
    }

    public List<User> getAllTeacher(){
        List<User> resultList = new ArrayList<>();
        for(User user : userList){
            if (user instanceof Teacher){
                resultList.add(user);
            }
        }
        return resultList;
    }
}
