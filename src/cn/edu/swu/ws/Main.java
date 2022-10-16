package cn.edu.swu.ws;

import cn.edu.swu.ws.student.IStudentReader;
import cn.edu.swu.ws.student.IStudentVisitor;
import cn.edu.swu.ws.student.Student;
import cn.edu.swu.ws.student.StudentManager;
import cn.edu.swu.ws.student.StudentReaderFactory;

import java.io.*;
import java.util.List;

public class Main {

    private StudentManager studentManager = null;

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.startup();
        main.execute();        
    }
    
    public void startup() throws IOException {
    	List<Student> students = this.loadData();
    	this.studentManager = this.initStudentManager(students);    
    } 
    
    public void execute() {
    	String id = "222021321072053";
    	this.findStudentById(id);
    	System.out.println("Total Student : " + this.studentManager.getTotalNumber());
    	this.studentManager.delete(id);
    	System.out.println("Total Student : " + this.studentManager.getTotalNumber());
    	
//    	IStudentVisitor visitor = new IStudentVisitor() {
//			@Override
//			public void visit(Student student) {
//				if (student.getName().startsWith("李")) {
//					System.out.println(student.toString());
//				}
//			}    		
//    	};
    	
    	this.studentManager.forEach(new IStudentVisitor() {
			@Override
			public void visit(Student student) {
				if (student.getName().startsWith("李")) {
					System.out.println(student.toString());
				}
			}    		
    	});
    }
    
    public void findStudentById(String id) {
        Student student = this.studentManager.findById(id);
        System.out.println(student.toString());
    }
    
    private List<Student> loadData() throws IOException {
    	 String uri = "http://10.122.7.154/javaweb/data/students.txt";
         IStudentReader reader = StudentReaderFactory.create(uri);
         List<Student> students = reader.read();
         return students;
    }
    
    private StudentManager initStudentManager(List<Student> students) {
        StudentManager manager = new StudentManager();
        students.forEach(s -> {
        	manager.addStudent(s);
        });
        return manager;
    }
    

}