/* *****************************************************************************************
*Autor: Nilton Cerqueira Bento de Oliveira Júnior
*Componente Curricular: MI-Programação 
*Concluido em: 05/02/2019
*Declaro que este código foi elaborado por mim de forma individual e não contém nenhum trecho 
*de código de outro colega ou de outro autor, tais como provindos de livros eapostilas, e 
*páginas ou documentos eletrônicos da Internet. Qualquer trecho de códigode outra autoria 
*que não a minha está destacado com uma citação para o autor e a fontedo código, e estou 
*ciente que estes trechos não serão considerados para fins de avaliação.
***************************************************************************************** */
package util;

/**
 *Aresta. Guarda as cidades que ela liga e sua distância
 * @author juniorlopes
 */
public class Aresta {
    private final Cidade cid1;
    private final Cidade cid2;
    private final int distancia;
    /**
     * Contrutor. recebe duas cidades e suas distâncias, uma origem e outra o destino
     * @param cid1
     * @param cid2
     * @param distancia 
     */
    public Aresta(Cidade cid1, Cidade cid2, int distancia) {
        this.cid1 = cid1;
        this.cid2 = cid2;
        this.distancia = distancia;
    }
    /**
     * retorna a primeira cidade 
     * @return 
     */
    public Cidade getCid1() {
        return cid1;
    }
    /**
     * retorna a segunda cidade
     * @return 
     */
    public Cidade getCid2() {
        return cid2;
    }
    /**
     * retorna a distância
     * @return 
     */
    public int getDistancia() {
        return distancia;
    }
    
}
