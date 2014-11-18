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

    @Coluna( primaryKey = true )
    private long id;

    @Coluna
    private String nome;

    @Coluna( nome = "area_estudo" )
    private String areaEstudo;

    public long getId() {
        return id;
    }

    public void setId( long id ) {
        this.id = id;
    }

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
