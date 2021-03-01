package com.renjie.sampleuser.util;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: fan
 * @Date: 2021/3/1
 * @Description:
 */
@Data
public class PageObj implements Serializable {

    private static final long serialVersionUID = 1L;

    // 总数
    private long total;

    // 结果集
    private List<?> rows;

    // 当前页数
    private int pageNum;

    // 每页条数
    private int pageSize;

    //总页数
    private int pageToals;

}
