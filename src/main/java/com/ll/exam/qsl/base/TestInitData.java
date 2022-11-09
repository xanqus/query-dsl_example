package com.ll.exam.qsl.base;

import com.ll.exam.qsl.product.dao.ProductRepository;
import com.ll.exam.qsl.product.domain.Product;
import com.ll.exam.qsl.user.dao.UserRepository;
import com.ll.exam.qsl.user.entity.SiteUser;
import lombok.Builder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("test") // 이 클래스에 정의된 Bean들은 test모드에서만 활성화 된다.
public class TestInitData {
    // CommandLineRunner : 주로 앱 실행 직후 초기데이터 세팅 및 초기화에 사용
    @Bean
    CommandLineRunner init(UserRepository userRepository, ProductRepository productRepository) {
        return args -> {
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

            SiteUser u5 = SiteUser.builder()
                    .username("user5")
                    .password("{noop}1234")
                    .email("user5@test.com")
                    .build();

            SiteUser u6 = SiteUser.builder()
                    .username("user6")
                    .password("{noop}1234")
                    .email("user6@test.com")
                    .build();

            SiteUser u7 = SiteUser.builder()
                    .username("user7")
                    .password("{noop}1234")
                    .email("user7@test.com")
                    .build();

            SiteUser u8 = SiteUser.builder()
                    .username("user8")
                    .password("{noop}1234")
                    .email("user8@test.com")
                    .build();

            userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5, u6, u7, u8));

            Product p1 = Product.builder()
                    .productName("줄무늬 티셔츠")
                    .price(10000)
                    .stockQuantity(1000)
                    .build();

            Product p2 = Product.builder()
                    .productName("파란 반바지")
                    .price(12000)
                    .stockQuantity(1000)
                    .build();

            Product p3 = Product.builder()
                    .productName("은 목걸이")
                    .price(20000)
                    .stockQuantity(1000)
                    .build();

            Product p4 = Product.builder()
                    .productName("롱코트")
                    .price(140000)
                    .stockQuantity(1000)
                    .build();

            Product p5 = Product.builder()
                    .productName("선글라스")
                    .price(15000)
                    .stockQuantity(1000)
                    .build();

            Product p6 = Product.builder()
                    .productName("청바지")
                    .price(40000)
                    .stockQuantity(1000)
                    .build();

            productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));

        };
    }
}
