package org.redispoc.sentinelpoc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
@Profile({"sentinel"})
public class RedisSentinelConfig {

	@Autowired
	private RedisProperties redisProperties;

	@Bean
	public StringRedisTemplate redisTemplate() {
		return new StringRedisTemplate(connectionFactory());
	}

	@Bean
	public RedisConnectionFactory connectionFactory() {
		return new LettuceConnectionFactory(sentinelConfig(), 
				LettuceClientConfiguration.defaultConfiguration());
	}

	@Bean
	public RedisSentinelConfiguration sentinelConfig() {
		RedisSentinelConfiguration redisConf = new RedisSentinelConfiguration();
		redisConf.setMaster(redisProperties.getSentinel().getMaster());
		redisProperties.getSentinel().getNodes().forEach(s -> {
			redisConf.addSentinel(new RedisNode(s, redisProperties.getPort()));
		});
		return redisConf;
	}

}
