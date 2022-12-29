package cn.edu.swu.book;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/removeCart")
public class  RemoveCart extends HttpServlet{
    public final static String CART="cart";
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
        List<Long> cart =this.getCart(request);
        cart.clear();
        response.sendRedirect("./index.html");
    }

    private List<Long> getCart(HttpServletRequest request)
    {
        HttpSession session = request.getSession(true);
        List<Long> cart =(List<Long>)session.getAttribute(CART);
        if (cart==null){
            cart = new ArrayList<Long>();
            session.setAttribute(CART,cart);
        }
        return cart;
    }



}