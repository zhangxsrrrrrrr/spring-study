package edu.ahau.mvc.anno.async;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * DeferredResult 等待调用 setResult 才响应数据
 *
 * @author zhangxuna
 * @date 2021-12-22 15:17
 */
@Controller 
public class AsyncDemo {

    private DeferredResult<String> deferredResult = null;

    @GetMapping("/deferred")
    @ResponseBody
    public DeferredResult<String> deferred() {
        DeferredResult<String> deferredResult = new DeferredResult<>(5000L);
        this.deferredResult = deferredResult;
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            deferredResult.setResult("hahahah");
        }).start();
        System.out.println("xixi");
        return deferredResult;
    }

    @GetMapping("/addData")
    public void addData() {
        if (this.deferredResult != null) {
            this.deferredResult.setResult("AsyncController deferredResult setResult");
            this.deferredResult = null;
        }
        
    }

    @GetMapping("/async1")
    @ResponseBody
    public Callable<String> async() {
        System.out.println("AsyncController async ......" + Thread.currentThread().getName());
        return () -> {
            System.out.println("AsyncController Callable ......" + Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(5);
            return "AsyncController async ......";
        };
    }

}
