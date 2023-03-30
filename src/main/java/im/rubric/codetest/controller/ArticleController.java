package im.rubric.codetest.controller;

import im.rubric.codetest.dto.ArticleDto;
import im.rubric.codetest.dto.io.CommonResponse;
import im.rubric.codetest.dto.io.PageResponse;
import im.rubric.codetest.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Article 관련 api를 처리하는 rest controller
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {
    private final ArticleService articleService;


    /*  📌 여러개의 게시글을 page 단위로 조회하기 위한 api
     *
     * 요구사항 1. page 단위로 조회되어야 합니다.
     * 요구사항 2. 게시글들에 달려있는 댓글 갯수의 정보를 포함하여 조회되어야 합니다.
     *
     * @param pageable 검색할 페이지 정보.
     * @return dto로 변환 된 객체의 페이지 단위 정보.
     */
    @GetMapping
    public PageResponse<ArticleDto.View> page(@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<ArticleDto.View> articles = articleService.findPage(pageable);
        return new PageResponse<>(articles, pageable);
    }


    /*  📌 하나의 게시글을 조회하기 위한 api
     *
     * 요구사항 1. 해당 게시글의 가장 최신 댓글 3개와 함께 조회되어야 합니다.
     *
     * @param id 조회할 대상
     * @return dto로 변환 된 대상 정보. 대상이 조회되지 않을 시 exception.
     */
    @GetMapping("/{id}")
    public CommonResponse<ArticleDto.Detail> detail(@PathVariable Long id) {
        ArticleDto.Detail article = articleService.findOne(id);
        return new CommonResponse<>(article);
    }


    /*  📌 새로운 게시글을 생성하기 위한 api
     *
     * 요구사항 1. 제목과 내용이 비어있는 상태로 게시글 작성이 불가합니다.
     *
     * @param dto 생성시 입력할 정보
     * @param userId 로그인한 유저 식별자 정보
     * @return 성공 시 기본 응답형. 실패 시 exception.
     */
    @PostMapping
    public CommonResponse create(@RequestBody ArticleDto.Command dto, @AuthenticationPrincipal Long userId) {
        articleService.create(dto, userId);
        return CommonResponse.OK;
    }


    /*  📌 게시글 수정을 위한 api
     *
     * 요구사항 1. 게시글을 수정은 작성자 본인만 수정이 가능합니다.
     *
     * @param id 수정할 대상 식별자
     * @param dto 생성시 입력할 정보
     * @param userId 로그인한 유저의 식별자 정보
     * @return 성공 시 기본 응답형. 실패 시 exception.
     */
    @PutMapping("/{id}")
    public CommonResponse update(@PathVariable Long id, @RequestBody ArticleDto.Command dto, @AuthenticationPrincipal Long userId) {
        articleService.update(id, dto, userId);
        return CommonResponse.OK;
    }


    /*  📌 게시글 삭제를 위한 api
     *
     * 요구사항 1. 게시글을 삭제는 작성자 본인만 삭제가 가능합니다.
     *
     * @param id 수정할 대상 식별자
     * @param userId 로그인한 유저의 식별자 정보
     * @return 성공 시 기본 응답형. 실패 시 exception.
     */
    @DeleteMapping("/{id}")
    public CommonResponse delete(@PathVariable Long id, @AuthenticationPrincipal Long userId) {
        articleService.delete(id, userId);
        return CommonResponse.OK;
    }


    /*  📌 추가 문제 (SQL문 작성)

     인기 있는 글을 많이 작성하는 작성자들의 순위가 필요합니다.
     작성자들이 작성한 게시글 인기도의 평균을 내림차순으로 조회하는 쿼리를 작성해 주세요.
     ※ 게시글 인기도 계산식 = (조회수 * 1.5) + (좋아요수 * 5) + (댓글수 * 9)

     ------------------  작성  ------------------







     -------------------------------------------

     */


}
