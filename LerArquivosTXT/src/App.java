import java.nio.file.*;
import java.util.List;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        

        String caminhoDoArquivo = "C:\\Temp\\compras.txt";
        Path path = Paths.get(caminhoDoArquivo); //varíavel do local do arquivo, Paths.get retorna um caminho/url

        // Path path = Path.of("C:\\Temp\\compras.txt"); JAVA 11
        
        if (Files.notExists(path)) {//para verificar se o arquivo já não existe
           Files.createFile(path);//para criar o arquivo no caminho mencionado acima
        }

        String frase = "\nola mundo";

        byte[] fraseBytes = frase.getBytes();
        Files.write(path, fraseBytes);
        // Files.writeString(path,texto); JAVA 11


        //Método para ler com readAllLines
        List<String> strings = Files.readAllLines(path);//para ler o arquivo e ler todas as linhas

        for (String texto : strings) {
            System.out.println(texto);
        }

        //Método para ler com readAllBytes
        byte[] bytes = Files.readAllBytes(path);

        ///String texto = bytes.toString(); Não Funciona 
        String texto = new String(bytes);//para converter o bytes de forma correta

        System.out.println(texto);

        JOptionPane.showMessageDialog(null, texto);//para apresentar uma caixa de dialogo do java

    
        Files.delete(path);//para excluir o arquivo pelo caminho 
    }
}
