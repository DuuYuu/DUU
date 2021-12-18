package com.atduu.util;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

/**
 * Created  by DuuYuu on 2021/12/14 20:42
 **/
public class MyUtils {

    /**
     * 字符串转化为数组
     * @param ids
     * @return
     */
    public static List<Long> convertToList(String ids){
        List<Long> list = new ArrayList<>();
        if(!"".equals(ids) && ids != null){

            String[] idarray = ids.split(",");

            for (int i =0 ;i<idarray.length;i++){
                list.add(new Long(idarray[i]));
            }
        }
        return  list;
    }

    /**
     * 获取所有的属性值为空属性名的数组
     * @param obj
     * @return
     */
    public static String[] getNullPropertyNames(Object obj) {

        BeanWrapper beanWrapper = new BeanWrapperImpl(obj);

        PropertyDescriptor[] pds = beanWrapper.getPropertyDescriptors();

        List<String> nullPropertyName = new ArrayList<>();

        for (PropertyDescriptor pd : pds){
            String propertyName = pd.getName();

            if(beanWrapper.getPropertyValue(propertyName) == null) {
                nullPropertyName.add(propertyName);
            }
        }

        return nullPropertyName.toArray(new String[nullPropertyName.size()]);

    }



}
