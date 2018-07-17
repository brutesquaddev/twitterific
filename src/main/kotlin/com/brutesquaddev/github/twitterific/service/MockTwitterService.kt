package com.brutesquaddev.github.twitterific.service

import org.springframework.stereotype.Service

@Service
class MockTwitterService(val sampleTweeter: SampleTweeter) {

    fun sampleTweets(): List<String> {
        return sampleTweeter.tweets
    }
}