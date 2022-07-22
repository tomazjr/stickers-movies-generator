import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaNasa implements ExtratorDeConteudo{

    public List<Conteudo> extraiConteudos(String json){
        
        /// extrair somente os dados interessantes (título, poster, classificação)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);
        // System.out.println(listaDeAtributos.size());
        // System.out.println(listaDeAtributos.get(0));

        // não dá pra usar = new List ! uma List pode ser gerada desordenada,
        // alocada na memória de diferentes maneiras, então, usa-se uma ArrayList
        //TODO Desafio: tabalhar com Stream e Lambdas !?
        List<Conteudo> conteudos = new ArrayList<>();

        // popular lista de conteúdos
        for (Map<String,String> atributos : listaDeAtributos) {
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("url");
            Conteudo conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);
        }

        return conteudos;
    }
    
}
