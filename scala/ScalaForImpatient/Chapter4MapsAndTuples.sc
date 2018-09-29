import scala.collection.JavaConversions.mapAsScalaMap
import java.util.TreeMap
import scala.collection.mutable.LinkedHashMap

object Chapter4MapsAndTuples {
/*
//1
  val gizmos = Map(("Nexus 7",169.0),("Sony Xperia tablet",369.0))
  var discountedGizmos = for( (name,price) <- gizmos ) yield (name,price*0.9)
//2
  val in = new java.util.Scanner(new java.io.File("C:\\Users\\manu\\workspace\\ImpatientScala\\src\\filecount.txt"))
  

  import scala.collection.mutable.HashMap
  val words_mutable = new HashMap[String,Long]
  
  def countWordMutable(map:HashMap[String,Long],word:String) = {
  	val current_count:Long = map.getOrElse(word,0)
  	map(word) = current_count + 1
  }
  
  while (in.hasNext()) countWordMutable(words_mutable,in.next())
  in.close()
  for( (word,count) <- words_mutable ) println(word+"->"+count)
  //3
  def countWordImmutable(map:Map[String,Long],word:String) = {
  	var current_count:Long = map.getOrElse(word,0)
  	current_count += 1
  	map + (word->current_count)
  }
  val in2 = new java.util.Scanner(new java.io.File("C:\\Users\\manu\\workspace\\ImpatientScala\\src\\filecount.txt"))
  //var words_immutable = Map[String,Long]()
  //4
  import scala.collection.immutable.SortedMap
  var words_immutable = scala.collection.immutable.SortedMap[String,Long]()
  def countWordImmutableSorted(map:SortedMap[String,Long],word:String) = {
  	var current_count:Long = map.getOrElse(word,0)
  	current_count += 1
  	map + (word->current_count)
  }
  while (in2.hasNext()) {
  	words_immutable = countWordImmutableSorted(words_immutable,in2.next())
  }
  in.close()
  
  
  //5
  
  val words_mutable = new TreeMap[String,Long]
  def countWordMutable(map:TreeMap[String,Long],word:String) = {
  	val current_count:Long = map.getOrElse(word,0)
  	map(word) = current_count + 1
  }
  
  while (in.hasNext()) countWordMutable(words_mutable,in.next())
  in.close()
  for( (word,count) <- words_mutable ) println(word+"->"+count)
  
  import java.util.Calendar
  val day_of_week_map = LinkedHashMap( ("Monday",Calendar.MONDAY)
  ,("Tuesday",Calendar.TUESDAY)
  ,("Wednesday",Calendar.WEDNESDAY)
  ,("Thursday",Calendar.THURSDAY)
  ,("Friday",Calendar.FRIDAY)
  ,("Saturday",Calendar.SATURDAY)
  ,("Sunday",Calendar.SUNDAY)
  )
  for((day,code) <- day_of_week_map ) println(day+"->"+code)
                                                  
                                                  
  import scala.collection.JavaConversions.propertiesAsScalaMap
  val properties:scala.collection.Map[String,String] = System.getProperties()
  for( (prop,value) <- properties ) println(prop+"\t|\t"+value)*/
  
  //val arr = Array(1,2,3,4,5,-4,-2,1,0)
  
  /*def minmax(values: Array[Int]) = {
  	var min = values(0)
  	var max = values(0)
  	for(v<-values) {
  		if(v>max) max=v
  		if(v<min) min=v
  		}
  	(min->max)
  }
   minmax(arr)
   def lteqgt(values:Array[Int],v:Int) = {
    var (lt,eq,gt) = (0,0,0)
   	for(a<-values){
   		if (a>v) gt+=1 else if(a<v) lt +=1 else eq += 1
   		}
   	(lt,eq,gt)
   }
   lteqgt(arr,2)    */
}