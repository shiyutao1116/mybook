package com.yutao.shi.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author shiyutao
 * @create 2021-10-21 14:26
 */
public class Webutils {
    public  static <T> T copyparmtobean(Map value, T bean){
        try {
            BeanUtils.populate(bean,value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

return bean;
    }
    public static int parseint(String strint,int defaultvalue) {
        try {
            return Integer.parseInt(strint);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultvalue;

    }
}
