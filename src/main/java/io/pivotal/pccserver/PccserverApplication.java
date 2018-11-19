package io.pivotal.pccserver;

import org.apache.geode.cache.Cache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.gemfire.PartitionedRegionFactoryBean;
import org.springframework.data.gemfire.config.annotation.CacheServerApplication;
import org.springframework.data.gemfire.config.annotation.EnableLocator;
import org.springframework.data.gemfire.config.annotation.EnableManager;

@SpringBootApplication
@CacheServerApplication(name = "SpringBootGemFireServer")
@EnableLocator(port = 20388)
@EnableManager
public class PccserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(PccserverApplication.class, args);
	}

	@Bean(name = "formula1region")
	PartitionedRegionFactoryBean formual1Region(Cache gemfireCache) {
		PartitionedRegionFactoryBean f1 = new PartitionedRegionFactoryBean<>();
		f1.setCache(gemfireCache);
		f1.setClose(false);
		f1.setPersistent(false);
		return f1;
	}
}
