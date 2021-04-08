package com.doumer.app.springboot.domain.posts;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //JPA Entity 클래스에서 BaseTimeEntity 를 상속할 경우 필드들을 컬럼으로 인식
@EntityListeners(AuditingEntityListener.class) //Auditing 기능
public class BaseTimeEntity {
    @CreatedDate //Entity 가 생성되어 저장될 떄 시간이 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate // 조회한 Entity 의 값을 변경할 때 시간이 자동 저장
    private LocalDateTime modifiedDate;
}
