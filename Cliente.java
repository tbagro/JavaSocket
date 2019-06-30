
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
//cria o socket ClienteS
public class Cliente {
// variaveis da classe
	static PrintStream saidaPrintStream;
	static Socket cliente;
	static Scanner in;
//função principal da classe ClienteS
	public static void main(String[] args) throws IOException {
//Realiza a o pedido da conexão 	
		while (true) {
			// bloco de encapsulamento 
			try {
				// conecta o cliente socket no servidor no via TCP/VPN 
				cliente = new Socket("25.7.88.131", 7990);// ("25.50.162.186", 4991);
				System.out.println("Servidor do Ip " + cliente.getInetAddress().getHostAddress() + " conectado");
			} catch (Exception e) {
				System.out.println("Erro: " + e.getMessage());
				return;
			}
			// Etapa de conexão
			try {
				// cria os Streams de envio da mensagem ao servidor
				saidaPrintStream = new PrintStream(cliente.getOutputStream());
				saidaPrintStream.println("Oi, tudo bem? posso te derrubar");

			} catch (Exception e) {
				System.out.println("Erro ao enviar dados :C  \n" + "Log: " + e.getMessage());
				return;
			}
			try {
				// Cria a Stream de Recebimento do mensagem do servidor usando a biblioteca Scanner
				in = new Scanner(cliente.getInputStream()); // envia a String para o Cliente
				String entrada = in.nextLine();// le a mensagem até a proxima linha e converte em uma string
				System.out.println("Recebido do servidor: " + entrada);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Erro ao responder o cliente :C  \n" + "Log: " + e.getMessage());
				return;
			} // mantem a conexão com o servidor
		}

		// Etapa de encerramento da conexão
		/*
		 * try {
		 * 
		 * //cliente.close(); System.out.println("Cliente encerrado");
		 * 
		 * } catch (Exception e) { System.out.println("Erro ao encerrar conexão :C \n" +
		 * "Log: " + e.getMessage()); }
		 */

	}
}
