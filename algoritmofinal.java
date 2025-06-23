import java.util.Random;
import java.util.Scanner;
public class algoritmofinal
{
    
    // esse método mostra o conteúdo da matriz de caracteres
    
    public static void MostraMatriz(char[][] M, int linhas, int colunas)
    {
        for(int L = 0; L < linhas; L++)
        {
            for(int C = 0; C < colunas; C++)
            {
                System.out.printf(" %c ", M[L][C]); 
            }
            System.out.printf("\n");
        }
    }
    
    // o outro método serve para retornar o valor absoluto do número informado (sem sinal)
    public static double Modulo(int valor)
    {
        return Math.sqrt(valor * valor);
    }
    
    
    
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        // declara as váriaveis
        int Linhas, Colunas;  
        
        // introdução do código
        System.out.println("*********************************************************");
        System.out.println("*********************************************************");
        System.out.println("***************** CRIADOR DE MATRIZES 1.0 ***************");
        System.out.println("*********************************************************");
        System.out.println("*********  Cassiano de Oliveira Germano da Silva ********");
        System.out.println("*********************************************************");
        System.out.println("*********************************************************");
        System.out.println("***////Informe a quantidade de linhas: ");
        System.out.println("*********************************************************");
        Linhas = sc.nextInt(); // entrada
        
        
        
        // sistema de repetição quando um número for menor que 3, tanto para linhas e tanto para colunas
        do{
            if(Linhas < 3){
                System.out.println("*********************************************************");
                System.out.println("*****/Por favor, tente um valor maior que 2.            *");
                System.out.println("*********************************************************");
                System.out.println("*********************************************************");
                System.out.println("***////Informe a quantidade de Linhas:                  *");
                System.out.println("*********************************************************");
                Linhas = sc.nextInt();
            }
        } while(Linhas < 3);
        
        
        
        System.out.println("*********************************************************");
        System.out.println("*////Informe a quantidade de colunas:                   *");
        System.out.println("*********************************************************");
        Colunas = sc.nextInt(); // entrada
        
        
        
        
        do{
            if(Colunas < 3){
                System.out.println("*********************************************************");
                System.out.println("*****/Por favor, tente um valor maior que 2.            *");
                System.out.println("*********************************************************");
                System.out.println("*********************************************************");
                System.out.println("***////Informe a quantidade de colunas:                 *");
                System.out.println("*********************************************************");
                Colunas = sc.nextInt();
            }
        } while(Colunas < 3);
        
        // depois de informar a quantidade de ambas as linhas e colunas
        
        
        System.out.println("*********************************************************");
        System.out.println("*********************************************************");
        System.out.println("*//////Sorteando os pontos....                          *");
        System.out.println("#########################################################");
        System.out.println("#########################################################");
        System.out.println("#### LEGENDA:  ##########################################");
        System.out.println("#✗: Coordenadas repetidas.  ############################");
        System.out.println("#✓: Coordenadas diferentes. ############################");
        System.out.println("#########################################################");
        // o ✗ significa que o ponto está sobrescrevendo outro ponto
        // já o ✓ significa que o ponto é diferente do outro ponto
        
        char[][] M = new char[Linhas][Colunas];
        
        for(int L = 0; L < Linhas; L++)
        {
          for(int C = 0; C < Colunas; C++)
          {
             M[L][C] = '.'; 
          }
        }
        
        
        Random rd = new Random();
        
        
        
        int PontoAx = rd.nextInt(Colunas);
        int PontoAy = rd.nextInt(Linhas);
        
        
        int PontoBx = rd.nextInt(Colunas);
        int PontoBy = rd.nextInt(Linhas);
        
        
        // essa parte também serve pros pontos C e D, só que utilizando o "cd" no final       
        double DistYab = Modulo(PontoAy - PontoBy); 
        double DistXab = Modulo(PontoAx - PontoBx);
        double Distab = DistXab + DistYab;
        double DeslYab = DistYab / Distab; 
        double DeslXab = DistXab / Distab; 
        
        
        double PosYab = PontoAy;
        double PosXab = PontoAx;
        
        
        for(int a = 0; a < Distab; a++)
        {
            M[(int)PosYab][(int)PosXab] = '+';
            
            if(PontoBy > PontoAy)
            {
                PosYab += DeslYab;
            } else if(PontoBy < PontoAy)
            {
                PosYab -= DeslYab;
            }
            
            if(PontoBx > PontoAx)
            {
                PosXab += DeslXab;
            } else if(PontoBx < PontoAx)
            {
                PosXab -= DeslXab;
            }
            
            
        }
        
        int PontoCx = rd.nextInt(Colunas);
        int PontoCy = rd.nextInt(Linhas);
        
        int PontoDx = rd.nextInt(Colunas);
        int PontoDy = rd.nextInt(Linhas);
        
        double DistYcd = Modulo(PontoCy - PontoDy); 
        double DistXcd = Modulo(PontoCx - PontoDx);
        double Distcd = DistXcd + DistYcd;
        double DeslYcd = DistYcd / Distcd;
        double DeslXcd = DistXcd / Distcd;
        
        double PosYcd = PontoCy;
        double PosXcd = PontoCx;
        
        for(int a = 0; a < Distcd; a++)
        {
            M[(int)PosYcd][(int)PosXcd] = '*';
            
            
            if(PontoDy > PontoCy)
            {
                PosYcd += DeslYcd;
            } else if(PontoDy < PontoCy)
            {
                PosYcd -= DeslYcd;
            } 
            
            if(PontoDx > PontoCx)
            {
                PosXcd += DeslXcd;
            } else if(PontoDx < PontoCx)
            {
                PosXcd -= DeslXcd;
            } 
            
            
        }
        
        
        
        
        M[PontoAy][PontoAx] = 'A';
        M[PontoBy][PontoBx] = 'B';
        M[PontoCy][PontoCx] = 'C';
        M[PontoDy][PontoDx] = 'D';
        
        
        
        // parte que verifica se um lugar de um ponto esta sendo repetido por um outro ponto, aqui feito para cada ponto
        // pontos como A e B (pontos de origem e destino) são mostrados na tela se são diferentes ou iguais
        do{
            if(M[PontoBy][PontoBx] == M[PontoAy][PontoAx]){
                System.out.println("# ::: A e B: ✗ #########################################");
                break; 
            } else if(M[PontoAy][PontoAx] != M[PontoBy][PontoBx]){
                System.out.println("# ::: A e B: ✓ #########################################"); 
                break;
            } 
        }while(M[PontoBy][PontoBx] != M[PontoAy][PontoAx]);
        
        // a mesma coisa se aplica com o C e D
        do{
            if(M[PontoDy][PontoDx] == M[PontoCy][PontoCx]){
                System.out.println("# ::: C e D: ✗ #########################################");
                break;
            } else if(M[PontoCy][PontoCx] != M[PontoDy][PontoDx]){
                System.out.println("# ::: C e D: ✓ #########################################"); 
                break; // o break é utilizado como uma forma de evitar loops infinitos
            } 
        }while(M[PontoDy][PontoDx] != M[PontoCy][PontoCx]);
        
        // se os pontos (como por exemplo A e C) forem diferentes, não vai ser mostrado no console que são diferentes, só quando são iguais
        do{
            if(M[PontoAy][PontoAx] == M[PontoCy][PontoCx]){
               System.out.println("# ::: A e C: ✗ #########################################");
               break;
            } else if(M[PontoCy][PontoCx] != M[PontoAy][PontoAx]){ 
               break;
            } 
        }while(M[PontoAy][PontoAx] != M[PontoCy][PontoCx]);
        
        do{
            if(M[PontoAy][PontoAx] == M[PontoDy][PontoDx]){
               System.out.println("# ::: A e D: ✗ #########################################");
               break;
            } else if(M[PontoDy][PontoDx] != M[PontoAy][PontoAx]){ 
                break;
            } 
        }while(M[PontoAy][PontoAx] != M[PontoDy][PontoDx]);
        
        do{
            if(M[PontoBy][PontoBx] == M[PontoCy][PontoCx]){
               System.out.println("# ::: B e C: ✗ #########################################");
               break;
            } else if(M[PontoCy][PontoCx] != M[PontoBy][PontoBx]){
                break;
            } 
        }while(M[PontoBy][PontoBx] != M[PontoCy][PontoCx]);
        
        do{
            if(M[PontoBy][PontoBx] == M[PontoDy][PontoDx]){
               System.out.println("# ::: B e D: ✗ #########################################");
               break;
            } else if(M[PontoDy][PontoDx] != M[PontoBy][PontoBx]){ 
                break;
            } 
        }while(M[PontoBy][PontoBx] != M[PontoDy][PontoDx]);
        
        do{
            if(M[PontoCy][PontoCx] == M[PontoAy][PontoAx]){
               System.out.println("# ::: C e A: ✗ #########################################");
               break;
            } else if(M[PontoAy][PontoAx] != M[PontoCy][PontoCx]){ 
                break;
            } 
        }while(M[PontoCy][PontoCx] != M[PontoAy][PontoAx]);
        
        do{
            if(M[PontoCy][PontoCx] == M[PontoBy][PontoBx]){
               System.out.println("# ::: C e B: ✗ #########################################");
               break;
            } else if(M[PontoBy][PontoBx] != M[PontoCy][PontoCx]){
                break;
            } 
        }while(M[PontoCy][PontoCx] != M[PontoBy][PontoBx]);
        
        do{
            if(M[PontoDy][PontoDx] == M[PontoAy][PontoAx]){
               System.out.println("# ::: D e A: ✗ #########################################");
               break;
            } else if(M[PontoAy][PontoAx] != M[PontoDy][PontoDx]){ 
                break;
            } 
        }while(M[PontoDy][PontoDx] != M[PontoAy][PontoAx]);
        
        do{
            if(M[PontoDy][PontoDx] == M[PontoBy][PontoBx]){
               System.out.println("# ::: D e B: ✗ #########################################");
               break;
            } else if(M[PontoBy][PontoBx] != M[PontoDy][PontoDx]){ 
               break;
            } 
        }while(M[PontoDy][PontoDx] != M[PontoBy][PontoBx]);
        
        // aqui é onde acaba o código, mostrando a matriz, os pontos e os resultados das coordenadas no console
        System.out.println("#########################################################");
        MostraMatriz(M, Linhas, Colunas);
        System.out.println("#########################################################");
        System.out.println("#########################################################");
        }  
}
