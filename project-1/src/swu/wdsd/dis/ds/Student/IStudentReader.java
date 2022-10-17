package swu.wdsd.dis.ds.Student;
import java.io.IOException;
import java.util.List;

public interface IStudentReader {
    public List<Student> read() throws IOException;
    public List<Student> read2() throws IOException;
}

