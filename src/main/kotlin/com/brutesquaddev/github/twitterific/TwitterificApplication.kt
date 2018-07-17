package com.brutesquaddev.github.twitterific

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TwitterificApplication

fun main(args: Array<String>) {
    runApplication<TwitterificApplication>(*args)
}
