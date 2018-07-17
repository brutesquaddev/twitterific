package com.brutesquaddev.github.twitterific.service

import com.brutesquaddev.github.twitterific.config.SampleTweeter
import org.springframework.stereotype.Service

@Service
class MockTwitterService(sampleTweeter: SampleTweeter) {

    val sampleTweeter = sampleTweeter
    fun sampleTweets(): List<String> {
        return sampleTweeter.tweets
    }
}