import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        /// requisição http para a api, resgatando os top 250 filmes
        // String url = "https://imdb-api.com/en/API/Top250Movies/k_12345678"; // k_12345678 seria o seu código de registro
        // String url = "https://alura-filmes.herokuapp.com/conteudos";
        // String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/TopMovies.json";
        // String url = "https://api.mocki.io/v2/549a5d8b/Top250Movies";
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json";

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        /// extrair somente os dados interessantes (título, poster, classificação)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeConteudos = parser.parse(json);
        // System.out.println(listaDeConteudos.size());
        // System.out.println(listaDeConteudos.get(0));

        /// exibir e manipular os dados
        var geradora = new GeradoraDeFigurinhas();

        // percorrer a lista de filmes
        // for (Map<String, String> conteudo : listaDeConteudos) {
        for (int i = 0; i < 3; i++){

            // extrair o filme, e depois suas informações
            Map<String,String> conteudo = listaDeConteudos.get(i);

            // String urlImagem = conteudo.get("image");
            // usa-se regex para tirar da url (Top250Movies) o que está depois do @, pegando a imagem "maior"
            String urlImagem = 
            // conteudo.get("image")
            conteudo.get("url")
            .replaceAll("(@+)(.*).jpg$", "$1.jpg");

            String movieName = conteudo.get("title");

            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = "saida/" + movieName + ".png";

            geradora.cria(inputStream, nomeArquivo);

            // System.out.println(conteudo.get("title"));
            System.out.println(movieName);
            // System.out.println(conteudo.get("image"));
            // System.out.println(conteudo.get("imDbRating"));
            System.out.println();
            
        }
    }
}
