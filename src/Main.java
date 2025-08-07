package src;

public class Main {
    public static void main(String[] args) {
        testesIniciais();
        adicionaElementos();
        removeElementos();
    }

    public static void removePosicao(){
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.adiciona(1);
        lista.adiciona(2);
        lista.adiciona(3);
        lista.adiciona(4);

        System.out.println("elemento removido: " + lista.remove(0));
        System.out.println(lista);
        System.out.println("elemento removido: " + lista.remove(1));
        System.out.println(lista);
        System.out.println("elemento removido: " + lista.remove(1));
        System.out.println(lista);
        System.out.println("elemento removido: " + lista.remove(0));
        System.out.println(lista);
    }

    public static void removeElementos(){
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.adiciona(1);
        lista.adiciona(2);
        lista.adiciona(3);

        System.out.println("elemento removido: " + lista.removeFinal());
        System.out.println(lista);
        System.out.println("elemento removido: " + lista.removeFinal());
        System.out.println(lista);
        System.out.println("elemento removido: " + lista.removeFinal());
        System.out.println(lista);
     
    }

    public static void adicionaElementos(){
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.adiciona(1);
        lista.adiciona(3);
        lista.adiciona(5);

        lista.adiciona(2,2);
        lista.adiciona(3,4);
        System.out.println(lista);

        System.out.println(lista.removeInicio());
        System.out.println(lista);
       
    }

    public static void testesIniciais(){
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.adiciona(1);
        

        System.out.println(lista);
        
        lista.adiciona(2);
        System.out.println(lista);
        lista.adiciona(3);
        System.out.println(lista);

        /*lista.limpa();
        System.out.println(lista);

        System.out.println(lista.busca(0));
        System.out.println(lista.busca(1));
        System.out.println(lista.busca(2));*/

       
        System.out.println("\n*****Busca por posição*****");
        System.out.println(lista.buscaPorPosicao(0));
        System.out.println(lista.buscaPorPosicao(1));
        System.out.println(lista.buscaPorPosicao(2));
    }
}
