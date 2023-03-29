package im.rubric.codetest.config;

import im.rubric.codetest.entity.Member;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Data
public class UserAuthentication implements Authentication {
	private Long memberId;
	private String name;
	@Setter(AccessLevel.PRIVATE)
	private Set<? extends GrantedAuthority> authorities;
	private boolean authenticated;

	public UserAuthentication(Long memberId, String nickname) {
		this.memberId = memberId;
		this.name = nickname;
		this.authenticated = true;
	}

	@Override
	public String getCredentials() {
		return null;
	}

	@Override
	public Long getDetails() {
		return memberId;
	}

	@Override
	public Long getPrincipal() {
		return memberId;
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		this.authenticated = isAuthenticated;
	}

	@Override
	public String getName() {
		return name;
	}
}