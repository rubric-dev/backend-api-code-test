package im.rubric.codetest.config;

import im.rubric.codetest.repository.jpa.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private final MemberRepository memberRepository;

	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers(Constants.RESOURCE_URI);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				// api only
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				// csrf
				.csrf().disable()
				// cors
				.cors().disable()
				// auth by url
				.authorizeRequests()
				.anyRequest().authenticated()
				.and()
				// disable default form
				.formLogin().disable()
				.logout().disable()
				// auth filter
				.addFilterBefore(new StatelessAuthenticationFilter(memberRepository), UsernamePasswordAuthenticationFilter.class)
		;
	}
}