package com.digitalx;

import com.digitalx.listener.EliminateCommentListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DigitalXApplication extends SpringBootServletInitializer {

    // 重写configure方法，否则在部署到tomcat时，接口将访问不到
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DigitalXApplication.class);
    }

    public static void main(String[] args) {

        SpringApplication application = new SpringApplication(DigitalXApplication.class);
        // 添加一个初始化监听器，对映射地址配置进行加载
        application.addListeners(new EliminateCommentListener());
        application.run(args);


    }

}
