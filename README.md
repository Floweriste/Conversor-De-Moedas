# Conversor de Moedas em Java

Um aplicativo simples de **conversão de moedas** via **console**, desenvolvido em **Java**, utilizando a **API ExchangeRate** para obter cotações em tempo real e a biblioteca **Gson** para desserializar os dados JSON retornados pela API.

---

Como configurar o projeto

### 1️⃣ Clonar o repositório
```bash
git clone https://github.com/seu-usuario/conversor-moedas-java.git
cd conversor-de-moedas

Adicionar o Gson no IntelliJ

Clique com o botão direito na pasta do projeto → Abrir Configurações do Módulo (Open Module Settings).

Vá em Project Settings → Modules → Dependências (Dependencies).

Clique em “+” → “Library” → “From Maven...”.

Pesquise por:

com.google.code.gson:gson:2.11.0

Clique em OK → Apply → OK.

Como executar o projeto

Abra o projeto no IntelliJ.

Certifique-se de que o arquivo Main.java está selecionado.

Pressione Shift + F10 para executar.

O console exibirá o menu principal com as opções de conversão.
