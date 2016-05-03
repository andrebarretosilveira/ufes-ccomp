--
-- Trabalho 2 de LP - Lua
-- André Barreto Silveira
--

-- Adicionando arquivo de script livro.lua
local livroScript = require("livro")

narnia = livroScript.Livro("001", "As Crônicas de Nárnia")
hobbit = livroScript.Livro("122", "Hobbit - Uma Aventura Inesperada")
narnia:Print()
hobbit:Print()

comp = livroScript.comparaCodigo(narnia, hobbit)
print(comp)
