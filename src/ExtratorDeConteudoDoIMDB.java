import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// implements é uma assinatura de contrato, onde você deve implementar o que diz o apontado pelo implements
public class ExtratorDeConteudoDoIMDB implements ExtratorDeConteudo{

    public List<Conteudo> extraiConteudos(String json){
        
        /// extrair somente os dados interessantes (título, poster, classificação)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);
        // System.out.println(listaDeAtributos.size());
        // System.out.println(listaDeAtributos.get(0));

        // não dá pra usar = new List ! uma List pode ser gerada desordenada,
        // alocada na memória de diferentes maneiras, então, usa-se uma ArrayList
        List<Conteudo> conteudos = new ArrayList<>();

        // popular lista de conteúdos
        for (Map<String,String> atributos : listaDeAtributos) {
            // verificar no json que a api retorna, os nomes das informações (key)
            String titulo = atributos.get("title");
            // replaceAll específico para tratar o "image" do json imdb
            // usa-se regex para tirar da url (Top250Movies) o que está depois do @, pegando a imagem "maior"
            String urlImagem = atributos.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");
            Conteudo conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);
        }

        return conteudos;
    }
    
}
