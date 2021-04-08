package com.doumer.app.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) //PARAMETER 로 지정하여, 메소드의 파라미터로 선언된 객체에서만 사용가능
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser { //어노테이션 클래스, @LoginUser 어노테이션 사용가능
}
