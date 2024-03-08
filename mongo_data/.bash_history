mongosh
mongosh -U admin
mongosh --username admin --password  --authenticationDatabase '$external' --authenticationMechanism "PLAIN"  --host "mongodb.example.com" --port 27017
mongosh --username admin --password  --authenticationDatabase '$external' --authenticationMechanism "PLAIN" --host "localhost" --port 27017
exit
