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
    private TodoDao todoDao = new TodoDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        ServletOutputStream out = resp.getOutputStream();

        List<String> allTodos = todoDao.getAll();

        for (int i = 0; i < allTodos.size(); i++) {
            out.println(allTodos.get(i) + "<a href=\"/delete?lineNumber=" +
                    i + "\">[X]</a><br>");
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
        if (StringUtil.isNotBlank(newTodo)) {
            todoDao.addNew(newTodo);
        }

        resp.sendRedirect("/todos");
    }
}
