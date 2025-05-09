import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AnaliseDna {

    // 0 = Duck; 1: Chicken; 2: Rhea; 3: Ostrich; 4: Falcon; 5: Subosc; 6: Oscine; 7: Aligat; 8: Turtle
    String[] animais;
    File Birds;
    BufferedReader leitor;
    int numAnimal = 0;
    int compatibilidade = 0;

    public AnaliseDna(){
        Birds = new File("res/Birds.nex");
        animais = new String[9];
    }

    // COLOCA O DNA DE CADA ANIMAL NA SEU RESPECTIVA STRING
    public void extrairStrings() throws IOException {

        try {
            leitor = new BufferedReader(new FileReader(Birds));
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }

        boolean inMatrix = false;
        String linha;

        while ((linha = leitor.readLine()) != null) {
            
            linha = linha.trim();
            if (linha.toLowerCase().startsWith("matrix")) {
                inMatrix = true;
                continue;
            } else if (linha.equals(";")) {
                inMatrix = false;
            }

            if (inMatrix && !linha.isEmpty()) {
                String[] partes = linha.split("\\s+");
                animais[numAnimal] = partes[1];
                numAnimal++;
            }
        }
    }

    // COMPARA O DNA DO ANIMAL SELECIONADO COM O DNA DO RESTO
    public int comparar(int animal, int comparado){

        compatibilidade = 0;
        char base1, base2;
        for(int j=0; j<animais[animal].length(); j++){
            base1 = animais[animal].charAt(j);
            base2 = animais[comparado].charAt(j);

            if(base1 == base2) compatibilidade++;
        }
        return compatibilidade;
    }
}
