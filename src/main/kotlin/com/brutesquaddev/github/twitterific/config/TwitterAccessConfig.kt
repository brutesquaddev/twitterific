package com.brutesquaddev.github.twitterific.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties("twitterific")
class TwitterAccessConfig(val accessKey : String = "", val accessSecret : String = "",
                          val consumerKey : String = "", val consumerSecret : String = "")