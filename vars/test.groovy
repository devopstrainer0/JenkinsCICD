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
        def count = 0
        for (def value in params.inputScan.get(key)) {
           if (count == 0) {
                println "The count is 0!"
                  echo "Value: ${value}"
                count++
                   }else {
                println "The count is 1!"
                  echo "Value: ${value}"
               
               }
        }
    }

  
}
