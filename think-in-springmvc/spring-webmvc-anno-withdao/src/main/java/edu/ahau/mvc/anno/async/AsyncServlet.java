package edu.ahau.mvc.anno.async;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/**
 * 异步
 * @author zhangxuna
 * @date 2021-12-22 14:55
 */
@WebServlet(urlPatterns = "/async", asyncSupported = true)
public class AsyncServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("AsyncServlet doGet ......" + Thread.currentThread().getName());
        PrintWriter writer = resp.getWriter();

        AsyncContext asyncContext = req.startAsync();
        asyncContext.start(() -> {
            System.out.println("AsyncServlet asyncContext ......" + Thread.currentThread().getName());

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ignore) { }
            asyncContext.complete();

            writer.println("success");
            System.out.println("AsyncServlet asyncContext end ......" + Thread.currentThread().getName());
        });
        writer.println("diyi");
        writer.flush();
        System.out.println("AsyncServlet doGet end ......" + Thread.currentThread().getName());
    }
}
