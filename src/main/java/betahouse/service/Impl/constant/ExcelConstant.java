package betahouse.service.Impl.constant;

public class ExcelConstant {
    public static final String SINGLEUSER[][] = {
            {"学号","姓名","性别","专业","班级","入学时间","寝室号","政治面貌"}
            ,{"任职情况","开始时间","结束时间","考核结果","加分","备注"}
            ,{"活动名称","活动时间","加分","备注"}
            ,{"实践名称","实践时间","考核结果","加分","备注"}
            ,{"志愿名称","志愿时间","志愿时长","加分","备注"}
            ,{"卫生检查时间","检查结果"}
            ,{"荣誉名称","荣誉等级","加分"}
            ,{"备注加分项","加分"}
            ,{"技能加分项","等级","加分"}
    };
    public static final String GROUPUSER[] = {
            "学期","学号","姓名","性别","专业","班级","入学时间","寝室号","政治面貌","任职加分","活动加分","社会实践","志愿加分","卫生加分","荣誉加分","备用分","德育总分","技能分"
    };
    public static final String INPUTUSER[] = {
            "学号","姓名","专业号","班级号","寝室号","性别","入学时间","政治面貌"
    };
    //volunteer 导入
    public static final String INPUTVOLUNTEER[] = {"学号","姓名","志愿名称","志愿时长","学期","备注"};
    //Activity导入
    public static final String INPUTACTIVITY[] = {"学号","姓名","活动名称","时间","学期","备注"};
    //UserClean导入
    public static final String INPUTUSERCLEAN[] = {"楼号{6}","层号{2}","寝室号{206}","时间{2017/3/2}","得分{98}","学期{201701}"};
    //UserPractice导入
    public static final String INPUTUSERPRACTICE[] = {"学号","姓名","实践名称","实践时间{2017/08/01-2017/10/01}","学期","备注"};
    //UserVolunteer导入
    public static final String INPUTUSERVOLUNTEER[] = {"学号{16900000}","姓名{张三}","志愿名称{迎新志愿者}","志愿时间{2017/02/10 - 2017/02/10}","志愿时长{3.5}","学期{201701}","备注"};
    //userOffice
    public static final double USEROFFICESCORE[] = {0,1,2};
    //userActivity
    public static final double USERACTIVITYSCORE = 0.5;
    //userPractice
    public static final double USERPRACTICE[] = {0,1,2};
    //userVolunteer算分机制
    public static final double USERVOLUNTEER = 4.0;
    public static double calculationVolunteerScore(double time){
        if(time>=12){
            return 3.0;
        }
        return time/USERVOLUNTEER;
    }
    //userClean
    public static final double USERCLEANSCORE[] = {0,0.5,1,1.5};
    public static final double USERCLEANLEVEL[] = {85,90,95};
    public static double calculateUserCleanScore(double score){
        double result = USERCLEANSCORE[0];
        for (int i=0;i<USERCLEANLEVEL.length;i++){
            if(score<=USERCLEANLEVEL[i])
                result = USERCLEANSCORE[i+1];
        }
        return result;
    }
}
