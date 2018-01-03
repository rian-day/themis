package betahouse.core.base;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;

@Component
public class IOUtil {
    public void outPutStream(HttpServletResponse response, HSSFWorkbook workbook){
        try {
            OutputStream out = response.getOutputStream();
            String fileName = "test.xls";// 文件名  
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition", "attachment; filename="
                    + URLEncoder.encode(fileName, "UTF-8"));
            workbook.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}
