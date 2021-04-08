package com.doumer.app.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter//모든 필드의 get메소드를 생성(lombok)
@RequiredArgsConstructor//선언된 모든 final 필드가 포함된 생성사 생성(final 없는 필드는 포함x)
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
