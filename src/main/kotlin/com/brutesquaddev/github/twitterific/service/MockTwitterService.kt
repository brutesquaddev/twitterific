package com.brutesquaddev.github.twitterific.service

import com.brutesquaddev.github.twitterific.config.MicrometerConfig
import com.brutesquaddev.github.twitterific.config.SampleTweeter
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Service

@ConditionalOnProperty(value = ["twitter.source"], havingValue = "mock")
@Service
class MockTwitterService(sampleTweeter: SampleTweeter) : TwitterService {

    val sampleTweeter = sampleTweeter
    override fun sampleTweets(): List<String> {
        return sampleTweeter.tweets
    }
}
