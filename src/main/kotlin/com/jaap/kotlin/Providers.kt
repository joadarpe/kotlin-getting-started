package com.jaap.kotlin

import java.security.Provider
import java.security.Security


data class ProviderDetails (val providerName : String, val name : String)

class Providers {

    fun apply(fn : (Provider) -> Unit) {
        getProviders().forEach { p -> fn(p) }
    }

    fun getProviderDetails() : List<ProviderDetails> {

        // Create a mutable list to add mapped values
        val details = mutableListOf<ProviderDetails>()

        getProviders().forEach {

            // Mapping all entries of every provider
            p -> val providerDetails = p.entries.map { entry -> ProviderDetails(p.name, entry.key.toString()) }
            // Adding every provider detail list into global detail list
            details.addAll(providerDetails)
            // can be done as:
            // details += providerDetails
        }

        return details
    }

    fun getFilteredProviderDetails(filter : String) : List<ProviderDetails> {

        // Using flat map
        return getProviders().flatMap {
            // There's no need of using item name, you can simply use "it"
            p -> p.entries.filter { it.key.toString().contains(filter, true) }
                .map { ProviderDetails(p.name, it.key.toString()) }
        }
    }

    companion object {

        fun getProviders() : List<Provider> {
            return Security.getProviders().asList()
        }

    }
}