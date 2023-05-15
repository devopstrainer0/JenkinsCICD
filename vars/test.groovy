def call(Map params = [:]) {
   println "Name: ${params.name}"
    println "Number: ${params.number}"
    
/*    params.inputScan.each { key, value ->
        println "Key: ${key}"
        println "Values: ${value.join(', ')}"
    }
  */
  for (def key in params.inputScan.keySet()) {
        echo "Key: ${key}"
        for (def value in params.inputScan.get(key)) {
            echo "Value: ${value}"
        }
    }
  
}
