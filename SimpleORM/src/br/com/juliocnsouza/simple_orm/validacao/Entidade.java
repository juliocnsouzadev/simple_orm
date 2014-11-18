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
@Target( { ElementType.TYPE } )
@Retention( RetentionPolicy.RUNTIME )
public @interface Entidade {

    public String nome() default "";

}
