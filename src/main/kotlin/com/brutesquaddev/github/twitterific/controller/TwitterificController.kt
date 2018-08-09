package com.brutesquaddev.github.twitterific.controller

import com.brutesquaddev.github.twitterific.service.TwitterService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TwitterificController(val twitterService: TwitterService) {

    @GetMapping("/tweets")
    fun getTweets() : List<String> = twitterService.sampleTweets()

}
