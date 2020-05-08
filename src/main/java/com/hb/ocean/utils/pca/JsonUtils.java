package com.hb.ocean.utils.pca;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Json工具类
 * 
 * @author hyy
 *
 */
public class JsonUtils {
    private JsonUtils() {
        throw new IllegalAccessError("工具类不能实例化");
    }

    private final static ObjectMapper mapper = new FrameObjectMapper();
    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);
    private static ObjectMapper mapperr;
    /**
     * 将对象转转化成Json字符串
     * 
     * @param o
     * @return
     */
    public static String writeValueAsString(Object o) {
        String str = null;
        try {
            str = mapper.writeValueAsString(o);
        } catch (JsonGenerationException e) {
            logger.error(e.getMessage(), e);
        } catch (JsonMappingException e) {
            logger.error(e.getMessage(), e);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return str;
    }

    /**
     * 将对象字符串(不是List格式),转化成对象.
     * 
     * @param content
     * @param clazz
     * @return
     */

    public static <T> T readValue(String content, Class<T> clazz) {
        T t = null;
        try {
            t = mapper.readValue(content, clazz);
        } catch (JsonParseException e) {
            logger.error(e.getMessage(), e);
        } catch (JsonMappingException e) {
            logger.error(e.getMessage(), e);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return t;
    }

    /**
     * 将List对象字符串,转化成List对象.
     * 
     * @param content
     *            字符串内容
     * @param clazz
     *            对象类型 例如 User.class
     * @return
     */
    public static <T> List<T> readValues(String content, Class<T> clazz) {
        return (List<T>) readValues(content, ArrayList.class, clazz);
    }

    /**
     * 将List对象字符串,转化成List对象.
     * 
     * @param content
     *            字符串内容
     * @param collectionClass
     *            集合类型,例如 ArrayList.class
     * @param clazz
     *            对象类型 例如 User.class
     * @return
     */
    public static Object readValues(String content, Class collectionClass, Class clazz) {
        Object o = null;

        try {
            o = mapper.readValue(content, getCollectionType(collectionClass, clazz));
        } catch (JsonParseException e) {
            logger.error(e.getMessage(), e);
        } catch (JsonMappingException e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }

        return o;
    }

    private static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

    /**
     * 将bean、List、Map、Array转成Json字符串
     * @param obj bean、List、Map、Array
     * @return json 字符串
     */
    public static String objToString(Object obj){
        String json;
        if(null == mapperr) mapperr = new ObjectMapper();
        try {
            // 格式化
//			mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, Boolean.TRUE);
            mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            json = mapper.writeValueAsString(obj);
        } catch (Exception e) {
            logger.error("生成JSON字符串出错"+obj.getClass().getName(),e);
            json = "";
        }
        return json;
    }


}
