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

 import java.util.Scanner;

    public class Desafio{
        public static void main(String[] args){
            Scanner input = new Scanner(System.in);
            int opcao;
            boolean sair = false;
    
            while(!sair){
                System.out.println("1 - Cadastro de Usuário");
                System.out.println("2 - Login de Usuário");
                System.out.println("3 - Alteração de Dados do Usuário");
                System.out.println("4 - Sair");
                System.out.print("Digite a opção desejada: ");
                opcao = input.nextInt();
    
                switch(opcao){
                    case 1:
                        cadastrarUsuario();
                        break;
                    case 2:
                        loginUsuario();
                        break;
                    case 3:
                        alterarDadosUsuario();
                        break;
                    case 4:
                        sair = true;
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }
        }
    
        public static void cadastrarUsuario(){
            Scanner input = new Scanner(System.in);
            String nomeUsuario, senha;
    
            System.out.print("Digite o nome de usuário: ");
            nomeUsuario = input.nextLine();
            System.out.print("Digite a senha: ");
            senha = input.nextLine();
    
            // Verificar se o nome de usuário já existe
            // Salvar o nome de usuário e a senha na lista
        }
    
        public static void loginUsuario(){
            Scanner input = new Scanner(System.in);
            String nomeUsuario, senha;
    
            System.out.print("Digite o nome de usuário: ");
            nomeUsuario = input.nextLine();
            System.out.print("Digite a senha: ");
            senha = input.nextLine();
    
            // Verificar se o nome de usuário está registrado
            // Verificar se a senha fornecida é correta
            // Retornar mensagem de sucesso ou erro
        }
    
        public static void alterarDadosUsuario(){
            Scanner input = new Scanner(System.in);
            String nomeUsuario, senhaAtual, novaSenha;
    
            System.out.print("Digite o nome de usuário: ");
            nomeUsuario = input.nextLine();
            System.out.print("Digite a senha atual: ");
            senhaAtual = input.nextLine();
            System.out.print("Digite a nova senha: ");
            novaSenha = input.nextLine();
    
            // Verificar se a senha atual está correta
            // Verificar se a nova senha tem um formato seguro
            // Atualizar o arquivo de usuários com a nova senha

 