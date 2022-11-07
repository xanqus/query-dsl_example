package com.ll.exam.qsl;

import com.ll.exam.qsl.user.dao.UserRepository;
import com.ll.exam.qsl.user.entity.SiteUser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
class UserRepositoryTests {

	@Autowired
	private UserRepository userRepository;
	@Test
	@DisplayName("회원 생성")
	void test1() {
		SiteUser u3 = SiteUser.builder()
				.username("user3")
				.password("{noop}1234")
				.email("user3@test.com")
				.build();
		SiteUser u4 = SiteUser.builder()
				.username("user4")
				.password("{noop}1234")
				.email("user4@test.com")
				.build();
		userRepository.saveAll(Arrays.asList(u3, u4));
	}

	@Test
	@DisplayName("1번 회원을 Qsl로 가져오기")
	void test2() {
		SiteUser u1 = userRepository.getQslUser(1L);

		assertThat(u1.getId()).isEqualTo(1L);
	}

	@Test
	@DisplayName("모든 회원 수")
	void test3() {
		long count = userRepository.getQslCount();
		assertThat(count == 2L);
	}

	@Test
	@DisplayName("가장 오래된 회원 1명")
	void test5() {
		SiteUser u1 = userRepository.getQslUserOrderByIdAscOne();
		assertThat(u1.getId()).isEqualTo(1L);
	}

	@Test
	@DisplayName("전체 회원")
	void test6() {
		List<SiteUser> users = userRepository.getQslUsersOrderByIdAsc();
		System.out.println(users.get(0).getId());
	}

	@Test
	@DisplayName("회원에게 관심사 등록")
	@Rollback(false)
	void t7() {
		SiteUser u2 = userRepository.getQslUser(2L);

		u2.addInterestKeywordContent("축구");
		u2.addInterestKeywordContent("게임");
		u2.addInterestKeywordContent("헬스");
		u2.addInterestKeywordContent("헬스");

		userRepository.save(u2);
	}
}
