package org.springframework.beans.core.io;

/**
 * ● @author: YiHui
 * ● @date: Created in 23:10  2023/3/21
 */
public interface ResourceLoader {
    Resource getResource(String location);
}
