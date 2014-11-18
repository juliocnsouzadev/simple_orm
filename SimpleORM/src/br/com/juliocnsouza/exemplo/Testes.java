package br.com.juliocnsouza.exemplo;

import br.com.juliocnsouza.exemplo.model.Pessoa;
import br.com.juliocnsouza.exemplo.model.PessoaFisica;
import br.com.juliocnsouza.simple_orm.util.ColunaUtil;
import br.com.juliocnsouza.simple_orm.util.QueryUtil;
import br.com.juliocnsouza.simple_orm.util.TabelaUtil;

/**
 * Testes.java -> Job:
 * <p>
 * @since 17/11/2014
 * @version 1.0
 * @author Julio Cesar Nunes de Souza (julio.souza@mobilitasistemas.com.br)
 */
public class Testes {

    public static void main( String[] args ) {
        Pessoa pessoa = new Pessoa();
        pessoa.setAreaEstudo( "Estudo as Arvores" );
        pessoa.setNome( "Adalberto Soares" );

        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica.setPessoa( pessoa );

        try {
            System.out.println( "Nomes Tabelas:" );
            System.out.println( TabelaUtil.getNomeTabela( pessoa ) );
            System.out.println( TabelaUtil.getNomeTabela( pessoaFisica ) );

            System.out.println( "\nCampos Tabelas:" );
            System.out.println( TabelaUtil.getNomeTabela( pessoa ) );
            System.out.println( ColunaUtil.getCampos( pessoa ) + "\n" );
            System.out.println( TabelaUtil.getNomeTabela( pessoaFisica ) );
            System.out.println( ColunaUtil.getCampos( pessoaFisica ) );

            System.out.println( "\nQueries" );
            System.out.println( "\nInsert: " + TabelaUtil.getNomeTabela( pessoa ) );
            System.out.println( QueryUtil.getInsert( pessoa ) );
            System.out.println( "\nInsert: " + TabelaUtil.getNomeTabela( pessoaFisica ) );
            System.out.println( QueryUtil.getInsert( pessoaFisica ) );

        }
        catch ( Exception ex ) {
            System.out.println( "Erro: " + ex.getMessage() );
        }
    }

}
