package com.bank.account.manager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionConfig;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizePolicy;

@Configuration
public class CacheConfig {

	@Bean
	public Config configure() {
		EvictionConfig evictionConfig=new EvictionConfig();
		evictionConfig.setEvictionPolicy(EvictionPolicy.LRU);
		evictionConfig.setMaxSizePolicy(MaxSizePolicy.FREE_HEAP_SIZE);
		return new Config().setInstanceName("hazlecast-insatnce")
				.addMapConfig(new MapConfig().setName("userCache")
						.setEvictionConfig(evictionConfig).setTimeToLiveSeconds(2000));
	}

}