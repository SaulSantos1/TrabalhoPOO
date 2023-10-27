import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Autenticacao {
    private static final String FILE_PATH = "C:\\temp\\ws-java\\q2_SaulMarinhoo\\src\\senha.txt";
    private static Map<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        loadUsers();
        Scanner scanner = new Scanner(System.in);

        // Registration
        System.out.println("Bem vindo ao Sistema de Autenticação de Usuário");
        System.out.println("Por favor, registre uma nova conta.");

        System.out.print("Entre com seu nome de usuário: ");
        String username = scanner.nextLine();
        System.out.print("Coloque sua senha: ");
        String password = scanner.nextLine();

        registerUser(username, password);

        // Login
        System.out.println("Faça login na sua conta.");
        System.out.print("Entre com seu nome de usuário: ");
        String loginUsername = scanner.nextLine();
        System.out.print("Coloque sua senha: ");
        String loginPassword = scanner.nextLine();

        if (authenticateUser(loginUsername, loginPassword)) {
            System.out.println("SUCESSO: Login bem-sucedido!");
        } else {
            System.out.println("FALHA: Nome de usuário ou senha inválidos.");
        }
        scanner.close();
    }

    private static void loadUsers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    users.put(parts[0], parts[1]);
                } else {
                    //pass
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar usuários: " + e.getMessage());
        }
    }

    private static void registerUser(String username, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write("Usuário: " + username + " ||" + "Senha: " + password);
            writer.newLine();
            users.put(username,password);
            System.out.println("Cadastro realizado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao registrar usuário: " + e.getMessage());
        }
    }

    private static boolean authenticateUser(String username, String password) {
        String storedPassword = users.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }
}
