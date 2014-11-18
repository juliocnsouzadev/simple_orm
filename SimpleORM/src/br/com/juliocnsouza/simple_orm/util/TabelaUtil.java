package br.com.juliocnsouza.simple_orm.util;

import br.com.juliocnsouza.simple_orm.validacao.Entidade;
import java.lang.annotation.Annotation;

/**
 * TabelaUtil.java -> Job:
 * <p>
 * @since 17/11/2014
 * @version 1.0
 * @author Julio Cesar Nunes de Souza (julio.souza@mobilitasistemas.com.br)
 */
public class TabelaUtil {

    public static String getNomeTabela( Object object )
            throws Exception {
        if ( object == null ) {
            throw new Exception( "Objeto nulo" );
        }

        if ( !object.getClass().isAnnotationPresent( Entidade.class ) ) {
            throw new Exception( "Não é entidade" );
        }
        return getNomeEntidade( object );
    }

    private static String getNomeEntidade( Object object ) {
        Annotation anotacao = object.getClass().getAnnotation( Entidade.class );
        Entidade entidadeAnot = ( Entidade ) anotacao;
        String nomeEntidade = entidadeAnot.nome();
        if ( nomeEntidade.equals( "" ) ) {
            return object.getClass().getSimpleName();
        }
        return nomeEntidade;
    }

}
