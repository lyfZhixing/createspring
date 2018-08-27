package lyf.litespring.bean;


/**
 * @Author: liyufeng
 * @Description: 异常处理
 * @Date: Created in 上午11:51 18-8-21
 * @Modified By:
 */
public class BeansException extends RuntimeException {
    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
