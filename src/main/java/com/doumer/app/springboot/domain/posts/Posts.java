package com.doumer.app.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter //클래스 내 모든 필드의 Getter 메소드를 자동 생성
@NoArgsConstructor //기본생성자 자동추가
@Entity //테이블과 링크될 클래스임을 나타냄, 클래시의 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름을 매칭
public class Posts extends BaseTimeEntity {
    @Id //해당 테이블의 PK 필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY)//PK의 생성 규칙을 나타내며 여기선 auto_increment 처리
    private Long id;

    @Column(length = 500, nullable = false)//사용하지 않으면 기본 컬럼, 사용하면 기본값 외에 추가로 변경이 필요한 옵션사용 가능, 여기선 컬럼길이 수정
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)//컬럼을 TEXT로 관리
    private String content;

    private String author;

    @Builder //생성 시점에 값을 채워주는 역할
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
