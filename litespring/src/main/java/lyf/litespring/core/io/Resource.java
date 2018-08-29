package lyf.litespring.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: liyufeng
 * @Description:
 * @Date: Created in 下午3:35 18-8-29
 * @Modified By:
 */
public interface Resource {
    /**
     * 获取资源输入流
     * @return
     * @throws IOException
     */
    InputStream getInputStream() throws IOException;

    /**
     * 资源描述
     * @return
     */
    String getDescription();
}
