# Kütüphane Projesi

Teknolojiler:Java,Spring Boot, Hibernate, Spring Data JPA, Postgresql
PosgtreSql: Docker imaj ile çalıştırıldı

## İlk Commit olarak:
1.User ve userAccount sınıfları oluşturularak temel tanımlamalar yapıldı.

2.Veritabanı olarak PostgreSql seçtim ve bunu Docker imajı olarak ayağa kaldırdım.
[My Docker Compose File](https://github.com/cagrikucukbesleme/LibraryProject-JavaSpringBoot/blob/master/src/main/resources/docker-compose.yml)

3.Projeyi 3 katmanlı mimari ile dizayn ettim. Dışarıdan direkt olarak veri tabanına erişilmemesi için UserDto gibi ara katmanlarla çalıştım.

## 06.01 Commit'i:
Book ve Author tabloları yaratıldı. API'lerde gerekli düzenlemeler yapıldı. Dependeny Injection Yapıldı.

[HTTP Methods Class](https://github.com/cagrikucukbesleme/LibraryProject-JavaSpringBoot/blob/master/src/main/java/com/libraryproject/libraryproject/controller/UserController.java)
PUT, DELETE, UPDATE Http metodalrını ekledim ve ve arka planda gerçekleşmesi gereken işlemleri BookServiceImpl ve UserServiceImpl sınıfında metod fonk olarak tanımladım.

Aspect Oriented Programming yapıldı. [My Aspect Class](https://github.com/cagrikucukbesleme/LibraryProject-JavaSpringBoot/blob/master/src/main/java/com/libraryproject/libraryproject/aspects/ServiceAspect.java)
aspects isminde package ve onun altında @Aspect'lerimi yazdığım ServiceAspect sınıfını oluşturdum. Gerekli metodaları tanımladım.
her işlem sonrasında konsola mesaj dönülmesi sağlandı.

Projem sadece projenon config dosyasını değiştirerek Hem H2 DB Hemde PostgreSql ile çalışabilmekte. 
[Config File](https://github.com/cagrikucukbesleme/LibraryProject-JavaSpringBoot/blob/master/src/main/resources/application.properties)
