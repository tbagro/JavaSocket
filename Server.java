
import java.net.*;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintStream;
//cria o ServerSocket ServerR
public class Server {
//variaveis gerais
	private static Scanner in;
	static PrintStream saida;
	static Socket cliente;
	static ServerSocket servidor;
	static int porta = 7990;
	
	//função principal da classe ServerR
	public static void main(String[] args) throws IOException {
		// Cria Socket de comunicaçao
		// bloco de encapsulamento try catch
		try {
			servidor = new ServerSocket(porta);
			System.out.println("servidor iniciado na porta  " + porta);
			System.out.println("Aguardando Conexão");
			// Cria o canal de comunicação para este serviço
		} catch (Exception e) {
			System.out.println("Erro ao criar o servidor");
			return;
		}
		while (true) {// mantem o servidor em funcionamento
			try {
				cliente = servidor.accept();
				System.out.println("Cliente do Ip " + cliente.getInetAddress().getHostAddress() + " Conectado");
			} catch (Exception e) {
				System.out.println("Erro ao conectar com cliente :C  \n" + "Log: " + e.getMessage());
//				return;
			}
			try {
				// etapa de comunicação do cliente
				in = new Scanner(cliente.getInputStream());
				String entradaString;
				entradaString = in.nextLine();
				// while (entradaString != null) {
				System.out.println("Msg Recebida " + cliente.getInetAddress().getHostAddress() + ": " + entradaString);
				// }
				// retorna a mensagem ao cliente confirmando o recebimento
				saida = new PrintStream(cliente.getOutputStream());
				saida.println("Servidor Tiago: ainda não, tente novamente");
			} catch (Exception e) {
				System.out.println("Erro de comunicação :C \n" + "Log: " + e.getMessage());
				return;
			}
		}
		// encerra a conexão
		// cliente.close();
		// servidor.close();
		// }
	}
}
