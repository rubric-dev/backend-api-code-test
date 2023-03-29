package im.rubric.codetest.repository.jpa;

import im.rubric.codetest.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/** Member 관련 기능을 처리하는 JPA repository */
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByUsername(String username);
}
