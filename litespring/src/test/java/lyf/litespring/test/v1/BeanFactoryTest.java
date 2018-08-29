package lyf.litespring.test.v1;

import lyf.litespring.bean.BeanDefinition;
import lyf.litespring.bean.factory.support.DefaultBeanFactory;
import lyf.litespring.bean.factory.xml.XmlBeanDefinitionReader;
import lyf.litespring.core.io.ClassPathResource;
import lyf.litespring.core.io.Resource;
import lyf.litespring.test.service.v1.PetStoreService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @Author: liyufeng
 * @Description: 测试类
 * @Date: Created in 上午10:28 18-8-21
 * @Modified By:
 */
public class BeanFactoryTest {
    DefaultBeanFactory factory = null;
    XmlBeanDefinitionReader xmlBeanDefinitionReader = null;

    @Before
    public void setUp() {
        factory = new DefaultBeanFactory();
        xmlBeanDefinitionReader = new XmlBeanDefinitionReader(factory);
    }

    @Test
    public void testGetBean() {

        Resource resource = new ClassPathResource("petstore-v1.xml");

        xmlBeanDefinitionReader.loadBeanDefinitions(resource);

        BeanDefinition beanDefinition = factory.getBeanDefinition("petStore");

        assertTrue(beanDefinition.isSingleton());

        assertFalse(beanDefinition.isPrototype());

        assertEquals(BeanDefinition.SCOPE_DEFAULT, beanDefinition.getScope());

        assertEquals("lyf.litespring.test.service.v1.PetStoreService",beanDefinition.getBeanClassName());

        PetStoreService petStoreService = (PetStoreService) factory.getBean("petStore");

        assertNotNull(petStoreService);

        PetStoreService petStoreService1 = (PetStoreService) factory.getBean("petStore");

        assertTrue(petStoreService.equals(petStoreService1));

    }
}
