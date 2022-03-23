package cn.xyuli.cloud.common.vo;

import cn.hutool.json.JSONUtil;
import cn.xyuli.cloud.common.enums.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.extern.jackson.Jacksonized;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName R
 * @Description TODO
 * @Author xyuli
 * @Date 2022/3/2 6:37 PM
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
public class R<T> {
    /**
     * http返回码
     */
    private Integer code;
    /**
     * http请求描述
     */
    private String msg;
    /**
     * 跟踪ID
     */
    private String traceId;
    /**
     * 返回数据
     */
    private T data;
    /**
     * 返回时间戳
     */
    private Long date;

    public static R success(){
        return new R(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(),null,null,getCurrentDate());
    }
    public static R success(String traceId){
        return new R(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(),traceId,null,getCurrentDate());
    }
    public static <T> R success(T t){
        return new R<T>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(),null,t,getCurrentDate());
    }
    public static <T> R success(T t,String traceId){
        return new R<T>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(),traceId,t,getCurrentDate());
    }
    public static R build(HttpStatus httpStatus){
        return new R(httpStatus.value(), httpStatus.getReasonPhrase(), null,null,getCurrentDate());
    }
    public static R build(Integer code,String message){
        return new R(code, message, null,null,getCurrentDate());
    }
    public static R failure(String reasonPhrase){
        return new R(HttpStatus.INTERNAL_SERVER_ERROR.value(),reasonPhrase,null,null,getCurrentDate());
    }

    private static Long getCurrentDate(){
        return System.currentTimeMillis();
    }

}
