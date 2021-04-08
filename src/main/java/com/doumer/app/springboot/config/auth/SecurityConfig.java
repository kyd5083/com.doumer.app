package com.doumer.app.springboot.config.auth;

import com.doumer.app.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity //Spring Security 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable().headers().frameOptions().disable()//h2-console 화면을 사용하기 위해 해당 옵션들을 disable
                .and()
                .authorizeRequests()//URL 별 권한 관리를 설정하는 옵션의 시작점
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**")//권한 관리 대상지정
                .permitAll()//앞에 URL 패턴들은 전체 열람 권한 부여
                .antMatchers("/api/v1/*")
                .hasRole(Role.USER.name())//앞에 URL 패턴은 USER 권한을 가진 사람만 접근가능
                .anyRequest().authenticated()//설정된 값들 이외 나머지 URL 은 모두 인증된 사용자에게만 허용
                .and().logout().logoutSuccessUrl("/")//로그아웃 기능에 대한 설정으로 로그아웃 성공시 "/" 주소로 이동
                .and().oauth2Login().userInfoEndpoint()//OAuth2 로그인 성공 이후 사용자 정보를 가져옴
                .userService(customOAuth2UserService);//로그인 성공 후속 조치를 진행할 인터페이스 구현체 등록
    }
}
