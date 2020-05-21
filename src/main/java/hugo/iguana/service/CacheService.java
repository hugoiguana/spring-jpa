package hugo.iguana.service;

import hugo.iguana.domain.onetoone.OneToOneOneDirectional1;
import hugo.iguana.service.onetoone.OneToOneOneDirectional1Service;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static hugo.iguana.config.cache.EhCacheConfiguration.CACHE_NAME;

@Slf4j
@Service
public class CacheService {

    @Autowired
    private OneToOneOneDirectional1Service service;

    @Autowired
    private CacheManager cacheManager;

    @SneakyThrows
    @Cacheable(value = CACHE_NAME, key = "'cache-one'+#id")
    public Optional<OneToOneOneDirectional1> findById(Long id) {
        Thread.sleep(2000);
        return service.findById(id);
    }


    public void evict1(Long id) {
        if (cacheManager != null) {
            cacheManager.getCache(CACHE_NAME).evict("cache-one" + id);
        }
    }

    @CacheEvict(value = CACHE_NAME, key = "'cache-one'+#id")
    public void evict2(Long id) {
        log.info("evict2 {}", id);
    }

    @CacheEvict(value = "first", allEntries = true)
    public void evictAllCacheValues() {
        log.info("evictAllCacheValues");
    }
}
