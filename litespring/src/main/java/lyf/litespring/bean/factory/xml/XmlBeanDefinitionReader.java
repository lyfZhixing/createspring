package lyf.litespring.bean.factory.xml;


import lyf.litespring.bean.BeanDefinition;
import lyf.litespring.bean.factory.support.BeanDefinitionRegistry;
import lyf.litespring.bean.factory.support.GenericBeanDefinition;
import lyf.litespring.core.io.Resource;
import lyf.litespring.util.ClassUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/**
 * @Author: liyufeng
 * @Description:
 * @Date: Created in 上午10:38 18-8-29
 * @Modified By:
 */
public class XmlBeanDefinitionReader {

    public static final String ID_ATTRIBUTE = "id";
    public static final String CLASS_ATTRIBUTE = "class";

    BeanDefinitionRegistry registry;

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    public void loadBeanDefinitions(Resource resource) {
        InputStream is = null;
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            is = resource.getInputStream();
            document = reader.read(is);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Element rootElement = document.getRootElement();
        Iterator<Element> iterator = rootElement.elementIterator();
        while(iterator.hasNext()) {
            Element element = (Element) iterator.next();
            String id = element.attributeValue(ID_ATTRIBUTE);
            String className = element.attributeValue(CLASS_ATTRIBUTE);
            BeanDefinition beanDefinition = new GenericBeanDefinition(id,className);
            this.registry.registryBeanDefinition(id, beanDefinition);
        }

    }
}
