import org.eclipse.jetty.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by FreeFly on 06.02.2017.
 */
public class TodoServlet extends HttpServlet {
    private List<String> todos = new LinkedList<String>();

    public TodoServlet() {
        todos.add("Go home");
        todos.add("Check email");
        todos.add("Drink Non-Stop");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        ServletOutputStream out = resp.getOutputStream();

        for (String todo : todos) {
            out.println(todo + "<br>");
        }

        out.println("<form method=\"post\">");
        out.println("<input type=\"text\" name=\"todo\">");
        out.println("<input type=\"submit\">");
        out.println("</form>");

        out.println("<a href=\"/\">Home</a>");
        out.close();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newTodo = req.getParameter("todo");
        if(StringUtil.isNotBlank(newTodo)) {
            todos.add(newTodo);
        }

        resp.sendRedirect("/todos");
    }
}
