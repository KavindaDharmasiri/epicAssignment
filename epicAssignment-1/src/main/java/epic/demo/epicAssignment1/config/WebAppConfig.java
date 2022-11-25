package epic.demo.epicAssignment1.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Created_By_: Kavinda Gimhan
 * @Date_: 11/25/2022
 * @Time_: 8:57 PM
 * @Project_Name : Assignments
 **/

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "epic.demo.epicAssignment1")
public class WebAppConfig implements WebMvcConfigurer {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}

