package lyf.litespring.context.support;

import lyf.litespring.core.io.ClassPathResource;
import lyf.litespring.core.io.Resource;

/**
 * @Author: liyufeng
 * @Description:
 * @Date: Created in 上午11:36 18-8-29
 * @Modified By:
 */
public class ClassPathApplicationContext extends AbstractApplicationContext {

    public ClassPathApplicationContext(String configFile) {
        super(configFile);
    }

    @Override
    public Resource getResourceByPath(String configFile) {
        return new ClassPathResource(configFile);
    }
}
