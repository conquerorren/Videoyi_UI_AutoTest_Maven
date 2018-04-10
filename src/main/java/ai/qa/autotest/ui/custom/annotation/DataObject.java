/*
 * System: Videoyi AutoTest
 * @version 1.00
 * 
 * @Package:ai.qa.autotest.ui.custom.annotation
 * @author Ren Qiang
 * @date:Mar 13, 2018
 * 
 * Copyright (C) 2017 YingPu Corporation. All rights reserved.
 * 
 */
package ai.qa.autotest.ui.custom.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: DataObject
 * @Description: 自动装配标签
 * @author: Ren Qiang
 * @date: Mar 13, 2018
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataObject {
    public String DataNode() default "";
}