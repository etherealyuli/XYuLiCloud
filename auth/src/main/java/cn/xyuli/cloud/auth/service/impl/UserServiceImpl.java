package cn.xyuli.cloud.auth.service.impl;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.xyuli.cloud.common.entity.User;
import cn.xyuli.cloud.common.enums.UserStatus;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.xyuli.cloud.auth.dao.UserDao;
import cn.xyuli.cloud.auth.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Locale;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2022-03-14 10:38:55
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Resource
    private Snowflake snowflake;
    @Resource
    private UserDao userDao;

    @Override
    public User findByUsername(String username) {
        return lambdaQuery()
                .eq(User::getName, username)
                .one();
    }

    @Override
    public User findByPhone(String phone) {
        return lambdaQuery()
                .eq(User::getPhone,phone)
                .one();
    }

    @Override
    public User findByUserId(String userId) {
        return lambdaQuery()
                .eq(User::getUserId, userId)
                .one();
    }

    @Override
    public void addUser(String username, String pwd) {
        User user = new User();
        user.setUserId(snowflake.nextIdStr());
        user.setOpenId(IdUtil.fastSimpleUUID().toUpperCase(Locale.ROOT));
        user.setName(username);
        user.setPwd(pwd);
        user.setDel(false);
        Date current = new Date(System.currentTimeMillis());
        user.setCreateTime(current);
        user.setUpdateTime(current);
        user.setPhone(null);
        user.setStatus(UserStatus.NORMAL);
        userDao.insert(user);
    }
}

