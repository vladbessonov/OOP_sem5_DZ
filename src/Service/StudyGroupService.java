package Service;

import java.util.List;
import java.util.ArrayList;
import Data.StudyGroup;
import Data.User;
import Data.Teacher;
import Data.Student;
import Data.Type;
public class StudyGroupService {
    public StudyGroup createStudyGroup (int number, User teacher, List<User> students) {
        return new StudyGroup(number,teacher,students);
    }

    private List<User> userList = new ArrayList<>();

    public List<User> getAllConcUser(Type type) {
        List<User> resultList = new ArrayList<>();
        boolean itsStudent = type == Type.STUDENT;
        for (User user : userList) {
            if (user instanceof Student && itsStudent) {
                resultList.add(user);
            }
            if (user instanceof Teacher && !itsStudent) {
                resultList.add(user);

            }
        }
        return resultList;
    }









}
