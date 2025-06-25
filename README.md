# Fluxo completo na aws
![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.4-brightgreen)
![AWS SDK](https://img.shields.io/badge/AWS%20SDK-2.24.12-yellow)
![Docker](https://img.shields.io/badge/Docker-✓-blue)
![Maven](https://img.shields.io/badge/Maven-3.9.6-red)

## Prerequisites
- Java 21 JDK
- Maven
- AWS Account

## Comandos
### Observação: trocar url e a senha do BD local para BD da nuvem

### Metadados na ec2
```
#!/bin/bash
sudo update -y
sudo yum install nginx -y
sudo yum install java-21-amazon-corretto-headless
sudo systemctl enable nginx
sudo systemctl start nginx
```
### Permissão na chave antes de conectar via SSH:
```
chmod 400 <SUA_CHAVE.pem>
```

### Copindo o index.html para pasta tmp da minha maquina EC2:
```
scp -i "<SUA_CHAVE.pem>" index.html  ec2-user@<SEU_IP_PUBLICO>:/tmp
scp -i "<SUA_CHAVE.pem>" add.html  ec2-user@<SEU_IP_PUBLICO>:/tmp
scp -i "<SUA_CHAVE.pem>" style.css  ec2-user@<SEU_IP_PUBLICO>:/tmp
scp -i "<SUA_CHAVE.pem>" jar.jar  ec2-user@<SEU_IP_PUBLICO>:/tmp
```

### Conectando via SSH:
```
ssh -i "<SUA_CHAVE.pem>" ec2-user@<SEU_IP_PUBLICO>
```

### Movendo o index.html para o index.html do nginx:
```
sudo mv index.html /usr/share/nginx/html/index.html
sudo mv add.html /usr/share/nginx/html/add.html
sudo mv style.css /usr/share/nginx/html/style.css
```

### rodando o jar
```
nohup java -jar sua-aplicacao.jar > log.out 2>&1 &
```

### Adcionando o path do spring no nginx
```
sudo nano /etc/nginx/nginx.conf 
```
```
location /mural {
            proxy_pass http://localhost:8080/mural;
            proxy_http_version 1.1;
            proxy_set_header Host $host;
            proxy_set_header X-Real-IP $remote_addr;
            proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
            proxy_set_header X-Forwarded-Proto $scheme;
        }
```

## Diagrama
<p align="center">
  <img src="/images/aws-estudo-backend.drawio.png">
</p>
