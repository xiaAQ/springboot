package com.xiahl.apicommon.entity;

import com.xiahl.apicommon.constant.ResultCode;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author xiahl
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Res<T> implements Serializable {

    @ApiModelProperty(value = "返回码", example = "200")
    private final String code;
    @ApiModelProperty(value = "描述信息", example = "成功")
    private final String msg;
    @ApiModelProperty("数据")
    private @Setter T data;

    protected static <T> Res<T> of(String code, String msg, T data) {
        return new Res<>(code, msg, data);
    }

    public static <T> Res<T> success(T data) {
        return of(ResultCode.OK.getCode(), ResultCode.OK.getMessage(), data);
    }

    public static <T> Res<T> success() {
        return success(null);
    }

    public static <T> Res<T> failure(ResultCode resp) {
        return failure(resp, resp.getMessage());
    }

    public static <T> Res<T> failure(String msg) {
        return failure(ResultCode.SYSTEM_ERROR, msg);
    }

    public static <T> Res<T> failure(ResultCode resp, String msg) {
        return of(resp.getCode(), msg, null);
    }

    public static <T> Res<T> failure(ResultCode resp, T data) {
        return of(resp.getCode(), resp.getMessage(), data);
    }

}
