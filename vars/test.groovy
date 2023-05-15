def call(Map params = [:]) {
  def myList = params.myList
  for (item in myList) {
    println item
  }
  
  
}
