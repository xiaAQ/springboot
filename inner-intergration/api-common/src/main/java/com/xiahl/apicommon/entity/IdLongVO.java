package com.xiahl.apicommon.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author xiahl
 * @version 1.0.0
 * @date 2019-10-22 10:28
 * @description
 */
@Data
public class IdLongVO {

    @NotEmpty(message = "不允许为空")
    @ApiModelProperty(required = true)
    private List<Long> idList;

}
