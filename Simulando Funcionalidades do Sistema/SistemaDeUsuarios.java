/**
 * Objetivo: Desenvolver um sistema em Python que permita o cadastro de usuários, 
login com autenticação por senha e alteração de dados do usuário. O sistema deve 
ser simples, utilizando uma interface de linha de comando (CLI), com 
armazenamento básico em listas. 

Funcionalidades

1. Cadastro de Usuário: 

○ O sistema permitirá que novos usuários se cadastrem, criando um 
nome de usuário único e uma senha. 
○ A senha será armazenada de forma segura utilizando uma função de 
hash, para proteger a privacidade dos usuários. 
○ Os dados dos usuários serão salvos em uma lista. 

2. Login de Usuário: 

○ O sistema permitirá que um usuário faça login fornecendo seu nome 
de usuário e senha. 
○ O sistema verificará se o nome de usuário existe e se a senha 
fornecida corresponde ao valor armazenado. 
○ Se o login for bem-sucedido, o usuário poderá acessar o sistema; caso 
contrário, receberá uma mensagem de erro.

3. Alteração de Dados do Usuário: 

○ O usuário poderá alterar sua senha, fornecendo a senha atual e a 
nova senha. 
○ A senha será validada para garantir que a nova senha tenha um 
formato seguro (por exemplo, pelo menos 8 caracteres, contendo 
letras e números). 
○ O sistema atualizará o arquivo de usuários com a nova senha. 

Estrutura do Código 

O sistema será estruturado da seguinte forma: 

1. Função de Cadastro (cadastrar_usuario): 

○ Recebe o nome de usuário e a senha do novo usuário. 
○ Verifica se o nome de usuário já existe. 
○ Se não existir, o nome de usuário e senha são salvos na lista.

2. Função de Login (login_usuario): 

○ Recebe o nome de usuário e a senha. 
○ Verifica se o nome de usuário está registrado e se a senha fornecida é 
correta. 
○ Retorna uma mensagem de sucesso ou erro.
 */
   
  import java.util.ArrayList;
  import java.util.List;
  import java.util.Scanner;
  
  public class SistemaDeUsuarios {

    //Criação de classe Usuario que apresenta os atributos: nome e senha.  
      static class Usuario {
          String nome;
          String senha;
  
          Usuario(String nome, String senha) {
              this.nome = nome;
              this.senha = senha;
          }
      }
  
      // Lista para armazenar os usuários
      static List<Usuario> users = new ArrayList<>();
  
      // Função para gerar o hash da senha usando SHA-256
      public static String hashSenha(String senhaDoUsuario) {
          try {
              java.security.MessageDigest digest = java.security.MessageDigest.getInstance("SHA-256");
              byte[] hashBytes = digest.digest(senhaDoUsuario.getBytes());
              StringBuilder hexString = new StringBuilder();
              for (byte b : hashBytes) {
                  hexString.append(String.format("%02x", b));
              }
              return hexString.toString();
          } catch (Exception e) {
              e.printStackTrace();
          }
          return null;
      }
  
      // Função para verificar se a senha atende aos critérios
      public static boolean aprovarSenha(String senha) {
          if (senha.length() < 8) {
              System.out.println("A senha precisa ser constituída por pelo menos 8 caracteres.");
              return false;
          } else if (!senha.matches(".*\\d.*")) {
              System.out.println("A senha deve consistir de no mínimo um número.");
              return false;
          } else if (!senha.matches(".*[a-zA-Z].*")) {
              System.out.println("A senha deve consistir de no mínimo uma letra.");
              return false;
          }
          return true;
      }
  
      // Função para cadastrar um novo usuário
      public static void cadastrarUsuario() {
          Scanner input = new Scanner(System.in);
          System.out.print("Digite o nome de um(a) usuário(a): ");
          String nomeDoUsuario = input.nextLine();
          
          //Implementação do laço para verificar se o nome do usuário já existe.
          for (Usuario user : users) {
              if (user.nome.equals(nomeDoUsuario)) {
                  System.out.println("Usuário(a) já existe. Tente novamente.");
                  return;
              }
          }
  
          System.out.print("Digite a senha: ");
          String senhaDoUsuario = input.nextLine();

          //Verifica se a senha atende as condições de contrução de uma senha segura.
          while (!aprovarSenha(senhaDoUsuario)) {
              System.out.println("Problema detectado na construção da senha!");
              System.out.print("Digite a senha: ");
              senhaDoUsuario = input.nextLine();
          }
  
          //Transforma a senha em hash chamando o método hashSenha(senhaDoUsuario).
          String senhaHash = hashSenha(senhaDoUsuario);
          //Armazena os dados cadastrados no Arraylist.
          users.add(new Usuario(nomeDoUsuario, senhaHash));
          System.out.println("Usuário " + nomeDoUsuario + " cadastrado.");
      }
  
      //Função para realizar o login.
      public static Usuario loginUsuario() {
          Scanner input = new Scanner(System.in);
          System.out.print("Digite o nome do(a) usuário(a): ");
          String nomeDoUsuario = input.nextLine();
          System.out.print("Digite a senha: ");
          String senhaDoUsuario = input.nextLine();
          
          String senhaHash = hashSenha(senhaDoUsuario);
          
          //Verifica se o nome e a senha estão cadastrados no sistema.
          for (Usuario user : users) {
              if (user.nome.equals(nomeDoUsuario) && user.senha.equals(senhaHash)) {
                  System.out.println("Login bem-sucedido!");
                  return user;
              }
          }  
          
          return null;
      }
  
      // Função para atualizar a senha
      public static void updateSenha(Usuario user) {
          Scanner input = new Scanner(System.in);          
          System.out.print("Digite a senha atual: ");
          String senhaAtual = input.nextLine();
          //Transforma a senha atual em hash chamando o método hashSenha(senhaAtual).
          String senhaAtualHash = hashSenha(senhaAtual);
          int option = 1;
  
          while (option == 1 && !user.senha.equals(senhaAtualHash)) {
              System.out.println("Senha atual incorreta.");
              System.out.print("Para tentar novamente, digite 1. Caso contrário, digite 0: ");
              option = input.nextInt();
              input.nextLine(); // Consume the newline character
              if (option == 0) {
                  break;
              } else {
                  System.out.print("Digite a senha atual: ");
                  senhaAtual = input.nextLine();
                  senhaAtualHash = hashSenha(senhaAtual);
              }
          }
  
          if (option == 0) {
              System.out.println("Senha atual não foi alterada.");
          } else if (option == 1 && user.senha.equals(senhaAtualHash)) {
              System.out.print("Digite uma nova senha: ");
              String novaSenha = input.nextLine();
              String novaSenhaHash = hashSenha(novaSenha);
              user.senha = novaSenhaHash;
              System.out.println("Senha alterada com sucesso.");
          }
      }
  
      // Função para exibir o menu principal
      public static void menuPrincipal() {
          Scanner input = new Scanner(System.in);
  
          while (true) {
              //Enquanto a condição for verdadeira, exibe o menu principal.
              System.out.println("\n1. Adicionar usuário");
              System.out.println("2. Realizar login");
              System.out.println("3. Atualizar senha");
              System.out.println("4. Sair");
              System.out.print("\nDigite uma opção: ");
              String opcao = input.nextLine();
  
              //Implementação das verificações condicionais para cada opção do menu.
              if (opcao.equals("1")) {
                  cadastrarUsuario();
              } else if (opcao.equals("2")) {
                  //Cria uma objetdo tipo Usuario e atribui ao mesmo o método loginUsuario(). 
                  Usuario usuarioLogado = loginUsuario();
                  //Verifica se o objeto é nulo.
                  if (usuarioLogado != null) {
                      //Verifica se a condição (estar logado) para alterar a senha é satisfeita.
                      while (true) {
                          //Exibe o menu de opções para o usuário logado.
                          System.out.println("\n1. Alterar senha");
                          System.out.println("2. Sair");
                          System.out.print("\nEscolha uma opção: ");
                          String opcaoLogado = input.nextLine();
  
                          if (opcaoLogado.equals("1")) {
                              updateSenha(usuarioLogado);
                          } else if (opcaoLogado.equals("2")) {
                              System.out.println("Você será encaminhado ao menu principal.");
                              break;
                          }
                      }
                  }
              } else if (opcao.equals("3")) {
                  System.out.println("É necessário estar conectado para alterar a senha.");
              } else if (opcao.equals("4")) {
                  System.out.println("Você saiu do sistema!");
                  break;
              } else {
                  System.out.println("A opção não é válida.");
              }
          }
      }
  
      // Função principal que executa o menu
      public static void main(String[] args) {
          menuPrincipal();
      }
  }