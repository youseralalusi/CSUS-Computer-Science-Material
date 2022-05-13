#import socket module
from socket import *
serverSocket = socket(AF_INET, SOCK_STREAM)

#Prepare a server socket
serverPort = 6789
serverSocket.bind(("", serverPort))
serverSocket.listen(1)

while True:
	print('Ready to serve...')

	#Establish the connection
	connectionSocket, addr = serverSocket.accept()
	try:
			message = connectionSocket.recv(1024)
			filename = message.split()[1]
			f = open(filename[1])
			outputData = f.read()

		#Send one HTTP header line into socket
			connectionSocket.send('HTTP/1.0 200 OK\r\n\r\n')
		#Send the content of the requested file to the client
			for i in range(0, len(outputData)):
				connectionSocket.sent(outputdata[i])
				connectionSocket.close()
	except IOError:
		#Send response message for file not found
		connectionSocket.send("HTTP/1.1 404 Not Found\r\n\r\n")
		#Close client socket
		connectionSocket.close()
	serverSocket.close()
