# Turkcell Ecommerce HomeWork

Bir E-ticaret sistemi oluşturmak istiyoruz. Spring Boot 3.0.4, paket yöneticisi olarak Maven ve Java SDK olarak 17 veya daha üst bir versiyon kullanılacaktır.
(Sadece Spring Web ve Swagger bağımlılığını eklemeniz yeterli olacaktır.)

Proje ismi : e-commerce

Req 1 : Sistemde Ürünler(Product) tutulmalıdır.

Req 2 : Ürünün id,name,quantity,price ve description şeklinde özellikleri olacaktır.

Req 3 : Ürünleri ekleyebilecek, silebilecek, güncelleyebilecek, listeleyebilecek, id ile getirebilecek kodları yazınız. Bunu tamamen in memory yapınız.

Req 4 : Ürünlerin fiyat bilgisi 0 dan büyük olmalıdır.

Req 5 : Ürünlerin quantity(miktarı) 0 dan küçük olamaz.

Req 6 : Ürünlerin description(açıklama) alanı min 10 karakter max 50 karakter olmalıdır.

Req 7 : Ürünleri aktif veya pasif yapacak bir kod yazılmalıdır. Bu kod bir metod içinde yer almalıdır.

Req 8 : Ürünler listelenirken bir parametre kullanılmalıdır. Bu parametre ile pasif olan ürünlerin görünürlüğü kontrol edilebilir hale getirilmelidir.

Req 9 : Ürünlerin satışı için bir Sale servisi yazılmalıdır. Ürünün stokta olup olmadığını ve aktif durumda olup olmadığı kontrol edilmelidir.

Req 10 : Ürünün satılabilmesi için Payment servisi yazılmalıdır. Bu servis, müşterinin ödeme bilgilerini kontrol etmeli ve ödeme işlemini gerçekleştirmelidir.

Req 11 : Ürün satışı sonrası fatura müşteriye gönderilmelidir. Bu işlem simüle edilebilir.