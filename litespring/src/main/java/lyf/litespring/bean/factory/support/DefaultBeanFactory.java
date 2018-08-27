package lyf.litespring.bean.factory.support;

import lyf.litespring.bean.BeanDefinition;
import lyf.litespring.bean.factory.BeanFactory;
import lyf.litespring.util.ClassUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: liyufeng
 * @Description: 工厂类的默认实现类，实例化bean对象
 * @Date: Created in 上午10:40 18-8-21
 * @Modified By:
 */
public class DefaultBeanFactory implements BeanFactory {

    public static final String ID_ATTRIBUTE = "id";
    public static final String CLASS_ATTRBUTR = "class";
    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    public DefaultBeanFactory(String configFielName) {
        loadBeanDefinition(configFielName);
    }

    public void loadBeanDefinition(String configFiel) {
        InputStream is = null;
        try {
            ClassLoader cl = ClassUtils.getDefaultClassLoader();
            is = cl.getResourceAsStream(configFiel);
            SAXReader reader = new SAXReader();
            Document document = reader.read(is);

            Element element = document.getRootElement();
            Iterator<Element> iter = element.elementIterator();
            while (iter.hasNext()) {
                Element element1 = (Element) iter.next();
                String id = element1.attributeValue(ID_ATTRIBUTE);
                String beanClassName = element1.attributeValue(CLASS_ATTRBUTR);
                BeanDefinition beanDefinition = new GenericBeanDefinition(id, beanClassName);
                this.beanDefinitionMap.put(id,beanDefinition);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }


    }

    public BeanDefinition getBeanDefinition(String beanId) {
        return this.beanDefinitionMap.get(beanId);
    }

    public Object getBean(String beanId) {
        BeanDefinition beanDefinition = this.getBeanDefinition(beanId);
        if (beanDefinition == null) {
            return null;
        }
        ClassLoader classLoader = ClassUtils.getDefaultClassLoader();
        String beanClassName = beanDefinition.getBeanClassName();
        try {
            Class<?> clazz = classLoader.loadClass(beanClassName);
            return clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return null;
    }
}
