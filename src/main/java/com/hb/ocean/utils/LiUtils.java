package com.hb.ocean.utils;


import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class LiUtils {
    /**
     *
     * @param maps
     * @param fx 0为第一个值当key，1相反
     * @return
     */
    public static Map<String, Object> listMapToMap(List<Map<String, Object>> maps, Integer fx) {
        Map<String, Object> mapAll = new HashMap<>();

        for (Map<String, Object> map : maps) {
            String num0 = "";
            String num1 = "";
            int i = 0;
            for (String key:map.keySet()) {
                if (i == 0) {
                    if (fx == 1) {
                        num1 =map.get(key)==null?"":map.get(key).toString();
                    } else {
                        num0 = map.get(key)==null?"":map.get(key).toString();
                    }
                } else if (i == 1) {

                    if (fx == 1) {
                        num0 = map.get(key)==null?"":map.get(key).toString();
                    } else {
                        num1 = map.get(key)==null?"":map.get(key).toString();
                    }
                }
                i++;
            }
            mapAll.put(num0, num1);
        }
        return mapAll;
    }


    /**
     * 专门为逗号拼接信用代码
     *
     * @param list
     * @return
     */
    public static String listMapRoadTransportNo(List<Map<String, Object>> list) {
        if (list.size() == 0) {
            return "0";
        }
        String roadTransportNO = "";
        for (Map<String, Object> m2 : list) {
            Iterator<Map.Entry<String, Object>> itm2 = m2.entrySet().iterator();
            while (itm2.hasNext()) {
                Map.Entry<String, Object> entry2 = itm2.next();

                roadTransportNO += entry2.getValue() + ",";
            }
        }
        roadTransportNO = roadTransportNO.substring(0, roadTransportNO.length() - 1);
        return roadTransportNO;
    }

    /**
     *
     * @param size 文件大小 kb
     * @param e 写0
     * @return
     */
    public static String getSize(Double size, int e) {
        DecimalFormat df_double = new DecimalFormat("0.00000");// 设置保留位数
        if (size < 1024 && e == 0) {
            if (Math.round(size) - size == 0) {
//            Integer.parseInt();

            }
            return size + "KB";
        }
        Double b = Double.valueOf(df_double.format(size / 1024));
        if (b > 1024) {
            return getSize(b, e++);
        }

        DecimalFormat df_99 = new DecimalFormat("#.00");
        Double dob = Double.valueOf(df_99.format(b));

        BigDecimal bg = new BigDecimal(b).setScale(2, RoundingMode.UP);
        double num = bg.doubleValue();
        String cxl = "";
        String type = "KB";
        if (e == 1) {
            type = "MB";
        }
        if (e == 2) {
            type = "GB";
        }
        if (e == 3) {
            type = "TB";
        }
        if (Math.round(num) - num == 0) {
            cxl = String.valueOf((long) num) + type;

        } else {
            cxl = dob + type;
        }

        return cxl;
    }


    public static int IdNOToAge(String IdNO){
        int leh = IdNO.length();
        String dates="";
        if (leh == 18) {
            int se = Integer.valueOf(IdNO.substring(leh - 1)) % 2;
            dates = IdNO.substring(6, 10);
            SimpleDateFormat df = new SimpleDateFormat("yyyy");
            String year=df.format(new Date());
            int u=Integer.parseInt(year)-Integer.parseInt(dates);
            return u;
        }else{
            dates = IdNO.substring(6, 8);
            return Integer.parseInt(dates);
        }

    }


    /**
     *
     * @param id
     * @return 身份证号码脱敏
     */
    public static String idEncrypt(String id) {
        if (StringUtils.isEmpty(id) || (id.length() < 11)) {
            return id;
        }
        return id.replaceAll("(?<=\\w{6})\\w(?=\\w{4})", "*");
    }

    public static String cardnoToSex(String cardno){
        int sexNum = Integer.valueOf(cardno.substring(cardno.length()-2,cardno.length()-1));
        if(sexNum %2 ==1){
            return "男";
        }
        if(sexNum %2 ==0){
            return "女";
        }
        return "";
    }

}
