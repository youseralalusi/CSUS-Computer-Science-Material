from socket import*

serverName = '127.0.0.1'
serverPort = 12000

clientSocket = socket(AF_INET, SOCK_STREAM)
clientSocket.connect((serverName, serverPort))
message = raw_input('Input lowercase message...')
clientSocket.send(message)

modifiedMessage = clientSocket.recv(1024)
print 'From Server:', modifiedMessage
clientSocket.close()
