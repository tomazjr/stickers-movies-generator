import java.util.List;

/// interface diz tudo o que um objeto precisa fazer, sem dizer como ele deve fazer !
/// quam vai dizer como ele deve fazer, são as várias implementações da interface
// uma interface une objetos, faz o desacoplamento
public interface ExtratorDeConteudo {

    public List<Conteudo> extraiConteudos(String json);
    
}
