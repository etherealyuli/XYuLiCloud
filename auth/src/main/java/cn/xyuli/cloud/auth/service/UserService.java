package cn.xyuli.cloud.auth.service;

import cn.xyuli.cloud.common.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2022-03-14 10:38:55
 */
public interface UserService extends IService<User> {

    User findByUsername(String username);

    User findByPhone(String phone);

    User findByUserId(String userId);

    void addUser(String username, String pwd);
}

