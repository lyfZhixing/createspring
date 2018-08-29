package lyf.litespring.bean.factory.support;

import lyf.litespring.bean.BeanDefinition;
import lyf.litespring.bean.factory.config.ConfigurableBeanFactory;
import lyf.litespring.util.ClassUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: liyufeng
 * @Description: 工厂类的默认实现类，实例化bean对象
 * @Date: Created in 上午10:40 18-8-21
 * @Modified By:
 */
public class DefaultBeanFactory implements ConfigurableBeanFactory, BeanDefinitionRegistry {

    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();
    private ClassLoader beanClassLoader = null;

    public BeanDefinition getBeanDefinition(String beanId) {
        return this.beanDefinitionMap.get(beanId);
    }

    public Object getBean(String beanId) {
        BeanDefinition beanDefinition = this.getBeanDefinition(beanId);
        if (beanDefinition == null) {
            return null;
        }
        ClassLoader classLoader = this.getClassLoader();
        String beanClassName = beanDefinition.getBeanClassName();
        try {
            Class<?> clazz = classLoader.loadClass(beanClassName);
            return clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void registryBeanDefinition(String id, BeanDefinition beanDefinition) {
        this.beanDefinitionMap.put(id, beanDefinition);
    }

    public void setBeanClassLoader(ClassLoader beanClassLoader) {
        this.beanClassLoader = beanClassLoader;
    }

    public ClassLoader getClassLoader() {
        return (this.beanClassLoader != null ? this.beanClassLoader : ClassUtils.getDefaultClassLoader());
    }
}
