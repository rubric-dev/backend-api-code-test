package im.rubric.codetest.config;

import im.rubric.codetest.entity.Member;
import im.rubric.codetest.repository.jpa.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class StatelessAuthenticationFilter extends GenericFilterBean {
    private final MemberRepository memberRepository;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        authenticate();
        chain.doFilter(request, response);
    }

    public void authenticate() {
        final String USERNAME_FIXED = "tester";
        Member member = memberRepository.findByUsername(USERNAME_FIXED);

        if(member != null) {
            UserAuthentication auth = new UserAuthentication(member.getId(), member.getNickname());
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
    }
}
