package utilitarios;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.google.protobuf.ByteString;

import protocolo.CommandsProto;
import protocolo.CommandsProto.Command;
import protocolo.CommandsProto.Response;
import protocolo.CommandsProto.StatusCode;

/**
 * Classe responsável por todos os métodos de
 * comunicação entre cliente e servidor, ao qual
 * realiza a construção e leitura das mensagens 
 * no padrão protocol buffers. 
 * 
 * @author André Barreto
 * @author Igor Ventorim
 * @version 1.0
 *
 */
public class Message {
	
	/**
	 * SubClasse responsável pela mensagens
	 * de comandos que foram requisitados.
	 */
	public static class CommandMessage
	{
		private Command.Builder msg;
		private Command cmd;
		
		public CommandMessage(){ msg = Command.newBuilder(); }
		
		public CommandMessage(CommandCode type) {
			// TODO Auto-generated constructor stub
			msg = Command.newBuilder();
			msg.setType(CommandsProto.CommandType.forNumber(type.getValue()));
			msg.build();
		}
		
		public CommandMessage(CommandCode type, String arg0) {
			// TODO Auto-generated constructor stub
			msg = Command.newBuilder();
			msg.setType(CommandsProto.CommandType.forNumber(type.getValue()));
			msg.setArg0(arg0);
			msg.build();
		}
		
		public CommandMessage(CommandCode type, String arg0, String arg1) {
			// TODO Auto-generated constructor stub
			msg = Command.newBuilder();
			msg.setType(CommandsProto.CommandType.forNumber(type.getValue()));
			msg.setArg0(arg0);
			msg.setArg1(arg1);
			msg.build();
		}
		
		public CommandMessage(CommandCode type, String arg0, byte[] data) {
			// TODO Auto-generated constructor stub
			msg = Command.newBuilder();
			msg.setType(CommandsProto.CommandType.forNumber(type.getValue()));
			msg.setArg0(arg0);
			msg.setData(ByteString.copyFrom(data));
			msg.build();
		}
		
		/**
		 * Responsável por escrever uma mensagem no buffer
		 * e enviá-la.
		 * @param out OutputStream da conexão estabelecida.
		 */
		public void writeMessage(OutputStream out)
		{
			try {
				cmd = msg.build();
				cmd.writeDelimitedTo(out);
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("ERRO AO ENVIAR MENSAGEM!");
			}
		}
		
		/**
		 * Responsável por ler uma mensagem recebida.
		 * @param ini InputStream da conexão estabelecida.
		 */
		public void readMessage(InputStream ini)
		{
			try {
				cmd = Command.parseDelimitedFrom(ini);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("ERRO AO LER A MENSAGEM!");
			}
		}
		
		// Getters
		
		public Command.Builder getCommandMessage(){ return msg; }
		
		public Command getMessage(){ return cmd; }
		
		public CommandCode getCommand()
		{
			return CommandCode.getCode(cmd.getType().getNumber());
		}
		
		public String getArg0(){ return cmd.getArg0(); }
		
		public String getArg1(){ return cmd.getArg1(); }
		
		public ByteString getData(){ return cmd.getData(); }
	}
	
	/**
	 * SubClasse responsável pelas mensagens de resposta
	 * que seram realizadas na comunicação.
	 */
	public static class ResponseMessage
	{
		
		private Response.Builder msg;
		private Response response;
		
		public ResponseMessage(){ msg = Response.newBuilder();}
		
		public ResponseMessage(utilitarios.StatusCode code, ByteString bytes)
		{
			msg = Response.newBuilder();
			msg.setStatusCode(StatusCode.forNumber(code.getValue()));
			msg.setResponse(bytes);
			msg.build();
		}
		
		public ResponseMessage(utilitarios.StatusCode code)
		{
			msg = Response.newBuilder();
			msg.setStatusCode(StatusCode.forNumber(code.getValue()));
			msg.build();
		}
		
		/**
		 * Responsável por ler uma mensagem de resposta recebida.
		 * @param in InputStream da conexão estabelecida.
		 */
		public void readMessage(InputStream in)
		{
			try {
				response = Response.parseDelimitedFrom(in);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("ERRO AO LER A MENSAGEM!");
			}
		}
		
		/**
		 * Responsável por escrever uma mensagem de resposta 
		 * no buffer e enviá-la.
		 * @param out OutputStream da conexão estabelecida.
		 */
		public void writeMessage(OutputStream out)
		{
			
			try {
				response = msg.build();
				response.writeDelimitedTo(out);
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("ERRO AO ESCREVER A MENSAGEM!");
			}
		}
		
		public Response getResponse()
		{
			return response;
		}
		
		public ByteString getBytes()
		{
			return response.getResponse();
		}
		
		public String getString()
		{
			return response.getResponse().toStringUtf8();
		}
		
		public utilitarios.StatusCode getStatusCode()
		{
			return utilitarios.StatusCode.getStatusCode(response.getStatusCode().getNumber());
		}
		
	}
}
