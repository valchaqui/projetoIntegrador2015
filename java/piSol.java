import java.util.Scanner;

public class piSol {
  public static void main(String args[]) {

    //declaração de variáveis
    int i              = 0;
    int nFunc          = 4; // quantidade de registros de usuarios;
    int statusLogin    = 1;
    int segueSis       = 1;
    Scanner entrada    = new Scanner(System.in);
    String[] login     = new String[2];
    String[] username  = new String[4];
    String[] password  = new String[4];
    String[] menuRef   = new String[4];
    int   [] menuCod   = new int   [4];
    int      menuOp    = 666;
    int      submenuOp = 666;

    int excluir = 2;
    int x,y;
    int codigo=1,alteraOp=666;
    int resAltera = 0;
    int codigoBusca = 0;
    String[][] cadastro = new String[4][3];

    /*
    +------+ CADASTRO +--------+
    | NOME | TELEFONE | STATUS |
    +------+----------+--------+
    |      |          |        |
    +------+----------+--------+
    |      |          |        |
    +------+----------+--------+
    |      |          |        |
    +------+----------+--------+
    */

    cadastro[0][0] = "CODIGO";
    cadastro[1][0] = "NOME";
    cadastro[2][0] = "TELEFONE";
    cadastro[3][0] = "OBSERVACAO";


    //controle de subsistemas
      menuRef[0] = "Cadastro de clientes";
      menuCod[0] = 1;

      menuRef[1] = "Orçamentos";
      menuCod[1] = 2;

    //usuarios cadastrados no sistemas
    //Renoir de Paula Faria dos Reis
      username[0] = "renoirfaria"; //username
      password[0] = "410141"; //password

    // variaveis de orcamento
    int qtdOrc = 1;
    int[][] orcamento = new int[10][5];
    int l,c;
    int selOrc = 0;

    //variaveis para calculo de orçamento
    int moradores, arCondicionados, comodos, geladeiras, computadores, chuveiros, televisores, microOndas, total=0;
    double valorOrcamento = 0;
    int potPlacaSolar = 100;
    double precoPlacaSolar  = 500.00;
    int qtdPlacas     = 0;
    int tempoSol      = 8;
    double valorContaLuz = 0;

    System.out.print("\n***** piSol - Sistema de Gerenciamento de vendas *****\n\n");
    do {
    //while (statusLogin != 1) {

    //TELA DE LOGIN DO USUARIO
    System.out.print("Nome de usuario: ");
    login[0] = entrada.nextLine();
    System.out.print("Senha..........: ");
    login[1] = entrada.nextLine();

    //INICIO DA VALIDAÇÃO DO LOGIN
    if (login[0] == null) {
      System.out.print("Campo login vazio!");
      statusLogin = 0;
    }
    else  {
      for (i=0; i < 4; i++) {
        if (login[0].equals(username[i])) {
          //System.out.print("\n****Usuário Encontrado****\n");
          statusLogin = 1;
        }
        else {
          System.out.print("** Usuario não cadastrado\n");
          statusLogin = 0;
        }
        if (login[1].equals(password[i])) {
          //System.out.print("\n****Senha Encontrada****\n");
        statusLogin =1;
        }
        else {
          System.out.print("** Senha não equivale ao usuario\n");
          statusLogin = 0;
        }

    //INICIO DO SISTEMA
    while (statusLogin == 1) {
      //INICIO CAMADA SECUNDARIA
      while (segueSis == 1) {
        System.out.println("Bem vindo ao sistema " + login[0] + "!");
        do {
          //inicio da camada menuOp
        for (i=0; i < (menuCod.length - 1); i++) {
          System.out.println(menuCod[i] + " - " + menuRef[i]);
        }
        System.out.println("0 - Deslogar");
        System.out.print("\nOperacao: ");
        menuOp = entrada.nextInt();
        switch(menuOp) {
          case 0:
            statusLogin = 0;
          break;
          //inicio da camada submenuOp
          case 1:
            while(submenuOp != 0) {
              System.out.print("\n\n");
              System.out.println("***** CADASTRO DE CLIENTES *****");
              System.out.println("1 - Listar clientes.");
              System.out.println("2 - Adicionar cliente.");
              System.out.println("3 - Editar cliente.");
              System.out.println("4 - Excluir cliente.");
              System.out.println("0 - Sair.");
              System.out.print("Operacao: ");
              submenuOp = entrada.nextInt();

              switch (submenuOp) {
                case 1:
                  submenuOp = 666;
                  System.out.println("***** LISTA DE CLIENTES *****");
                  for (y=0; y < 3; y++) {
                    if ((cadastro[0][y] != null) && (cadastro[1][y] != null) && (cadastro[2][y] != null)) {
                    System.out.println("Código: "          + cadastro[0][y]);
                    System.out.println("Nome do cliente: " + cadastro[1][y]);
                    System.out.println("Telefone: "        + cadastro[2][y]);
                    System.out.println("Descrição: "       + cadastro[3][y] + "\n");
                    }
                  }
                  System.out.println("***** FIM DE LISTAGEM *****\n\n\n");
                break;
                case 2:
                  System.out.println("***** CADASTRAR CLIENTE *****");
                  System.out.println("Codigo: " + codigo);
                  cadastro[0][codigo] = "" + codigo;
                  System.out.println("Nome do cliente: ");
                  entrada.nextLine(); //essa porra aqui meu
                  cadastro[1][codigo] = entrada.nextLine();
                  System.out.println("Telefone: ");
                  cadastro[2][codigo] = entrada.nextLine();
                  System.out.println("Observação: ");
                  cadastro[3][codigo] = entrada.nextLine();
                  System.out.println("***** CADASTRO CONCLUIDO *****\n\n\n");
                break;
                case 3:
                  System.out.println("***** EDITAR CLIENTE *****");
                    while(codigoBusca == 0) {
                      System.out.println("Digite o código do usuário: ");
                      entrada.nextLine();
                      codigoBusca = entrada.nextInt();
                    }
                    System.out.println("Buscando o cliente com código: " + codigoBusca);
                    //for (y=0; y < 3; y++) {
                      //if (cadastro[0][y] == codigoBusca) {
                        //resAltera = y;
                        System.out.println("Código: "              + cadastro[0][codigoBusca]);
                        System.out.println("1 - Nome do cliente: " + cadastro[1][codigoBusca]);
                        System.out.println("2 - Telefone: "        + cadastro[2][codigoBusca]);
                        System.out.println("3 - Descrição: "       + cadastro[3][codigoBusca]);

                        System.out.println("Desejo alterar a o campo/linha nº: ");
                        alteraOp = entrada.nextInt();
                        entrada.nextLine();
                        switch (alteraOp) {
                          case 1:
                            System.out.println("Nome do cliente: ");
                            cadastro[1][codigoBusca] = entrada.nextLine();
                          break;
                          case 2:
                            System.out.println("Telefone: ");
                            cadastro[2][codigoBusca] = entrada.nextLine();
                          break;
                          case 3:
                            System.out.println("Observação: ");
                            cadastro[3][codigoBusca] = entrada.nextLine();
                          break;
                          default:
                            System.out.println("Opção inválida. Tente novamente"); // tratar melhor essa parte
                        }
                      //}
                    //}

                break;
                case 4:
                      while( excluir == 2)   {
                            System.out.print("\nDigite o código do cliente: ");
                            codigoBusca = entrada.nextInt();
                            System.out.println("Código: "              + cadastro[0][codigoBusca]);
                            System.out.println("1 - Nome do cliente: " + cadastro[1][codigoBusca]);
                            System.out.println("2 - Telefone: "        + cadastro[2][codigoBusca]);
                            System.out.println("3 - Descrição: "       + cadastro[3][codigoBusca]);
                            System.out.println("\nDeseja excluir o cliente? ");
                            System.out.println("\n[1] - Sim ");
                            System.out.println("\n[2] - Não ");
                            System.out.print("Operacão: ");

                            excluir = entrada.nextInt();
                        }
                     cadastro[0][codigoBusca] = null;
                     cadastro[1][codigoBusca] = null;
                     cadastro[2][codigoBusca] = null;
                     cadastro[3][codigoBusca] = null;

                break;
                default:
                  for (y=0; y < 3; y++) {
                    System.out.print(cadastro[0][y] + " | ");
                    System.out.print(cadastro[1][y] + " | ");
                    System.out.print(cadastro[2][y] + " | ");
                    System.out.print(cadastro[3][y] + " | ");
                    System.out.print("\n");
                  }

              }//fim dos switch de cadastro
            }//fim do submenuOp
          break;
          case 2:
            submenuOp = 666;
            while(submenuOp != 0) {
              System.out.println("***** CONTROLE DE ORCAMENTOS *****");
              System.out.println("1 - Verificar orçamento.");
              System.out.println("2 - Criar orçamento.");
              System.out.println("0 - Sair.");
              System.out.print("Operacao: ");
              submenuOp = entrada.nextInt();
              switch (submenuOp) {
                case 1:
                  System.out.println("***** VERIFICAR ORÇAMENTO *****");
                  System.out.println("Digite o número do orçamento: ");
                  selOrc = entrada.nextInt();

                  for (l = 0; l < 10; l++) {
                      if(orcamento[l][0] == selOrc) {
                          System.out.println("*********** pi Sol  - ORCAMENTO **********");
                          System.out.println("Orcamento: " + orcamento[l][0]);
                          System.out.println("Cliente: "   + cadastro[l][orcamento[1][1]]);  //aprimorar com integração a array clientes
                          System.out.println("Potencia: "  + orcamento[l][2]);
                          System.out.println("Valor: "     + orcamento[l][3]);
                          System.out.println("Status: "    + orcamento[l][4]);
                          System.out.println("*********** FIM DE ORCAMENTO **********");
                      }
                      else if(l == 9) {
                        System.out.println("\n Não encontramos nenhum orcamento no sistema");

                    }
                  }
                break;
                case 2:
                  System.out.println("\n*********** pi Sol  - CRIAR ORCAMENTO **********");
                  //codigo do orcamento
                  orcamento[qtdOrc][0] = qtdOrc;
                  System.out.println("Codigo do cliente: ");
                  orcamento[qtdOrc][1] = entrada.nextInt();
                  System.out.println("Quantidade de moradores: ");
                  moradores = entrada.nextInt();
                  System.out.println("Quantidade de comodos: ");
                  comodos = entrada.nextInt();
                  System.out.println("Quantidade de ar-condicionados: ");
                  arCondicionados = entrada.nextInt();
                  System.out.println("Quantiade de geladeiras: ");
                  geladeiras = entrada.nextInt();
                  System.out.println("Quantidade de computadores: ");
                  computadores = entrada.nextInt();
                  System.out.println("Quantidade de chuveiros: ");
                  chuveiros = entrada.nextInt();
                  System.out.println("Quantidade de televisores: ");
                  televisores = entrada.nextInt();
                  System.out.println("Quantidade de microOndas: ");
                  microOndas = entrada.nextInt();
                  // calculando a potencia necessaria
                  //         POTENCIA |       QTD HORAS   |   QTD de APARELHOS
                  total += ((1200     * 6                 ) * arCondicionados);
                  total += ((10       * 6                 ) * comodos);
                  total += ((200      * 12                ) * geladeiras);
                  total += ((300      * 6                 ) * computadores);
                  total += ((4400     * 0.17              ) * chuveiros);
                  total += ((200      * 6                 ) * televisores);
                  total += ((1200     * (moradores * 0.08)) * microOndas);
                  orcamento[qtdOrc][2] = total;
                  System.out.println("Potencia necessaria: " + orcamento[qtdOrc][2] + " Kwh");
                  // calculando valor de materiais
                  valorContaLuz = (((total * 30) * 0.46 )/ 1000);
                  qtdPlacas = (total/(potPlacaSolar*tempoSol));
                  valorOrcamento = precoPlacaSolar * qtdPlacas;
                  orcamento[qtdOrc][3] = (int)valorOrcamento + 1;
                  System.out.println("Valor do orcamento: R$ " + orcamento[qtdOrc][3] + ".00"); //reclama pra dilma

                  //status do orcamento
                  orcamento[qtdOrc][4] = 1;
                  qtdOrc = qtdOrc + 1;
                  System.out.println("*********** ORCAMENTO CRIADO COM SUCESSO! **********\n");
                break;
                case 3:

                break;
              }

            }

          break;
          default:
          System.out.println("Operação inválida, insira um valor equivalente a lista.\n");
        }
      }while(menuOp != 0);

        segueSis = 0;
      }//fim do segueSis
      }//fim do statusLogin
      }
    }
  } while (statusLogin != 1);



  }
}
