# Autenticação de Documentos - Trabalho Vivencial (Estruturas de Dados)

Este projeto consiste na implementação de uma versão estendida de um processo de **autenticação textual digital**. Ele atua como um mecanismo capaz de assegurar a veracidade da identidade do signatário de um texto através de criptografia e processamento eficiente, utilizando estruturas de dados avançadas desenvolvidas em Java.

Trata-se do Trabalho Vivencial da disciplina de Estruturas de Dados (Inteligência Artificial - Análise e Desenvolvimento de Sistemas) da Universidade de Fortaleza - UNIFOR (Polo EAD).

## 🚀 Objetivo

Desenvolver um aplicativo para a verificação da autenticidade de documentos, garantindo a integridade dos dados por meio da geração de códigos hash SHA-1 baseados na distribuição de palavras do texto em uma Árvore AVL balanceada.

## ⚙️ Funcionamento e Estruturas Utilizadas

Para a correta autenticação de cada documento `.txt` iterado linha a linha, o projeto emprega o seguinte fluxo estrutural:

1. **Leitura de Arquivo:** Leitura da base textual de entrada.
2. **Lista Dinâmica:** Para cada linha lida, as palavras são extraídas, limpas (removendo pontuações) e armazenadas em uma Lista Dinâmica no sentido inverso.
3. **Árvore AVL:** As palavras de cada linha são inseridas em uma Árvore AVL balanceada. Comparações são realizadas de forma lexicográfica (ignorando o *case sensitive*), e palavras duplicadas na mesma linha são desconsideradas. O balanço é garantido através de operações de rotação simples e duplas (à esquerda e à direita).
4. **Travessia Pós-Ordem e Hashes:** A combinação do Hash (SHA-1) é computada percorrendo os nós no formato Pós-Ordem. Cada nó pai combina os hashes de seus nós filhos esquerdos e direitos junto com sua própria String armazenada para gerar um sub-hash, que propaga até a raiz.
5. **Pilha Dinâmica:** A árvore de cada linha é armazenada em uma Pilha Dinâmica.
6. **Desempilhamento e Saída:** Ao finalizar a leitura de todo o arquivo, cada árvore depositada na Pilha é desempilhada, e seu hash principal (gerado a partir da Raiz da AVL) é revelado, compondo a assinatura final do documento separada por quebras de linha.

## 🛠️ Tecnologias
- Java (JDK 8 ou superior)
- Tratamento de funções Criptográficas (SHA-1 via `java.security.MessageDigest`)

## 📂 Estrutura do Projeto
- `src/App.java` - O Controlador principal que roda o motor do software.
- `src/HasheadorString.java` - Utilitário estático produtor de strings SHA-1.
- `src/ArvoreAVL.java` - A estrutura da árvore binária balanceada com travessia pós-ordem.
- `src/No.java` - Nó que compõe as folhas da estrutura de árvore.


## 📖 Como Executar (Versão Final)

1. Clone este repositório no seu ambiente de preferência (`git clone`).
2. Adicione ou modifique o arquivo base de teste (`bin/texto.txt`) contendo a massa textual que deseja validar.
3. Compile o software rodando `javac -d bin src/*.java` no terminal.
4. Execute o validador com `java -cp bin App`.

## 🤝 Desenvolvimento em Equipe

Este repositório contém a **estrutura inicial** e parte do motor principal do trabalho.

**Cada membro da equipe deve:**
1. Fazer o pull (ou *fork*) deste repositório original.
2. Adicionar as classes referentes à sua parte do trabalho dentro do diretório `/src` (ex: `Pilha.java`, `ListaDinamica.java`, etc.).
3. Ao realizar o *commit* ou *Pull Request*, **adicione o seu nome na seção "Equipe" deste README** e atualize, se necessário, as instruções da seção *Estrutura do Projeto* listada acima constando o arquivo que você criou!

## 👨‍💻 Equipe
- *Arthur Honorio*
- *(Insira o seu nome aqui após subir sua parte!)*

---
*Este código será avaliado sob critérios do relatório do modelo padrão e submetido por checadores anti-plágio de acordo com os requisitos disciplinares.*
