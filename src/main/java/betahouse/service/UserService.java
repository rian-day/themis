package betahouse.service;

import betahouse.model.vo.UserVo;

public interface UserService {

    public UserVo SelectUserVoById(Integer id);
    public UserVo SelectUserVoBySchoolId(Integer schoolId);

}
