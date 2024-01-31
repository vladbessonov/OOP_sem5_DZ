package Service;

import java.util.List;
import java.util.ArrayList;
import Data.StudyGroup;
import Data.User;
import Data.Teacher;
import Data.Student;
import Data.Type;
import java.util.Scanner;



public class StudyGroupService {
    public StudyGroup createStudyGroup (int number, User teacher, List<User> students) {
        return new StudyGroup(number,teacher,students);
    }
















}
