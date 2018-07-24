package com.brutesquaddev.github.twitterific.service

import com.brutesquaddev.github.twitterific.config.TwitterAccessConfig
import org.springframework.stereotype.Component
import twitter4j.Query
import twitter4j.TwitterFactory
import twitter4j.conf.ConfigurationBuilder
import kotlin.streams.toList

@Component
class RealTwitterService(var twitterAccessConfig: TwitterAccessConfig): TwitterService {
    override fun sampleTweets(): List<String> {
        val cb = ConfigurationBuilder()
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(twitterAccessConfig.consumerKey)
                .setOAuthConsumerSecret(twitterAccessConfig.consumerSecret)
                .setOAuthAccessToken(twitterAccessConfig.accessKey)
                .setOAuthAccessTokenSecret(twitterAccessConfig.accessSecret)
        val tf = TwitterFactory(cb.build())
        val twitter = tf.getInstance()

        val query = Query("kroger")
        val result = twitter.search(query)

        return result.tweets.stream()
                .map { item -> item.text }
                .toList()
    }

}