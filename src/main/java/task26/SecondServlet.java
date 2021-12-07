package task26;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

public class SecondServlet extends HttpServlet {

    AtomicInteger getCount = new AtomicInteger(1);
    AtomicInteger postCount = new AtomicInteger(1);

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {
        String value = request.getParameter("key");
        PrintWriter pw = response.getWriter();
        pw.println("key=" + value);
        int requestCounter = getCount.getAndIncrement();
        pw.println("Processed " + requestCounter + " GET-requests");
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
        String value = request.getParameter("key");
        PrintWriter pw = response.getWriter();
        pw.println("key=" + value);
        int requestCounter = postCount.getAndIncrement();
        pw.println("Processed " + requestCounter + " POST-requests");
    }
}
