def call(Map params = [:]) {
   println "Name: ${params.name}"
    println "Number: ${params.number}"
    
/*    params.inputScan.each { key, value ->
        println "Key: ${key}"
        println "Values: ${value.join(', ')}"
    }
  */
  for (def key in params.inputScan.keySet()) {
       def cList = []
       def bList = []
        echo "Key: ${key}"
        for (def value in params.inputScan.get(key)) {
           
            echo "Value: ${value}"
           for 
        }
    }
   
   for (def i = 0; i < params.inputScan.get(key)[0].size(); i++) {
         def value1 = params.inputScan.get(key)[0][i]
         def value2 = params.inputScan.get(key)[1][i]
         echo "Value 1: ${value1}"
         echo "Value 2: ${value2}"
      }
  
}
