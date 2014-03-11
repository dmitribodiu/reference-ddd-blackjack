package org.home.blackjack.core;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.websocket.DeploymentException;
import javax.websocket.server.ServerContainer;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.server.ServerEndpointConfig;

import org.eclipse.jetty.websocket.jsr356.server.AnnotatedServerEndpointConfig;
import org.home.blackjack.core.infrastructure.events.websocket.EchoWSEndpoint;
import org.home.blackjack.core.infrastructure.events.websocket.WebsocketBasedExternalEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;

//@Configuration
public class AppConfig {

    @Inject
    private WebApplicationContext context;

    private ServerContainer container;

    public class SpringServerEndpointConfigurator extends ServerEndpointConfig.Configurator {

        @Override
        public <T> T getEndpointInstance(Class<T> endpointClass) throws InstantiationException {
            return context.getAutowireCapableBeanFactory().createBean(endpointClass);
        }
    }

    @Bean
    public ServerEndpointConfig.Configurator configurator() {

        return new SpringServerEndpointConfigurator();

    }

    @PostConstruct
    public void init() throws DeploymentException {

        container = (ServerContainer) context.getServletContext().getAttribute(javax.websocket.server.ServerContainer.class.getName());

        container.addEndpoint(configForClass(EchoWSEndpoint.class));
        container.addEndpoint(configForClass(WebsocketBasedExternalEventPublisher.class));
    }

    private AnnotatedServerEndpointConfig configForClass(Class<?> clazz) throws DeploymentException {
        return new AnnotatedServerEndpointConfig(clazz, clazz.getAnnotation(ServerEndpoint.class)) {
            @Override
            public Configurator getConfigurator() {
                return configurator();
            }
        };
    }

}
