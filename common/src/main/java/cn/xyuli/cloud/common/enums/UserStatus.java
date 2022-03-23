package cn.xyuli.cloud.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName UserType
 * @Description TODO
 * @Author xyuli
 * @Date 2022/3/11 4:54 PM
 * @Version 1.0
 **/
@Getter
@AllArgsConstructor
public enum UserStatus {
    NORMAL("NORMAL","正常"),
    FREEZE("FREEZE","冻结");
    /**
     * 值
     */
    private final String value;
    /**
     * 备注
     */
    private final String remark;
}
