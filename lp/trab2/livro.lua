--
-- Trabalho 2 de LP - Lua
-- André Barreto Silveira
--
-- Classe Livro
--

-- Tabela de métodos
local Livro_methods = {}

-- Metatable de Livro
local Livro Livro_metatable = {
    __index = Livro_methods
}

-- Construtor
local function Livro(codigo, titulo, autor, assunto, dataPub, editora, resumo)
    self = {}
    self.codigo  = codigo  or "0"
    self.titulo  = titulo  or "Desconhecido"
    self.autor   = autor   or "Desconhecido"
    self.assunto = assunto or "Desconhecido"
    self.dataPub = dataPub or "Desconhecido"
    self.editora = editora or "Desconhecido"
    self.resumo  = resumo  or "Desconhecido"
    setmetatable(self, Livro_metatable)
    return self
end
Livro_methods.Livro = Livro


--
-- FUNÇÕES
--

-- Retorna o código do livro
local function getCodigo()
    return self.codigo
end

-- Retorna o título do livro
local function getTitulo()
    return self.titulo
end

-- Retorna o autor do livro
local function getAutor()
    return self.autor
end

-- Retorna a data de publicação do livro
local function getData()
    return self.dataPub
end

-- Retorna os dados do livro em uma lista
--local function getDados(self)
--    dados = [self.__codigo] + [self.__titulo] + [self.__autor] + [self.__assunto] + [self.__dataPub.strftime("%d/%m/%Y")] + [self.__editora] + [self.__resumo]
--    return dados
--end

-- Compara crescentemente por Código
local function comparaCodigo(livro1, livro2)
    cod1 = tonumber(livro1.getCodigo())
    cod2 = tonumber(livro2.getCodigo())

    print(cod1, cod2)

    if cod1 < cod2 then
        return -1
    elseif cod1 == cod2 then
        return 0
    else
        return 1
    end
end

-- Compara decrescentemente por Título
local function comparaTitulo(livro1, livro2)
    titulo1 = livro1.getTitulo()
    titulo2 = livro2.getTitulo()

    if titulo1 > titulo2 then
        return -1
    elseif titulo1 == titulo2 then
        return (-1)*Livro.comparaCodigo(livro1, livro2)
    else
        return 1
    end
end

-- Compara crescentemente por Autor
local function comparaAutor(livro1, livro2)
    autor1 = livro1.getAutor()
    autor2 = livro2.getAutor()

    if autor1 < autor2 then
        return -1
    elseif autor1 == autor2 then
        return Livro.comparaCodigo(livro1, livro2)
    else
        return 1
    end
end

-- Compara decrescentemente por Data
local function comparaData(livro1, livro2)
    data1 = livro1.getData()
    data2 = livro2.getData()

    if data1 > data2 then
        return -1
    elseif data1 == data2 then
        return (-1)*Livro.comparaCodigo(livro1, livro2)
    else
        return 1
    end
end

-- Print
local function Print(self)
    print(self.codigo, self.titulo, self.autor, self.assunto, self.dataPub, self.editora, self.resumo)
end

--
-- Adicionando funções à tabela de métodos
--
Livro_methods.getCodigo = getCodigo
Livro_methods.getTitulo = getTitulo
Livro_methods.getAutor = getAutor
Livro_methods.getData = getData
Livro_methods.comparaCodigo = comparaCodigo
Livro_methods.comparaTitulo = comparaTitulo
Livro_methods.comparaAutor = comparaAutor
Livro_methods.comparaData = comparaData
Livro_methods.Print = Print
--

return Livro_methods
