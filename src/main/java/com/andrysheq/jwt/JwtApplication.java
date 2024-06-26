package com.andrysheq.jwt;

import io.jsonwebtoken.security.Keys;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.crypto.SecretKey;
import java.security.SecureRandom;

@SpringBootApplication
@EnableJpaRepositories
public class JwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtApplication.class, args);
		SecureRandom secureRandom = new SecureRandom();
		byte[] keyBytes = new byte[32]; // 256 бит = 32 байта
		secureRandom.nextBytes(keyBytes);

		// Преобразование массива байт в SecretKey
		SecretKey secretKey = Keys.hmacShaKeyFor(keyBytes);

		// Вывод ключа (рекомендуется хранить его в безопасном месте)
		String hexKey = DatatypeConverter.printHexBinary(secretKey.getEncoded());
		System.out.println("Сгенерированный ключ: " + hexKey);
	}

}
