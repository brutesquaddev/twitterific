package com.brutesquaddev.github.twitterific.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties("sample")
class SampleTweeter(var tweets: List<String> = mutableListOf())