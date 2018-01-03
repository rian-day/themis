package betahouse.core.base;

import betahouse.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Component
public class ExcelOutPut {
    private final static Logger logger = LoggerFactory.getLogger(ExcelOutPut.class);

    @Autowired
    UserService userService;

    public void outFileToUser(HttpServletResponse response , String fileName){
        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        byte[] buff = new byte[1024];
        BufferedInputStream bufferedInputStream = null;
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(fileName)));
            int i = bufferedInputStream.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bufferedInputStream.read(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("success");
    }
}
