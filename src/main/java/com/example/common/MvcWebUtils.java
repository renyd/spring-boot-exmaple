package com.example.common;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Domg on 2016/11/20.
 */
public class MvcWebUtils {

    public static boolean isAjax(HttpServletRequest request) {
        String ajaxHeader = request.getHeader("X-Requested-With");
        if (ajaxHeader != null && ajaxHeader.contains("XMLHttpRequest")) {
            return true;
        }
        return false;
    }
}
