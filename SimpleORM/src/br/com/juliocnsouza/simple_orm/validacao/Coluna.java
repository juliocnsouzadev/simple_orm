package br.com.juliocnsouza.simple_orm.validacao;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Entidade.java -> Job:
 * <p>
 * @since 17/11/2014
 * @version 1.0
 * @author Julio Cesar Nunes de Souza (julio.souza@mobilitasistemas.com.br)
 */
@Documented
@Target( { ElementType.FIELD } )
@Retention( RetentionPolicy.RUNTIME )
public @interface Coluna {

    public enum Relacionamento {

        ONE_TO_ONE,
        ONE_TO_MANY,
        MANY_TO_ONE,
        MANY_TO_MANY,
        NENHUM
    }

    public String nome() default "";

    public Relacionamento relacionamento() default Relacionamento.NENHUM;

    public boolean donaDoRelacionamento() default true;

}
