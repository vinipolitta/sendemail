package br.com.sendemail.dtos;

public record Email(String email, String name, String phone, String subject, String message) {
}
