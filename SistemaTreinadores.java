import java.util.ArrayList;
import java.util.Scanner;

public class SistemaTreinadores {
    private ArrayList<Treinador> treinadores;
    private Scanner scanner;

    public SistemaTreinadores() {
        this.treinadores = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void executar() {
        int opcao;
        do {
            exibirMenuPrincipal();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    cadastrarNovoTreinador();
                    break;
                case 2:
                    mostrarDados();
                    break;
                case 3:
                    adicionarPokemon();
                    break;
                case 4:
                    retirarPokemon();
                    break;
                case 5:
                    ganharMedalha();
                    break;
                case 6:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 6);
    }

    private void exibirMenuPrincipal() {
        System.out.println("\n=== SISTEMA DE TREINADORES POKÉMON ===");
        System.out.println("1. Cadastrar novo treinador");
        System.out.println("2. Mostrar dados");
        System.out.println("3. Adicionar Pokémon");
        System.out.println("4. Retirar Pokémon");
        System.out.println("5. Ganhar medalha");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private void cadastrarNovoTreinador() {
        System.out.print("Nome do treinador: ");
        String nome = scanner.nextLine();
        System.out.print("Idade do treinador: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer

        Treinador novoTreinador = new Treinador(nome, idade);
        treinadores.add(novoTreinador);
        System.out.println("Treinador " + nome + " cadastrado com sucesso!");
    }

    private Treinador selecionarTreinador() {
        if (treinadores.isEmpty()) {
            System.out.println("Nenhum treinador cadastrado!");
            return null;
        }

        System.out.println("\n=== TREINADORES CADASTRADOS ===");
        for (int i = 0; i < treinadores.size(); i++) {
            System.out.println((i + 1) + ". " + treinadores.get(i).getNome());
        }

        System.out.print("Selecione o treinador (número): ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer

        if (escolha > 0 && escolha <= treinadores.size()) {
            return treinadores.get(escolha - 1);
        } else {
            System.out.println("Treinador inválido!");
            return null;
        }
    }

    private void mostrarDados() {
        Treinador treinador = selecionarTreinador();
        if (treinador != null) {
            treinador.exibirInformacoes();
        }
    }

    private void adicionarPokemon() {
        Treinador treinador = selecionarTreinador();
        if (treinador != null) {
            System.out.print("Espécie do Pokémon: ");
            String especie = scanner.nextLine();
            System.out.print("Tipo do Pokémon: ");
            String tipo = scanner.nextLine();
            System.out.print("Nível do Pokémon (1-100): ");
            int nivel = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            if (nivel >= 1 && nivel <= 100) {
                Pokemon novoPokemon = new Pokemon(especie, tipo, nivel);
                treinador.adicionarPokemon(novoPokemon);
            } else {
                System.out.println("Nível inválido! Deve ser entre 1 e 100.");
            }
        }
    }

    private void retirarPokemon() {
        Treinador treinador = selecionarTreinador();
        if (treinador != null && !treinador.getEquipe().isEmpty()) {
            System.out.println("\n=== POKÉMONS NA EQUIPE ===");
            ArrayList<Pokemon> equipe = treinador.getEquipe();
            for (int i = 0; i < equipe.size(); i++) {
                System.out.println((i + 1) + ". " + equipe.get(i));
            }

            System.out.print("Qual Pokémon deseja retirar? (número): ");
            int indice = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            treinador.retirarPokemon(indice - 1);
        } else if (treinador != null) {
            System.out.println("Este treinador não possui Pokémons!");
        }
    }

    private void ganharMedalha() {
        Treinador treinador = selecionarTreinador();
        if (treinador != null) {
            System.out.println("\n=== MEDALHAS DISPONÍVEIS ===");
            String[] medalhas = {"Pedra", "Cascata", "Trovão", "Arco-Iris",
                    "Pântano", "Alma", "Vulcão", "Terra"};

            for (int i = 0; i < medalhas.length; i++) {
                System.out.println((i + 1) + ". " + medalhas[i]);
            }

            System.out.print("Escolha a medalha (número): ");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            if (escolha > 0 && escolha <= medalhas.length) {
                treinador.adicionarMedalha(medalhas[escolha - 1]);
            } else {
                System.out.println("Medalha inválida!");
            }
        }
    }
}