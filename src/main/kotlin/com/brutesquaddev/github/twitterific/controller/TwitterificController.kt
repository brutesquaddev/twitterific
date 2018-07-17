package com.brutesquaddev.github.twitterific.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TwitterificController {

    @GetMapping("/tweets")
    fun getTweets() : List<String> {



        return emptyList()
    }

}