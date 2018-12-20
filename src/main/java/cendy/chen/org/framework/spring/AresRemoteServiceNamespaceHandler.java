package cendy.chen.org.framework.spring;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * 服务发布自定义标签
 *
 */
public class AresRemoteServiceNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("service", new ProviderFactoryBeanDefinitionParser());
    }
}
