package org.diorite.web.cms.core;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "org.diorite.web.cms.*")
@EntityScan("org.diorite.web.cms.*")
@EnableJpaRepositories("org.diorite.web.cms.*")
@EnableCaching
public class DioriteCms extends SpringBootServletInitializer
{
    private static DioriteCms INSTANCE;
    private final Logger logger = Logger.getLogger("DioriteCMS");

    public DioriteCms()
    {
    }

    private void run()
    {
    }

    public Logger getLogger()
    {
        return this.logger;
    }

    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder builder)
    {
        return builder.sources(DioriteCms.class);
    }

    public static void main(final String[] args)
    {
        DioriteCms.INSTANCE = new DioriteCms();
        SpringApplication.run(DioriteCms.class, args);
        DioriteCms.INSTANCE.run();
    }

    public static DioriteCms getInstance()
    {
        return INSTANCE;
    }
}
