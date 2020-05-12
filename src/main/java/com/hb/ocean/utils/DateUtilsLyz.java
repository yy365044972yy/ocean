package com.hb.ocean.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.util.Calendar.getInstance;

/**
 * 
 * 日期,时间工具类
 */
public class DateUtilsLyz {

	/**
	 * 默认的日期格式化样式
	 */
	public static final String DAY_PATTERN = "yyyy-MM-dd";
	public static final String DAY_PATTERN_TWO="yyyy/MM/dd";
	public static final String DAY_PATTERN_DATE="yyyy/MM/dd HH:mm:ss";
	public static final String DAY_PATTERN_DATE_HM="yyyy-MM-dd HH:mm";
	public final static char[] upper = "〇一二三四五六七八九十".toCharArray();
	/**
	 * 默认的时间格式化样式
	 */
	public static final String TIME_PATTERN = "HH:mm:ss";

	public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss:SSS";

	/**
	 * 将Date格式化成符合默认格式的字符串
	 *
	 * @param date
	 * @return 返回样例:2012-03-29 14:32:23
	 */
	public static String format(Date date) {
		SimpleDateFormat formatTool = new SimpleDateFormat();
		formatTool.applyPattern(DAY_PATTERN + " " + TIME_PATTERN);
		return formatTool.format(date);
	}
	/**
	 * 将Date格式化成yyyyMMddHHmm格式
	 * @param date
	 * @return 返回样例：201304152022
	 */
	public static String formatBatch(Date date){
		SimpleDateFormat formatTool = new SimpleDateFormat();
		formatTool.applyPattern("yyyyMMddHHmm");
		return formatTool.format(date);
	}
	/**
	 * 将Date格式化成符合默认日期格式的字符串
	 *
	 * @param date
	 * @return 返回样例:2012-03-29
	 */
	public static String formatDate(Date date) {
		SimpleDateFormat formatTool = new SimpleDateFormat();
		formatTool.applyPattern(DAY_PATTERN);
		return formatTool.format(date);
	}

	/**
	 * 获取当年的第一天
	 * @param
	 * @return
	 */
	public static Date getCurrYearFirst(){
		Calendar currCal=Calendar.getInstance();
		int currentYear = currCal.get(Calendar.YEAR);
		return getYearFirst(currentYear);
	}

	/**
	 * 获取某年第一天日期
	 * @param year 年份
	 * @return Date
	 */
	public static Date getYearFirst(int year){
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		Date currYearFirst = calendar.getTime();
		return currYearFirst;
	}



	/**
	 * 将Date格式化成符合默认时间格式的字符串
	 *
	 * @param date
	 * @return 返回样例:14:32:23
	 */
	public static String formatTime(Date date) {
		SimpleDateFormat formatTool = new SimpleDateFormat();
		formatTool.applyPattern(TIME_PATTERN);
		return formatTool.format(date);
	}

	/**
	 * 按照pattern格式格式化Date
	 *
	 * @param date
	 * @param pattern
	 *            样例: yyyy/MM/dd
	 * @return 返回样例:2012/03/29
	 */
	public static String format(Date date, String pattern) {
		SimpleDateFormat formatTool = new SimpleDateFormat();
		formatTool.applyPattern(pattern);
		return formatTool.format(date);
	}

	/**
	 * 将符合默认格式的字符串转换成Date
	 *
	 * @param dateValue
	 *            样例:2012-03-29 14:32:23
	 * @return
	 * @throws ParseException
	 */
	public static Date parse(String dateValue) throws ParseException {
		SimpleDateFormat formatTool = new SimpleDateFormat();
		formatTool.applyPattern(DAY_PATTERN + " " + TIME_PATTERN);
		return formatTool.parse(dateValue);
	}

	/**
	 * 将符合默认格式的日期字符串转换成Date
	 *
	 * @param dateValue
	 *            样例:2012-03-29
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDate(String dateValue) throws ParseException {
		SimpleDateFormat formatTool = new SimpleDateFormat();
		if(dateValue.contains("-")){
			formatTool.applyPattern(DAY_PATTERN);
		}else if(dateValue.contains("/")){
			formatTool.applyPattern(DAY_PATTERN_TWO);
		}else if(dateValue.contains("/")&&dateValue.contains(":")){
			formatTool.applyPattern(DAY_PATTERN_DATE);
		}else if(dateValue.contains("-")&&dateValue.contains(":")){
			formatTool.applyPattern("yyyy-MM-dd HH:mm:ss");
		}
		return formatTool.parse(dateValue);
	}

	/**
	 * 将符合pattern格式的dateValue转换成Date
	 *
	 * @param dateValue
	 *            样例:2012/03/29
	 * @param pattern
	 *            样例:yyyy/MM/dd
	 * @return
	 * @throws ParseException
	 */
	public static Date parse(String dateValue, String pattern)
			throws ParseException {
		SimpleDateFormat formatTool = new SimpleDateFormat();
		formatTool.applyPattern(pattern);
		return formatTool.parse(dateValue);
	}

	/**
	 * 返回这一天的最早的时候
	 *
	 * @param date
	 * @return
	 */
	public static Date getEarliest(Date date) {
		return parseTime(date, 0, 0, 0, 0);
	}

	/** 返回当前日期当月的最早时间
	 *
	 * */
	public static Date getEarliestDay(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		return parseTime(cal.getTime(), 0, 0, 0, 0);
	}

	/** 返回当前日期当月的最晚时间
	 *
	 * */
	public static Date getLatestDay(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		return parseTime(cal.getTime(), 23, 59, 59, 999);
	}

	public static void main(String[] args) {
		System.out.println(DateUtilsLyz.getUpperYear("2010"));

	}

	/**
	 * 返回这一天的最晚时候
	 *
	 * @param date
	 * @return
	 */
	public static Date getLastest(Date date) {
		return parseTime(date, 23, 59, 59, 999);
	}

	/**
	 * 得到指定月的天数
	 *
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getMonthLastDay(int year, int month) {
		Calendar a = Calendar.getInstance();
		a.set(Calendar.YEAR, year);
		a.set(Calendar.MONTH, month - 1);
		a.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		a.roll(Calendar.DATE, -1);// 日期回滚一天，也就是最后一天
		int maxDate = a.get(Calendar.DATE);
		return maxDate;
	}

	/**
	 * 得到指定月的第一天
	 *
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date getFirstDayOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DAY_OF_MONTH,cal.getMinimum(Calendar.DATE));
		Date theDate = cal.getTime();
		return theDate;
	}

	/**
	 * 得到指定月的最后一天
	 *
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date getLastDayOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DATE));
		Date theDate = cal.getTime();
		return theDate;
	}

	/**
	 * @Title: getMonthLastDay
	 * @Description: 取当月第一天最早时候
	 * @author  lyz
	 */
	public static Date getMonthFirstDay() {
		Calendar a = Calendar.getInstance();
		a.setTime(new Date());
		a.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		return a.getTime();
	}

	/**
	 * @Title: getMonthLastDay
	 * @Description: 取当月最后一天最晚时候
	 * @author  lyz
	 */
	public static Date getMonthLastDay() {
		Calendar a = Calendar.getInstance();
		a.setTime(new Date());
		final   int   lastDay   =   a.getActualMaximum(Calendar.DAY_OF_MONTH);
		a.set(Calendar.DATE, lastDay);
		return a.getTime();
	}


	/**
	 * 计算两个时间相差天数
	 * @param early
	 * @param late
	 * @return
	 */
	public static final int daysBetween(Date early, Date late) {

		Calendar calst = Calendar.getInstance();
		Calendar caled = Calendar.getInstance();
		calst.setTime(early);
		caled.setTime(late);
		//设置时间为0时
		calst.set(Calendar.HOUR_OF_DAY, 0);
		calst.set(Calendar.MINUTE, 0);
		calst.set(Calendar.SECOND, 0);
		caled.set(Calendar.HOUR_OF_DAY, 0);
		caled.set(Calendar.MINUTE, 0);
		caled.set(Calendar.SECOND, 0);
		//得到两个日期相差的天数
		int days = ((int) (caled.getTime().getTime() / 1000) - (int) (calst
				.getTime().getTime() / 1000)) / 3600 / 24;

		return days;
	}

	/**
	 * 返回指定时间加上num天后的时间
	 *
	 * @param date
	 * @param num
	 * @return
	 */
	public static Date add(Date date, int num) {
		Calendar a = Calendar.getInstance();
		a.setTime(date);
		a.add(Calendar.DAY_OF_MONTH, num);
		return a.getTime();
	}


	/**
	 * 得到几天前的时间
	 * @param d
	 * @param day
	 * @return
	 */
	public static Date getDateBefore(Date d,int day){
		Calendar now =Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.DATE,now.get(Calendar.DATE)-day);
		return now.getTime();
	}


	/**
	 * 返回false：date=null，date是1970年；其它都返回true
	 *
	 * @param date
	 * @return
	 */
	public static boolean isNotEmpty(Date date) {
		if (date != null) {
			Calendar a = Calendar.getInstance();
			a.setTime(date);
			return a.get(Calendar.YEAR) != 1970;
		}
		return Boolean.FALSE;
	}

	/**
	 * 获得date的小时数0-23
	 *
	 * @param date
	 * @return
	 */
	public static int getHours(Date date) {
		Calendar a = Calendar.getInstance();
		a.setTime(date);
		return a.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 获得date是一周的第几天，注意：周日 返回 1，周六 返回 7
	 *
	 * @param date
	 * @return
	 */
	public static int getDay(Date date) {
		Calendar a = Calendar.getInstance();
		a.setTime(date);
		return a.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 设定date的时间细节
	 *
	 * @param date
	 *            要设定时间细节的date
	 * @param hourOfDay
	 *            0-23
	 * @param minute
	 *            0-59
	 * @param second
	 *            0-59
	 * @param milliSecond
	 *            0-999
	 * @return
	 */
	public static Date parseTime(Date date, int hourOfDay, int minute,
								 int second, int milliSecond) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		setCalendarTime(cal, hourOfDay, minute, second, milliSecond);
		return cal.getTime();

	}

	/**
	 * 设定date的时间细节
	 *
	 * @param date
	 *            要设定时间细节的date
	 * @param timeDetail
	 *            以:号分隔的24小时制的时间，例:16:23:42:267 或 16(等同于16:00:00:000)
	 * @return
	 */
	public static Date parseTime(Date date, String timeDetail) {
		List<String> strList = new ArrayList<String>();
		strList.addAll(Arrays.asList(timeDetail.split(":")));
		while (strList.size() < 4) {
			strList.add("0");
		}
		return parseTime(date, Integer.parseInt(strList.get(0)),
				Integer.parseInt(strList.get(1)),
				Integer.parseInt(strList.get(2)),
				Integer.parseInt(strList.get(3)));
	}

	/**
	 * 指定时间 是否在 当前时间 之后，注：和日期无关
	 *
	 * @param time
	 *            指定的时间， 传入样例:16:23:42:267 或 16(等同于16:00:00:000)
	 * @return
	 */
	public static boolean isAfterTime(String time) {
		Date date = parseTime(new Date(), time);
		return date.after(new Date());
	}

	/**
	 * 指定时间 是否在 当前时间 之前，注：和日期无关
	 *
	 * @param time
	 *            指定的时间， 传入样例:16:23:42:267 或 16(等同于16:00:00:000)
	 * @return
	 */
	public static boolean isBeforeTime(String time) {
		Date date = parseTime(new Date(), time);
		return date.before(new Date());
	}

	private static void setCalendarTime(Calendar cal, int hourOfDay,
										int minute, int second, int milliSecond) {
		cal.set(Calendar.HOUR_OF_DAY, hourOfDay);
		cal.set(Calendar.MINUTE, minute);
		cal.set(Calendar.SECOND, second);
		cal.set(Calendar.MILLISECOND, milliSecond);
	}


	public static  String setEndDate(Date endTime) {
		Calendar calendar = getInstance();
		if(endTime!=null){
			calendar.setTime(endTime);
			calendar.add(Calendar.DATE, 1);
		}
		return  endTime==null ? "":DateUtilsLyz.format(calendar.getTime()) ;
	}

	/*
	 * 将中国标准时间改为标准日期时间格式
	 */
	public static Date changeStandard(String standardDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss 'GMT'Z", Locale.ENGLISH);
		Date dd = sdf.parse(standardDate); //将字符串改为date的格式
		String resDate= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dd);
		Date date = parse(resDate);
		return date;
	}

	/**
	 * 获取给定日期所在周(周一为第一天)的最早时间
	 * @Title: getEarliestOfWeek
	 * @param date 日期
	 * @return
	 * @author:  lyz
	 * @date: 2019年4月17日 上午10:43:14
	 */
	public static Date getEarliestOfWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, c.getActualMinimum(Calendar.DAY_OF_WEEK) + 1);
		c.set(Calendar.HOUR_OF_DAY, c.getActualMinimum(Calendar.HOUR_OF_DAY));
		c.set(Calendar.MINUTE, c.getActualMinimum(Calendar.MINUTE));
		c.set(Calendar.SECOND, c.getActualMinimum(Calendar.SECOND));
		return c.getTime();
	}

	/**
	 * 获取给定日期所在周(周一为第一天)的最晚时间
	 * @Title: getLatestOfWeek
	 * @param date 日期
	 * @return
	 * @author:  lyz
	 * @date: 2019年4月17日 上午10:43:37
	 */
	public static Date getLatestOfWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, c.getActualMaximum(Calendar.DAY_OF_WEEK) + 1);
		c.set(Calendar.HOUR_OF_DAY, c.getActualMaximum(Calendar.HOUR_OF_DAY));
		c.set(Calendar.MINUTE, c.getActualMaximum(Calendar.MINUTE));
		c.set(Calendar.SECOND, c.getActualMaximum(Calendar.SECOND));
		return c.getTime();
	}

	/**
	 * 获取给定日期所在月的最早时间
	 * @params: [date]
	 * @return: java.util.Date
	 * @auther:  lyz
	 * @date: 2019/6/24 17:55
	 */
	public static Date getEarliestOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
		c.set(Calendar.HOUR_OF_DAY, c.getActualMinimum(Calendar.HOUR_OF_DAY));
		c.set(Calendar.MINUTE, c.getActualMinimum(Calendar.MINUTE));
		c.set(Calendar.SECOND, c.getActualMinimum(Calendar.SECOND));
		return c.getTime();
	}

	/**
	 * 获取给定日期所在月的最早时间
	 * @params: [date]
	 * @return: java.util.Date
	 * @auther: lyz
	 * @date: 2019/6/24 17:55
	 */
	public static Date getLatestOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		c.set(Calendar.HOUR_OF_DAY, c.getActualMaximum(Calendar.HOUR_OF_DAY));
		c.set(Calendar.MINUTE, c.getActualMaximum(Calendar.MINUTE));
		c.set(Calendar.SECOND, c.getActualMaximum(Calendar.SECOND));
		return c.getTime();
	}

	/**
	 * 获取给定日期所在年的最早时间
	 * @Title: getEarliestTimeOfYear
	 * @param date
	 * @return xxxx-xx-xx 00:00:00
	 * @author:  lyz
	 * @date: 2019年4月18日 下午3:50:49
	 */
	public static Date getEarliestTimeOfYear(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_YEAR, c.getActualMinimum(Calendar.DAY_OF_YEAR));
		c.set(Calendar.HOUR_OF_DAY, c.getActualMinimum(Calendar.HOUR_OF_DAY));
		c.set(Calendar.MINUTE, c.getActualMinimum(Calendar.MINUTE));
		c.set(Calendar.SECOND, c.getActualMinimum(Calendar.SECOND));
		return c.getTime();
	}

	/**
	 * 获取给定日期所在年的最晚时间
	 * @Title: getLatestTimeOfYear
	 * @param date
	 * @return xxxx-xx-xx 23:59:59
	 * @author: lyz
	 * @date: 2019年4月18日 下午3:51:16
	 */
	public static Date getLatestTimeOfYear(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_YEAR, c.getActualMaximum(Calendar.DAY_OF_YEAR));
		c.set(Calendar.HOUR_OF_DAY, c.getActualMaximum(Calendar.HOUR_OF_DAY));
		c.set(Calendar.MINUTE, c.getActualMaximum(Calendar.MINUTE));
		c.set(Calendar.SECOND, c.getActualMaximum(Calendar.SECOND));
		return c.getTime();
	}

	/**
	 * 获取时间的年份
	 * @param date
	 * @return
	 */
	public static int getYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.YEAR);
		return month;
	}
	/**
	 * 获取时间的月份
	 * @param date
	 * @return
	 */
	public static int getDataMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH)+1;
		return month;
	}
	/**
	 * 获取时间的日
	 * @param date
	 * @return
	 */
	public static int getDataDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.DAY_OF_MONTH);
		return month;
	}

	/**
	 * 获取当前年
	 * @return
	 */
	public static int getYear() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int month = cal.get(Calendar.YEAR);
		return month;
	}

	/**
	 * 获取当前月份
	 * @param
	 * @return
	 */
	public static int getMonth() {
		Calendar cal = Calendar.getInstance();
		int nowmonth = cal.get(Calendar.MONTH) + 1;
		return nowmonth;
	}



	/**
	 * 获取某个月有多少天
	 * @param date
	 * @return
	 */
	public static int getDaysOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 获取当前年
	 * @return
	 */
	public static int getDataYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.YEAR);
		return month;
	}

	public static String getUpperYear(String date) {
		if(date == null) return null;
		if(date.length() != 4) return null;
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<4;i++) {//年
			sb.append(upper[Integer.parseInt(date.substring(i, i+1))]);
		}
		return sb.toString();
	}


	public static String getUpperDate(String date) {
		//支持yyyy-MM-dd、yyyy/MM/dd、yyyyMMdd等格式
		if(date == null) return null;
		//非数字的都去掉
		date = date.replaceAll("\\D", "");
		if(date.length() != 8) return null;
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<4;i++) {//年
			sb.append(upper[Integer.parseInt(date.substring(i, i+1))]);
		}
		sb.append("年");//拼接年
		int month = Integer.parseInt(date.substring(4, 6));
		if(month <= 10) {
			sb.append(upper[month]);
		} else {
			sb.append("十").append(upper[month%10]);
		}
		sb.append("月");//拼接月

		int day = Integer.parseInt(date.substring(6));
		if (day <= 10) {
			sb.append(upper[day]);
		} else if(day < 20) {
			sb.append("十").append(upper[day % 10]);
		} else {
			sb.append(upper[day / 10]).append("十");
			int tmp = day % 10;
			if (tmp != 0) sb.append(upper[tmp]);
		}
		sb.append("日");//拼接日
		return sb.toString();
	}
	
	
	/**
	* TODO
	* @Author lyz
	* @Date 2020/4/18 11:48
	* @param 
	 * @param a  开始时间
	 * @param b  结束时间
	* @return int
	*/
	public static  int getMinunits(Date a,Date b){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long createTime = a.getTime();
		long oldTime = b.getTime();
		long diff=(oldTime-createTime)/1000/60;
        return (int)diff;
	}

}
