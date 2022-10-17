package cn.edu.swu.ws.student;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class StudentManager {

    private Map<String, Student> students = new HashMap<>();

    public void addStudent(Student student) {
        this.students.put(student.getId(), student);
    }

    private Map<String, Student> getStudents() {
        return this.students;
    }
    
    public void forEach(IStudentVisitor visitor) {
    	for (Entry<String, Student> entry : this.getStudents().entrySet()) {
        	visitor.visit(entry.getValue());
        }
    }

    public int getTotalNumber() {
        return this.getStudents().size();
    }

    public void printAll() {
        Map<String, Student> ss = this.getStudents();
        for (Iterator<String> it = ss.keySet().iterator(); it.hasNext(); ) {
            String key = it.next();
            Student student = ss.get(key);
            System.out.println(String.format("学号：%s, 姓名：%s", student.getId(), student.getName()));
        }
    }

    public Student findById(String id) {
    	return this.getStudents().get(id);
    }

    public void
    
    public void delete(String id) {
    	this.getStudents().remove(id);
    }

    public void saveAs(String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        
        for (Entry<String, Student> entry : this.getStudents().entrySet()) {
        	Student student = entry.getValue();
        	writer.write(String.format("%s, %s\n", student.getId(), student.getName()));
        }
       
        writer.close();
    }

}





