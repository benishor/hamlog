package hamlog.web.services;

import hamlog.domain.User;
import hamlog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Adrian Scripca
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String callsign) throws UsernameNotFoundException {
		User user = userService.findByCallsign(callsign);
		if (user == null) {
			throw new UsernameNotFoundException("User with callsign " + callsign + " not found");
		}
		return new UserDetailsImpl(user);
	}

	public static class UserDetailsImpl implements UserDetails {

		private final User user;

		public UserDetailsImpl(User user) {
			this.user = user;
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
			// add here more roles should the case be (e.g. ROLE_ADMIN)
			return authorities;
		}

		@Override
		public String getPassword() {
			return user.getPassword();
		}

		@Override
		public String getUsername() {
			return user.getCallsign();
		}

		@Override
		public boolean isAccountNonExpired() {
			return true; // no such thing as account expiration yet
		}

		@Override
		public boolean isAccountNonLocked() {
			// TODO: insert enabled flag in user model and use that
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return true;
		}
	}
}
