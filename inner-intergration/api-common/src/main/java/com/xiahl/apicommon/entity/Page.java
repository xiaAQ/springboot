package com.xiahl.apicommon.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiahl
 * 分页参数
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page {

    public static final int DEFAULT_NUM = 1;
    public static final int DEFAULT_SIZE = 20;

    @ApiModelProperty(value = "页数。1开始，默认1", example = "1")
    private int num = DEFAULT_NUM;

    @ApiModelProperty(value = "每页条数，默认20", example = "20")
    private int size = DEFAULT_SIZE;

}
