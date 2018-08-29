package lyf.litespring.util;

/**
 * @Author: liyufeng
 * @Description:
 * @Date: Created in 下午3:58 18-8-29
 * @Modified By:
 */
public class Assert {

    /**
     * 如果为空，抛出非法参数异常
     * @param object
     * @param msg
     */
    public static void notNull(Object object, String msg) {
        if (object == null) {
            throw new IllegalArgumentException(msg);
        }

    }
}
