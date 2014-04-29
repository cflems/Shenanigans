package org.archphantom.shenanigans.parser
/*
import org.archphantom.shenanigans.elements.expressions._
import org.archphantom.shenanigans.elements.expressions.statements._
import org.archphantom.shenanigans.elements.values._
import scala.util.parsing.combinator._
import scala.util.parsing.combinator.lexical.StdLexical
import scala.util.parsing.combinator.syntactical.StandardTokenParsers
import org.archphantom.shenanigans.elements.expressions.operations._

object ShenaniganParser extends StandardTokenParsers {
  override val lexical = new ShenaniLexer
  
  def parse (input : String) {
    
  }
  
  def boolean : Parser[BoolValue] = ("true" | "false")  ^^ {
    s => new BoolValue(s.toBoolean)
  }
  
  def string : Parser[Array] = stringLit ^^ {
    s => new Array(s)
  }
  
  def double : Parser[DecimalValue] = numericLit ^^ {
    s => new DecimalValue(s)
  }
  
  def int : Parser[IntValue] = """\-?[0-9]+""".r ^^ {
    s => new IntValue(s)
  }
  
  def parens : Parser[Expression] = "(" ~> expr <~ ")"
  
  def unaryMinus:Parser[Subtraction] = "-" ~> expr ^^ { new Subtraction(new IntValue(0), expr) }
    
  def literal : Parser[Value] = boolean | string | double | int
    
  def variable : Parser[Variable] = """[a-zA-Z_]([\w\.]*\w)?""".r ^^ {
    s => new Variable(s)
  }
  
  def expr = literal | variable
  
}

class ShenaniLexer extends StdLexical {
  
}*/