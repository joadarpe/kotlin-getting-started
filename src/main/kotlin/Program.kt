import com.jaap.kotlin.Providers

fun main(args: Array<String>) {

    // With instance
    Providers().apply { p -> println("\t${p.name} has ${p.size} items") }


    // With companion
    val providers = Providers.getProviders()

    providers.forEach {
        provider -> println("Name ${provider.name}")
        provider.forEach { key, value -> println("\t$key : $value") }
    }

}