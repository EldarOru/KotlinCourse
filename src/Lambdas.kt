fun convert(x: Double,
            converter: (Double) -> Double):Double{
    val result = converter(x)
    println("$x is converted to $result")
    return result
}

fun convertFive(converter: (Int) -> Double):Double{
    val result = converter(5)
    println("5 is converted to $result")
    return result
}

fun getConversionLambda(str: String): (Double) -> Double{
    if (str == "CentigradeToFahrenheit"){
        return {it * 1.8 + 32}
    }else if (str == "KgsToPounds"){
        return {it * 2.204623}
    }else if (str == "PoundsToUSTons"){
        return {it/2000.0}
    }else{
        return {it}
    }
}

fun main() {
    convert(20.0){it * 1.8 + 32}
    convertFive{it * 1.8 + 32}
    val pounds = getConversionLambda("KgsToPounds")(2.5)
}