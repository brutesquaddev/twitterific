package com.brutesquaddev.github.twitterific.service

import com.brutesquaddev.github.twitterific.config.SampleTweeter
import org.springframework.stereotype.Service

@Service
class MockTwitterService(sampleTweeter: SampleTweeter) : TwitterService {

    val sampleTweeter = sampleTweeter
    override fun sampleTweets(): List<String> {
        return sampleTweeter.tweets
    }
}