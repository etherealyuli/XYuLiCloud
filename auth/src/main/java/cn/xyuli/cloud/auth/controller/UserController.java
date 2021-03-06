package cn.xyuli.cloud.auth.controller;


import cn.xyuli.cloud.common.entity.User;
import cn.xyuli.cloud.web.annotation.NoLogin;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.xyuli.cloud.auth.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import cn.xyuli.cloud.common.vo.R;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (User)user表控制层
 *
 * @author makejava
 * @since 2022-03-14 10:38:55
 */
@Api(tags = "用户相关接口")
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param user 查询实体
     * @return 所有数据
     */
    @GetMapping("find")
    public R selectAll(Page<User> page, User user) {
        return R.success(this.userService.page(page, new QueryWrapper<>(user)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return R.success(this.userService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param user 实体对象
     * @return 新增结果
     */
    @PostMapping("save")
    public R insert(@RequestBody User user) {
        return R.success(this.userService.save(user));
    }

    /**
     * 修改数据
     * @param user 实体对象
     * @return 修改结果
     */
    @PutMapping("update")
    public R update(@RequestBody User user) {
        return R.success(this.userService.updateById(user));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping("del")
    public R delete(@RequestParam("idList") List<Long> idList) {
        return R.success(this.userService.removeByIds(idList));
    }
}

