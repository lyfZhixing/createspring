package lyf.litespring.bean.factory.config;

import lyf.litespring.bean.factory.BeanFactory;

/**
 * @Author: liyufeng
 * @Description: 可配置的BeanFactory
 * @Date: Created in 下午4:48 18-8-29
 * @Modified By:
 */
public interface ConfigurableBeanFactory extends BeanFactory {
    /**
     * set ClassLoader
     * @param beanClassLoader
     */
    void setBeanClassLoader(ClassLoader beanClassLoader);

    /**
     * get ClassLoader
     * @return
     */
    ClassLoader getClassLoader();
}
