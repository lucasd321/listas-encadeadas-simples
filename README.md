# MyArrayList - Implementação de Lista Sequencial

> Implementação do Tipo Abstrato de Dados (TAD) de uma Lista Sequencial (Array-Based List) em Java.

Este repositório contém as operações fundamentais de manipulação de dados, a lógica de redimensionamento dinâmico e os algoritmos clássicos de gerenciamento de arrays para uma estrutura personalizada de Lista Sequencial.

## ⚙️ Como funciona

Uma Lista Sequencial é uma estrutura de dados linear onde os elementos são armazenados em posições contíguas de memória, utilizando um array interno como base.

* Ao contrário de um array padrão de tamanho fixo, essa estrutura gerencia sua própria capacidade de forma abstrata.
* Ela utiliza um array interno para guardar os dados e um número inteiro para rastrear o tamanho atual (`size`), ou seja, o número de posições válidas e ocupadas.
* Quando o array interno atinge sua capacidade máxima, a estrutura cria automaticamente um novo array maior e copia os elementos existentes, dando a ilusão de uma lista que se expande infinitamente.
* Os elementos são acessados diretamente através de índices numéricos, começando do zero.

## 💡 O porquê: vantagens e utilidade

Implementar essa estrutura de dados evidencia os compromissos (trade-offs) entre o gerenciamento de memória e a velocidade de processamento. Aqui estão os principais motivos pelos quais as listas sequenciais são amplamente utilizadas:

* **Acesso instantâneo (Indexação):** Recuperar um elemento pelo seu índice tem complexidade de tempo `O(1)`. Não é necessário percorrer a estrutura para encontrar o item em uma posição específica.
* **Eficiência de cache:** Como a memória é contígua, as CPUs modernas conseguem pré-carregar os dados de forma altamente eficiente, tornando laços de repetição (loops) e iterações significativamente mais rápidos do que em estruturas baseadas em ponteiros.
* **Baixo consumo de memória extra:** Não há necessidade de alocar memória adicional para ponteiros ou referências (como o nó `next` em listas encadeadas). A estrutura armazena apenas os dados reais.

## 🚀 Quando usar em aplicações

No desenvolvimento de software moderno, estruturas baseadas em arrays dinâmicos (como o `ArrayList` nativo do Java) costumam ser a escolha padrão para dados lineares. Use conceitos de listas sequenciais em cenários como:

* **Playlists de música e filas de mídia:** Aplicações que exigem indexação para pular diretamente para uma faixa específica, embaralhar elementos eficientemente ou ler dados sequencialmente sem inserções frequentes no meio da lista.
* **Visualização de dados e tabelas:** Renderização de placares, catálogos de produtos ou painéis onde o sistema lê os dados com muito mais frequência do que os modifica.
* **Iterações de alta performance:** Sistemas que processam lotes de dados e exigem máxima eficiência de cache da CPU, onde a memória contígua é um requisito estrito.

## 📂 Estrutura do projeto

* `ArrayListTAD.java`: Interface que define o contrato para as operações da estrutura de dados (ex: adicionar, remover, buscar, tamanho).
* `MyArrayList.java`: Implementação concreta da interface. Esta classe gerencia o array interno, o contador `size` e a lógica de redimensionamento dinâmico do array (expandindo a capacidade quando cheio).
* `Main.java`: Interface de linha de comando (CLI) interativa para testar as funcionalidades, adicionar ou remover elementos e visualizar o comportamento da estrutura e as mudanças de capacidade em tempo real.

--

# MyArrayList - Sequential List Implementation

> Abstract Data Type (ADT) implementation of a Sequential List (Array-Based List) in Java.

This repository contains the fundamental data manipulation operations, dynamic resizing logic, and classical array management algorithms for a custom Sequential List structure.

## ⚙️ How it Works

A Sequential List is a linear data structure where elements are stored in contiguous memory locations, utilizing an internal array as its foundation.

* Unlike a standard fixed array, this structure abstractly manages its own capacity.
* It utilizes an internal array to hold the data and an integer tracking the current `size` (the number of valid, occupied positions).
* When the internal array reaches its maximum capacity, the structure automatically creates a new, larger array and copies the existing elements over, giving the illusion of an infinitely expanding list.
* Elements are accessed directly through numerical indices, starting from zero.

## 💡 The Why: Advantages and Utility

Implementing this data structure highlights the trade-offs between memory management and processing speed. Here are the main reasons sequential lists are widely used:

* **Instant access (Indexing):** Retrieving an element by its index has a time complexity of `O(1)`. You do not need to traverse the structure to find the item in a specific position.
* **Cache friendliness:** Because the memory is contiguous, modern CPUs can pre-fetch the data highly efficiently, making loops and iterations significantly faster than pointer-based structures.
* **Low memory overhead:** There is no need to allocate extra memory for pointers or references (like the `next` node in linked lists). The structure only stores the actual data.

## 🚀 When to use in applications

In modern software development, structures based on dynamic arrays (like Java's native `ArrayList`) are often the default choice for linear data. Use sequential list concepts in scenarios such as:

* **Music playlists and media queues:** Applications that require indexing to skip directly to a specific track, shuffle elements efficiently, or read data sequentially without frequent insertions in the middle of the list.
* **Data visualization and tables:** Rendering leaderboards, product catalogs, or dashboards where the system reads data much more frequently than it modifies it.
* **High-performance iterations:** Systems that process batches of data and require maximum CPU cache efficiency, where contiguous memory is a strict requirement.

## 📂 Project Structure

* `ArrayListTAD.java`: Interface that defines the contract for the data structure operations (e.g., add, remove, get, size).
* `MyArrayList.java`: Concrete implementation of the interface. This class manages the internal array, the `size` counter, and the dynamic array resizing logic (expanding capacity when full).
* `Main.java`: Interactive Command Line Interface (CLI) to test the functionalities, add or remove elements, and visualize the structure's behavior and capacity changes in real time.
