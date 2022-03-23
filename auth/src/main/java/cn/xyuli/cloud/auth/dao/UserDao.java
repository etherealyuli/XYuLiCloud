package cn.xyuli.cloud.auth.dao;

import cn.xyuli.cloud.common.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2022-03-14 10:38:55
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

}

