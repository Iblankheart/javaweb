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

@WebServlet("/api/linkBook")
public class LinkServletApi extends HttpServlet  {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        response.setContentType("application/json; charset=UTF-8");
        System.out.println(id);
        Book book = null;
        try {
            book = BookRepo.getInstance().getById(String.valueOf(Long.valueOf(id)));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try (Writer ignored = response.getWriter()) {
            this.writeJsonByJackson(response.getWriter(), book);
        }
}
    private void writeJsonByJackson(Writer writer, Book book)  throws IOException  {
        String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(book);
        writer.write(json);
    }
}