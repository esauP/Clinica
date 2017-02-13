package servlet;

import Model.Login;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FrontController extends HttpServlet {
    
    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException, SQLException {

        String resource = request.getParameter("res");
        if (resource.equals("index.html")) {
            HttpSession session = request.getSession(false);
            session.invalidate();
            RequestDispatcher d = request.getRequestDispatcher(resource);
            if (d != null) {
                d.forward(request, response);

            }
        } else if (logado(request)) {
            RequestDispatcher d = request.getRequestDispatcher(resource);
            if (d != null) {
                d.forward(request, response);
            }
            System.out.println("LOGADO ACCEDIENDO A " + resource);
        } else {
            response.sendRedirect("error.html");
        }

    }

    private boolean logado(HttpServletRequest request) throws SQLException {
        boolean logado = false;

        HttpSession session = request.getSession(false);

        String userForm = request.getParameter("user");
        String passwdForm = request.getParameter("passwd");

        if (session == null) {
            session = request.getSession();
            if (userForm == null || passwdForm == null
                    || userForm.length() == 0 || passwdForm.length() == 0) {
                logado = false;

            } else if (valido(userForm, passwdForm)) {
                logado = true;
                session.setAttribute("session.user", userForm);
            } else {
                logado = false;
            }

        } else if (userForm == null || passwdForm == null) {
            logado = false;
        } else if (valido(userForm, passwdForm)) {
            logado = true;
            session.setAttribute("session.user", userForm);

           

        } else {
            logado = false;
        }
        return logado;
    }

    public boolean valido(String userForm, String passwdForm) throws SQLException {
        boolean res = false;
        //res = (userForm.equals(this.user) && passwdForm.equals(this.passwd));

        Login lo = new Login();

        res = (lo.consulta(userForm, passwdForm));

        System.out.println(res);
        return res;

    }

}
