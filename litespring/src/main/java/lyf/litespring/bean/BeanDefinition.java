package lyf.litespring.bean;

/**
 * @Author: liyufeng
 * @Description: 接口,存储bean的属性等
 * @Date: Created in 上午10:42 18-8-21
 * @Modified By:
 */
public interface BeanDefinition {
    String SCOPE_DEFAULT = "singleton";
    String SCOPE_PROTOTYPE = "prototype";

    /**
     * 获取Bean类名
     * @return
     */
    String getBeanClassName();

    boolean isSingleton();

    boolean isPrototype();

    String getScope();

    void setScope(String scope);

}
