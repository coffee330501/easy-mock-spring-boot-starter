package io.github.coffee330501.easyMock.springBootStarter;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

@Import({MockAspect.class})
@EnableConfigurationProperties(MockConfig.class)
public class EasyMockAutoConfiguration {

}
