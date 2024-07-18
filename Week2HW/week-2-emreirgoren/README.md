## Senkron ve Asenkron iletişim nedir örneklerle açıklayın?

### Senkron İletişim
Her işlemin bir sonraki işlemi beklemesidir. Bu iletişimde işlemlerin bir çıktı beklemesi durumunda, çıktının alınamaması bütün iş akışının bozulmasına neden olabilir. Aynı zamanda bu iletişim bir önceki işlemi beklediği için oldukça yavaştır.

### Asenkron İletişim 
İşlemlerin bir önceki işlemleri beklememesi ve çıktıya ihtiyaç duymaksızın çalışabilmesidir. Bu yüzden bu yöntem senkron iletişime göre çok daha hızlı ve kararlıdır.

## RabbitMQ ve Kafka arasındaki farkları araştırın?


## Docker ve Virtual Machine nedir?

### Docker
Docker web uygulamalarını container haline getirip daha hızlı derlememizi ve dağıtmamızı sağlayan yazılım platformudur.

###
Virtual Machine
Kendi işletim sistemleri olan sanal makinelerdir. Sanal makineler işletim sistemleri tam kurulu olduğu için docker'dan daha yavastır.


## Docker ile RabbitMQ ve PostgreSQL ve ya MySQL kurulumu yapın(komutları ekleyin).

### RabbitMQ

RabbitMQ Container oluşturma Port: 5672 UIPort: 15672 Container İsmi: yei-rabbitmq
docker run -d --name yei-rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management

### PostgreSQL

PostgreSQL Container oluşturma Port: 5432 Container İsmi: yei-postgres
docker run --name yei-postgres -e POSTGRES_PASSWORD************* -d postgres


## Docker komutlarını örneklerle açıklayın.


## Microservice ve Monotlith mimarilerini kıyaslayın.
Monolith mimari projenin tek bir servis ve veritabanı üzerinden yürütülmesidir. Proje buyudukce servis ve veritabanı üzerindeki yük artar ve performans sorunlarına yol açar. Microservice mimarisi ise servislerin micro parçalara ayrılıp her servisin bağımsız olarak çalışmasını sağlar. Boylece geliştirmeye açık ve test edilebilirlik kolaylaşır.

## API Gateway, Service Discovery, Load Balancer kavramlarını açıklayın.

### API Gateway
Api Gateway kullanıcıdan gelen endpointlerin hangi servise gideceğini söyleyen yapılardır. Projede gelen isteğin UserService yada BlogService gitmesini belirleyen yapıdır.

### Service Discovery


### Load Balancer 


## BlogHub-service uygulamasına aşağıdaki özellikleri ekleyin. (40 PUAN)
• Kullanıcı şifresini değiştiren endpointi yazın. (Min:6 max 12 karakter)

• like-count endpoint’ini bir kullanıcın en fazla 50 kere beğenibileceği şekilde refactor
edin.

• Kullanıcı kendi PUBLISHED ve DRAFT olan blog’larını getiren endpointi yazın.

• Kullanıcı kendi blog’larından DRAFT statüsünde olanları hard delete ile silebilir.

• Blog’lar bir tane resime sahip olabilir, bu resim ücretsiz bir storage kaydedilmelidir.

• Sadece onaylanmış bir kullanıcı blog yayınlayabilir.

• Email ve payment service’larına da generic response ve exception handler
mekanizmasını ekleyin.
