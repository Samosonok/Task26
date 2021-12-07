package task26;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FirstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {
        Map<String, String> result = new HashMap<>();
        for (int f = 0; f <= 5; f++) {
            String key = "key" + f;
            String value = request.getParameter(key);
            if (value != null) {
                result.put(key, value);
            }
        }
        response.getWriter().println(result);
    }
}
