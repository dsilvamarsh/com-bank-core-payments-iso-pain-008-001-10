docker rmi --force dsilvamarsh/com-bank-core-payments-iso-pain-008-001-10:1.0.0
docker rm $(docker ps --filter status=exited -q)
docker build -t dsilvamarsh/com-bank-core-payments-iso-pain-008-001-10:1.0.0 .
docker push dsilvamarsh/com-bank-core-payments-iso-pain-008-001-10:1.0.0
#docker run -p 8080:8080 com-bank-core-payments-iso-pain-008-001-10
