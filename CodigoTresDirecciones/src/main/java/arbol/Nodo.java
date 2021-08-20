package arbol;

/**
 * @author hectoradolfo
 */
public class Nodo {

    /**
     * Enumeración de los posibles tipos para un nodo del árbol de sintaxis
     * abstracta.
     */
    public static enum Tipo {
        SUMA,
        RESTA,
        MULTIPLICACION,
        DIVISION,
        NEGATIVO,
        NUMERO
    }
    /**
     * Tipo del nodo.
     */
    private final Tipo tipo;
    private Nodo operadorIzq;
    private Nodo operadorDer;
    /**
     * Valor que almacena el nodo cuando se trata de un numero.
     */
    private String valor;

    private String datos;
    private int contador = 0;
    private String variable;
    private int hijos;
    private boolean inicio = false;
    private int bandera;

    /**
     * Constructor para los nodos que tienen dos hijos, es decir, los de tipo
     * SUMA, RESTA, MULTIPLICACIÓN Y DIVISION
     *
     * @param operadorIzq operador izquierdo de la operación
     * @param operadorDer operador derecho de la operación
     * @param tipo tipo de operación
     */
    public Nodo(Nodo operadorIzq, Nodo operadorDer, Tipo tipo) {
        this.tipo = tipo;
        this.operadorIzq = operadorIzq;
        this.operadorDer = operadorDer;
    }

    /**
     * Constructor para los nodos que solo tienen un hijo, es decir, los de tipo
     * NEGATIVO
     *
     * @param operadorIzq operador izquierdo de la operación
     * @param tipo tipo de operación
     */
    public Nodo(Nodo operadorIzq, Tipo tipo) {
        this.tipo = tipo;
        this.operadorIzq = operadorIzq;
    }

    /**
     * Constructor para los nodos que no tienen hijos, es decir, los de tipo
     * NUMERO
     *
     * @param valor Valor específico del número que almacena el nodo
     */
    public Nodo(String valor) {
        this.tipo = Tipo.NUMERO;
        this.valor = valor;
    }

    public void inorden(Nodo a, String var,int conta) {
        datos = "";
        contador= conta + 1;
        bandera = 1;
        hijos = 1;
        variable = "";
        inicio = true;
        try {
            System.out.println("Recorrido Preorden del árbol binario de búsqueda:");
            ordenarInorden(a);
            if (hijos != 1) {
                variable += var + "= t" + (contador - 1) + "\n";
            }
            System.out.println();
        } catch (Exception e) {
        }
    }

    private void ordenarInorden(Nodo a) {

        if (a.operadorIzq == null || a.operadorDer == null) {
            if (hijos == 1) {
                datos += variable + " = " + a.valor + " ";
                System.out.println(a.valor + "," + a.tipo);
                return;
            } else {
                if (a.tipo == Tipo.NEGATIVO) {
                    datos += "-" + a.operadorIzq.valor + "\n";
                    System.out.println(a.valor + "," + a.tipo);
                    return;
                }
                if (inicio) {
                    System.out.println(a.valor + "," + a.tipo);
                    inicio = false;
                } else {
                    datos += a.valor + "\n";
                    System.out.println(a.valor + "," + a.tipo);
                }
                return;
            }

        }

        // System.out.print(a.valor + ",");
        hijos++;
        ordenarInorden(a.operadorIzq);

        switch (a.tipo) {
            case MULTIPLICACION:
                if (bandera == 1) {
                    datos += "t" + contador + " = " + a.operadorIzq.valor + " * ";

                } else {
                    if (a.operadorDer.tipo == Tipo.NUMERO && a.operadorIzq.tipo == Tipo.NUMERO) {
                        datos += "t" + contador + " = " + a.operadorIzq + " * ";
                        contador--;
                    } else {
                        datos += "t" + contador + " = " + "t" + (contador - 1) + " * ";
                    }
                }
                contador++;
                bandera++;
                System.out.println(" * " + a.tipo);
                break;
            case SUMA:
                if (bandera == 1) {
                    datos += "t" + contador + " = " + a.operadorIzq.valor + " + ";

                } else {
                    if (a.operadorDer.tipo == Tipo.NUMERO && a.operadorIzq.tipo == Tipo.NUMERO) {
                        datos += "t" + contador + " = " + a.operadorIzq + " + ";
                        contador--;
                    } else {
                        datos += "t" + contador + " = " + "t" + (contador - 1) + " + ";
                    }
                }
                contador++;
                bandera++;
                System.out.println("+ ," + a.tipo);
                break;
            case DIVISION:
                if (bandera == 1) {
                    datos += "t" + contador + " = " + a.operadorIzq.valor + " / ";

                } else {
                    if (a.operadorDer.tipo == Tipo.NUMERO && a.operadorIzq.tipo == Tipo.NUMERO) {
                        datos += "t" + contador + " = " + a.operadorIzq + " / ";
                        contador--;
                    } else {
                        datos += "t" + contador + " = " + "t" + (contador - 1) + " / ";
                    }
                }
                contador++;
                bandera++;
                System.out.println("/ ," + a.tipo);
                break;
            case RESTA:
                if (bandera == 1) {
                    datos += "t" + contador + " = " + a.operadorIzq.valor + " - ";

                } else {
                    if (a.operadorDer.tipo == Tipo.NUMERO && a.operadorIzq.tipo == Tipo.NUMERO) {
                        datos += "t" + contador + " = " + a.operadorIzq + " - ";
                        contador--;
                    } else {
                        datos += "t" + contador + " = " + "t" + (contador - 1) + " - ";
                    }
                    // datos += " + ";
                }
                contador++;
                bandera++;
                System.out.println("- ," + a.tipo);
                break;
        }

        /*datos += a.valor.toString() + ",";
        System.out.println(a.valor + "," + a.tipo);*/
        ordenarInorden(a.operadorDer);
    }

    /**
     * @return the datos
     */
    public String getDatos() {
        return datos;
    }

    public String getVariable() {
        return variable;
    }
    
    public int getContador() {
        return contador;
    }

}
