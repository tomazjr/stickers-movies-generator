import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        // requisição http para a api, resgatando os top 250 filmes
        // String url = "https://imdb-api.com/en/API/Top250Movies/k_12345678"; // k_12345678 seria o seu código de registro
        String url = "https://alura-filmes.herokuapp.com/conteudos";
        URI uri = URI.create(url); // endereço
        HttpClient client =  HttpClient.newHttpClient();
        HttpRequest request =  HttpRequest.newBuilder(uri).GET().build();
        HttpResponse<String> response =  client.send(request, BodyHandlers.ofString());
        var body = response.body(); // var é uma String, pois o response foi manipulado como String
        // System.out.println(body);

        // extrair somente os dados interessantes (título, poster, classificação)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> moviesList = parser.parse(body);
        // System.out.println(moviesList.size());
        // System.out.println(moviesList.get(0));

        // exibir e manipular os dados
        for (Map<String, String> movie : moviesList) {
            System.out.println(movie.get("title"));
            System.out.println(movie.get("image"));
            System.out.println(movie.get("imDbRating"));
            System.out.println();
            
        }
    }
}
