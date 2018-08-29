package lyf.litespring.context.support;

import lyf.litespring.bean.factory.support.DefaultBeanFactory;
import lyf.litespring.bean.factory.xml.XmlBeanDefinitionReader;
import lyf.litespring.context.ApplicationContext;
import lyf.litespring.core.io.Resource;
import lyf.litespring.util.ClassUtils;

/**
 * @Author: liyufeng
 * @Description:
 * @Date: Created in 下午4:28 18-8-29
 * @Modified By:
 */
public abstract class AbstractApplicationContext implements ApplicationContext {
    private DefaultBeanFactory factory = null;
    private ClassLoader beanClassLoader = null;

    /**
     * 根据路径获取Resource 在ClassPathResource和FileSystemResource中重写
     * @param configFile
     * @return
     */
    public abstract Resource getResourceByPath(String configFile);

    public AbstractApplicationContext(String configFile) {
        factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        Resource resource = this.getResourceByPath(configFile);
        reader.loadBeanDefinitions(resource);
        factory.setBeanClassLoader(this.beanClassLoader);
    }

    public Object getBean(String beanId) {
        return factory.getBean(beanId);
    }
    public void setBeanClassLoader(ClassLoader beanClassLoader) {
        this.beanClassLoader = beanClassLoader;
    }

    public ClassLoader getClassLoader() {
        return (this.beanClassLoader != null ? this.beanClassLoader : ClassUtils.getDefaultClassLoader());
    }
}
