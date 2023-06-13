package org.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * ● @author: YiHui
 * ● @date: Created in 23:08  2023/3/21
 * ● @notes: 资源抽象
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
