package com.hmdp;

import com.hmdp.entity.Shop;
import com.hmdp.service.impl.ShopServiceImpl;
import com.hmdp.utils.CacheClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

import static com.hmdp.utils.RedisConstants.CACHE_SHOP_KEY;
import static com.hmdp.utils.RedisConstants.CACHE_SHOP_TTL;

@SpringBootTest
class HmDianPingApplicationTests {

    @Autowired
    private ShopServiceImpl shopService;

    @Autowired
    private CacheClient cacheClient;

    @Test
    public void testSaveShop() {
        // 缓存预热
        // shopService.saveShop2Redis(1L, 20L);

        // 缓存工具类实现缓存重建
        Shop shop = shopService.getById(1L);
        cacheClient.setWithLogicExpire(CACHE_SHOP_KEY + 1L, shop, CACHE_SHOP_TTL, TimeUnit.MINUTES);
    }

}
