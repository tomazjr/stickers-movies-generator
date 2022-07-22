public class Conteudo {

    // private restringe o acesso a esse atributo,
    // permitindo somente a própria class acessá-lo diretamente,
    // final para não alterar depois de criado
    private final String titulo;
    private final String urlImagem;

    // botão direito - Source Actions - Generate Constructors
    public Conteudo(String titulo, String urlImagem) {
        this.titulo = titulo;
        this.urlImagem = urlImagem;
    }

    // botão direito - Source Actions - Generate Getters
    public String getTitulo() {
        return titulo;
    }

    public String getUrlImagem() {
        return urlImagem;
    }
    // aqui não há necessidade de Setters, pois depois de passar pelo JsonParser,
    // essas informações não serão mais alteradas !

    
    
}
