package com.xiahl.apicommon.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author xiahl
 * @version 1.0.0
 * @date 2019/8/13 16:56
 * @description
 */
@Data
public class IdVO {

    @NotEmpty(message = "不允许为空")
    @ApiModelProperty(required = true)
    private List<Integer> idList;

}
