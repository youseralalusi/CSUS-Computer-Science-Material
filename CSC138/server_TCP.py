from socket import*

serverPort = 12000
serverSocket = socket(AF_INET, SOCK_STREAM)
serverSocket.bind(('', serverPort))
serverSocket.listen(1)
print 'The server is ready to recieve...'

while 1:
	connectionSocket, addr = serverSocket.accept()

	message = connectionSocket.recv(1024)
	messageCap = message.upper()
	connectionSocket.send(messageCap)
	connectionSocket.close()
