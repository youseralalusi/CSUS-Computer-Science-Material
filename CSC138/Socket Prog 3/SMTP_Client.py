from socket import *

msg = '\r\n I love computer networks!'

endmsg = '\r\n.\r\n'

mailserver = 'gaia.ecs.csus.edu'

clientSocket = socket(AF_INET, SOCK_STREAM)

clientSocket.connect((mailserver, 25))
#double check mail server

recv = clientSocket.recv(1024)

print recv

if recv[:3] != '220':

        print '220 reply not recieved from server.'

heloCommand = 'HELO gaia.ecs.csus.edu\r\n'

clientSocket.send(heloCommand)

recv1 = clientSocket.recv(1024)

print recv1

if recv1[:3] != '250':
        print 'The server did not recieve 250.'

mailfrom = 'Mail From: <youseralalusi@csus.edu>\r\n'

clientSocket.send(mailfrom)

recv2 = clientSocket.recv(1024)

print recv2

if recv2[:3] != '250':
        print 'The server did not recieve 250.'

rcpTo = 'RCPT TO: <youseralalusi@csus.edu>\r\n'

clientSocket.send(rcpTo)

recv3 = clientSocket.recv(1024)

print recv3

if recv3[:3] != '250' :
        print 'The server did not recieve 250.'

data = 'DATA\r\n'

clientSocket.send(data)

recv4 = clientSocket.recv(1024)

print recv4

if recv4[:3] != '354' :
        print 'Ther server did not recieve 354.'

clientSocket.send(msg)

clientSocket.send(endmsg)
recv5 = clientSocket.recv(1024)
print recv5

if recv5 [:3] != '250':
        print 'The server did not recieve 250.'

quitCommand = 'Quit\r\n'

clientSocket.send(quitCommand)

recv6 = clientSocket.recv(1024)

print recv6

if recv6[:3] != '221':
        print 'The server did to recieve 221.'