import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Tarefa> tarefas = new ArrayList<>();

        int opcao;

        do {

            System.out.println();
            System.out.println("==============================");
            System.out.println("     CADASTRO DE TAREFAS");
            System.out.println("==============================");
            System.out.println("1 - Inserir tarefa");
            System.out.println("2 - Listar tarefas");
            System.out.println("3 - Alterar tarefa");
            System.out.println("4 - Excluir tarefa");
            System.out.println("0 - Sair");
            System.out.println("==============================");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:

                    System.out.print("Digite a tarefa: ");
                    String descricao = scanner.nextLine();

                    if (descricao.trim().isEmpty()) {
                        System.out.println("A tarefa não pode ficar vazia.");
                        break;
                    }

                    boolean existe = false;

                    for (Tarefa tarefa : tarefas) {

                        if (tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                            existe = true;
                            break;
                        }
                    }

                    if (existe) {
                        System.out.println("Essa tarefa já está cadastrada!");
                    } else {

                        Tarefa novaTarefa = new Tarefa(descricao);

                        tarefas.add(novaTarefa);

                        System.out.println("Tarefa cadastrada com sucesso!");
                    }

                    break;

                case 2:

                    if (tarefas.isEmpty()) {

                        System.out.println("Nenhuma tarefa cadastrada.");

                    } else {

                        System.out.println();
                        System.out.println("======= LISTA DE TAREFAS =======");

                        for (int i = 0; i < tarefas.size(); i++) {

                            System.out.println((i + 1) + " - " + tarefas.get(i));
                        }
                    }

                    break;

                case 3:

                    if (tarefas.isEmpty()) {

                        System.out.println("Nenhuma tarefa cadastrada para alterar.");

                    } else {

                        System.out.println();
                        System.out.println("======= LISTA DE TAREFAS =======");

                        for (int i = 0; i < tarefas.size(); i++) {

                            System.out.println((i + 1) + " - " + tarefas.get(i));
                        }

                        System.out.print("Digite o número da tarefa que deseja alterar: ");
                        int numeroAlterar = scanner.nextInt();
                        scanner.nextLine();

                        if (numeroAlterar < 1 || numeroAlterar > tarefas.size()) {

                            System.out.println("Número de tarefa inválido.");

                        } else {

                            System.out.print("Digite a nova descrição: ");
                            String novaDescricao = scanner.nextLine();

                            if (novaDescricao.trim().isEmpty()) {

                                System.out.println("A nova tarefa não pode ficar vazia.");

                            } else {

                                boolean tarefaExiste = false;

                                for (int i = 0; i < tarefas.size(); i++) {

                                    if (i != numeroAlterar - 1 &&
                                            tarefas.get(i).getDescricao()
                                                    .equalsIgnoreCase(novaDescricao)) {

                                        tarefaExiste = true;
                                        break;
                                    }
                                }

                                if (tarefaExiste) {

                                    System.out.println(
                                            "Já existe uma tarefa com essa descrição."
                                    );

                                } else {

                                    tarefas.get(numeroAlterar - 1)
                                            .setDescricao(novaDescricao);

                                    System.out.println(
                                            "Tarefa alterada com sucesso!"
                                    );
                                }
                            }
                        }
                    }

                    break;

                case 4:

                    if (tarefas.isEmpty()) {

                        System.out.println("Nenhuma tarefa cadastrada para excluir.");

                    } else {

                        System.out.println();
                        System.out.println("======= LISTA DE TAREFAS =======");

                        for (int i = 0; i < tarefas.size(); i++) {

                            System.out.println((i + 1) + " - " + tarefas.get(i));
                        }

                        System.out.print("Digite o número da tarefa que deseja excluir: ");
                        int numeroExcluir = scanner.nextInt();
                        scanner.nextLine();

                        if (numeroExcluir < 1 || numeroExcluir > tarefas.size()) {

                            System.out.println("Número de tarefa inválido.");

                        } else {

                            tarefas.remove(numeroExcluir - 1);

                            System.out.println(
                                    "Tarefa excluída com sucesso!"
                            );
                        }
                    }

                    break;

                case 0:

                    System.out.println("Programa encerrado.");
                    break;

                default:

                    System.out.println(
                            "Opção inválida! Escolha uma opção do menu."
                    );
            }

        } while (opcao != 0);

        scanner.close();
    }
}
