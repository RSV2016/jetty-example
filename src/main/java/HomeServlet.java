import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by FreeFly on 06.02.2017.
 */
public class HomeServlet extends HttpServlet {
    private int count = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream respOutputStream = resp.getOutputStream();
        respOutputStream.println(
                "<p>Hello, world!!!</p>" +
                "<p>" + ++count + "</p>" +
                "<p><a href=\"/todos\">Todo list</a></p>"
        );
        respOutputStream.close();
    }
}
