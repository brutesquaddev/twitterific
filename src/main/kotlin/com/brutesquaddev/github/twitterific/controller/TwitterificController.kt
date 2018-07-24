package com.brutesquaddev.github.twitterific.controller

import com.brutesquaddev.github.twitterific.service.RealTwitterService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import twitter4j.Query
import twitter4j.TwitterFactory
import twitter4j.Twitter
import twitter4j.conf.ConfigurationBuilder
import java.util.stream.Collectors
import twitter4j.QueryResult
import kotlin.streams.toList


@RestController
class TwitterificController(val realTwitterService: RealTwitterService) {

    @GetMapping("/tweets")
    fun getTweets() : List<String> = realTwitterService.sampleTweets()

}