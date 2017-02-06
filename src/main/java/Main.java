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

        context.addServlet(new ServletHolder(new ErrorServlet()),"/");
        context.addServlet(new ServletHolder(new HomeServlet()),"");
        context.addServlet(new ServletHolder(new TodoServlet()),"/todos");

        server.start();
        server.join();
    }
}
