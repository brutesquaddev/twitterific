package com.brutesquaddev.github.twitterific.controller

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
class TwitterificController {

    @GetMapping("/tweets")
    fun getTweets() : List<String> {

        val cb = ConfigurationBuilder()
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(System.getProperty("consumer_key"))
                .setOAuthConsumerSecret(System.getProperty("consumer_secret"))
                .setOAuthAccessToken(System.getProperty("access_token"))
                .setOAuthAccessTokenSecret(System.getProperty("access_secret"))
        val tf = TwitterFactory(cb.build())
        val twitter = tf.getInstance()

        val query = Query("kroger")
        val result = twitter.search(query)

        return result.tweets.stream()
                .map { item -> item.text }
                .toList()

    }

}