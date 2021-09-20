package com.integrado.auth;


public class JwtConfig {
public static final String LLAVE_SECRETA= "fg.key.string";
public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\r\n"
		+ "MIIEowIBAAKCAQEAv2OIYho6YXr7FeHQyLRrlGs7wJsXw8ha2+hLSrRN9LQWWzjy\r\n"
		+ "r+ontIOeLDz6I0EGs8ZYVWJRmDGxx1mvOCL3p6qW6ii+Lyk71Ho4xXz6Y1T3nEkM\r\n"
		+ "/BUq6VPUHz1nk/i3M9pVbYpjoLfuyXRSWd+T5pEkYsVukb7osn1EGQneaeu8O6r5\r\n"
		+ "cGB2cjaO4Jm3BSnNpwEMTdkBDC1zNgvBzHmzSWYtY3yD9HdvK6GdqUMixhFf+etm\r\n"
		+ "tOhZuIP97MYAgbnCa/y1Mn2o7c/W6Rgs8cGxH/zVvkbPi1x86aP/rjGDTG0V6z/B\r\n"
		+ "xyP9DNgkYBn6+97BCtw4oNqiVIdfjgE7zoOfawIDAQABAoIBACZyKxpx5Fpipv+d\r\n"
		+ "TiCTRa0Z4XXucdatb7sPLdjC4YoPhxIqHW5DHli/u81tLl5YmK0SYfo89uEY0nqW\r\n"
		+ "RIGFXLR8qzY8mv/ES7WCG9doJLBBiEAH2Kjm46jdYxYncqAh7UNoT5LiouLNMBWd\r\n"
		+ "3VEafY5qh6GjwXNbo0j/qudQuTIThGg7J+eUX1hfLbXdS3k5qO52mPyk/XGDqrBj\r\n"
		+ "pZ1dIFd+tBTOguCEdfaDEGPVeesDJ+iJ2KM8G5Bx3nFwf9fjShfgh40PUwNEDqL8\r\n"
		+ "MqY7Zgy/MuoiQ1fj+M9bsDTjNEfoxbRdpxY68OVnrQoCnlH/oarEpkPRz9noztZ9\r\n"
		+ "HuII2FECgYEA9Pk38k7X6iex1qZ7Y6MrB32JKCEzGaZUjVnJVM/QO/mvy6kLH2Wk\r\n"
		+ "0yBzSg6fYUNoGXdpVmXaE09+uBSSWOvSq7zql8WK8kQKW+lvipQmyETBj0SFJgXy\r\n"
		+ "fCiWofd+xvwPemxdEN1z8DhZuO5B/powzLKiigZ/jx5WPfWQ/znQookCgYEAyADe\r\n"
		+ "P2lSHxwNjlcwezJyyGpPDAhw5M1Bm6LFpNWP5qTr9lwZ7t+IzfX3JGRymj2M7Okv\r\n"
		+ "YMXQeyyxNk002tEhj8SLwfZBVIyVFR90kPkXJDOCX+djAvyl0rherRkzeyFiYQov\r\n"
		+ "pcXZXo2BsoYrwCqSaB2IW56wzBXhT/ebAm+QRVMCgYBRRD/QDWHJVwPDDpWOVznW\r\n"
		+ "EUon2uOl1azk+20zyoDs9IbiDCEZeFG2jGRSpAkxbfghwqBaPg2bLFsAXCq0fv7z\r\n"
		+ "ZAd689iFSBcbqJQNJ9q5wz1m9rcpBv4LPDfEYWNYRZQo67vv9VcZ0MfK9pdEDAi2\r\n"
		+ "T2hmW4ODie/YPBeu45IX6QKBgQC16mQ8VTXG6iNCZvfH9tkEhf2kOkFFO5UDVQhk\r\n"
		+ "p4OeDEA78wX7igLLI4BJ77t1o6p9CpR3dzXr83i0pYD/ztyyAdoE8FH3727iqZvD\r\n"
		+ "CW4NFXTuem5KlzbU9bHXzGZRBsqO7U7tf4n5QMjJctR0k8RbQxF2FF9HIlev/s1V\r\n"
		+ "Z9hX1QKBgD1F1rrgxvPgfIGkr0g4EMQXRz5UryWT5n+bk1ORok8vlFx5k/4I0N5L\r\n"
		+ "uY83ZSrQJ5ZOLkxUwZ73eKS88nf6tseyt+lmNPh7Vv63zq51HmaR1I6zPnw1/LuM\r\n"
		+ "SMCF/gFkHXG1rX4JsubB4yvIBXprTPMvcc2yyD8d5OqL2zX5Rl9L\r\n"
		+ "-----END RSA PRIVATE KEY-----";
public static final String RSA_PUBLIC = "-----BEGIN PUBLIC KEY-----\r\n"
		+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAv2OIYho6YXr7FeHQyLRr\r\n"
		+ "lGs7wJsXw8ha2+hLSrRN9LQWWzjyr+ontIOeLDz6I0EGs8ZYVWJRmDGxx1mvOCL3\r\n"
		+ "p6qW6ii+Lyk71Ho4xXz6Y1T3nEkM/BUq6VPUHz1nk/i3M9pVbYpjoLfuyXRSWd+T\r\n"
		+ "5pEkYsVukb7osn1EGQneaeu8O6r5cGB2cjaO4Jm3BSnNpwEMTdkBDC1zNgvBzHmz\r\n"
		+ "SWYtY3yD9HdvK6GdqUMixhFf+etmtOhZuIP97MYAgbnCa/y1Mn2o7c/W6Rgs8cGx\r\n"
		+ "H/zVvkbPi1x86aP/rjGDTG0V6z/BxyP9DNgkYBn6+97BCtw4oNqiVIdfjgE7zoOf\r\n"
		+ "awIDAQAB\r\n"
		+ "-----END PUBLIC KEY-----";
}
