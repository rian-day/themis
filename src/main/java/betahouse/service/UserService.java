package betahouse.service;

import betahouse.model.vo.UserVo;

public interface UserService {

    /**
     *
     * @param id
     * @return
     */
    public UserVo SelectUserVoById(Integer id);
}
