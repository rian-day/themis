package betahouse.service.Impl;

import betahouse.core.base.ExcelOutPut;
import betahouse.exception.ExcelException;
import betahouse.model.mapper.DormitoryMapper;
import betahouse.model.mapper.UserPracticeMapper;
import betahouse.model.mapper.UserVolunteerMapper;
import betahouse.model.xo.*;
import betahouse.model.po.*;
import betahouse.model.vo.UserVo;
import betahouse.service.*;
import betahouse.service.Impl.constant.ExcelConstant;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelServiceImpl implements ExcelService {

    @Autowired
    UserService userService;
    @Autowired
    UserOfficeService userOfficeService;
    @Autowired
    UserActivityService userActivityService;
    @Autowired
    UserPracticeMapper userPracticeMapper;
    @Autowired
    DormitoryMapper dormitoryMapper;
    @Autowired
    UserCleanService userCleanService;
    @Autowired
    UserVolunteerMapper userVolunteerMapper;

    private final static Logger logger = LoggerFactory.getLogger(ExcelOutPut.class);
    String SingleUser[][] = ExcelConstant.SINGLEUSER;
    String GroupUser[] = ExcelConstant.GROUPUSER;
    String InputUser[] = ExcelConstant.INPUTUSER;
    String InputActivity[] = ExcelConstant.INPUTACTIVITY;
    String InputUserClean[] = ExcelConstant.INPUTUSERCLEAN;
    String InputUserPractice[] = ExcelConstant.INPUTUSERPRACTICE;
    String InputUserVolunteer[] = ExcelConstant.INPUTUSERVOLUNTEER;


    @Override
    public void outPutSingleUser(Integer userId, HttpServletResponse response){
        UserVo userVo = userService.selectUserVoById(userId);

        HSSFWorkbook workbook = new HSSFWorkbook();
        //新建工作表
        HSSFSheet sheet = workbook.createSheet("用户所有信息");
        //创建行,行号作为参数传递给createRow()方法,第一行从0开始计算
        int rowNum = 0;
        HSSFRow row = sheet.createRow(rowNum);
        for(int i=0;i<SingleUser[0].length;i++){
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(SingleUser[0][i]);
        }
        rowNum++;
        row = sheet.createRow(rowNum);
        //{"学号","姓名","性别","专业","班级","入学时间","寝室号","政治面貌"}
        row.createCell(0).setCellValue(userVo.getSchoolId());
        row.createCell(1).setCellValue(userVo.getRealName());
        row.createCell(2).setCellValue(userVo.getGender());
        row.createCell(3).setCellValue(userVo.getMajor().getMajorName());
        row.createCell(4).setCellValue(userVo.getUclass().getClassName());
        row.createCell(5).setCellValue(userVo.getEntranceTime());
        row.createCell(6).setCellValue(userVo.getDormitory().getRoom());
        row.createCell(7).setCellValue(userVo.getPolitical());
        rowNum+=2;

        row = sheet.createRow(rowNum);
        for(int i=0;i<SingleUser[1].length;i++){
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(SingleUser[1][i]);
        }
        rowNum++;
        //,{"任职情况","开始时间","结束时间","考核结果","加分","备注"}
        for(int i=0;i<userVo.getUserOffices().size();i++,rowNum++){
            UserOffice userOffice = userVo.getUserOffices().get(i);
            row = sheet.createRow(rowNum);
            row.createCell(0).setCellValue(userOffice.getOfficeName());
            row.createCell(1).setCellValue(userOffice.getStartDate());
            row.createCell(2).setCellValue(userOffice.getEndDate());
            row.createCell(3).setCellValue(userOffice.getResult());
            row.createCell(4).setCellValue(userOffice.getOfficeLv());
            row.createCell(5).setCellValue(userOffice.getComment());
        }
        rowNum++;

        row = sheet.createRow(rowNum);
        for(int i=0;i<SingleUser[2].length;i++){
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(SingleUser[2][i]);
        }
        rowNum++;
        //,{"活动名称","活动时间","加分","备注"}
        for(int i=0;i<userVo.getUserVolunteers().size();i++,rowNum++){
            UserActivity userActivity = userVo.getUserActivities().get(i);
            row = sheet.createRow(rowNum);
            row.createCell(0).setCellValue(userActivity.getActivityName());
            row.createCell(1).setCellValue(userActivity.getActivityDate());
            row.createCell(2).setCellValue(0.5);
            row.createCell(3).setCellValue(userActivity.getComment());
        }
        rowNum++;

        row = sheet.createRow(rowNum);
        for(int i=0;i<SingleUser[3].length;i++){
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(SingleUser[3][i]);
        }
        rowNum++;
        //,{"实践名称","实践时间","考核结果","加分","备注"}
        for(int i=0;i<userVo.getUserPractices().size();i++,rowNum++){
            UserPractice userPractice= userVo.getUserPractices().get(i);
            row = sheet.createRow(rowNum);
            row.createCell(0).setCellValue(userPractice.getPracticeName());
            row.createCell(1).setCellValue(userPractice.getPracticeDate());
            row.createCell(2).setCellValue(userPractice.getResult());
            row.createCell(3).setCellValue(0.5);
            row.createCell(4).setCellValue(userPractice.getComment());
        }
        rowNum++;

        row = sheet.createRow(rowNum);
        for(int i=0;i<SingleUser[4].length;i++){
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(SingleUser[4][i]);
        }
        rowNum++;
        //,{"志愿名称","志愿时间","志愿时长","加分","备注"}
        for(int i=0;i<userVo.getUserVolunteers().size();i++,rowNum++){
            UserVolunteer userVolunteer = userVo.getUserVolunteers().get(i);
            row = sheet.createRow(rowNum);
            row.createCell(0).setCellValue(userVolunteer.getVolunteerName());
            row.createCell(1).setCellValue(userVolunteer.getVolunteerDate());
            row.createCell(2).setCellValue(userVolunteer.getVolunteerTime());
            row.createCell(3).setCellValue(0.5);
            row.createCell(4).setCellValue(userVolunteer.getComment());
        }
        rowNum++;

        row = sheet.createRow(rowNum);
        for(int i=0;i<SingleUser[5].length;i++){
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(SingleUser[5][i]);
        }
        rowNum++;
        //,{"卫生检查","检查结果"}
        for(int i=0;i<userVo.getUserCleans().size();i++,rowNum++){
            UserClean userClean = userVo.getUserCleans().get(i);
            row = sheet.createRow(rowNum);
            row.createCell(0).setCellValue(userClean.getCheckDate());
            row.createCell(1).setCellValue(userClean.getScore());
        }
        rowNum++;


        row = sheet.createRow(rowNum);
        for(int i=0;i<SingleUser[6].length;i++){
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(SingleUser[6][i]);
        }
        rowNum++;
        //,{"荣誉名称","荣誉等级","加分"}
        for(int i=0;i<userVo.getUserHonors().size();i++,rowNum++){
            UserHonor userHonor = userVo.getUserHonors().get(i);
            row = sheet.createRow(rowNum);
            row.createCell(0).setCellValue(userHonor.getHonorName());
            row.createCell(1).setCellValue(userHonor.getHonorLv());
            row.createCell(2).setCellValue(userHonor.getHonorScore());
        }
        rowNum++;

        row = sheet.createRow(rowNum);
        for(int i=0;i<SingleUser[7].length;i++){
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(SingleUser[7][i]);
        }
        rowNum++;
        //,{"备注加分项","加分"}
        for(int i=0;i<userVo.getUserReserves().size();i++,rowNum++){
            UserReserve userReserve = userVo.getUserReserves().get(i);
            row = sheet.createRow(rowNum);
            row.createCell(0).setCellValue(userReserve.getCause());
            row.createCell(1).setCellValue(userReserve.getScore());
        }
        rowNum++;

        row = sheet.createRow(rowNum);
        for(int i=0;i<SingleUser[8].length;i++){
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(SingleUser[8][i]);
        }
        rowNum++;
        //,{"技能加分项","等级","加分"}
        for(int i=0;i<userVo.getUserSkills().size();i++,rowNum++){
            UserSkill userSkill = userVo.getUserSkills().get(i);
            row = sheet.createRow(rowNum);
            row.createCell(0).setCellValue(userSkill.getSkillName());
            row.createCell(1).setCellValue(userSkill.getSkillLv());
            row.createCell(2).setCellValue(userSkill.getSkillScore());
        }
        rowNum++;
        try {
            workbook.write(response.getOutputStream());
        }catch (IOException e){

        }

        //输出到磁盘中
        FileOutputStream fos ;
        try{
            fos = new FileOutputStream(new File("11.xls"));
            workbook.write(fos);
            fos.close();
        }catch (java.lang.Exception e){
            e.printStackTrace();
        }finally {
        }
        //写入输出流

    }

    @Override
    public void outPutGroupUserByTerm(Integer term) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        //新建工作表
        HSSFSheet sheet = workbook.createSheet("用户所有信息");
        //创建行,行号作为参数传递给createRow()方法,第一行从0开始计算
        int rowNum = 0;
        HSSFCell cell = null;
        HSSFRow row = sheet.createRow(rowNum);
        for(int i=0;i<GroupUser.length;i++){
            cell = row.createCell(i);
            cell.setCellValue(GroupUser[i]);
        }
        rowNum++;
        List<UserVo> userVoList = userService.selectAllUserVoByTerm(term);
        for(int i=0;i<userVoList.size();i++){
            row = sheet.createRow(rowNum);
            rowNum++;
            UserVo userVo = userVoList.get(i);
           // "学期","学号","姓名","性别","专业","班级","入学时间","寝室号","政治面貌"
            int index = 0;
            row.createCell(index++).setCellValue(term);

            row.createCell(index++).setCellValue(userVo.getSchoolId());

            row.createCell(index++).setCellValue(userVo.getRealName());

            row.createCell(index++).setCellValue(userVo.getGender());

            row.createCell(index++).setCellValue(userVo.getMajor().getMajorName());

            row.createCell(index++).setCellValue(userVo.getUclass().getClassName());

            row.createCell(index++).setCellValue(userVo.getEntranceTime());

            row.createCell(index++).setCellValue(userVo.getDormitory().getRoom());

            row.createCell(index++).setCellValue(userVo.getPolitical());
            //,"任职加分","活动加分","社会实践","志愿加分","卫生加分","荣誉加分","备用分","德育总分","技能分"
            double score = 0;
            double totalScore = 0;
            double time = 0;
            for(int j=0;j<userVo.getUserOffices().size();j++){
                score += ExcelConstant.USEROFFICESCORE[userVo.getUserOffices().get(i).getOfficeLv()];
            }
            row.createCell(index++).setCellValue(score);
            totalScore += score;
            score = 0;

            for(int j =0;j<userVo.getUserActivities().size();j++){
                score += ExcelConstant.USERACTIVITYSCORE;
            }
            row.createCell(index++).setCellValue(score);
            totalScore += score;
            score = 0;

            for(int j =0;j<userVo.getUserPractices().size();j++){
                score += ExcelConstant.USERPRACTICE[userVo.getUserPractices().get(i).getResult()];
            }
            row.createCell(index++).setCellValue(score);
            totalScore += score;
            score = 0;
            //志愿分
            for(int j =0;j<userVo.getUserVolunteers().size();j++){
                time += userVo.getUserVolunteers().get(j).getVolunteerTime();
            }
            score += ExcelConstant.calculationVolunteerScore(time);
            time = 0;
            row.createCell(index++).setCellValue(score);
            totalScore += score;
            score = 0;
            //寝室卫生分
            for(int j =0;j<userVo.getUserCleans().size();j++){
                score += userVo.getUserCleans().get(j).getScore();
            }
            score /= userVo.getUserCleans().size();
            score = ExcelConstant.calculateUserCleanScore(score);
            row.createCell(index++).setCellValue(score);
            totalScore += score;
            score = 0;
            //荣誉分
            for(int j =0;j<userVo.getUserHonors().size();j++){
                score += userVo.getUserHonors().get(j).getHonorScore();
            }
            row.createCell(index++).setCellValue(score);
            totalScore += score;
            score = 0;
            //额外分
            for(int j =0;j<userVo.getUserReserves().size();j++){
                score += userVo.getUserReserves().get(j).getScore();
            }
            row.createCell(index++).setCellValue(score);
            totalScore += score;
            //德育分汇总
            row.createCell(index++).setCellValue(totalScore);
            score = 0;
            for(int j =0;j<userVo.getUserSkills().size();j++){
                score += userVo.getUserSkills().get(j).getSkillScore();
            }
            row.createCell(index++).setCellValue(score);
        }
        //输出到磁盘中
        FileOutputStream fos ;
        try{
            fos = new FileOutputStream(new File("12.xls"));
            workbook.write(fos);
            fos.close();
        }catch (java.lang.Exception e){
            e.printStackTrace();
        }finally {
        }
        //写入输出流
    }

    @Override
    public void outPutAllUser() {

    }

    @Transactional
    @Override
    public void inPutUser(InputStream inputStream) throws ExcelException{
        //String name = "用户导入表.xlsx";
        Workbook workbook = null;
        try {
            //InputStream inputStream = new FileInputStream(new File(name));
            workbook = new XSSFWorkbook(inputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
        Sheet sheet = workbook.getSheetAt(0);
        DataFormatter formatter = new DataFormatter();
        boolean first = true;
        List<User> userList = new ArrayList<>();
        for (Row row : sheet) {
            if(row.getPhysicalNumberOfCells()!=InputUser.length){
                //信息不符合
                throw new ExcelException("首行信息不符合");
            }
            if(first){
                for(int i=0;i<InputUser.length;i++){
                    Cell cell = row.getCell(i);
                    if(!cell.getStringCellValue().equals(InputUser[i])){
                        //首行异常
                        throw new ExcelException("首行信息不符合");
                    }
                }
                first = false;
            }else{
                User user = new User();
                Cell cell = row.getCell(0);
                user.setSchoolId(getCellValue(cell));
                cell = row.getCell(1);
                user.setRealName(getCellValue(cell));
                cell = row.getCell(2);
                user.setMajorId(Integer.valueOf(getCellValue(cell)));
                cell = row.getCell(3);
                user.setClassId(Integer.valueOf(getCellValue(cell)));
                cell = row.getCell(4);
                user.setDormitoryId(Integer.valueOf(getCellValue(cell)));
                cell = row.getCell(5);
                user.setGender(getCellValue(cell));
                cell = row.getCell(6);
                user.setEntranceTime(getCellValue(cell));
                cell = row.getCell(7);
                user.setPolitical(getCellValue(cell));
                userList.add(user);
            }
        }
        //接下去
        String schoolIds[] = new String[userList.size()];
        for (int i=0;i<userList.size();i++){
            schoolIds[i] = userList.get(i).getSchoolId();
        }
        List result = userService.selectAllUserInShoolIds(schoolIds);
        if(result.size()!=0){
            throw new ExcelException("学号已存在");
        }
        userService.insertUserInfoWithGroup(userList);
    }

    private String getCellValue(Cell cell) {
        String cellValue = "";
        DataFormatter formatter = new DataFormatter();
        if (cell != null) {
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        cellValue = formatter.formatCellValue(cell);
                    } else {
                        double value = cell.getNumericCellValue();
                        int intValue = (int) value;
                        cellValue = value - intValue == 0 ? String.valueOf(intValue) : String.valueOf(value);
                    }
                    break;
                case Cell.CELL_TYPE_STRING:
                    cellValue = cell.getStringCellValue();
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                    cellValue = String.valueOf(cell.getBooleanCellValue());
                    break;
                case Cell.CELL_TYPE_FORMULA:
                    cellValue = String.valueOf(cell.getCellFormula());
                    break;
                case Cell.CELL_TYPE_BLANK:
                    cellValue = "";
                    break;
                case Cell.CELL_TYPE_ERROR:
                    cellValue = "";
                    break;
                default:
                    cellValue = cell.toString().trim();
                    break;
            }
        }
        return cellValue.trim();
    }


    @Transactional
    @Override
    public void inPutOffice(InputStream inputStream) throws ExcelException {
        String name = "Office导入.xlsx";
        Workbook workbook = null;
        try {
            //InputStream inputStream = new FileInputStream(new File(name));
            workbook = new XSSFWorkbook(inputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
        Sheet sheet = workbook.getSheetAt(0);
        DataFormatter formatter = new DataFormatter();
        boolean first = true;
        List<UserOfficeXo> userOfficeXos = new ArrayList<>();
        List<UserOffice> userOfficeList = new ArrayList<>();
        for (Row row : sheet) {
            if(row.getPhysicalNumberOfCells()!=InputUser.length){
                //信息不符合
                throw new ExcelException("首行信息不符合");
            }
            if(first){
                for(int i=0;i<InputUser.length;i++){
                    Cell cell = row.getCell(i);
                    if(!cell.getStringCellValue().equals(InputUser[i])){
                        //首行异常
                        throw new ExcelException("首行信息不符合");
                    }
                }
                first = false;
            }else{
                UserOfficeXo userOfficeXo = new UserOfficeXo();
                int i=0;
                userOfficeXo.setShchoolId(getCellValue(row.getCell(i++)));
                userOfficeXo.setUserName(getCellValue(row.getCell(i++)));
                userOfficeXo.setOfficeName(getCellValue(row.getCell(i++)));
                userOfficeXo.setOfficeLv(Integer.valueOf(getCellValue(row.getCell(i++))));
                userOfficeXo.setStartDate(getCellValue(row.getCell(i++)));
                userOfficeXo.setEndDate(getCellValue(row.getCell(i++)));
                userOfficeXo.setTerm(Integer.valueOf(getCellValue(row.getCell(i++))));
                userOfficeXo.setComment(getCellValue(row.getCell(i)));

                userOfficeXos.add(userOfficeXo);
            }
        }
        //接下去
        for (int i = 0; i< userOfficeXos.size(); i++){
            UserOffice userOffice = new UserOffice(userOfficeXos.get(i));
            userOffice.setUserId(userService.selectUserBySchoolId(userOfficeXos.get(i).getShchoolId()).getId());
            userOfficeList.add(userOffice);
        }
        userOfficeService.InsertUserOfficeList(userOfficeList);
    }

    @Transactional
    @Override
    public void inPutActivity(InputStream inputStream) throws ExcelException {
        String name = "14.xlsx";
        Workbook workbook = null;
        try {
            //InputStream inputStream = new FileInputStream(new File(name));
            workbook = new XSSFWorkbook(inputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
        Sheet sheet = workbook.getSheetAt(0);
        DataFormatter formatter = new DataFormatter();
        boolean first = true;
        List<UserActivityXo> userActivityXos = new ArrayList<>();
        List<UserActivity> userActivityList = new ArrayList<>();
        for (Row row : sheet) {
            if(row.getPhysicalNumberOfCells()!=InputActivity.length){
                //信息不符合
                throw new ExcelException("首行信息不符合");
            }
            if(first){
                for(int i=0;i<InputActivity.length;i++){
                    Cell cell = row.getCell(i);
                    if(!cell.getStringCellValue().equals(InputActivity[i])){
                        //首行异常
                        throw new ExcelException("首行信息不符合");
                    }
                }
                first = false;
            }else{
                UserActivityXo userActivityXo = new UserActivityXo();
                int i=0;
                userActivityXo.setSchoolId(getCellValue(row.getCell(i++)));
                userActivityXo.setUserName(getCellValue(row.getCell(i++)));
                userActivityXo.setActivityName(getCellValue(row.getCell(i++)));
                userActivityXo.setActivityDate(getCellValue(row.getCell(i++)));
                userActivityXo.setTerm(Integer.valueOf(getCellValue(row.getCell(i++))));
                userActivityXo.setComment(getCellValue(row.getCell(i)));

                userActivityXos.add(userActivityXo);
            }
        }
        //接下去
        for (int i = 0; i<userActivityXos.size(); i++){
            UserActivity userActivity = new UserActivity(userActivityXos.get(i));
            userActivity.setUserId(userService.selectUserBySchoolId(userActivityXos.get(i).getSchoolId()).getId());
            userActivityList.add(userActivity);
        }
        userActivityService.InsertUserActivityGroup(userActivityList);
    }


    @Transactional
    @Override
    public void inPutUserClean(InputStream inputStream) throws ExcelException {
        String name = "13.xlsx";
        Workbook workbook = null;
        try {
            //InputStream inputStream = new FileInputStream(new File(name));
            workbook = new XSSFWorkbook(inputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
        Sheet sheet = workbook.getSheetAt(0);
        DataFormatter formatter = new DataFormatter();
        boolean first = true;
        List<UserCleanXo> userCleanXoList = new ArrayList<>();
        List<UserClean> userCleanList = new ArrayList<>();
        for (Row row : sheet) {
            if(row.getPhysicalNumberOfCells()!=InputUserClean.length){
                //信息不符合
                throw new ExcelException("首行信息不符合");
            }
            if(first){
                for(int i=0;i<InputUserClean.length;i++){
                    Cell cell = row.getCell(i);
                    if(!cell.getStringCellValue().equals(InputUserClean[i])){
                        //首行异常
                        throw new ExcelException("首行信息不符合");
                    }
                }
                first = false;
            }else{
                UserCleanXo userCleanXo = new UserCleanXo();
                int i=0;
                userCleanXo.setBuilding(Integer.valueOf(getCellValue(row.getCell(i++))));
                userCleanXo.setFloor(Integer.valueOf(getCellValue(row.getCell(i++))));
                userCleanXo.setRoom(Integer.valueOf(getCellValue(row.getCell(i++))));
                userCleanXo.setCheckDate(getCellValue(row.getCell(i++)));
                userCleanXo.setScore(Double.valueOf(getCellValue(row.getCell(i++))));
                userCleanXo.setTerm(Integer.valueOf(getCellValue(row.getCell(i))));

                userCleanXoList.add(userCleanXo);
            }
        }
        //接下去
        for (int i = 0; i<userCleanXoList.size(); i++){
            UserCleanXo userCleanXo = userCleanXoList.get(i);
            Dormitory dormitory = dormitoryMapper.selectByBuildingAndFloorAndRoom(userCleanXo.getBuilding(),userCleanXo.getFloor(),userCleanXo.getRoom());
            List<User> userList = userService.selectUserByDormitoryId(dormitory.getId());
            for(int j=0;j<userList.size();j++){
                UserClean userClean = new UserClean(userCleanXoList.get(i));
                userClean.setUserId(userList.get(j).getId());
                userCleanList.add(userClean);
            }
        }
        userCleanService.insertUserCleanList(userCleanList);
    }

    @Override
    public void inPutPractice(InputStream inputStream) throws ExcelException {
        //String name = "15.xlsx";
        Workbook workbook = null;
        try {
            ////InputStream inputStream = new FileInputStream(new File(name));
            workbook = new XSSFWorkbook(inputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
        Sheet sheet = workbook.getSheetAt(0);
        boolean first = true;
        List<UserPracticeXo> userPracticeXoList = new ArrayList<>();
        List<UserPractice> userPracticeList = new ArrayList<>();
        for (Row row : sheet) {
            if(first){
                if(row.getPhysicalNumberOfCells()!=InputUserPractice.length){
                    //信息不符合
                    throw new ExcelException("首行信息不符合");
                }
                for(int i=0;i<InputUserPractice.length;i++){
                    Cell cell = row.getCell(i);
                    if(!cell.getStringCellValue().equals(InputUserPractice[i])){
                        //首行异常
                        throw new ExcelException("首行信息不符合");
                    }
                }
                first = false;
            }else{
                UserPracticeXo userPracticeXo = new UserPracticeXo();
                int i=0;
                userPracticeXo.setSchoolId(getCellValue(row.getCell(i++)));
                userPracticeXo.setUserName(getCellValue(row.getCell(i++)));
                userPracticeXo.setPracticeName(getCellValue(row.getCell(i++)));
                userPracticeXo.setPracticeDate(getCellValue(row.getCell(i++)));
                userPracticeXo.setTerm(Integer.valueOf(getCellValue(row.getCell(i++))));
                userPracticeXo.setComment(getCellValue(row.getCell(i)));

                userPracticeXoList.add(userPracticeXo);
            }
        }
        //接下去
        for (int i = 0; i<userPracticeXoList.size(); i++){
            UserPracticeXo userPracticeXo = userPracticeXoList.get(i);
            UserPractice userPractice = new UserPractice(userPracticeXo);
            userPractice.setUserId(userService.selectUserBySchoolId(userPracticeXo.getSchoolId()).getId());
            userPracticeList.add(userPractice);
        }
        userPracticeMapper.insertList(userPracticeList);
    }

    @Override
    public void inPutVolunteer(InputStream inputStream) throws ExcelException {
        String name = "16.xlsx";
        Workbook workbook = null;
        try {
            //InputStream inputStream = new FileInputStream(new File(name));
            workbook = new XSSFWorkbook(inputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
        Sheet sheet = workbook.getSheetAt(0);
        boolean first = true;
        List<UserVolunteerXo> userVolunteerXoList = new ArrayList<>();
        List<UserVolunteer> userVolunteerList = new ArrayList<>();
        for (Row row : sheet) {
            if(first){
                if(row.getPhysicalNumberOfCells()!=InputUserVolunteer.length){
                    //信息不符合
                    throw new ExcelException("首行信息不符合");
                }
                for(int i=0;i<InputUserVolunteer.length;i++){
                    Cell cell = row.getCell(i);
                    if(!cell.getStringCellValue().equals(InputUserVolunteer[i])){
                        //首行异常
                        throw new ExcelException("首行信息不符合");
                    }
                }
                first = false;
            }else{
                UserVolunteerXo userVolunteerXo = new UserVolunteerXo();
                int i=0;
                userVolunteerXo.setSchoolId(getCellValue(row.getCell(i++)));
                userVolunteerXo.setUserName(getCellValue(row.getCell(i++)));
                userVolunteerXo.setVolunteerName(getCellValue(row.getCell(i++)));
                userVolunteerXo.setVolunteerDate(getCellValue(row.getCell(i++)));
                userVolunteerXo.setVolunteerTime(Double.valueOf(getCellValue(row.getCell(i++))));
                userVolunteerXo.setTerm(Integer.valueOf(getCellValue(row.getCell(i++))));
                userVolunteerXo.setComment(getCellValue(row.getCell(i)));

                userVolunteerXoList.add(userVolunteerXo);
            }
        }
        //接下去
        for (int i = 0; i<userVolunteerXoList.size(); i++){
            UserVolunteerXo userVolunteerXo = userVolunteerXoList.get(i);
            UserVolunteer userVolunteer = new UserVolunteer(userVolunteerXo);
            userVolunteer.setUserId(userService.selectUserBySchoolId(userVolunteerXo.getSchoolId()).getId());
            userVolunteerList.add(userVolunteer);
        }
        userVolunteerMapper.insertList(userVolunteerList);
    }
}
