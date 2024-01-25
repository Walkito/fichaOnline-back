package br.com.walkito.fichaOnline.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Configuration
public class MapperUtil {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
