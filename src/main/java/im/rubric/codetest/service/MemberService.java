package im.rubric.codetest.service;


import im.rubric.codetest.repository.jpa.MemberRepository;
import im.rubric.codetest.repository.mybatis.MemberDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/** Member 관련 로직을 처리하는 서비스 */
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberDao memberDao;

}
