package cn.edu.swu.book;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.swu.user.User;
import cn.edu.swu.user.UserRepo;
import cn.edu.swu.user.ValidateCodeServlet;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@WebServlet("/saveUser")
public class SaveUserServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id = request.getParameter("id");
        String name = "管理员";
        String users = request.getParameter("user");
        String password = request.getParameter("password");

        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setUser(users);
        if (id != null) {
            user.setId(String.valueOf(Long.valueOf(id)));
        }

        String message = null;
        try {
            UserRepo.getInstance().save(user);
            message = "提交信息保存成功！";
        } catch (SQLException e) {
            e.printStackTrace();
            message = "提交信息保存失败！";
        }
    }
}


