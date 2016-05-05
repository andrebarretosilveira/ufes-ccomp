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
    __index = Catalogo_methods
}

-- Construtor
function Catalogo()
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
function lerLivro(self, filename)
    print(filename)
    io.input(filename) -- Abre arquivo para leitura

    codigo = io.read()
    -- Evita erros de leitura caso existam linhas
    -- em branco extras
    if codigo == '\n' or codigo == '' then
        return nil, codigo
    end

    codigo = codigo:gsub("\n", "")
    titulo = io.read():gsub("\n", "")
    autor = io.read():gsub("\n", "")
    assunto = io.read():gsub("\n", "")
    dataStr = io.read():gsub("\n", "")
    dataTab = self.split(dataStr, '/')
    dataTab = {day=dataTab[1], month=dataTab[2], year=dataTab[3]}
    data = os.time(dataTab)
    editora = io.read():gsub("\n", "")
    resumoPart = io.read()
    resumo = ''
    -- Lendo o resumo até achar uma linha em branco
    -- ou o final do arquivo
    while resumoPart ~= '\n' and resumoPart ~= '' do
        resumo = resumo .. resumoPart
        resumoPart = io.read()
    end

    resumo = resumo:gsub("\n", "")

    livro = ls.Livro(codigo, titulo, autor, assunto, data, editora, resumo)
    livro:Print()
    return livro, resumoPart
end

-- Função que verifica se o livro já existe no catálogo
function possuiLivro(self, livro)
    for key,l in ipairs(self.livros) do
        if livro.getCodigo() == l.getCodigo() then
            return True
        end
    end

    return False
end

-- Função para adicionar um livro do Catálago
function adicionaLivro(self, livro)
    if not self:possuiLivro(livro) then
        table.insert(self.livros, livro)
    end
end

-- Função para remover um livro do Catálago
function removeLivro(self, codigo)
    for key,livro in ipairs(self.livros) do
        if livro.getCodigo() == codigo then
            table.remove(self.livros, key)
            break
        end
    end
end

-- Função que abre um arquivo para leitura dos livros
function lerCatalogo(self, filename)
    posArqv = nil
    while posArqv ~= '' do
        livro, posArqv = self:lerLivro(filename)
        if livro ~= nil then
            self:adicionaLivro(livro)
        end
    end
end

-- Função atualizar o Catálago com base no arquivo
function atualiza(self, arquivo)
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
function escreveSaida(self, arquivo)
    f = open(arquivo, 'w')

    self.ordena(Livro.comparaCodigo)
    f.write("Lista de Livros Ordenada Crescentemente por Codigo:\n")
    for key,livro in ipairs(self.livros) do
        f.write('\n')
        dados = livro.getDados()
        for key,dado in ipairs(dados) do
            f.write(dado .. '\n')
        end
    end

    f.write('\n')
    self.ordena(Livro.comparaTitulo)
    f.write("Lista de Livros Ordenada Decrescentemente por Titulo:\n")
    for key,livro in ipairs(self.livros) do
        f.write('\n')
        dados = livro.getDados()
        for key,dado in ipairs(dados) do
            f.write(dado .. '\n')
        end
    end

    f.write('\n')
    self.ordena(Livro.comparaAutor)
    f.write("Lista de Livros Ordenada Crescentemente por Autor:\n")
    for key,livro in ipairs(self.livros) do
        f.write('\n')
        dados = livro.getDados()
        for key,dado in ipairs(dados) do
            f.write(dado .. '\n')
        end
    end

    f.write('\n')
    self.ordena(Livro.comparaData)
    f.write("Lista de Livros Ordenada Decrescentemente por Data de Publicacao:\n")
    for key,livro in ipairs(self.livros) do
        f.write('\n')
        dados = livro.getDados()
        for key,dado in ipairs(dados) do
            f.write(dado .. '\n')
        end
    end
end

-- Função para reescrita do Catálago
function escreveCatalogo(self, arquivo)
    f = open(arquivo, 'w')

    if len(self.livros) == 0 then
        return;
    end

    -- Primeiro livro
    dados = self.livros["0"].getDados()
    for key,dado in ipairs(dados) do
        f.write(i .. '\n')
    end

    -- Demais livros
    for key,livro in ipairs(self.livros) do
        f.write('\n')
        dados = livro.getDados()
        for key,dado in ipairs(dados) do
            f.write(dado .. '\n')
        end
    end
end

-- Função de Ordenação (Selection Sort)
function ordena(self, comparador)
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

-- Função utilitária para separar strings
function split(str, pat)
    local t = {}
    local fpat = "(.-)" .. pat
    local last_end = 1
    local s, e, cap = str:find(fpat, 1)
    while s do
        if s ~= 1 or cap ~= "" then
            table.insert(t,cap)
        end
        last_end = e+1
        s, e, cap = str:find(fpat, last_end)
    end
    if last_end <= #str then
        cap = str:sub(last_end)
        table.insert(t, cap)
    end
    return t
end

--
-- Adicionando funções à tabela de métodos
--
Catalogo_methods.lerLivro = lerLivro
Catalogo_methods.possuiLivro = possuiLivro
Catalogo_methods.adicionaLivro = adicionaLivro
Catalogo_methods.removeLivro = removeLivro
Catalogo_methods.lerCatalogo = lerCatalogo
Catalogo_methods.atualiza = atualiza
Catalogo_methods.escreveSaida = escreveSaida
Catalogo_methods.escreveCatalogo = escreveCatalogo
Catalogo_methods.ordena = ordena
Catalogo_methods.split = split
--

return Catalogo_methods
