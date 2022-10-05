package swu.wdsd.dis.ds.Student;

import javax.xml.transform.Result;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class StudentManager {
    private Map<String, Student> students = new HashMap<>();

    public void addStudent(Student student) {
        this.students.put(student.getId(), student);
    }

    private Map<String, Student> getStudents() {
        return this.students;
    }



    public void printAll() {
        Map<String, Student> ss = this.getStudents();
        for (Iterator<String> it = ss.keySet().iterator(); it.hasNext(); ) {
            String key = it.next();
            Student student = ss.get(key);
            System.out.println(String.format("学号：%s, 姓名：%s 语文：%d 数学：%d 英语：%d 总分：%d 平均：%f",student.getId(), student.getName(),student.getChineseScore(),student.getMathScore(),student.getEnglishScore(),student.getTotalPoints(),student.getAverage()));
        }
    }

    public void loadScore(StudentManager studentManager,int i)
    {
        Map<String, Student> ss = studentManager.getStudents();
        for (Iterator<String> it = ss.keySet().iterator(); it.hasNext(); ) {
            String key = it.next();
            Student student = ss.get(key);
            Student student1=getStudentById(student.getId());
            if(i==0)
            {
                student.setChineseScore(student1.getScore());
            }
            if (i==1)
            {
                student.setMathScore(student1.getScore());
            }
            if (i==2)
            {
                student.setEnglishScore(student1.getScore());
            }

        }
    }




    public Student getStudentById(String id) {
        return this.getStudents().get(id);
    }

    public List<Student> findByScore(String classType, int min, int max) //根据课程类别，分值范围查询返回符合要求的学生列表;
    {
        Map<String, Student> ss = getStudents();
        List<Student> students = new ArrayList<>();
        for (Iterator<String> it = ss.keySet().iterator(); it.hasNext(); ) {
            String key = it.next();
            Student student = ss.get(key);
            if (classType == "chinese") {
                if (student.getChineseScore() < min) {
                    continue;
                }
                if (student.getChineseScore() > max) {
                    continue;
                } else {
                    students.add(student);

                }
            }
            if (classType == "math") {
                if (student.getMathScore() < min) {
                    continue;
                }
                if (student.getMathScore() > max) {
                    continue;
                } else {
                    students.add(student);

                }
            }
            if (classType == "english") {
                if (student.getEnglishScore() < min) {
                    continue;
                }
                if (student.getEnglishScore() > max) {
                    continue;
                } else {
                    students.add(student);
                }
            }
        }
        return students;
    }



    public List<Student> findByAverageScore(int min, int max) //查询三科成绩平均分在指定范围内的学生列表;
    {
        Map<String, Student> ss = getStudents();
        List<Student> students = new ArrayList<>();
        for (Iterator<String> it = ss.keySet().iterator(); it.hasNext(); ) {
            String key = it.next();
            Student student = ss.get(key);
            if(student.getAverage()<min)
            {
                continue;
            }
            if (student.getAverage()>max)
            {
                continue;
            }
            else
            {
                students.add(student);
            }


        }
        return students;
    }

    public List<Student> sortByTotal() //返回一个列表，列表中的学生按总分由高到低排序
    {
        List<Student> Result=new ArrayList<>();
        List<Student> finalResult = Result;
        this.getStudents().entrySet().forEach(e->
                {
                    finalResult.add(e.getValue());
                }
        );
        Result = Result.stream().sorted(Comparator.comparing(Student::getAverage).reversed()).collect(Collectors.toList());
        return Result;
    }

    public void saveAs(String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);

        for (Entry<String, Student> entry : this.getStudents().entrySet()) {
            Student student = entry.getValue();
            writer.write(String.format("%s %s %d %d %d %d %f\n", student.getId(), student.getName(),student.getChineseScore(),student.getMathScore(),student.getEnglishScore(),student.getTotalPoints(),student.getAverage()));
        }
        writer.close();
    }
}
