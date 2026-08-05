# 🛒 E-Commerce API

![Java](https://img.shields.io/badge/Java-17-orange.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x%20%2F%204.x-brightgreen.svg)
![MongoDB](https://img.shields.io/badge/MongoDB-Database-green.svg)
![Redis](https://img.shields.io/badge/Redis-Cache-red.svg)
![Maven](https://img.shields.io/badge/Maven-Build-blue.svg)

Uma API RESTful para ecossistema de e-commerce desenvolvida em **Java 17** com **Spring Boot**, utilizando persistência em **MongoDB**, camada de cache reativo com **Redis** e integração entre microsserviços/APIs externas via **Spring Cloud OpenFeign**.

---

## 📋 Sumário

- [Visão Geral](#-visão-geral)
- [Tecnologias Utilizadas](#-tecnologias-utilizadas)
- [Arquitetura e Estrutura do Projeto](#-arquitetura-e-estrutura-do-projeto)
- [Pré-requisitos e Configuração](#-pré-requisitos-e-configuração)
- [Como Executar a Aplicação](#-como-executar-a-aplicação)
- [Autor](#-autor)

---

## 🎯 Visão Geral

O projeto consiste na API backend de uma plataforma de e-commerce. Ele foi projetado focando em alta performance, desacoplamento de responsabilidades e escalabilidade. 

A arquitetura adota:
- **NoSQL (MongoDB)** para armazenamento flexível e escalável de produtos, pedidos e clientes.
- **Cache In-Memory (Redis)** para otimização de consultas frequentes e alta vazão de acessos.
- **OpenFeign** para integração simplificada e declarativa com serviços web externos.

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java 17
- **Framework Principal:** Spring Boot
- **Módulos Spring:**
  - **Spring Web / WebMVC:** Construção de controladores REST.
  - **Spring Data MongoDB:** Mapeamento de documentos e persistência de dados.
  - **Spring Data Redis (Reactive):** Gerenciamento de cache e dados temporários de alta velocidade.
  - **Spring Cloud OpenFeign:** Cliente HTTP declarativo para consumo de APIs de terceiros.
  - **Spring Validation:** Validação de DTOs e payload das requisições.
  - **Spring Cache:** Abstração para gerenciamento de cache.
- **Utilitários:**
  - **Lombok:** Redução de código boilerplate (`@Data`, `@Getter`, `@Setter`, `@Builder`, etc.).
  - **Maven:** Gerenciador de dependências e build da aplicação.

---

## 📂 Arquitetura e Estrutura do Projeto

A aplicação segue o padrão em camadas com separação clara de responsabilidades:

```text
src/main/java/lucas/java/ecommerce/
├── client/       # Interfaces e clientes HTTP (Spring Cloud OpenFeign) para integração com APIs externas.
├── controller/   # Camada REST (Endpoints HTTP, recebimento de requisições e respostas DTO).
├── entity/       # Modelos de domínio e documentos mapeados para o MongoDB.
├── repository/   # Interfaces de acesso ao banco de dados (Spring Data MongoDB Repositories).
├── service/      # Camada de regras de negócio, validações e orquestração dos serviços.
└── EcommerceApplication.java # Classe principal de inicialização da aplicação Spring Boot.
