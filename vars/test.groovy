def call(Map params = [:]) {
   println "Name: ${params.name}"
    println "Number: ${params.number}"
    
    params.inputScan.each { key, value ->
        println "Key: ${key}"
        println "Values: ${value.join(', ')}"
    }
  
  
}
