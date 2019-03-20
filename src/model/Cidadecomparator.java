/* *****************************************************************************************
*Autor: João Pedro
*Componente Curricular: MI-Programação 
*Concluido em: 05/02/2019
*Declaro que este código foi elaborado por mim de forma individual e não contém nenhum trecho 
*de código de outro colega ou de outro autor, tais como provindos de livros eapostilas, e 
*páginas ou documentos eletrônicos da Internet. Qualquer trecho de códigode outra autoria 
*que não a minha está destacado com uma citação para o autor e a fontedo código, e estou 
*ciente que estes trechos não serão considerados para fins de avaliação.
***************************************************************************************** */
package model;
import java.util.Comparator;
import util.Cidade;

/**Comparator para a ordenação das cidades de acordo com o valor de suas distrâncias.
 *
 * @author João Pedro
 */
public class Cidadecomparator implements Comparator<Cidade> {
    
    @Override
    public int compare(Cidade cidade1, Cidade cidade2){
        if(cidade1.get_distancia_cidade() > cidade2.get_distancia_cidade()){
            return 1;
        }
        else if(cidade1.get_distancia_cidade() < cidade2.get_distancia_cidade()){
            return -1;
        }
        else return 0;
    }
}
