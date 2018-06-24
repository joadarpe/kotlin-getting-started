package com.jaap.kotlin

import java.security.Provider
import java.security.Security


class Providers {

    fun apply(fn : (Provider) -> Unit) {
        getProviders().forEach { p -> fn(p) }
    }

    companion object {

        fun getProviders() : List<Provider> {
            return Security.getProviders().asList()
        }

    }
}