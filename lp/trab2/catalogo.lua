--
-- catalogo.lua
--
-- Definição e implementação da
-- classe Catalogo e suas funções
--

-- Adicionando arquivo de script livro.lua
local ls = require("livro")

-- Tabela de métodos
local Catalogo_methods = {}

-- Metatable de Catalogo
local Catalogo Catalogo_metatable = {
    index = Catalogo_methods
}

-- Construtor
local function Catalogo()
    self = {}
    self.livros = {}
    setmetatable(self, Catalogo_metatable)
    return self
end
Catalogo_methods.Catalogo = Catalogo

--
-- FUNÇÕES
--

-- Função que efetivamente realiza a leitura de um
-- livro. Retorna uma tupla contendo o livro e a
-- última linha lida, que no caso será ou '\n' ou
-- '', indicando se a leitura deve continuar ou se
-- o arquivo arquivo acabou, respectivamente.
local function lerLivro(self, file)
    codigo = file.read()

    -- Evita erros de leitura caso existam linhas
    -- em branco extras
    if codigo == '\n' or codigo == '' then
        return {nil, codigo}
    end

    codigo = codigo:gsub("\n", "")
    titulo = file.read():gsub("\n", "")
    autor = file.read():gsub("\n", "")
    assunto = file.read():gsub("\n", "")
    dataStr = file.read():gsub("\n", "")
    --dataPub = date(int(dataStr["6:10"]), int(dataStr["3:5"]), int(dataStr["0:2"]))
    editora = file.read():gsub("\n", "")
    resumoPart = file.read()
    resumo = ''
    -- Lendo o resumo até achar uma linha em branco
    -- ou o final do arquivo
    while resumoPart ~= '\n' and resumoPart ~= '' do
        resumo = resumo .. resumoPart
        resumoPart = file.read()
    end

    resumo = resumo:gsub("\n", "")

    livro = ls.Livro(codigo, titulo, autor, assunto, dataPub, editora, resumo)
    return {livro, resumoPart}
end

-- Função que verifica se o livro já existe no catálogo
local function possuiLivro(self, livro)
    for l in self.livros do
        if livro.getCodigo() == l.getCodigo() then
            return True
        end
    end

    return False
end

-- Função para adicionar um livro do Catálago
local function adicionaLivro(self, livro)
    if not self.possuiLivro(livro) then
        self.livros.append(livro)
    end
end

-- Função para remover um livro do Catálago
local function removeLivro(self, codigo)
    pos = 0
    for livro in self.livros do
        if livro.getCodigo() == codigo then
            self.livros.pop(pos)
            break
        end
        pos = pos + 1
    end
end

-- Função que abre um arquivo para leitura dos livros
local function lerCatalogo(self, arquivo)
    --arqv = open(arquivo, 'r')
    posArqv = nil
    while posArqv ~= '' do
        livro, posArqv = self.lerLivro(arqv)
        if livro ~= nil then
            self.adicionaLivro(livro)
        end
    end
end

-- Função atualizar o Catálago com base no arquivo
local function atualiza(self, arquivo)
    f = open(arquivo, 'r')
    line = f.read()

    while line ~= '' do
        line = line:gsub("\n", "")

        -- Caso de inserção
        if line == 'i' then
            livro, posArqv = self.lerLivro(f)
            self.adicionaLivro(livro)

        -- Caso de alteração
        elseif line == 'a' then
            livro, posArqv = self.lerLivro(f)
            if self.possuiLivro(livro) then
                self.removeLivro(livro.getCodigo())
                self.adicionaLivro(livro)
            end

        -- Caso de exclusão
        elseif line == 'e' then
            codigo = f.read():gsub("\n", "")
            self.removeLivro(codigo)
        end

        line = f.read()
    end
end

-- Função para escrita do arquivo de saída
local function escreveSaida(self, arquivo)
    f = open(arquivo, 'w')

    self.ordena(Livro.comparaCodigo)
    f.write("Lista de Livros Ordenada Crescentemente por Codigo:\n")
    for livro in self.livros do
        f.write('\n')
        dados = livro.getDados()
        for i in dados do
            f.write(i .. '\n')
        end
    end

    f.write('\n')
    self.ordena(Livro.comparaTitulo)
    f.write("Lista de Livros Ordenada Decrescentemente por Titulo:\n")
    for livro in self.livros do
        f.write('\n')
        dados = livro.getDados()
        for i in dados do
            f.write(i .. '\n')
        end
    end

    f.write('\n')
    self.ordena(Livro.comparaAutor)
    f.write("Lista de Livros Ordenada Crescentemente por Autor:\n")
    for livro in self.livros do
        f.write('\n')
        dados = livro.getDados()
        for i in dados do
            f.write(i .. '\n')
        end
    end

    f.write('\n')
    self.ordena(Livro.comparaData)
    f.write("Lista de Livros Ordenada Decrescentemente por Data de Publicacao:\n")
    for livro in self.livros do
        f.write('\n')
        dados = livro.getDados()
        for i in dados do
            f.write(i .. '\n')
        end
    end
end

-- Função para reescrita do Catálago
local function escreveCatalogo(self, arquivo)
    f = open(arquivo, 'w')

    if len(self.livros) == 0 then
        return;
    end

    -- Primeiro livro
    dados = self.livros["0"].getDados()
    for i in dados do
        f.write(i .. '\n')
    end

    -- Demais livros (ERRADO)
    for livro in self.livros do
        f.write('\n')
        dados = livro.getDados()
        for i in dados do
            f.write(i .. '\n')
        end
    end
end

-- Função de Ordenação (Selection Sort)
local function ordena(self, comparador)
    N = #self.livros
    for i=0,N do
        minPos = i
        for j=i,N do
            if comparador(self.livros["j"], self.livros["minPos"]) < 0 then
                minPos = j
            end
        end

        -- Swap livros
        self.livros["i"], self.livros["minPos"] = self.livros["minPos"], self.livros["i"]
    end
end

--
-- Adicionando funções à tabela de métodos
--

--

return Catalogo_methods
