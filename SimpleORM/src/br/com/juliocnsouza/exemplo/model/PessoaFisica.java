package br.com.juliocnsouza.exemplo.model;

import br.com.juliocnsouza.simple_orm.validacao.Coluna;
import br.com.juliocnsouza.simple_orm.validacao.Entidade;

/**
 * PessoaFisica.java -> Job:
 * <p>
 * @since 17/11/2014
 * @version 1.0
 * @author Julio Cesar Nunes de Souza (julio.souza@mobilitasistemas.com.br)
 */
@Entidade( nome = "pessoa_fisica" )
public class PessoaFisica {

    @Coluna( primaryKey = true )
    private long id;

    @Coluna( donaDoRelacionamento = true ,
             relacionamento = Coluna.Relacionamento.ONE_TO_ONE )
    private Pessoa pessoa;

    public long getId() {
        return id;
    }

    public void setId( long id ) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa( Pessoa pessoa ) {
        this.pessoa = pessoa;
    }

}
