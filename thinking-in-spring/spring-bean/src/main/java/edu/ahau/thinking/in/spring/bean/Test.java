package edu.ahau.thinking.in.spring.bean;

import org.apache.commons.io.IOUtils;//这个是用的apache的
import org.springframework.util.Base64Utils;
import sun.misc.BASE64Decoder;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author zhangxuna
 * @create 2021-10-12 17:14
 */
public class Test {
    public static void abc(String base64) throws IOException {

        //byte[] decode = Base64Utils.decode(base64);方法一公司的包

        BASE64Decoder decoder = new BASE64Decoder();//sun的
        byte[] bytes = decoder.decodeBuffer(base64);

        IOUtils.write(bytes,new FileOutputStream("D:\\b.jpg"));

    }


    public static void main(String[] args) throws IOException {
        abc("data:image/jpeg;base64,/9j/4AAQSkZJRgABAgAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0aHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAARCAAeAFoDASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwD3yqtzPcJcww28cTl1Z28xyvAwMDAPOWH5VNCJlQid0d97EFEKjbuO0YJPIGAT3IJwM4FC88o6mrXRMcEcPySYZQGY8/vBwvCgds7qyxMnGHuuzuvz/wAgZZglnmnO7y0WLcksYBYlyFZSrZHABOQV5JHIxzhePNd1Pw54eTUtMjszsuY0uJLsMY4omyu8hSGOGKdATgng1t6YqpYKqKFjDuI8DgpuO0++Rg579a5f4s/8ky1f/tj/AOjkq6EnKEXLqTNtQbJ9C1nxIvil9D8RQ6QXeyN5DLp0j8BXCEMrndzuBBwBwcZ529bXmcT23gzxRplrpOs3OtXOs3Zhvbe5ZZ5yi/IZvNVdwERRhtYkffxtKsR6ZWrVhU3pZkFxdwWm03D+WrZ+dgdg+rdF/EjNSQzRXESywypJG3R0YEH8RWSb68S4MaSwXEwIDwRo3y844b8ec9Kt3lrp6JNe3Oy3CKXluRIYSFA5LOCDtAHc449qwpVVUb5eg4z5ti9TJTIIXMKI8oU7Fdtqk9gSAcD3wfpWXdSXGnuscN0824FvLmCsUVeeG4PTI+bJPrnq6XWfscUUl9CsSSsoSSOXerbiAByAxYkjACnJIGcnFbJPQPaRu12IoNS1qS3iun0aB4HQPsgu28/BHHySxxgHnkMykc9+Kf8A2xff9C3qn/fy2/8Aj1XYdSs55VhS4QTHpC/ySev3Dhhxz06c1apbml12Ciio542lt5I0meF3UqssYUshI+8NwIyOvII9jTESVS1bSbHXNMm03UoPPtJtvmR72XOGDDlSD1A71dooE1fRnP6J4H8NeHbo3Wl6TDDcHpK7NI68EfKXJK5BIOMZ71t3EUk0BSKd4HyCJEVSRg5xggjB6HvgnBB5qWih67gklojCtbe8e8jt5Y1iFl5e2Y73aVMcYkYkt3Byd2RkjBBbZhnhuELwSpKgdkLIwYBlYqw47hgQR2IIqSis4U1C7vdsFFLYqLZ7rm4lmYOJF2KBkYXuP8/1qvpttMrlrjOYQYo859eSM/gAfStCKGK3QpDEkalmcqigAsxLMeO5JJJ7kk0+tmyPZq6YyaGK4iaKaJJI26o6gg/gaq/2VajhTcovZUupVVR6ABsAewq7RUWTND//2Q==");
    }
}
