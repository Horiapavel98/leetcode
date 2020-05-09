object RomanToInteger {


    def romanToIntLS(ls: List[Char]) : Int = ls match {
        case Nil => 0
        case 'I'::'V'::rest => 4 + romanToIntLS(rest)
        case 'I'::'X'::rest => 9 + romanToIntLS(rest)
        case 'X'::'L'::rest => 40 + romanToIntLS(rest)
        case 'X'::'C'::rest => 90 + romanToIntLS(rest)
        case 'C'::'D'::rest => 400 + romanToIntLS(rest)
        case 'C'::'M'::rest => 900 + romanToIntLS(rest)
        case 'I'::rest => 1 + romanToIntLS(rest)
        case 'V'::rest => 5 + romanToIntLS(rest)
        case 'X'::rest => 10 + romanToIntLS(rest)
        case 'L'::rest => 50 + romanToIntLS(rest)
        case 'C'::rest => 100 + romanToIntLS(rest)
        case 'D'::rest => 500 + romanToIntLS(rest)
        case 'M'::rest => 1000 + romanToIntLS(rest)
        case _ => 0
    }

    def romanToInt(s: String) : Int = {
        return romanToIntLS(s.toList)
    }

    def main(args: Array[String]) : Unit = {

        println(romanToInt("MCMXCIV"))
    }

}