package org.springframework.beans.core.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * ● @author: YiHui
 * ● @date: Created in 23:40  2023/3/21
 */
public class UrlResource implements Resource{
    private final URL url;

    public UrlResource(URL url) {
        this.url = url;
    }

    @Override public InputStream getInputStream() throws IOException {
        URLConnection urlConnection = this.url.openConnection();
        return urlConnection.getInputStream();
    }
}
