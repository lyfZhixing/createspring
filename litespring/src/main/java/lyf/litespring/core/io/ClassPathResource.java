package lyf.litespring.core.io;

import lyf.litespring.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: liyufeng
 * @Description:
 * @Date: Created in 下午3:39 18-8-29
 * @Modified By:
 */
public class ClassPathResource implements Resource {

    private String configFile;
    private ClassLoader classLoader;

    public ClassPathResource(String configFile) {
        this(configFile, (ClassLoader) null);
    }

    public ClassPathResource(String configFile, ClassLoader classLoader) {
        this.configFile = configFile;
        this.classLoader = (classLoader != null ? classLoader :
        ClassUtils.getDefaultClassLoader());
    }

    public InputStream getInputStream() throws IOException {
        InputStream is = this.classLoader.getResourceAsStream(configFile);
        if (is == null) {
            throw new FileNotFoundException("没找到"+configFile);
        }
        return is;
    }

    public String getDescription() {
        return this.configFile;
    }
}
