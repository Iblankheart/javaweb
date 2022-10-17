package cn.edu.swu.ws.student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

abstract class StudentAbstractReader implements IStudentReader {

    protected abstract InputStream getInputStream() throws IOException;

    public List<Student> read() throws IOException {
        List<Student> students = new ArrayList<>();
        try (InputStreamReader inputStreamReader = new InputStreamReader(this.getInputStream()))
        {
            try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
                String line = null;
                while ((line = reader.readLine()) != null) {
                    if (line.trim().isEmpty())  continue;
                    Student student = this.createStudent(line);
                    students.add(student);
                }
            }
        }
        return students;
    };

    private Student createStudent(String line) {
        String[] vals = line.split("\t");
        Student student = new Student();
        student.setId(vals[0]);
        student.setName(vals[1]);
        return student;
    }

}
