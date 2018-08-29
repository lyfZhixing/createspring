package lyf.litespring.test.v1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @Author: liyufeng
 * @Description:
 * @Date: Created in 下午3:21 18-8-29
 * @Modified By:
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ApplicationContextTest.class,
        BeanFactoryTest.class,
        ResourceTest.class})
public class V1AllTest {
}
