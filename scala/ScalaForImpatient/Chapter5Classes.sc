import scala.beans.BeanProperty

object Chapter5Classes {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  class Counter{
  	private var value = 0
  	def increment() =
  	if (value == Int.MaxValue )
  		value
  		else
  	value += 1
  	
  	
  	def current() = value
  }
  val counter = new Counter()                     //> counter  : Chapter5Classes.Counter = Chapter5Classes$Counter$1@6bdf28bb
  counter.increment()                             //> res0: AnyVal = ()
  println(counter.current)                        //> 1
  /* 2 */
  class BankAccount{
  	private var balance_ = 0.0;
  	def balance = balance_ ;
  	def deposit(amount: Double) = if (amount > 0)
  			balance_ += amount
  		else
  			balance_
  	def withdraw(amount: Double) = if (balance_ - amount > 0) balance_ -= amount else amount
  }
 	val account = new BankAccount             //> account  : Chapter5Classes.BankAccount = Chapter5Classes$BankAccount$1@e5809
                                                  //| 29
 	println(account.balance)                  //> 0.0
 	account.withdraw(100)                     //> res1: AnyVal = 100.0
 	println(account.balance)                  //> 0.0
 	account.deposit(120)                      //> res2: AnyVal = ()
 	println(account.balance)                  //> 120.0
 	account.withdraw(10)                      //> res3: AnyVal = ()
 	println(account.balance)                  //> 110.0
 	/* 3 */
 	class Time(val hours:Long, val minutes: Long){
 		private val minsSinceMidnight = 60*hours + minutes
 		//def before(other: Time) = other.hours > hours || ((other.hours == hours) && other.minutes > minutes)
 		def before(other: Time) = other.minsSinceMidnight > minsSinceMidnight
 	}
 	var time1 = new Time(12,12)               //> time1  : Chapter5Classes.Time = Chapter5Classes$Time$1@1cd072a9
 	var time2 = new Time(12,11)               //> time2  : Chapter5Classes.Time = Chapter5Classes$Time$1@7c75222b
 	time1.before(time2)                       //> res4: Boolean = false
 	time2.before(time1)                       //> res5: Boolean = true
 	/* 5 */
 	class Student(@BeanProperty var name: String,@BeanProperty var id: Long){
 	}
}