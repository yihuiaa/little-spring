package ioc;

import cn.hutool.core.io.IoUtil;
import org.junit.Test;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

/**
 * ● @author: YiHui
 * ● @date: Created in 23:49  2023/3/21
 */
public class ResourceLoaderTest {
    @Test
    public void test() throws IOException {
        DefaultResourceLoader loader = new DefaultResourceLoader();
        //classpath下资源的加载
        Resource resource = loader.getResource("classpath:test.txt");
        InputStream inputStream = resource.getInputStream();
        String content =  IoUtil.readUtf8(inputStream);
        System.out.println("classpath - 资源内容测试："+content);

        //文件系统资源的加载
        resource = loader.getResource("src/test/resources/test.txt");
        inputStream = resource.getInputStream();
        content =  IoUtil.readUtf8(inputStream);
        System.out.println("文件系统 - 资源内容测试："+content);
        //url资源的加载
        resource = loader.getResource("https://blog.csdn.net/weixin_43848166");
        inputStream = resource.getInputStream();
        content =  IoUtil.readUtf8(inputStream);
        System.out.println("URL - 资源内容测试："+content);
    }
}
