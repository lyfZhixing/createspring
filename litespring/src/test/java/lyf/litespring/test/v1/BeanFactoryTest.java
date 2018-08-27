package lyf.litespring.test.v1;

import lyf.litespring.bean.BeanDefinition;
import lyf.litespring.bean.factory.BeanFactory;
import lyf.litespring.bean.factory.support.DefaultBeanFactory;
import lyf.litespring.test.service.v1.PetStoreService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @Author: liyufeng
 * @Description: 测试类
 * @Date: Created in 上午10:28 18-8-21
 * @Modified By:
 */
public class BeanFactoryTest {

    @Test
    public void testGetBean() {

        //1.解析xml
        BeanFactory beanFactory = new DefaultBeanFactory("petstore-v1.xml");
        //1.1 根据id获取bean的属性，类名……
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("petStore");
        assertEquals("lyf.litespring.test.service.v1.PetStoreService",beanDefinition.getBeanClassName());
        //2.获取bean的实例对象
        PetStoreService petStoreService = (PetStoreService)beanFactory.getBean("petStore");
        assertNotNull(petStoreService);

    }
}
