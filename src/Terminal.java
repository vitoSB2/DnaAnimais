import java.io.IOException;
import java.util.Scanner;

public class Terminal {

    // 1 = Duck; 2: Chicken; 3: Rhea; 4: Ostrich; 5: Falcon; 6: Subosc; 7: Oscine; 8: Aligat; 9: Turtle
    public int animal = 1;
    public int compatibilidade;
    public float porcentagem;
    public Scanner input;
    public AnaliseDna dna;

    public Terminal(){
        input = new Scanner(System.in);
        dna = new AnaliseDna();
    }

    public void apresentarMensagem(){
        try {
            dna.extrairStrings();
        } catch (IOException e) {
            System.out.println("An error occurred while extracting DNA strings: " + e.getMessage());
        }

        while(animal>0 && animal < 10){
            System.out.println("\n\n1 = Duck; 2: Chicken; 3: Rhea; \n4: Ostrich; 5: Falcon; 6: Subosc; \n7: Oscine; 8: Aligat; 9: Turtle");
            System.out.println("Escolha uma das opcoes de animal para descobrir qual DNA animal mais se aproxima ao dele: ");
            animal = input.nextInt();
            if (animal>0 && animal < 10)
                analisarDnaAnimal();
        }
    }

    public void analisarDnaAnimal(){
        System.out.println("\nCompatibilidade com esse animal:");
        for(int i=0; i<9; i++){
            if(i != animal-1){
                compatibilidade = dna.comparar(animal-1, i);
               porcentagem = ((float)compatibilidade/14043)*100;

                System.out.println(
                    switch (i+1) {
                        case 1 -> "Duck: ";
                        case 2 -> "Chicken: ";
                        case 3 -> "Rhea: ";
                        case 4 -> "Ostrich: ";
                        case 5 -> "Falcon: ";
                        case 6 -> "Subosc: ";
                        case 7 -> "Oscine: ";
                        case 8 -> "Aligat: ";
                        case 9 -> "Turtle: ";
                        default -> "Unknown animal: ";
                    }
                    + porcentagem + "%"
                );
            }
        }
    }

}
