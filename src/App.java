import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        /// requisição http para a api, resgatando as informações do conteúdo
        //TODO Desafio: explorar outras apis
        //TODO Desafio: tratar a api (url-ExtratorDeConteudo) em uma enum !?
        // k_12345678 seria o seu código de registro

        // String url = "https://imdb-api.com/en/API/Top250Movies/k_0ojt0yvm";
        // ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();
        
        // String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/TopMovies.json";
        // ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();

        // String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json";
        // ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();

        String url = "http://localhost:8080/linguagens";
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        /// exibir e manipular os dados
        
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new GeradoraDeFigurinhas();

        // percorrer a lista de conteudos
        // for (Conteudo conteudo : conteudos) {
        for (int i = 0; i < 3; i++){

            // extrair o filme, e depois suas informações
            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";

            geradora.cria(inputStream, nomeArquivo);

            // System.out.println(conteudo.get("title"));
            System.out.println(conteudo.getTitulo());
            // System.out.println(conteudo.get("image"));
            // System.out.println(conteudo.get("imDbRating"));
            System.out.println();
            
        }
    }
}
