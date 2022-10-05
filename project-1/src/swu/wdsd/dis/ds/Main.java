package swu.wdsd.dis.ds;

import swu.wdsd.dis.ds.Student.IStudentReader;
import swu.wdsd.dis.ds.Student.Student;
import swu.wdsd.dis.ds.Student.StudentManager;
import swu.wdsd.dis.ds.Student.StudentReaderFactory;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {
        private StudentManager studentManager = null;
        private StudentManager studentManager1 = null;
        private StudentManager studentManager2 = null;
         private StudentManager studentManager3 = null;


        public static void main(String[] args) throws IOException {
            Main main = new Main();
            main.startup();
            main.execute();
        }

        public void startup() throws IOException {
            List<Student> students = this.loadData();
            this.studentManager = this.initStudentManager(students);
            List<Student> students1 = this.loadChinese();
            this.studentManager1 = this.initStudentManager(students1);
            List<Student> students2 = this.loadChinese();
            this.studentManager2 = this.initStudentManager(students2);
            List<Student> students3 = this.loadEnglish();
            this.studentManager3 = this.initStudentManager(students3);
        }


    public void execute() throws IOException {
            for(int i=0;i<3;i++)
            {
                if(i==0)
                {
                    studentManager1.loadScore(studentManager,i);
                }
                if(i==1)
                {
                    studentManager2.loadScore(studentManager,i);
                }
                if (i==2)
                {
                    studentManager3.loadScore(studentManager,i);
                }
            }
            studentManager.printAll();
            studentManager.saveAs("C:/Users/25436/Desktop/score.txt");
            System.out.println("\n语文成绩在88-90的同学\n");

            this.studentManager3 = this.initStudentManager(studentManager.findByScore("chinese",88,90));
            studentManager3.printAll();
            System.out.println("\n平均成绩在88-90的同学\n");
            this.studentManager3=this.initStudentManager(studentManager.findByAverageScore(88,90));
            studentManager3.printAll();
            System.out.println("\n平均成绩从高到低\n");
            List<Student> students=studentManager.sortByTotal();
            students.forEach(e ->
            {
                System.out.println(e);
            });
        }

        public void findStudentById(String id) {
            Student student = this.studentManager.getStudentById(id);
            System.out.println(student.toString());
        }

        private List<Student> loadData() throws IOException {
            String uri = "C:/Users/25436/Desktop/students.txt";
            IStudentReader reader = StudentReaderFactory.create(uri);
            List<Student> students = reader.read();
            return students;
        }
        private List<Student> loadChinese() throws IOException {
             String uri = "http://139.186.26.196/javaweb/data/chinese.txt";
             IStudentReader reader = StudentReaderFactory.create(uri);
             List<Student> students = reader.read2();
            return students;
        }
        private List<Student> loadMath() throws IOException {
            String uri = "http://139.186.26.196/javaweb/data/math.txt";
            IStudentReader reader = StudentReaderFactory.create(uri);
            List<Student> students = reader.read2();
            return students;
        }
         private List<Student> loadEnglish() throws IOException {
            String uri = "http://139.186.26.196/javaweb/data/english.txt";
            IStudentReader reader = StudentReaderFactory.create(uri);
            List<Student> students = reader.read2();
            return students;
        }


        private StudentManager initStudentManager(List<Student> students) {
            StudentManager manager = new StudentManager();
            students.forEach(manager::addStudent);
            return manager;
        }



}
