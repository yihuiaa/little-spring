package org.springframework.core.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * ● @author: YiHui
 * ● @date: Created in 23:21  2023/3/21
 */
public class FileSystemResource implements Resource{
    private final String filePath;

    public FileSystemResource(String filePath) {
        this.filePath = filePath;
    }

    @Override public InputStream getInputStream() throws IOException{
            Path path = new File(this.filePath).toPath();
            return  Files.newInputStream(path);
    }
}
