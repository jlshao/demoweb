package hello.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MemoryUserDetailsServiceImpl implements UserDetailsService {
	private static List<UserObject> users = new ArrayList<UserObject>();

	public MemoryUserDetailsServiceImpl() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		String result = encoder.encode("admin");
		users.add(new UserObject("admin", "$2a$10$LDdbYE2VjQ94b0XFAAW8TuPnuS8kP3ToNuKNld00cD46TOWwc6k8.", "ADMIN"));
		users.add(new UserObject("user", "$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG", "USER"));
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserObject> user = users.stream().filter(u -> u.name.equals(username)).findAny();
		if (!user.isPresent()) {
			throw new UsernameNotFoundException("User not found by name: " + username);
		}
		return toUserDetails(user.get());
	}

	private UserDetails toUserDetails(UserObject userObject) {
		return User.withUsername(userObject.name).password(userObject.password).roles(userObject.role).build();
	}

	private static class UserObject {
		private String name;
		private String password;
		private String role;

		public UserObject(String name, String password, String role) {
			this.name = name;
			this.password = password;
			this.role = role;
		}
	}
}
