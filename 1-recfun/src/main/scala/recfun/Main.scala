package recfun
import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int =
    if (c==0 || c==r)
      1
    else
      pascal(c-1, r-1) + pascal(c, r-1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {

    @tailrec
    def balanceAcc(chars: List[Char], balance: Int): Boolean =
      if (balance < 0)
        false
      else if (chars.isEmpty)
        balance == 0
      else {
        val patch = if (chars.head == '(') 1 else if (chars.head == ')') -1 else 0
        balanceAcc(chars.tail, balance + patch)
      }

    balanceAcc(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int =
    if (money == 0)
      1
    else if (money < 0)
      0
    else if (coins.isEmpty)
      0
    else
      countChange(money-coins.head, coins) + countChange(money, coins.tail)

}
