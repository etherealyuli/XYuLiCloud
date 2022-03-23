package cn.xyuli.cloud.common.vo;

import lombok.Data;

import java.util.List;

/**
 * @ClassName RPage
 * @Description TODO 响应分页请求
 * @Author xyuli
 * @Date 2022/3/3 2:29 PM
 * @Version 1.0
 **/
@Data
public class RPage<T> {
    /**
     * 当前页数
     */
    private Integer page;
    /**
     * 页数大小
     */
    private Integer pageSize;
    /**
     * 总数据量
     */
    private Long total;
    /**
     * 数据列表
     */
    private List<T> items;
}
