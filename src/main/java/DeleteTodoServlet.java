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
public class DeleteTodoServlet extends HttpServlet {
    private TodoDao todoDao = new TodoDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String lineNumber = req.getParameter("lineNumber");

        todoDao.deleteLine(Integer.parseInt(lineNumber));

        resp.sendRedirect("/todos");
    }
}
