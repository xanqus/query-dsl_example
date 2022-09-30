package com.ll.exam.qsl;

import com.ll.exam.qsl.user.dao.UserRepository;
import com.ll.exam.qsl.user.entity.SiteUser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class UserRepositoryTests {

	@Autowired
	private UserRepository userRepository;
	@Test
	@DisplayName("회원 생성")
	void test1() {
		SiteUser u1 = SiteUser.builder()
				.username("user1")
				.password("{noop}1234")
				.email("user1@test.com")
				.build();
		SiteUser u2 = SiteUser.builder()
				.username("user2")
				.password("{noop}1234")
				.email("user2@test.com")
				.build();
		userRepository.saveAll(Arrays.asList(u1, u2));
	}

	@Test
	@DisplayName("1번 회원을 Qsl로 가져오기")
	void test2() {
		SiteUser u1 = userRepository.getQslUser(1L);

		assertThat(u1.getId()).isEqualTo(1L);
	}
}
