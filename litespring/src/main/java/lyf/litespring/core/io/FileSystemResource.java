package lyf.litespring.core.io;

import lyf.litespring.util.Assert;
import lyf.litespring.util.ClassUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: liyufeng
 * @Description:
 * @Date: Created in 下午3:50 18-8-29
 * @Modified By:
 */
public class FileSystemResource implements Resource {

    private final String configFile;
    private final File file;

    public FileSystemResource(String configFile) {
        Assert.notNull(configFile, "path must be not null");
        this.file = new File(configFile);
        this.configFile = configFile;
    }

    public InputStream getInputStream() throws IOException {

        return new FileInputStream(this.file);
    }

    public String getDescription() {
        return configFile ;
    }
}
