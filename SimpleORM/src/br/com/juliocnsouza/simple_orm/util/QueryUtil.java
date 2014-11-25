package br.com.juliocnsouza.simple_orm.util;

import java.util.ArrayList;
import java.util.List;

/**
 * QueryUtil.java -> Job:
 * <p>
 * @since 17/11/2014
 * @version 1.0
 * @author Julio Cesar Nunes de Souza (julio.souza@mobilitasistemas.com.br)
 */
public class QueryUtil {

    private static List<String> preQueries;

    public static String getInsert( Object object )
            throws Exception {
        preQueries = new ArrayList<>();
        StringBuilder query = createInsert( object );
        return query.toString();
    }

    private static StringBuilder createInsert( Object object )
            throws Exception {

        String tabela = TabelaUtil.getNomeTabela( object );
        List<ColunaUtil.Campo> campos = ColunaUtil.getCampos( object );
        StringBuilder query = new StringBuilder( "INSERT INTO " + tabela + " (" );
        getDados( campos , query , true );
        query.append( ") values (" );
        getDados( campos , query , false );
        query.append( ");" );

        StringBuilder finalQuery = new StringBuilder();
        if ( !preQueries.isEmpty() ) {
            for ( String q : preQueries ) {
                finalQuery.append( q ).append( "\n" );
            }
        }
        finalQuery.append( query.toString() );
        return finalQuery;
    }

    private static void getDados( List<ColunaUtil.Campo> campos , StringBuilder query , boolean nome )
            throws Exception {
        int index = 0;
        for ( ColunaUtil.Campo campo : campos ) {
            index++;

            if ( nome ) {
                query.append( campo.getNome() );
            }
            else {
                if ( campo.isTemRelacionamento() ) {
                    if ( campo.isEhDonoRelacionamento() ) {
                        preQueries.add( createInsert( campo.getValor() ).toString() );
                        campo.setValor( getQueryUltimoInserido( campo.getValor() ) );
                    }
                }
                query.append( "\'" ).append( campo.getValor() ).append( "\'" );
            }
            if ( index == campos.size() ) {
                break;
            }
            else {
                query.append( ", " );
            }
        }
    }

    private static Object getQueryUltimoInserido( Object valor )
            throws Exception {
        String tabela = TabelaUtil.getNomeTabela( valor );
        String query = "SELECT LAST_INSERT_ID() INTO " + tabela; //MySQL
        return query;
    }

}
