package com.brutesquaddev.github.twitterific.config

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import io.micrometer.atlas.AtlasMeterRegistry
import io.micrometer.core.instrument.simple.SimpleMeterRegistry
import io.micrometer.core.instrument.composite.CompositeMeterRegistry
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration
import java.time.Clock

@EnableConfigurationProperties
@Configuration
class MicrometerConfig {

    @Bean
    fun CompositeMeterRegistry(): CompositeMeterRegistry {
        return CompositeMeterRegistry()
    }

    @Bean
    fun SimpleMeterRegistry(): SimpleMeterRegistry {
        return SimpleMeterRegistry()
    }

//    @Bean
//    fun AtlasMeterRegistry() {
//        var atlasMeterRegistry = AtlasMeterRegistry(atlasConfig, Clock.SYSTEM)
//    }

}