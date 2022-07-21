import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {
        /// leitura da imagem
            // pegando um file localizado localmente, do SO
        // BufferedImage imagemOriginal = ImageIO.read(new File("entrada/top_gun_maverick_2022.jpg"));
            // a classe InputStream é abstrada, portanto, não pode-se instanciá-la
        // InputStream inputStream = new FileInputStream(new File("entrada/top_gun_maverick_2022.jpg"));
            // pegando o poster de uma url; o .openStream retorna uma InputStream
        // InputStream inputStream = new URL("https://imersao-java-apis.s3.amazonaws.com/MostPopularMovies_3.jpg").openStream();
            // poliformismo: pode-se criar um BufferedImage de qualquer InputStream, não importanto de onde ele é gerado, se é de um FileInputStream ou de uma URL
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        /// cria nova imagem, em memória, com transparência e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
            // "tipo" da imagem transparente
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        /// copiar a iamgem original para nova imagem (em memória)
            // por padrão .getGraphics é um Graphics, = (Graphics2D) força o retorno ser Graphics2D
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
            // "escreve" a imagem antiga na nova imagem
        graphics.drawImage(imagemOriginal, 0, 0, null); 
        
        /// configurar a fonte da frase a ser escrita
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 86);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        /// escrever uma frase na nova imagem
        graphics.drawString("TOPZERA", 304, novaAltura - 75);

        /// escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));
    }

    /// Criado para testes
    // public static void main(String[] args) throws Exception {
    //     var geradora = new GeradoraDeFigurinhas();
    //     geradora.cria();
    // }
}

