package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
Entity글래스(Posts)와 거의 유사한 형태임에도 Dto 클래스를 추가로 생성했다.
하지만, 절대로 Entity클래스를 Request/Response 클래스로 사용해서는 안된다.

Entity클래스는 데이터베이스와 맞닿은 핵심 클래스 이다. 화면변경은 사소한 변경인데, 이를위해 테이블과 연결된 Entity클래스를 변경 하는 것은 너무 큰 병경이다.
따라서 View Layer와 DB Layer의 역할 분리를 하기위해 Dto 클래스를 따로 만드는것다.
 */
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
