package cn.edu.swu.book;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.List;




@WebServlet("/api/books")
public class ListBookApi extends HttpServlet  {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            List<Book> books = BookRepo.getInstance().getAll();
            response.setContentType("application/json; charset=UTF-8");
            try (Writer ignored = response.getWriter()) {
                this.writeJsonByJackson(response.getWriter(), books);
            }
        } catch (SQLException e) {
            throw new IOException(e);
        }
    }

    private void writeJsonByJackson(Writer writer, List<Book > books)  throws IOException  {
        String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(books);
        writer.write(json);
    }

}
