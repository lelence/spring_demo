package org.maogogo.lock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@Slf4j
public class RedisLock {

    @Autowired
    private StringRedisTemplate template;

    /**
     * 主要是解决死锁的问题
     *
     * @param key
     * @param value
     * @return
     */
    public boolean lock(String key, String value) {

        // 设置成功 获取 锁
        if (template.opsForValue().setIfAbsent(key, value)) {
            return true;
        }

        // 如果不加锁的过期时间, 当出现异常，这把锁就不会解开

        String currentValue = template.opsForValue().get(key);

        if (!StringUtils.isEmpty(currentValue) &&
                Long.parseLong(currentValue) < System.currentTimeMillis()) {
            // 进入这个 if 说明 锁还没过期, 需要 看看当前value和之前的value是不是一样的

            String oldValue = template.opsForValue().getAndSet(key, value);

            // 如果 设置成功, 说明获取新的锁控制
            if (!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue))
                return true;
        }

        return false;
    }

    public void unlock(String key, String value) {

        try {
            String currentValue = template.opsForValue().get(key);

            if (!StringUtils.isEmpty(currentValue) && currentValue.equals(value)) {
                template.delete(key);
            }
        } catch (Exception e) {
            log.error("redis 解锁异常: {}", e.getMessage(), e);
        }

    }

}
