import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Created by FreeFly on 06.02.2017.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Server server = new Server(80 );

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        // Any url wihout mapping
        context.addServlet(new ServletHolder(new ErrorServlet()),"/");

        // Home page(Main page)
        // URL: http://localhost
        context.addServlet(new ServletHolder(new HomeServlet()),"");

        // Todos
        // URL: http://localhost/todos
        context.addServlet(new ServletHolder(new TodoServlet()),"/todos");

        // Delete to-do
        // URL: http://localhost/delete?lineNumber=[int]
        context.addServlet(new ServletHolder(new DeleteTodoServlet()),"/delete");



        server.start();
        server.join();
    }
}
