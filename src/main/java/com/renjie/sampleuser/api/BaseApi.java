package com.renjie.sampleuser.api;

import com.renjie.sampleuser.exception.BusinessException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @Auther: fan
 * @Date: 2021/3/1
 * @Description: 基类
 */
public class BaseApi {


    // 获取参数Map
    public Map<String, Object> getParameterMap(HttpServletRequest req) {
        return getParameterMap(req, null);
    }

    public Map<String, Object> getParameterMap(HttpServletRequest req, String[] must) {
        Map<String, String[]> paramMap = req.getParameterMap();
        Map<String, Object> map = new HashMap<String, Object>();

        if (must != null && must.length > 0) {
            for (String str : must) {
                if (!paramMap.containsKey(str) || "".equals(paramMap.get(str)[0])) {
                    throw new BusinessException("必须参数[" + str + "]为空。",400);
                }
            }
        }

        for (Map.Entry<String, String[]> entry : paramMap.entrySet()) {
            map.put(entry.getKey().trim(), entry.getValue()[0].trim());
        }

        return map;
    }

}
