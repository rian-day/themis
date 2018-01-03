package betahouse;

import betahouse.core.base.ExcelOutPut;
import betahouse.exception.ExcelException;
import betahouse.service.ExcelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IoTest {
    @Autowired
    ExcelService excelService;
    @Test
    public void ExcelOutTest(){

    }
//    @Test
//    public void ExcelInTest(){
//        excelService.inPutUser();
//    }

}
