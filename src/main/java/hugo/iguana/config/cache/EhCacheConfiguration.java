package hugo.iguana.config.cache;

import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class EhCacheConfiguration extends CachingConfigurerSupport {

    public static final String CACHE_NAME = "cache-one";

    @Bean
    public CacheManager ehCacheConfig() {

        CacheConfiguration cc = new CacheConfiguration();

        cc.setName(CACHE_NAME);
        cc.setMemoryStoreEvictionPolicy("LRU");
        cc.setMaxEntriesLocalHeap(100);
        cc.setTimeToLiveSeconds(120);
        cc.setTimeToIdleSeconds(120);

        net.sf.ehcache.config.Configuration c = new net.sf.ehcache.config.Configuration();
        c.addCache(cc);

        return net.sf.ehcache.CacheManager.newInstance(c);
    }

    @Override
    @Bean
    public org.springframework.cache.CacheManager cacheManager() {
        return new EhCacheCacheManager(ehCacheConfig());
    }
}
