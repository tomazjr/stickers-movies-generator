import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
//alt + shift + o

public class ClienteHttp {

    // public para todos poderem acessar esse método
    public String buscaDados(String url){

        try {

            URI endereco = URI.create(url);
            HttpClient client =  HttpClient.newHttpClient();
            HttpRequest request =  HttpRequest.newBuilder(endereco).GET().build();
            // .send pede para tratar um IOException, InterruptedException !
            HttpResponse<String> response =  client.send(request, BodyHandlers.ofString());
            // var é uma String, pois o response foi manipulado como String
            var body = response.body(); 
            // System.out.println(body);

            return body;

        } catch (IOException | InterruptedException e) { // " | " = 'ou'
            System.out.println("Error: " + e);
            // embrulha em uma RuntimeException, que não precisa de tratamento
            throw new RuntimeException(e);
            //TODO Desafio: pode-se criar a sua própria excessão !?
        }

    }
    
}
