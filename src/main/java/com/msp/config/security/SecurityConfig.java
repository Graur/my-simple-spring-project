package com.msp.config.security;

import com.msp.security.handlers.CustomAuthenticationSuccessHandler;
import com.msp.security.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;


@Configuration
@ComponentScan("com.msp")
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    /**
     *
     * Конфигурация
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        // отключена защита csrf на время тестов
        http.csrf().disable().addFilterBefore(filter, CsrfFilter.class);
        http.authorizeRequests()
                /** Предоставление доступа к /user/** только для пользователей,
                 * c ролью USER
                 * user/** - означает любые url начинающиеся с /user
                 */
                .antMatchers("/user/**").hasAnyAuthority("USER")
                /**
                 *Аналогично для url /admin/** и пользователей имеющих роль ADMIN
                 */
                .antMatchers("/admin/**").hasAnyAuthority("ADMIN")
                .and()
                .formLogin()
                /**
                 * Форма логина находится на страницк с url "/"
                 */
                .loginPage("/")
                /**
                 * url на который отправляется запрос GET при ошибке
                 */
                .failureUrl("/?error")
                /**
                 * Handler (то что выберет дальнейший url в зависимости от роли)
                 */
                .successHandler(customAuthenticationSuccessHandler)
                /**
                 * Имя инпута для имени в форме логина (может быть username,login,email или что-то подобное)
                 */
                .usernameParameter("login")
                /**
                 * Имя инпута для пароля в форме логина
                 */
                .passwordParameter("password");

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        /**
         * Authentication Service - то, что проверяет наличие в базе юзера с введенными данными
         */
        auth.userDetailsService(authenticationService);
    }
}