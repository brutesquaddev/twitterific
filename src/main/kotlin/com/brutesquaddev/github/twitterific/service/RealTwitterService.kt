package com.brutesquaddev.github.twitterific.service

import com.brutesquaddev.github.twitterific.config.TwitterAccessConfig
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Component
import twitter4j.Query
import twitter4j.TwitterFactory
import twitter4j.conf.ConfigurationBuilder
import kotlin.streams.toList

@Component
@ConditionalOnProperty(value = ["twitter.source"], havingValue = "real", matchIfMissing = true)
class RealTwitterService(var twitterAccessConfig: TwitterAccessConfig): TwitterService {
    override fun sampleTweets(): List<String> {
        val cb = ConfigurationBuilder()
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(twitterAccessConfig.consumerKey)
                .setOAuthConsumerSecret(twitterAccessConfig.consumerSecret)
                .setOAuthAccessToken(twitterAccessConfig.accessKey)
                .setOAuthAccessTokenSecret(twitterAccessConfig.accessSecret)
        val tf = TwitterFactory(cb.build())
        val twitter = tf.instance

        val query = Query("kroger -peta -tases")
            .apply { count = 100; lang = "en"; }

        val result = twitter.search(query)

        return result.tweets.stream()
                .map {"${it.user.name} : ${it.text}" }
                .toList()
    }

    override fun searchTweets(query: String): List<String> {
        val cb = ConfigurationBuilder()
        cb.setDebugEnabled(true)
            .setOAuthConsumerKey(twitterAccessConfig.consumerKey)
            .setOAuthConsumerSecret(twitterAccessConfig.consumerSecret)
            .setOAuthAccessToken(twitterAccessConfig.accessKey)
            .setOAuthAccessTokenSecret(twitterAccessConfig.accessSecret)
        val tf = TwitterFactory(cb.build())
        val twitter = tf.instance

        val twitterQuery = Query(query)
            .apply { count = 100; lang = "en"; }

        val result = twitter.search(twitterQuery)

        return result.tweets.stream()
            .map {"${it.user.name} : ${it.text}" }
            .toList()
    }

}
