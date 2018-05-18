package ar.org.centro8.curso.java.serverclientsocket;

public class TardeClase30 {
	
	/*
	 *
	 *	Protocolo de comunicaciones TCP
	 *
	 *	Server                  |            Client
	 *	------                  |            ------
	 *	ServerSocket(port)      |            Socket
	 *		.accept()           |
	 *                          | 
	 *	OutputStream    --------|------->    InputStream
	 *	InputStream     <-------|--------    OutpuStream
	 *	                        |
	 *	close()                 |            close()
	 *	------------------------------------------------
	 *	
	 *	PrintStream: Transporta caracteres UNICODE
	 *	BufferedOutpuStream - BufferedInputStream: Transporta datos de a buffers
	 *	DataOutStream - DataInputStream: Transporto datos primitivos de JAVA
	 *	DataObjectInputStream - DataObjectOutputStream: Transporta Objetos de JAVA
	 *	
	 */
}
