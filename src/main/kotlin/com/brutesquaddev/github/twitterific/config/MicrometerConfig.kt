package com.brutesquaddev.github.twitterific.config

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import io.micrometer.atlas.AtlasMeterRegistry
import io.micrometer.core.instrument.simple.SimpleMeterRegistry
import io.micrometer.core.instrument.composite.CompositeMeterRegistry
import org.springframework.context.annotation.Configuration
import java.time.Clock

@Configuration
class MicrometerConfig {

    @Bean
    fun CompositeMeterRegistry() {
        return CompositeMeterRegistry()
    }

    @Bean
    fun SimpleMeterRegistry() {
        return SimpleMeterRegistry()
    }

//    @Bean
//    fun AtlasMeterRegistry() {
//        var atlasMeterRegistry = AtlasMeterRegistry(atlasConfig, Clock.SYSTEM)
//    }

}