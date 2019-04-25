import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @ClassName: GlobalDateUtil
 * @Author: Mr_Deer
 * @Date: 2019/4/10 22:03
 * @Description: 日期工具类
 */
public class GlobalDateUtil {

    private static final String FORMAT_DATE = "yyyy-MM-dd";
    private static final String FORMAT_DATE_TIME = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期转字符串（不包含时分秒）
     *
     * @param date 被格式化日期
     * @return 格式化后字符串
     */
    public static String date2String(Date date) {
        if (GlobalUtil.isEmpty(date))
            return null;
        return new SimpleDateFormat(FORMAT_DATE).format(date);

    }

    /**
     * 日期转字符串（自定义格式）
     *
     * @param date 被格式化日期
     * @return 格式化后字符串
     */
    public static String date2String(Date date, String format) {
        if (GlobalUtil.isEmpty(date))
            return null;
        if (GlobalUtil.isEmpty(format))
            return date2String(date);
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 日期转字符串（包含时分秒）
     *
     * @param date 被格式化日期
     * @return 格式化后字符串
     */
    public static String dateTime2String(Date date) {
        if (GlobalUtil.isEmpty(date))
            return null;
        return new SimpleDateFormat(FORMAT_DATE_TIME).format(date);
    }

    /**
     * 日期转 LocalDate
     *
     * @param date 被格式化日期
     * @return LocalDate
     */
    public static LocalDate date2LocalDate(Date date) {
        if (GlobalUtil.isEmpty(date))
            return null;
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * 日期转 LocalDateTime
     *
     * @param date 被格式化日期
     * @return LocalDateTime
     */
    public static LocalDateTime date2LocalDateTime(Date date) {
        if (GlobalUtil.isEmpty(date))
            return null;
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * localDate转 日期
     *
     * @param localDate localDate
     * @return 日期
     */
    public static Date localDate2Date(LocalDate localDate) {
        if (GlobalUtil.isEmpty(localDate))
            return null;
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }

    /**
     * localDateTime转 日期
     *
     * @param localDateTime localDateTime
     * @return 日期
     */
    public static Date localDateTime2Date(LocalDateTime localDateTime) {
        if (GlobalUtil.isEmpty(localDateTime))
            return null;
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }

    /**
     * 毫秒数转秒
     *
     * @param milliseconds 被转格式毫秒数
     * @return 秒
     */
    public static long milliseconds2Second(long milliseconds) {
        return milliseconds / 1000;
    }

    /**
     * 毫秒数转分
     *
     * @param milliseconds 被转格式毫秒数
     * @return 分
     */
    public static long milliseconds2Minute(long milliseconds) {
        return (milliseconds2Second(milliseconds) / 60);
    }

    /**
     * 毫秒数转小时
     *
     * @param milliseconds 被转格式毫秒数
     * @return 小时
     */
    public static long milliseconds2Hour(long milliseconds) {
        return (milliseconds2Minute(milliseconds) / 60);
    }

}
