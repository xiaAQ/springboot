package com.xiahl.apicommon.entity;

import com.github.pagehelper.PageInfo;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @author xiahl
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PageRes<T> implements Serializable {

    private final int num;

    private final int size;

    private final long total;

    private final int pages;

    private final boolean hasNext;

    private final List<T> data;

    public static <T> PageRes<T> of(PageInfo<T> info) {
        return new PageRes<>(info.getPageNum(), info.getPageSize(), info.getTotal(), info.getPages(), info.isHasNextPage(), info.getList());
    }

    public static <T> PageRes<T> of(PageInfo<?> info, List<T> result) {
        return new PageRes<>(info.getPageNum(), info.getPageSize(), info.getTotal(), info.getPages(), info.isHasNextPage(), result);
    }

    public static <T> PageRes<T> empty(Page pageable) {
        return new PageRes<>(pageable.getNum(), pageable.getSize(), 0, 0, false, Collections.emptyList());
    }

}
