package br.com.juliocnsouza.simple_orm.util;

import br.com.juliocnsouza.simple_orm.validacao.Coluna;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * TabelaUtil.java -> Job:
 * <p>
 * @since 17/11/2014
 * @version 1.0
 * @author Julio Cesar Nunes de Souza (julio.souza@mobilitasistemas.com.br)
 */
public class ColunaUtil {

    private static Field[] fields;
    private static List<Campo> campos;

    public static List<Campo> getCampos( Object object )
            throws Exception {
        inicializar( object );
        return campos;
    }

    public static void inicializar( Object object )
            throws Exception {

        if ( object == null ) {
            throw new Exception( "Objeto nulo" );
        }

        fields = object.getClass().getDeclaredFields();

        if ( fields == null ) {
            throw new Exception( "Não tem Campos" );
        }
        campos = new ArrayList<>();
        for ( Field field : fields ) {
            if ( field.isAnnotationPresent( Coluna.class ) ) {
                Campo campo = getCampo( field , object );
                campos.add( campo );
            }
        }
    }

    private static Campo getCampo( Field field , Object object )
            throws IllegalArgumentException ,
                   SecurityException ,
                   IllegalAccessException {
        field.setAccessible( true );
        Annotation anotacao = field.getAnnotation( Coluna.class );
        Coluna coluna = ( Coluna ) anotacao;

        ColunaUtil.Campo campo = new ColunaUtil.Campo();
        Object valor = field.get( object );
        String nome = !coluna.nome().equals( "" )
                      ? coluna.nome()
                      : field.getName();
        boolean temRelacionamento = coluna.relacionamento() != Coluna.Relacionamento.NENHUM;
        if ( temRelacionamento ) {
            campo.setClazzRelacionamento( field.getType() );
        }
        boolean ehDonoRelacionamento = coluna.donaDoRelacionamento();
        campo.setNome( nome );
        campo.setValor( valor );
        campo.setEhDonoRelacionamento( ehDonoRelacionamento );
        campo.setTemRelacionamento( temRelacionamento );
        return campo;
    }

    public static class Campo {

        private String nome;
        private Object valor;
        private boolean temRelacionamento;
        private boolean ehDonoRelacionamento;
        private Class<?> clazzRelacionamento;

        public String getNome() {
            return nome;
        }

        public void setNome( String nome ) {
            this.nome = nome;
        }

        public Object getValor() {
            return valor;
        }

        public void setValor( Object valor ) {
            this.valor = valor;
        }

        public boolean isTemRelacionamento() {
            return temRelacionamento;
        }

        public void setTemRelacionamento( boolean temRelacionamento ) {
            this.temRelacionamento = temRelacionamento;
        }

        public boolean isEhDonoRelacionamento() {
            return ehDonoRelacionamento && temRelacionamento;
        }

        public void setEhDonoRelacionamento( boolean ehDonoRelacionamento ) {
            this.ehDonoRelacionamento = ehDonoRelacionamento;
        }

        public Class<?> getClazzRelacionamento() {
            return clazzRelacionamento;
        }

        public void setClazzRelacionamento(
                Class<?> clazzRelacionamento ) {
            this.clazzRelacionamento = clazzRelacionamento;
        }

        @Override
        public String toString() {
            String clazz = clazzRelacionamento != null && temRelacionamento
                           ? clazzRelacionamento.getSimpleName()
                           : "sem relacionamento";
            return "\n-> Campo:\n" + "nome: " + nome + " | valor: " + valor + " | temRelacionamento: " + temRelacionamento + " | ehDonoRelacionamento: " + ehDonoRelacionamento + " | classeRelacionamento: " + clazz;
        }

    }

}
