package com.suhang.layoutfinderannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by 苏杭 on 2017/5/15 17:33.
 */
@Retention(RetentionPolicy.CLASS)
@Inherited
@Target(ElementType.TYPE)
public @interface FindMethod {
}
