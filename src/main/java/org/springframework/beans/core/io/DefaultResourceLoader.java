package org.springframework.beans.core.io;

import java.net.URL;

/**
 * ● @author: YiHui
 * ● @date: Created in 23:45  2023/3/21
 */
public class DefaultResourceLoader implements ResourceLoader{
    public  static final String CLASSPATH_URL_PREFIX = "classpath:";
    @Override public Resource getResource(String location) {
        if(location.startsWith(CLASSPATH_URL_PREFIX)){
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        }else {
            try {
                URL url = new URL(location);
                return new UrlResource(url);
            }catch (Exception e){
                return new FileSystemResource(location);
            }

        }
    }
}
