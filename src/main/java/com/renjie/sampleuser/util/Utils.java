package com.renjie.sampleuser.util;

import com.github.pagehelper.PageInfo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: fan
 * @Date: 2021/3/1
 * @Description:
 */
public class Utils {
    /**
     * 分页查询数据转换
     * @param pageInfo  com.github.pagehelper.PageInfo
     * @return  hai.guo.novel.base.model.PageObj
     *
     * {
     *     "total":2,
     *     "rows":[
     *         {
     *             "id":1,
     *             "name":"张索尼"
     *         }
     *     ],
     *     "pageNum":1,
     *     "pageSize":1,
     *     "pageToals":2
     * }
     */
    public static PageObj PageInfo2PageObj(PageInfo pageInfo) {
        PageObj pageObj = new PageObj();
        pageObj.setPageToals(pageInfo.getPages());
        pageObj.setRows(pageInfo.getList());
        pageObj.setTotal(pageInfo.getTotal());
        pageObj.setPageNum(pageInfo.getPageNum());
        pageObj.setPageSize(pageInfo.getPageSize());
        return pageObj;
    }

    //校验手机号
    public static boolean mobileNum(String num) {
        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
        if (num.length() != 11) {
            return false;
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(num);
            boolean isMatch = m.matches();
            if (!isMatch) {
                return false;
            }
            return true;
        }
    }
    //验证邮箱格式
    public static boolean isEmail(String email){
        if (null==email || "".equals(email)){
            return false;
        }
        String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern p = Pattern.compile(regEx1);
        Matcher m = p.matcher(email);
        if(m.matches()){
            return true;
        }else{
            return false;
        }
    }
}
