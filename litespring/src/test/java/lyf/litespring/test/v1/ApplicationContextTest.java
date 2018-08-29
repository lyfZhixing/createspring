package lyf.litespring.test.v1;

import lyf.litespring.context.ApplicationContext;
import lyf.litespring.context.support.ClassPathApplicationContext;
import lyf.litespring.context.support.FileSystemXmlApplicationContext;
import lyf.litespring.test.service.v1.PetStoreService;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @Author: liyufeng
 * @Description: ApplicationContext 测试用例
 * @Date: Created in 上午11:32 18-8-29
 * @Modified By:
 */
public class ApplicationContextTest {

    @Test
    public void testGetBean() {
        ApplicationContext applicationContext = new ClassPathApplicationContext("petstore-v1.xml");
        PetStoreService petStoreService = (PetStoreService) applicationContext.getBean("petStore");
        assertNotNull(petStoreService);
    }

    @Test
    public void testGetBeanFromFileSystemContext() {
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("./src/test/file/test.xml");
        PetStoreService petStoreService = (PetStoreService) applicationContext.getBean("petStore");
        assertNotNull(petStoreService);
    }
}
