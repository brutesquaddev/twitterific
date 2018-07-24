package com.brutesquaddev.github.twitterific.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties("twitterific")
class TwitterAccessConfig(var accessKey : String = "",
                          var accessSecret : String = "",
                          var consumerKey : String = "",
                          var consumerSecret : String = "")