# embedded-tomcat-https
#### Enable HTTPS in a Spring Boot Java

###### Generate a self-signed SSL certificate
```
keytool -genkeypair -alias tomcat -keyalg RSA -keysize 2048 -keystore keystore.jks -validity 3650
keytool -genkeypair -alias tomcat -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore keystore.p12 -validity 3650 #PKCS12
```

###### view content of  SSL certificate
```
keytool -list -v -keystore keystore.jks
keytool -list -v -storetype pkcs12 -keystore keystore.p12 #PKCS12
```

###### Use an existing SSL certificate
```
keytool -import -alias tomcat -file myCertificate.crt -keystore keystore.p12 -storepass password
```

###### Distribute the SSL certificate to clients
```
keytool -export -keystore keystore.jks -alias tomcat -file myCertificate.crt
```

###### Import the certificate inside the JRE keystore
```
keytool -importcert -file myCertificate.crt -alias tomcat -keystore $JDK_HOME/jre/lib/security/cacerts
```

###### view public key in using openssl
```
keytool -list -rfc --keystore keystore.jks | openssl x509 -inform pem -pubkey
```