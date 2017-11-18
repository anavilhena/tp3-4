package inter.expr.bool;

import inter.expr.Expr;
import lexer.Token;

/**
 * Universidade Federal de Minas Gerais
 *
 * Disciplina: 
 *
 * Compiladores I
 *
 * @author Isabel Bicalho Amaro
 * Matrícula: 2013431427
 *
 * <p>
 * Funcionalidade: Implementa o funcionamento do Or lógico.
 * </p>
 *
 * Criado em: 29 de nov de 2015
 */
public class Or extends Logical
{
  /**
   * Construtor.
   * 
   * @param tok Operador lógico.
   * @param x1 Expressão booleana 1.
   * @param x2 Expressão booleana 2.
   */
  public Or (Token tok, Expr x1, Expr x2)
  {
    super(tok,x1,x2);
  }
  
  /**
   * Gera código de desvio para a expressão boleana B = B1 || B2.
   * 
   * @param t True.
   * @param f False.
   */
  public void jumping(int t, int f)
  {
    int label = t != 0 ? t : newLabel();
    expr1.jumping(label, 0);
    expr2.jumping(t, f);
    if (t == 0)
    {
      emitLabel(label);
    }
  }
}
