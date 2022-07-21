import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        /// requisição http para a api, resgatando os top 250 filmes
        // String url = "https://imdb-api.com/en/API/Top250Movies/k_12345678"; // k_12345678 seria o seu código de registro
        // String url = "https://alura-filmes.herokuapp.com/conteudos";
        // String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/TopMovies.json";
        String url = "https://api.mocki.io/v2/549a5d8b/Top250Movies";
        URI uri = URI.create(url); // endereço
        HttpClient client =  HttpClient.newHttpClient();
        HttpRequest request =  HttpRequest.newBuilder(uri).GET().build();
        HttpResponse<String> response =  client.send(request, BodyHandlers.ofString());
        var body = response.body(); // var é uma String, pois o response foi manipulado como String
        // System.out.println(body);

        /// extrair somente os dados interessantes (título, poster, classificação)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> moviesList = parser.parse(body);
        // System.out.println(moviesList.size());
        // System.out.println(moviesList.get(0));

        /// exibir e manipular os dados
        var geradora = new GeradoraDeFigurinhas();
        for (Map<String, String> movie : moviesList) {
            String urlImagem = movie.get("image");
            String movieName = movie.get("title");

            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = "saida/" + movieName + ".png";

            geradora.cria(inputStream, nomeArquivo);

            // System.out.println(movie.get("title"));
            System.out.println(movieName);
            // System.out.println(movie.get("image"));
            // System.out.println(movie.get("imDbRating"));
            System.out.println();
            
        }
    }
}
