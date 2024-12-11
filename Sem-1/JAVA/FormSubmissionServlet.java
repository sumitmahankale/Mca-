import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/SubmitForm")
public class FormSubmissionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set the response content type
        response.setContentType("text/html");

        // Retrieve form parameters
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");

        // Validate inputs (basic example)
        if (name == null || name.isEmpty() || email == null || email.isEmpty()) {
            displayError(response, "Name and email are required fields.");
            return;
        }

        // Generate HTML response
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Form Submission</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Form Submitted Successfully!</h1>");
        out.println("<p><strong>Name:</strong> " + name + "</p>");
        out.println("<p><strong>Email:</strong> " + email + "</p>");
        out.println("<p><strong>Message:</strong> " + (message != null ? message : "No message provided.") + "</p>");
        out.println("<a href=\"form.html\">Go back to the form</a>");
        out.println("</body>");
        out.println("</html>");
    }

    private void displayError(HttpServletResponse response, String errorMessage) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Error</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Error</h1>");
        out.println("<p>" + errorMessage + "</p>");
        out.println("<a href=\"form.html\">Go back to the form</a>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "GET method is not supported for this endpoint.");
    }
}
