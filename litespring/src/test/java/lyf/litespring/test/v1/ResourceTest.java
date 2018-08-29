package lyf.litespring.test.v1;

import lyf.litespring.core.io.ClassPathResource;
import lyf.litespring.core.io.FileSystemResource;
import lyf.litespring.core.io.Resource;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: liyufeng
 * @Description:
 * @Date: Created in 下午3:30 18-8-29
 * @Modified By:
 */
public class ResourceTest {
    @Test
    public void testClassPathResource() throws IOException {
        Resource resource = new ClassPathResource("petstore-v1.xml");
        InputStream is = null;
        is = resource.getInputStream();
        Assert.assertNotNull(is);
    }

    @Test
    public void testFileSystemResource() throws IOException {
        Resource resource = new FileSystemResource("./src/test/file/test.xml");
        InputStream is = null;
        is = resource.getInputStream();
        Assert.assertNotNull(is);
    }
}
