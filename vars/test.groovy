def call(Map params = [:]) {
  def myList = params.name
  for (item in myList) {
    println item
  }
  
  
}
