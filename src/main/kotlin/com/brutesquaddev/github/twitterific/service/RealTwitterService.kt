package com.brutesquaddev.github.twitterific.service

import com.brutesquaddev.github.twitterific.config.TwitterAccessConfig
import io.micrometer.core.instrument.Timer
import io.micrometer.core.instrument.composite.CompositeMeterRegistry
import io.micrometer.core.instrument.simple.SimpleMeterRegistry
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Component
import twitter4j.Query
import twitter4j.QueryResult
import twitter4j.TwitterFactory
import twitter4j.conf.ConfigurationBuilder
import java.util.concurrent.TimeUnit
import kotlin.streams.toList



@Component
@ConditionalOnProperty(value = ["twitter.source"], havingValue = "real", matchIfMissing = true)
class RealTwitterService(var twitterAccessConfig: TwitterAccessConfig,
                         var compositeMeterRegistry: CompositeMeterRegistry): TwitterService {
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

        val registry = SimpleMeterRegistry()
        val timer: Timer = registry.timer("app.event")

        var result: QueryResult? = null

        timer.record {
            try {
                result = twitter.search(twitterQuery)
            } catch (e: InterruptedException) {
            }
        }

        println(timer.totalTime(TimeUnit.MILLISECONDS))

        return result!!.tweets.stream()
            .map {"${it.user.name} : ${it.text}" }
            .toList()
    }

}
