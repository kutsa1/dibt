package com.miro.dibt;

import com.miro.dibt.business.abstracts.IRoleService;
import com.miro.dibt.business.abstracts.IUserService;
import com.miro.dibt.core.entities.Role;
import com.miro.dibt.core.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@SpringBootApplication
@EnableSwagger2
public class DibtApplication {

    public static void main(String[] args) {
        SpringApplication.run(DibtApplication.class, args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

//    @Bean
//    CommandLineRunner run(IUserService userService, IRoleService roleService) {
//        return args -> {
//
//            userService.add(new User(0, "ismailkrc57", "test@test1.com", "12345", true, new ArrayList<>()));
//            userService.add(new User(0, "gurlek", "gürlek@gürlek.com", "12345", true, new ArrayList<>()));
//
//            roleService.add(new Role(0, "admin"));
//            roleService.add(new Role(0, "user"));
//
//            userService.addRoleToUser("ismailkrc57", "admin");
//            userService.addRoleToUser("gurlek", "admin");
//        };
//    }
}

