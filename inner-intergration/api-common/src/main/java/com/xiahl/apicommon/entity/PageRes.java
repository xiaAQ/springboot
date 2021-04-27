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

    /**
     * pagehelper手动分页
     * @param currentPage 当前页
     * @param pageSize
     * @param list
     * @param <T>
     * @return
     */
    public static <T> PageInfo<T> getPageInfo(int currentPage, int pageSize, List<T> list) {
        int total = list.size();
        if (total > pageSize) {
            int toIndex = pageSize * currentPage;
            if (toIndex > total) {
                toIndex = total;
            }
            list = list.subList(pageSize * (currentPage - 1), toIndex);
        }
        com.github.pagehelper.Page<T> page = new com.github.pagehelper.Page<>(currentPage, pageSize);
        page.addAll(list);
        page.setPages((total + pageSize - 1) / pageSize);
        page.setTotal(total);

        PageInfo<T> pageInfo = new PageInfo<>(page);
        return pageInfo;
    }


}
