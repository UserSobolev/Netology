package ru.netology.springboot.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.springboot.controller.ProfileController;
import ru.netology.springboot.profile.DevProfile;
import ru.netology.springboot.profile.ProductionProfile;
import ru.netology.springboot.profile.SystemProfile;

@Configuration
public class JavaConfig {
    @Bean
    @ConditionalOnProperty(
            value="netology.profile.dev",
            matchIfMissing = false)
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(
            value="netology.profile.dev",
            matchIfMissing = true)
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }

    @Bean
    public ProfileController profileController(SystemProfile profile) {
        return new ProfileController(profile);
    }

}
