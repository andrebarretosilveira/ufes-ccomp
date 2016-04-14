--
-- Trabalho 2 de LP - Lua
-- André Barreto Silveira
--
-- Classe Livro
--


-- Métodos
local Livro_methods = {
    Print = function(self)
        print(self.codigo, self.titulo, self.autor, self.assunto, self.dataPub, self.editora, self.resumo)
    end,
}

-- Metatable de Livro
local Livro Livro_metatable = {
    __index = Livro_methods
}

-- Construtor
function Livro(codigo, titulo, autor, assunto, dataPub, editora, resumo)
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

narnia = Livro("001", "As Crônicas de Nárnia")
narnia:Print()
