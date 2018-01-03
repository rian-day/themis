package betahouse.service;

import betahouse.exception.ExcelException;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

public interface ExcelService {
    public void outPutSingleUser(Integer userId, HttpServletResponse response);

    public void outPutGroupUserByTerm(Integer term);

    public void outPutAllUser();

    public void inPutUser(InputStream inputStream) throws ExcelException;
    public void inPutOffice(InputStream inputStream) throws ExcelException;
    public void inPutActivity(InputStream inputStream) throws ExcelException;
    public void inPutUserClean(InputStream inputStream) throws ExcelException;
    public void inPutPractice(InputStream inputStream) throws ExcelException;
    public void inPutVolunteer(InputStream inputStream) throws ExcelException;
}
