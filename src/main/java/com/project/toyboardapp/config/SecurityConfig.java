package com.project.toyboardapp.config;

/*
 * hasIpAddress(ip) – 접근자의 IP주소가 매칭 하는지 확인합니다.
 * hasRole(role) – 역할이 부여된 권한(Granted Authority)과 일치하는지 확인합니다.
 * hasAnyRole(role) – 부여된 역할 중 일치하는 항목이 있는지 확인합니다.
 * ex) access = "hasAnyRole(‘ROLE_USER’,’ROLE_ADMIN’)"
 * permitAll – 모든 접근자를 항상 승인합니다.
 * denyAll – 모든 사용자의 접근을 거부합니다.
 * anonymous – 사용자가 익명 사용자인지 확인합니다.
 * authenticated – 인증된 사용자인지 확인합니다.
 * rememberMe – 사용자가 remember me를 사용해 인증했는지 확인합니다.
 * fullyAuthenticated – 사용자가 모든 크리덴셜을 갖춘 상태에서 인증했는지 확인합니다.
 *
 * @param http
 * @throws Exception
 */
/*
import com.project.toyboardapp.biz.customer.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private MemberService memberService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception
    {
        // static 디렉터리의 하위 파일 목록은 인증 무시 ( = 항상통과 )
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 페이지 권한 설정
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/myinfo").hasRole("MEMBER")
                .antMatchers("/**").permitAll()
                .and() // 로그인 설정
                .formLogin()
                .loginPage("/user/login")
                .defaultSuccessUrl("/user/result")
                .permitAll()
                .and() // 로그아웃 설정
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                .logoutSuccessUrl("/user/result")
                .invalidateHttpSession(true)
                .and()
                // 403 예외처리 핸들링
                .exceptionHandling().accessDeniedPage("/user/denied");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
    }

    /*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and()
                .csrf()
                .disable()// rest api이므로 csrf 보안이 필요없으므로 disable처리.
                .authorizeRequests()
                .antMatchers("/v1/api/**", "/v1/view/**", "/h2-console/**").permitAll()
                .antMatchers("/user").hasAuthority("USER")
                .antMatchers("/admin").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                //               .formLogin()
                //                    .and()
                .logout()
        ;
        http.headers().frameOptions().disable();

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs", "/configuration/ui",
                "/swagger-resources", "/configuration/security",
                "/swagger-ui.html", "/webjars/**", "/swagger/**", "/websocket-client.html", "/websocket-client",
                "/websocket", "/sockjs", "/websockethandler/**", "/webjars/**", "/greetings/**");
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

     */


