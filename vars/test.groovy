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
                cList = value
                echo "cList: ${cList}"
                count++
            } else {
                println "The count is 1!"
                echo "Value: ${value}"
                bList = value
                echo "bList: ${bList}"
            }
            
        }
        
    }

            if (cList.size() == bList.size()) {
                for (i = 0; i < cList.size(); i++) {
                    params.each { key, val ->
                        if (key == 'compname') {
                            params.put(key, cList[i])
                        }
                        if (key == 'buildfile') {
                            params.put(key, bList[i])
                        }
                    }
                }
            }
    echo "*********************************************"
    println params
}
