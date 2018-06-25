import com.jaap.kotlin.ProviderDetails
import com.jaap.kotlin.Providers

fun main(args: Array<String>) {

    val providers = Providers()

    // With instance
    providers.apply { p -> println("\t${p.name} has ${p.size} items") }


    // With companion
    Providers.getProviders().forEach { provider ->
        println("Name ${provider.name}")
        provider.forEach { key, value -> println("\t$key : $value") }
    }


    // Using Functions
    val providerFormatter = { detail: ProviderDetails -> "${detail.providerName} -> ${detail.name}" }
    val providerFormatter2 : (ProviderDetails) -> String = { "${it.providerName} -> ${it.name}"}

    println("\nPrinting all =================")
    providers.getProviderDetails()
            .forEach { println(providerFormatter(it)) } // Printing
    println("\nPrinting filtered =================")
    providers.getFilteredProviderDetails("random")
            .map(providerFormatter2)// Transforming to printable string
            .forEach(::println) // Printing

}