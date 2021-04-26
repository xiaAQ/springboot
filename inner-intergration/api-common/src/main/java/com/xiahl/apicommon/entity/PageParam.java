package com.xiahl.apicommon.entity;

import com.github.pagehelper.IPage;
import lombok.Data;

/**
 * @author xiahl
 * @date 2021/3/17 14:15
 * @description TODO
 */
@Data
public class PageParam<T>  implements IPage {

    /**
     * description = "页码", defaultValue =  1
     */
    private Integer pageNum = Page.DEFAULT_NUM;

    /**
     * description = "页数", defaultValue = 20
     */
    private Integer pageSize = Page.DEFAULT_SIZE;

    /**
     * description = "排序", example = "id desc"
     * todo 可能有SQL注入风险
     */
    private String orderBy;

    /**
     * description = "参数"
     */
    private T param;

}
