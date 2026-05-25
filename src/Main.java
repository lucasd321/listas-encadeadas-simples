import java.util.Scanner;

public class Main {

    private static MyLinkedList<Integer> userList = new MyLinkedList<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int option;
        do {
            printMenu();
            option = readInt("Opcao: ");
            System.out.println();
            switch (option) {
                case 1  -> menuCriarLista();
                case 2  -> menuQ1();
                case 3  -> menuQ2();
                case 4  -> menuQ3();
                case 5  -> menuQ4();
                case 6  -> menuQ5();
                case 0  -> System.out.println("Encerrando...");
                default -> System.out.println("Opcao invalida.");
            }
            System.out.println();
        } while (option != 0);
    }

    private static void printMenu() {
        System.out.println("                                       ");
        System.out.println("     Lista Encadeada                  ");
        System.out.println("                                        ");
        System.out.println(" 1 - Criar lista                      ");
        System.out.println(" 2 - #1: Sorted Insertion             ");
        System.out.println(" 3 - #2: Delete sem predecessor       ");
        System.out.println(" 4 - #3: Reversal                     ");
        System.out.println(" 5 - #4: Merge Two Sorted Lists       ");
        System.out.println(" 6 - #5: Remove Nth From End          ");
        System.out.println(" 0 - Sair                             ");
        System.out.println(" ");
        System.out.println("Sua lista: " + userList);
    }

    private static void menuCriarLista() {
        System.out.println("Criar lista ");
        System.out.println("Digite os valores separados por espaco (ex: 1 2 3):");
        System.out.print("> ");
        sc.nextLine();
        String[] tokens = sc.nextLine().trim().split("\\s+");
        userList = new MyLinkedList<>();
        for (String token : tokens) {
            try {
                userList.addLast(Integer.parseInt(token));
            } catch (NumberFormatException e) {
                System.out.println("Valor ignorado (nao numerico): " + token);
            }
        }
        System.out.println("Lista criada: " + userList);
    }

    private static MyLinkedList<Integer> escolherLista(int[] defaultValues, String descricao) {
        MyLinkedList<Integer> enunciado = new MyLinkedList<>();
        for (int v : defaultValues) enunciado.addLast(v);

        System.out.println("Qual lista usar?");
        System.out.println("  1 - Lista do enunciado: " + enunciado);
        System.out.println("  2 - Minha lista:        " + userList);
        int op = readInt("Opcao: ");

        if (op == 1) {
            System.out.println("Usando lista do enunciado.");
            return enunciado;
        } else {
            if (userList.isEmpty()) {
                System.out.println("Sua lista esta vazia! Usando lista do enunciado.");
                return enunciado;
            }
            System.out.println("Usando sua lista.");
            MyLinkedList<Integer> copia = copiar(userList);
            return copia;
        }
    }

    private static MyLinkedList<Integer> copiar(MyLinkedList<Integer> original) {
        MyLinkedList<Integer> copia = new MyLinkedList<>();
        Node<Integer> current = original.getHead();
        while (current != null) {
            copia.addLast(current.element);
            current = current.next;
        }
        return copia;
    }

    private static void menuQ1() {
        System.out.println("-- Q1: Insercao ordenada crescente --");
        System.out.println("(A lista deve estar em ordem crescente antes de inserir)");

        MyLinkedList<Integer> lista = escolherLista(
                new int[]{1, 5, 10, 20},
                "lista crescente de exemplo"
        );

        System.out.println("Lista atual: " + lista);
        int value = readInt("Valor a inserir: ");
        lista.addAscendingSorted(value);
        System.out.println("Resultado:   " + lista);

        atualizarUserList(lista);
    }

    private static void menuQ2() {
        System.out.println("-- Q2: Delete sem predecessor --");
        System.out.println("Lista do enunciado: 20 -> 4 -> 5 -> 19 -> 47");
        System.out.println("P aponta para o no com valor 5 (pos 2)");
        System.out.println("Resultado esperado: 20 -> 4 -> 19 -> 47");
        System.out.println();

        MyLinkedList<Integer> lista = escolherLista(
                new int[]{20, 4, 5, 19, 47},
                "20 -> 4 -> 5 -> 19 -> 47"
        );

        System.out.println("Lista: " + lista);
        int pos = readInt("Posicao do no P a remover (0-based): ");

        Node<Integer> p = getNodeAt(lista, pos);
        if (p == null) {
            System.out.println("Posicao invalida.");
            return;
        }
        if (p.next == null) {
            System.out.println("Erro: P nao pode ser o ultimo no (sem next).");
            return;
        }

        System.out.println("Removendo no na posicao " + pos + " (valor: " + p.element + ")");
        lista.deleteWithoutPredecessor(p);
        System.out.println("Resultado: " + lista);

        atualizarUserList(lista);
    }

    private static void menuQ3() {
        System.out.println("-- Q3: Reversal --");
        System.out.println("Lista do enunciado: 20 -> 4 -> 5 -> 19 -> 47");
        System.out.println("Resultado esperado: 47 -> 19 -> 5 -> 4 -> 20");
        System.out.println();

        MyLinkedList<Integer> lista = escolherLista(
                new int[]{20, 4, 5, 19, 47},
                "20 -> 4 -> 5 -> 19 -> 47"
        );

        System.out.println("Antes:    " + lista);
        lista.reverse();
        System.out.println("Depois:   " + lista);

        atualizarUserList(lista);
    }

    private static void menuQ4() {
        System.out.println("-- Q4: Merge Two Sorted Lists --");
        System.out.println("Listas do enunciado:");
        System.out.println("  A: 1 -> 3 -> 5 -> 7");
        System.out.println("  B: 2 -> 4 -> 6 -> 8");
        System.out.println("Resultado esperado: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8");
        System.out.println();

        System.out.println("Para lista A:");
        MyLinkedList<Integer> listaA = escolherLista(
                new int[]{1, 3, 5, 7},
                "1 -> 3 -> 5 -> 7"
        );

        System.out.println();
        System.out.println("Para lista B (segunda lista a intercalar):");
        System.out.println("  1 - Usar lista B do enunciado: [ 2 -> 4 -> 6 -> 8 ]");
        System.out.println("  2 - Digitar manualmente");
        int op = readInt("Opcao: ");

        MyLinkedList<Integer> listaB = new MyLinkedList<>();
        if (op == 1) {
            for (int v : new int[]{2, 4, 6, 8}) listaB.addLast(v);
        } else {
            int n = readInt("Quantos elementos na lista B? ");
            System.out.println("Digite em ordem crescente:");
            for (int i = 0; i < n; i++) listaB.addLast(readInt("  [" + i + "]: "));
        }

        System.out.println("Lista A:  " + listaA);
        System.out.println("Lista B:  " + listaB);
        listaA.mergeSorted(listaB);
        System.out.println("Merged:   " + listaA);

        atualizarUserList(listaA);
    }

    private static void menuQ5() {
        System.out.println("-- Q5: Remove N-esimo do final --");
        System.out.println("Lista do enunciado: 1 -> 2 -> 3 -> 4 -> 5");
        System.out.println();

        MyLinkedList<Integer> lista = escolherLista(
                new int[]{1, 2, 3, 4, 5},
                "1 -> 2 -> 3 -> 4 -> 5"
        );

        System.out.println("Lista: " + lista);
        int n = readInt("Remover o n-esimo a partir do final (1 = ultimo): ");
        try {
            lista.removeNthFromEnd(n);
            System.out.println("Resultado: " + lista);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        atualizarUserList(lista);
    }


    private static void atualizarUserList(MyLinkedList<Integer> resultado) {
        System.out.println();
        System.out.print("Salvar resultado como sua lista? (s/n): ");
        String resp = sc.next().trim().toLowerCase();
        if (resp.equals("s")) {
            userList = resultado;
            System.out.println("Sua lista atualizada: " + userList);
        }
    }

    private static int readInt(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) { sc.next(); System.out.print(prompt); }
        return sc.nextInt();
    }

    private static Node<Integer> getNodeAt(MyLinkedList<Integer> lista, int pos) {
        Node<Integer> current = lista.getHead();
        for (int i = 0; i < pos && current != null; i++) {
            current = current.next;
        }
        return current;
    }
}
