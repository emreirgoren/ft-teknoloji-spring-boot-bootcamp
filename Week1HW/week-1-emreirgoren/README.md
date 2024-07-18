# Ft Teknoloji Spring Boot Bootcamp Week 1 

## 1. Java dünyasındaki framework’ler ve çözdükleri problemler nedir? Kod Örneklendirinide içermelidir.

### Spring Framework

Java ile uygulama geliştirmemizi kolaylaştıran kodlarımızı yöneten framework’tür. Daha az kod yazarak daha fazla iş yapmamızı sağlar. Bu nedenle proje     geliştirirken gerçek iş kodları dediğimiz (business) kodlara daha fazla zaman ayırmamızı sağlar. Ayrıca modülerlik sağladığı için kod okunabilirliğini arttırır   ve test sürecimizi kolaylaştırır.

İlk çıktığı zamanda Java’da Dependency Injection insanları çok zorladığı için java’da kışı yaşıyorduk şimdi baharı yaşayacağız diyip ismini spring koymuşlardır.

Dependency Injection —> Bağımlılıkların sınıfa dışardan verilmesidir. (enjekte edilmesi) 3 farklı injection yöntemi vardır. Bunlar Constractor Injection, Setter Injection ve Method Injection. En çok kullanılan Constractor Injection’dır.

Kodlarımı framework’e veriyorum ve diyorum ki kodlarımı sen yönet.

### Quarkus

### Apache Struts

### Micronaut

## 2. SOA - Web Service - Restful Service - HTTP methods kavramlarını örneklerle açıklayınız.

### SOA (Service Oriented Architecture)
Servis yönelimli mimari buyuk projelerdeki birlikte olan servislerin ayrılıp her birinin ayrı bir sekilde bagımsız hizmet vermesini amaçlar. 

Microservices mimarisine benzerdir.

### Web Service
İki makinanın bir ağ üzerinden birbirleri ile iletişim kurmak için kullandığı yöntemdir. Örnek olarak bir e-ticaret sitesinde ürünleri listelemek için gönderilen endpointe karşılık listelenen ürün listesi.

### Restful Service
Client- Server arasında hızlı iletişim kurulmasını sağlayan servis yapısıdır. Minimum içerikle veri transferi yaptığı için hızlıdır. XML veya JSON verileri ile iletişim sağlar. Bu şekilde tasarlanan servislere Restful servis denir. Örnek olarak e-ticaret sitesinde belirli bir ürün ile ilgili bilgi almak için gönderilen get isteğine karşılık; servisin içinde ürün bilgileri olan json formatında veri göndermesi.

### HTTP Methods
Kullanıcı ile servis sağlayıcısı arasında kullanılan metotlardır. En çok kullanılanlar:

GET : Verileri getirmek için kullanılır.

POST : Veri eklemek için kullanılır.

PUT : Veri güncellemek için kullanılır.

DELETE : Veri silmek için kullanılır.

## 3. Singleton ve Factory pattern kullanarak projedeki objeleri oluşturun.
[Singleton Pattern]()

[Factory Pattern](https://github.com/ft-teknoloji-spring-boot-bootcamp/week-1-emreirgoren/tree/main/bloghubFactoryPattern)

## 4. Bir müşteri, ürün, sipariş ve fatura objeleri olacak şekilde online alışveriş sistemi tasarlayın. 
- Bir müşteri birden fazla sipariş verebilir.
- Bir sipariş içerisinde birden fazla ürün olabilir.
- Ürünün kategorisi, fiyatı, ismi ve stok bilgisi vardır.
- Her siparişin bir faturası vardır.
Bu kurallar çerçevesinde derste öğrendiğimiz OOP kavramlarını ve Collection framework
yapılarını örnekleyin. Sadece derslerde yaptığımız gibi Main method üzerinden
gerçekleştirmeniz yeterli.
• Sistemdeki bütün müşterisi sayısını bulan,

• İsmi Cem olan müşterilerin aldıkları ürün sayısını bulan,

• İsmi Cem olup yaşı 30’dan küçük 25’ten büyük müşterilerin toplam alışveriş tutarını hesaplayın,

• Sistemdeki 1500 TL üzerindeki faturaları listeleyin.

[Solution](https://github.com/ft-teknoloji-spring-boot-bootcamp/week-1-emreirgoren/tree/main/shoppingApi)

## 5. BlogHub uygulamasına aşağıdaki özellikleri ekleyin.

• Password bilgisini SHA-512 ile hashleyin.

• Blog istatistiklerini hesaplayan ve gösteren bir kodu yazın.

• Blog’ları oluşturulma tarihine göre, yorum sayısına göre ve okunma sayısına göre artan ve azalan olacak şekilde listeleyen kodu yazın.

[Solution](https://github.com/ft-teknoloji-spring-boot-bootcamp/week-1-emreirgoren/tree/main/bloghub-v2)
