def call(Map params = [:]) {

    println params
    echo "*********************************************"
    println "Name: ${params.name}"
    println "Number: ${params.number}"
    
    for (def itr in params.inputScan.keySet()) {
        def cList = []
        def bList = []
        echo "Key: ${itr}"
        def count = 0
        for (def value in params.inputScan.get(itr)) {
            if (count == 0) {
                println "The count is 0!"
                echo "Value: ${value}"
                cList = Eval.me(value)
                echo "cList: ${cList}"
                count++
            } else {
                println "The count is 1!"
                echo "Value: ${value}"
                bList = Eval.me(value)
                echo "bList: ${bList}"
            }
            
            for (i = 0; i < cList.size(); i++) {
                params.each { tkey, value ->
                    if (tkey == 'giturl') {
                        params.put(tkey, "${itr}")
                    }
                    
                    if (tkey == 'compname') {
                        params.put(tkey, cList[i])
                    }
                    
                    if (tkey == 'buildfile') {
                        params.put(tkey, bList[i])
                    }
                }
                
                echo "Params: ${params}"
            }
        }
    }
    
    echo "*********************************************"
    println params
}
