package lyf.litespring.bean.factory.support;

import lyf.litespring.bean.BeanDefinition;

/**
 * @Author: liyufeng
 * @Description:
 * @Date: Created in 上午10:53 18-8-29
 * @Modified By:
 */
public interface BeanDefinitionRegistry {

    void registryBeanDefinition(String id, BeanDefinition beanDefinition);

    BeanDefinition getBeanDefinition(String beanId);
}
