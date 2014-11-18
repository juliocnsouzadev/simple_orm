package br.com.juliocnsouza.exemplo.model;

import br.com.juliocnsouza.simple_orm.validacao.Coluna;
import br.com.juliocnsouza.simple_orm.validacao.Entidade;

/**
 * Pessoa.java -> Job:
 * <p>
 * @since 17/11/2014
 * @version 1.0
 * @author Julio Cesar Nunes de Souza (julio.souza@mobilitasistemas.com.br)
 */
@Entidade
public class Pessoa {

    @Coluna
    private String nome;

    @Coluna( nome = "area_estudo" )
    private String areaEstudo;

    public String getNome() {
        return nome;
    }

    public void setNome( String nome ) {
        this.nome = nome;
    }

    public String getAreaEstudo() {
        return areaEstudo;
    }

    public void setAreaEstudo( String areaEstudo ) {
        this.areaEstudo = areaEstudo;
    }

    @Override
    public String toString() {
        return nome;
    }

}
