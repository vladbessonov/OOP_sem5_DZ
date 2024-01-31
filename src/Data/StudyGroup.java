package Data;

import java.util.List;
public class StudyGroup {
    private int numberStudyGroup;
    private User teacherStudyGroup;
    private List<User> students;

    public StudyGroup(int numberStudyGroup, User teacherStudyGroup, List<User> students) {
        this.teacherStudyGroup = teacherStudyGroup;
        this.students = students;
        this.numberStudyGroup = numberStudyGroup;
    }

    public User getTeacherStudyGroup() {
        return teacherStudyGroup;
    }

    public void setTeacherStudyGroup(Teacher teacherStudyGroup) {
        this.teacherStudyGroup = teacherStudyGroup;
    }

    public List<User> getStudents() {
        return students;
    }

    public void setStudents(List<User> students) {
        this.students = students;
    }

    public int getNumberStudyGroup() {
        return numberStudyGroup;
    }

    public void setNumberStudyGroup(int numberStudyGroup) {
        this.numberStudyGroup = numberStudyGroup;
    }

    @Override
    public String toString() {
        return "Группа № "+ numberStudyGroup + '\'' +
                ", Преподаватель: " + teacherStudyGroup + '\'' +
                ", Студенты:" + '\'' +
                students + '\'' + '}';

    }
}

