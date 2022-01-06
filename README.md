# Kütüphane Projesi

Teknolojiler:Java,Spring Boot, Hibernate, Spring Data JPA, Postgresql
PosgtreSql: Docker imaj ile çalıştırıldı

## İlk Commit olarak:
1.User ve userAccount sınıfları oluşturularak temel tanımlamalar yapıldı.

2.Veritabanı olarak PostgreSql seçtim ve bunu Docker imajı olarak ayağa kaldırdım.

3.Projeyi 3 katmanlı mimari ile dizayn ettim. Dışarıdan direkt olarak veri tabanına erişilmemesi için UserDto gibi ara katmanlarla çalıştım.

## 06.01 Commit'i:
Book ve Author tabloları yaratıldı. API'lerde gerekli düzenlemeler yapıldı. Dependeny Injection Yapıldı.

PUT, DELETE, UPDATE Http metodalrını ekledim ve ve arka planda gerçekleşmesi gereken işlemleri BookServiceImpl ve UserServiceImpl sınıfında metod fonk olarak tanımladım.

Aspect Oriented Programming yapıldı. her işlem sonrasında konsola mesaj dönülmesi sağlandı.
