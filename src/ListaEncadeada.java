package src;


public class ListaEncadeada<T> {
    private No<T> inicio;
    private No<T> ultimo;
    private int tamanho = 0;
    private final int nEncontrado = -1;

    private final String NAO_EXISTE  = "Posição não existe!";
    private final String LISTA_VAZIA = "Lista está vazia!";

    public void adiciona(T elemento){
        No<T> celula = new No<T>(elemento);
        if(this.tamanho == 0){
        this.inicio = celula;
        this.ultimo = celula; 
        } else {
            this.ultimo.setProximo(celula);
        }
        this.ultimo = celula;
        this.tamanho++;
    }

    public void adicionaInicio(T elemento){
        No<T> novoNo = new No<>(elemento);
        if(this.tamanho == 0){
            this.inicio = novoNo;
            this.ultimo = novoNo;
        } else{
            novoNo.setProximo(this.inicio);
        }
        this.tamanho ++;
    }


    public void adiciona(int posicao, T elemento){
        if(this.posicaoNaoExiste(posicao)){
            throw new IllegalArgumentException(NAO_EXISTE);
        } else if (posicao == 0){
            adicionaInicio(elemento);
        }else if(posicao == this.tamanho){
            adiciona(elemento);
        } else {
            No<T> noAnterior = this.buscaNo(posicao-1);
            No<T> noSeguinte = noAnterior.getProximo();
            No<T> novoNo = new No<>(elemento, noSeguinte);
            noAnterior.setProximo(novoNo);
            this.tamanho ++;
        }
    }

    public int getTamanho(){
        return this.tamanho;
    }

    public void limpa(){
        No<T> atual = this.inicio;
        while(atual.getProximo() != null){
            No<T> proximo = atual.getProximo();
            atual.setElemento(null);
            atual.setProximo(null);
            atual = proximo;
        }

        this.inicio = null;
        this.tamanho = 0;
        this.ultimo = null;
    }

    public T removeInicio(){
        if(this.tamanho == 0){
            throw new IllegalArgumentException (LISTA_VAZIA);
        }
        T removido = this.inicio.getElemento();
        this.inicio = inicio.getProximo();
        tamanho --;
        if(this.tamanho == 0){
            this.ultimo = null;
        }
        return removido;
    }


    public T removeFinal(){
        if(this.tamanho == 0){
            throw new IllegalArgumentException(LISTA_VAZIA);
        }
        if(this.tamanho == 1){
            return this.removeInicio();
        }
        No<T> penultimoNo = this.buscaNo(this.tamanho - 2);
        T removido = penultimoNo.getProximo().getElemento();
        penultimoNo.setProximo(null);
        this.ultimo = penultimoNo;
        this.tamanho --;

        return removido;
    }

    public T remove(int posicao){
        if(this.posicaoNaoExiste(posicao)){
            throw new IllegalArgumentException();
        } 
        if(posicao == 0){
            return this.removeInicio();
        }
        if(posicao == this.tamanho - 1){
            return this.removeFinal();
        }

        No<T> noAnterior = this.buscaNo(posicao-1);
        No<T> noAtual = noAnterior.getProximo();
        No<T> noPosterior = noAtual.getProximo();
        noAnterior.setProximo(noPosterior);
        noAtual.setProximo(null);
        tamanho --;


        return noAtual.getElemento();
    }

    private boolean posicaoNaoExiste(int posicao){
        return posicao < 0 || posicao >= tamanho;
    }


    private No<T> buscaNo(int posicao) {
        if (this.posicaoNaoExiste(posicao)) { 
            throw new IllegalArgumentException(NAO_EXISTE);
        }
    
        No<T> atual = this.inicio;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }
        
        return atual;
    }    

    public T buscaPorPosicao(int posicao){
        return this.buscaNo(posicao).getElemento();
    }

    public int busca(T elemento){

       No<T> atual = this.inicio;
       int pos = 0;

       while(atual != null){
        if(atual.getElemento().equals(elemento)){
            return pos;
        }
        pos++;
        atual = atual.getProximo();
       }

       return nEncontrado  ;
    }


    @Override
    public String toString() {

        if(this.tamanho == 0){
            return "[]";
        }

        /*String ret = "";
        No<T> atual = this.inicio;

        for (int i = 0 ; i < tamanho-1; i++){
            ret += atual.getElemento() + ",";
            atual = atual.getProximo();
        }

        ret += atual.getElemento();
        return ret;*/
        
        StringBuilder builder = new StringBuilder();
        No<T> atual = this.inicio;

        for (int i = 0 ; i < tamanho - 1; i++){
                builder.append(atual.getElemento()).append(",");
                atual = atual.getProximo();
        }

        builder.append(atual.getElemento());
        return builder.toString();
    }

}
