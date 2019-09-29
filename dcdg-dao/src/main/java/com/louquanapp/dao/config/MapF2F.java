package com.louquanapp.dao.config;

import java.lang.annotation.*;

/**
 * @author 胡化敏(huhuamin)
 * @email 175759041@qq.com
 * @date 2018/7/23 上午10:27
 * <p>
 * 将查询结果映射成map的注解，其中第一个字段为key，第二个字段为value.
 * <p>
 * 注：返回类型必须为{@link java.util.Map Map<K, V>}。K/V的类型通过MyBatis的TypeHander进行类型转换，如有必要可自定义TypeHander。
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface MapF2F {
    /**
     * 是否允许key重复。如果不允许，而实际结果出现了重复，会抛出org.springframework.dao.DuplicateKeyException。
     *
     * @return
     */
    boolean isAllowKeyRepeat() default false;

    /**
     * 对于相同的key，是否允许value不同(在允许key重复的前提下)。如果允许，则按查询结果，后面的覆盖前面的；如果不允许，则会抛出org.springframework.dao.DuplicateKeyException。
     *
     * @return
     */
    boolean isAllowValueDifferentWithSameKey() default false;
}
