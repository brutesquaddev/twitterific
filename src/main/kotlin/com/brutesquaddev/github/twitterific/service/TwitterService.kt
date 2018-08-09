package com.brutesquaddev.github.twitterific.service

interface TwitterService {
    fun sampleTweets(): List<String>
    fun searchTweets(query: String): List<String> = sampleTweets()
}
