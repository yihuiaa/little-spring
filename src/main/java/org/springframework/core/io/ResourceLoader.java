package org.springframework.core.io;

/**
 * ● @author: YiHui
 * ● @date: Created in 23:10  2023/3/21
 */
public interface ResourceLoader {
    Resource getResource(String location);
}
