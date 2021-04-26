package com.xiahl.apicommon.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xiahl
 * @version 0.0.1 java-asset-data
 */
@Getter
@AllArgsConstructor
public enum ResultCode {
    /**
     * 正常登录
     */
    OK("200", "成功"),
    /**
     * 参数不匹配！
     */
    PARAM_NOT_MATCH("400", "参数不匹配！"),
    /**
     * 请先登录！
     */
    UNAUTHORIZED("401", "请先登录！"),
    /**
     * 暂无权限访问！
     */
    ACCESS_DENIED("403", "权限不足！"),
    /**
     * 请求不存在！
     */
    REQUEST_NOT_FOUND("404", "请求不存在！"),
    /**
     * 请求方式不支持！
     */
    HTTP_BAD_METHOD("405", "请求方式不支持！"),
    SYSTEM_ERROR("500", "服务繁忙，请稍后再试"),

    /**
     * 参数不能为空！
     */
    PARAM_NOT_NULL("400", "参数不能为空！"),

    /**
     * 当前用户已被锁定，请联系管理员解锁！
     */
    USER_DISABLED("403", "当前用户已被锁定，请联系管理员解锁！"),

    /**
     * 用户名或密码错误！
     */
    USERNAME_PASSWORD_ERROR("5001", "用户名或密码错误！"),

    /**
     * token 已过期，请重新登录！
     */
    TOKEN_EXPIRED("5002", "token 已过期，请重新登录！"),

    /**
     * token 解析失败，请尝试重新登录！
     */
    TOKEN_PARSE_ERROR("5002", "token 解析失败，请尝试重新登录！"),

    /**
     * 当前用户已在别处登录，请尝试更改密码或重新登录！
     */
    TOKEN_OUT_OF_CTRL("5003", "当前用户已在别处登录，请尝试更改密码或重新登录！"),

    /**
     * 无法手动踢出自己，请尝试退出登录操作！
     */
    KICKOUT_SELF("5004", "无法手动踢出自己，请尝试退出登录操作！"),
    ;

    private final String code;
    private final String message;

    public static boolean isOk(String code) {
        return OK.getCode().equals(code);
    }

}
