package user.info.user;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class BeamConfiguartion {


    @Bean
    public JedisPool getJedisPool() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setJmxEnabled(false);
        jedisPoolConfig.setMaxIdle(5000);
        jedisPoolConfig.setMaxWaitMillis(1000);
        return new JedisPool(jedisPoolConfig, "localhost", 6379, 6000);
    }

    @Bean
    public Jedis getJedis(@Autowired JedisPool pool){
        try (Jedis jedis = pool.getResource()) {
            return jedis;
        }
    }

    @Bean
    public Gson getGson(){
        Gson gson = new Gson();
        return gson;
    }



}
