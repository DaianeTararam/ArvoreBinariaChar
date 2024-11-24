# Árvore Binária de Busca para Caracteres

Este projeto implementa uma **Árvore Binária de Busca** para manipular caracteres, incluindo operações de inserção, remoção e exibição dos nós em ordem. A aplicação segue o padrão **MVC (Model-View-Controller)**, dividindo responsabilidades para facilitar a manutenção e compreensão do código.

---

## Estrutura do Projeto

O projeto é organizado em três pacotes principais:

1. **`view`**: Contém a classe principal, responsável por executar o programa.
2. **`controller`**: Controla as ações e gerencia a lógica da aplicação.
3. **`model.estrutura`**: Contém as classes relacionadas à estrutura da árvore binária e seus nós.

---

## Classes e Métodos

### 1. **`view.ArvoreCharPrincipal`**

Classe principal que executa o programa.

- **Função principal `main`**:
  - Instancia o controlador da árvore (`ArvoreCharController`).
  - Utiliza um bloco **try-catch** para capturar e exibir possíveis exceções.
  - Exemplo de execução:
    ```java
    try {
        String resultado = controller.teste();
        System.out.println("O resultado em ordem é: " + resultado);
    } catch (Exception e) {
        e.printStackTrace();
    }
    ```
  - **Uso do try-catch**:
    - Serve para lidar com erros que possam ocorrer durante a execução do programa, evitando que a aplicação termine inesperadamente. Nesse caso, o erro será exibido no console.

---

### 2. **`controller.ArvoreCharController`**

Controla as operações realizadas na árvore.

- **Método `teste`**:
  - Realiza a inserção de caracteres na árvore.
  - Retorna a árvore como uma **string ordenada**.
  - Exemplo de uso:
    ```java
    ArvoreChar tree = new ArvoreChar();
    tree.inserir('l');
    tree.inserir('c');
    tree.inserir('k');
    // ...
    return tree.toString();
    ```

---

### 3. **`model.estrutura.ArvoreChar`**

Classe principal que define a árvore binária de busca.

#### Atributos:
- `No raiz`: Representa a raiz da árvore, inicializada como `null`.

#### Métodos principais:
- **`inserir(char letra)`**:
  - Insere um novo nó na árvore.
  - Caso a árvore esteja vazia, o nó se torna a raiz. Caso contrário, chama o método `inserirNo`.

- **`inserirNo(No raiz, No atual)`**:
  - Método recursivo que encontra o local correto para inserir o novo nó.
  - Insere à **esquerda** caso o valor seja menor que a raiz, ou à **direita** caso seja maior.

- **`remover(char letra)`**:
  - Remove um nó com o valor especificado.
  - Atualiza a árvore com base nos casos:
    - Nó sem filhos.
    - Nó com um filho (esquerdo ou direito).
    - Nó com dois filhos (usa o menor valor do lado direito como sucessor).
  - Retorna `true` se a remoção foi bem-sucedida.

- **`encontrarMenor(No atual)`**:
  - Encontra o menor valor na subárvore, usado para substituir um nó removido que possui dois filhos.

- **`toString()`**:
  - Exibe a árvore em ordem crescente.
  - Usa o método auxiliar **`ordem(No no, StringBuilder builder)`**, que percorre os nós da árvore de forma recursiva:
    1. Visita a subárvore esquerda.
    2. Adiciona o nó atual.
    3. Visita a subárvore direita.
  - Exemplo:
    ```java
    @Override
    public String toString() {
        if (this.raiz == null) return "[]";
        StringBuilder builder = new StringBuilder();
        ordem(this.raiz, builder);
        return builder.toString().trim();
    }
    ```
    - **Uso do `trim()`**:
      - Remove espaços desnecessários do início e fim da string, garantindo uma saída limpa.

---

### 4. **`model.estrutura.No`**

Representa os nós da árvore.

#### Atributos:
- `char letra`: Valor armazenado no nó.
- `No esquerda`: Referência ao filho esquerdo.
- `No direita`: Referência ao filho direito.

#### Métodos principais:
- **Construtor**:
  - Inicializa o nó com um valor de caractere e define as referências como `null`.
- **Getters e Setters**:
  - Manipulam os atributos do nó.
- **Sobrescrita do `toString()`**:
  - Retorna o valor do nó como string para facilitar a exibição:
    ```java
    @Override
    public String toString() {
        return String.valueOf(letra);
    }
    ```

---

## Fluxo de Execução

1. **Inserção de Caracteres**:
   - Os caracteres são inseridos na árvore de forma a manter a propriedade da árvore binária de busca (valores menores à esquerda e maiores à direita).
2. **Remoção de Caracteres**:
   - Remove um nó especificado, reorganizando os filhos conforme necessário.
3. **Exibição em Ordem**:
   - Usa o método `toString` para retornar os caracteres em ordem crescente.

---

## Exemplo de Uso

### Entrada:
```java
ArvoreChar tree = new ArvoreChar();
tree.inserir('l');
tree.inserir('c');
tree.inserir('k');
tree.inserir('o');
tree.inserir('a');
tree.inserir('z');
System.out.println(tree.toString());
tree.remover('o');
System.out.println(tree.toString());
```

## Criadora

**Nome:** Daiane Tararam  
**Email:** daalkmim@gmail.com
🌐 **GitHub**: [Daiane Tararam](https://github.com/DaianeTararam)  

## Tecnologias Utilizadas

- **Java:** Linguagem de programação usada para o desenvolvimento das funcionalidades.
- **Eclipse:** IDE usada para o desenvolvimento do projeto.
- **Git e GitHub:** Ferramentas usadas para controle de versão e gerenciamento de código.
- **Sistema Operacional:** Windows 11*.

