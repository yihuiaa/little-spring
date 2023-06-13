package org.springframework.core.io;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * ● @author: YiHui
 * ● @date: Created in 23:36  2023/3/21
 */
public class ClassPathResource implements Resource{
    private final String path;

    public ClassPathResource(String path) {
        this.path = path;
    }

    @Override public InputStream getInputStream() throws FileNotFoundException {
        InputStream stream = this.getClass().getClassLoader().getResourceAsStream(path);
        if (stream == null) {
            throw new FileNotFoundException(this.path + " cannot be opened because it does not exist");
        }
        return stream;

    }
}
