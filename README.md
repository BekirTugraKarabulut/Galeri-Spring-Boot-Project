# Galeri-Spring-Boot-Project

ER Diyagramı (Mermaid)

```mermaid
erDiagram

  KULLANICI {
        String email PK
        String isim
        String soyisim
        String password
        String telefon_no
        String role
  }

  GALERICI {
        String galerici_id PK
        String name
        String password
        String role
  }

  ROL {
        Long id PK
        Integer rol_id
        String rol
  }

  MARKA {
        Long marka_id PK
        String marka_adi
  }

  MODEL {
        Long model_id PK
        String model_adi
  }

  ARAC {
        Long arac_id PK
        String marka
        String model
        Long yil
        String fiyat
        String arac_resmi
  }

  FAVORILEME {
        Long favorileme_id PK
        String email FK
        Long arac_id FK
  }

  RANDEVU {
        Long randevu_id PK
        Date randevu_tarihi
        String randevu_saati
  }

  REFRESH_TOKEN {
        Long refresh_token_id PK
        String token
        Date baslangic_tarihi
        Date bitis_tarihi
  }

  REFRESH_TOKEN_GALERICI {
        Long refresh_token_id PK
        String token
        Date baslangic_tarihi
        Date bitis_tarihi
   }

  ROL ||--o{ KULLANICI : "atanir"
  ROL ||--|| GALERICI : "atanir"

  MARKA ||--o{ MODEL : "icerir"
  MARKA ||--o{ ARAC : "sahiptir"

  GALERICI ||--o{ ARAC : "satar"
  GALERICI ||--o{ RANDEVU : "kabul eder"
  GALERICI ||--o{ REFRESH_TOKEN_GALERICI : "sahiptir"

  KULLANICI ||--o{ FAVORILEME : "yapar"
  KULLANICI ||--o{ RANDEVU : "alir"
  KULLANICI ||--o{ REFRESH_TOKEN : "sahiptir"

  ARAC ||--o{ FAVORILEME : "favorilenir"



  
