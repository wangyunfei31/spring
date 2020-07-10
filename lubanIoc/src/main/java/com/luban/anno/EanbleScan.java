package com.luban.anno;

import com.luban.register.MyImportBeanDefinitonRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Import(MyImportBeanDefinitonRegistrar.class)
@Target({ElementType.TYPE})
public @interface EanbleScan {
}
