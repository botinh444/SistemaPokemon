import java.util.ArrayList;

public class Treinador {
    private String nome;
    private int idade;
    private String[] medalhas;
    private ArrayList<Pokemon> equipe;
    private int contadorMedalhas;

    public Treinador(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.medalhas = new String[8];
        this.equipe = new ArrayList<>(6);
        this.contadorMedalhas = 0;
    }

    public String getNome() {
        return nome;
    }

    public void adicionarPokemon(Pokemon pokemon) {
        if (equipe.size() < 6) {
            equipe.add(pokemon);
            System.out.println(pokemon.getEspecie() + " foi adicionado à equipe!");
        } else {
            System.out.println("Equipe cheia! Máximo de 6 Pokémons.");
        }
    }

    public void retirarPokemon(int indice) {
        if (indice >= 0 && indice < equipe.size()) {
            Pokemon removido = equipe.remove(indice);
            System.out.println(removido.getEspecie() + " foi removido da equipe!");
        } else {
            System.out.println("Índice inválido!");
        }
    }

    public void adicionarMedalha(String medalha) {
        if (contadorMedalhas < 8) {
            medalhas[contadorMedalhas] = medalha;
            contadorMedalhas++;
            System.out.println("Medalha " + medalha + " adicionada!");
        } else {
            System.out.println("Máximo de medalhas atingido!");
        }
    }

    public void exibirInformacoes() {
        System.out.println("=== TREINADOR ===");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);

        System.out.println("\n=== MEDALHAS ===");
        if (contadorMedalhas == 0) {
            System.out.println("Nenhuma medalha conquistada.");
        } else {
            for (int i = 0; i < contadorMedalhas; i++) {
                System.out.println((i + 1) + ". " + medalhas[i]);
            }
        }

        System.out.println("\n=== EQUIPE POKÉMON ===");
        if (equipe.isEmpty()) {
            System.out.println("Nenhum Pokémon na equipe.");
        } else {
            for (int i = 0; i < equipe.size(); i++) {
                System.out.print((i + 1) + ". ");
                equipe.get(i).exibirInformacoes();
            }
        }
        System.out.println("======================");
    }

    public ArrayList<Pokemon> getEquipe() {
        return equipe;
    }

    public String[] getMedalhas() {
        return medalhas;
    }

    public int getContadorMedalhas() {
        return contadorMedalhas;
    }
}