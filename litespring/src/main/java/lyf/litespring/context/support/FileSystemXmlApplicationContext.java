package lyf.litespring.context.support;

import lyf.litespring.core.io.FileSystemResource;
import lyf.litespring.core.io.Resource;

/**
 * @Author: liyufeng
 * @Description:
 * @Date: Created in 下午4:17 18-8-29
 * @Modified By:
 */
public class FileSystemXmlApplicationContext extends AbstractApplicationContext {
    public FileSystemXmlApplicationContext(String configFile) {
        super(configFile);
    }

    @Override
    public Resource getResourceByPath(String configFile) {
        return new FileSystemResource(configFile);
    }
}
