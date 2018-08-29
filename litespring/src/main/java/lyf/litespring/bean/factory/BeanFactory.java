package lyf.litespring.bean.factory;

import lyf.litespring.bean.BeanDefinition;

/**
 * @Author: liyufeng
 * @Description: 工厂类，返回bean的实例
 * @Date: Created in 上午10:40 18-8-21
 * @Modified By:
 */
public interface BeanFactory {

    /**
     *
     * @param beanId
     * @return
     */
    Object getBean(String beanId);

}
