package hello.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet",urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(HttpServletResponse.SC_OK); //response 응답 코드 설정, 상수로 정의되어 있음

        //[response-header]
        resp.setHeader("Content-type", "text-plain");
        resp.setHeader("Cache-Control","no-cache, no_store,must-revalidate");
        resp.setHeader("Pragma","no-cache");
        resp.setHeader("my-header","hello");

        PrintWriter writer = resp.getWriter();
        writer.println("ok");

    }
}
