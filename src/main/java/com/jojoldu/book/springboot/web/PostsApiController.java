package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.service.posts.PostsService;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/*
 스프링에서 Bean을 주입받는 방식등은 다은과같다
  @Autowired, setter, 생성자
  이중에서 가장 권장하는 방식이 생성자로 주입받는 방식이다(@Autowired는 권장하지 않는다)
  즉 생성자로 Bean객체를 받도록 하면 @Autowired와 동일한 효과를 볼 수 있다.
  그럼 생성자는 어디에 있을까? 바로 @RequiredArgsConstructor에서 해결해 준다
  final이 선언된 모든 필드를 인자값으로 하는 생성자를 롬복의 @RequiredArgsConstructor가 대신 생성해 주는 것이다.

  생성자를 안쓰고 롬복 어노테이션을 사용한 이유는 간다하다. 해당 클래스의 의존성 관계가 변경될 때마다 생성자 코드를
  계속해서 수정하는 번거로움을 해결 하기 위함이다.
 */
@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }
}
