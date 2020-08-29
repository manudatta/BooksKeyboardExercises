/*
* Things learnt
* yield
* until is better than n-1
* javaconversions
* ArrayBuffer has appendAll
* dropRight is complementary of drop
*/



import util.Random

object Chapter3 {
  println("Welcome to the Scala worksheet")
/*  val v = 3
	def product(s:String):Long = if (s=="") 1 else product(s.drop(1))*s(0).toLong
	product("Hello")
	def compute(x:Double,n:Int):Double = if (n==0) 1
		else if(n % 2 == 0) {val v = compute(x,n/2); v*v}
		else if(n<0) 1.0/compute(x,-1*n)
		else x*compute(x,n-1)
	compute(2.0,-2)
	*/
	// Chapter 3
	//1
	val rnd = new Random                      //> rnd  : scala.util.Random = scala.util.Random@20fa23c1
	var n = 21                                //> n  : Int = 20
	val b = (for( i <- 0 until n ) yield rnd.nextInt).toArray
                                                  //> b  : Array[Int] = Array(-1188120723, -839425946, -1475399633, 1356397305, -3
                                                  //| 91926850, 2096092240, -1466950398, 2032847273, -1788876486, -877333691, -177
                                                  //| 3980385, 1371881060, 478349004, -1432065607, 337775392, 87695232, 454008504,
                                                  //|  -292716385, -639889992, -1108777359)
	//2
	var len = b.length                        //> len  : Int = 20
	for(i <- 1 until len by 2) {var t = b(i) ; b(i)=b(i-1); b(i-1) = t}
	b                                         //> res0: Array[Int] = Array(-839425946, -1188120723, 1356397305, -1475399633, 2
                                                  //| 096092240, -391926850, 2032847273, -1466950398, -877333691, -1788876486, 137
                                                  //| 1881060, -1773980385, -1432065607, 478349004, 87695232, 337775392, -29271638
                                                  //| 5, 454008504, -1108777359, -639889992)
	//3
	for(i <- 0 until len)
		yield
		if(i%2==1) b(i-1) else if(i== len-1) b(i) else b(i+1)
                                                  //> res1: scala.collection.immutable.IndexedSeq[Int] = Vector(-1188120723, -8394
                                                  //| 25946, -1475399633, 1356397305, -391926850, 2096092240, -1466950398, 2032847
                                                  //| 273, -1788876486, -877333691, -1773980385, 1371881060, 478349004, -143206560
                                                  //| 7, 337775392, 87695232, 454008504, -292716385, -639889992, -1108777359)
  //20
  import scala.collection.mutable.ArrayBuffer
  var arr = new ArrayBuffer[Int]()                //> arr  : scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer()
  arr ++= (for(i <- 0 until b.length if b(i) > 0 ) yield b(i))
                                                  //> res2: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1356397305, 20
                                                  //| 96092240, 2032847273, 1371881060, 478349004, 87695232, 337775392, 454008504)
                                                  //| 
  arr ++= (for(i<-0 until b.length if b(i) <= 0 ) yield b(i))
                                                  //> res3: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1356397305, 2
                                                  //| 096092240, 2032847273, 1371881060, 478349004, 87695232, 337775392, 45400850
                                                  //| 4, -839425946, -1188120723, -1475399633, -391926850, -1466950398, -87733369
                                                  //| 1, -1788876486, -1773980385, -1432065607, -292716385, -1108777359, -6398899
                                                  //| 92)
  arr                                             //> res4: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1356397305, 2
                                                  //| 096092240, 2032847273, 1371881060, 478349004, 87695232, 337775392, 45400850
                                                  //| 4, -839425946, -1188120723, -1475399633, -391926850, -1466950398, -87733369
                                                  //| 1, -1788876486, -1773980385, -1432065607, -292716385, -1108777359, -6398899
                                                  //| 92)
  //5
   val arrayDouble = Array[Double](1,2,3,4)       //> arrayDouble  : Array[Double] = Array(1.0, 2.0, 3.0, 4.0)
  val arrayDoubleBuffer = ArrayBuffer[Double](4,3,1,2,4,1,2,9,8)
                                                  //> arrayDoubleBuffer  : scala.collection.mutable.ArrayBuffer[Double] = ArrayBu
                                                  //| ffer(4.0, 3.0, 1.0, 2.0, 4.0, 1.0, 2.0, 9.0, 8.0)
  arrayDouble.sum/arrayDouble.length              //> res5: Double = 2.5
   //6
  arrayDouble.sorted.reverse                      //> res6: Array[Double] = Array(4.0, 3.0, 2.0, 1.0)
  arrayDoubleBuffer.sorted                        //> res7: scala.collection.mutable.ArrayBuffer[Double] = ArrayBuffer(1.0, 1.0, 
                                                  //| 2.0, 2.0, 3.0, 4.0, 4.0, 8.0, 9.0)
  //7
  arrayDoubleBuffer.distinct                      //> res8: scala.collection.mutable.ArrayBuffer[Double] = ArrayBuffer(4.0, 3.0, 
                                                  //| 1.0, 2.0, 9.0, 8.0)
                                                  
  //8
  var buff = ArrayBuffer[Int]()                   //> buff  : scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer()
  buff.appendAll(b)
  val negIndexes = (for (i <- 0 until buff.length if buff(i) < 0 ) yield i).reverse.dropRight(1)
                                                  //> negIndexes  : scala.collection.immutable.IndexedSeq[Int] = Vector(19, 18, 1
                                                  //| 6, 12, 11, 9, 8, 7, 5, 3, 1)
  for( i <- negIndexes ) buff.remove(i)
  buff                                            //> res9: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(-839425946, 1
                                                  //| 356397305, 2096092240, 2032847273, 1371881060, 478349004, 87695232, 3377753
                                                  //| 92, 454008504)
  negIndexes                                      //> res10: scala.collection.immutable.IndexedSeq[Int] = Vector(19, 18, 16, 12, 
                                                  //| 11, 9, 8, 7, 5, 3, 1)
  //9
  import java.util.TimeZone
  val ids = for (id <- TimeZone.getAvailableIDs if id.split("/")(0).equals("America") ) yield id
                                                  //> ids  : Array[String] = Array(America/Adak, America/Anchorage, America/Angui
                                                  //| lla, America/Antigua, America/Araguaina, America/Argentina/Buenos_Aires, Am
                                                  //| erica/Argentina/Catamarca, America/Argentina/ComodRivadavia, America/Argent
                                                  //| ina/Cordoba, America/Argentina/Jujuy, America/Argentina/La_Rioja, America/A
                                                  //| rgentina/Mendoza, America/Argentina/Rio_Gallegos, America/Argentina/Salta, 
                                                  //| America/Argentina/San_Juan, America/Argentina/San_Luis, America/Argentina/T
                                                  //| ucuman, America/Argentina/Ushuaia, America/Aruba, America/Asuncion, America
                                                  //| /Atikokan, America/Atka, America/Bahia, America/Bahia_Banderas, America/Bar
                                                  //| bados, America/Belem, America/Belize, America/Blanc-Sablon, America/Boa_Vis
                                                  //| ta, America/Bogota, America/Boise, America/Buenos_Aires, America/Cambridge_
                                                  //| Bay, America/Campo_Grande, America/Cancun, America/Caracas, America/Catamar
                                                  //| ca, America/Cayenne, America/Cayman, America/Chicago, America/Chihuahua, Am
                                                  //| erica/Coral_Harbour, Am
                                                  //| Output exceeds cutoff limit.
  //10
  import java.awt.datatransfer._
/*  import scala.collection.JavaConversions.asScalaBuffer
  import scala.collection.mutable.Buffer
  val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
                                                  //> flavors  : java.awt.datatransfer.SystemFlavorMap = java.awt.datatransfer.Sy
                                                  //| stemFlavorMap@2038ae61
  val cflavors:Buffer[String] = flavors.getNativesForFlavor(DataFlavor.imageFlavor)
                                                  //> cflavors  : scala.collection.mutable.Buffer[String] = Buffer(PNG, JFIF, DIB
                                                  //| , ENHMETAFILE, METAFILEPICT)
|
*/
}