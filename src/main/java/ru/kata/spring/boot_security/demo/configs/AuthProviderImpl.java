//package ru.kata.spring.boot_security.demo.configs;
//
//
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.stereotype.Component;
//
//
//@Component
////сравниваем пароль и логин из таблицы с введенным в форму
//public class AuthProviderImpl implements AuthenticationProvider {
//    //в (Authentication authentication) лежит логин и пароль
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String username = authentication.getName();
//        return null;
//    }
//
//    //чисто технический метод, для каких
//    // сценариев какой использовать провайдер
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return false;
//    }
//}
