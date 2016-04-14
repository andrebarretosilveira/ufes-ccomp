--
-- Trabalho 2 de LP - Lua
-- André Barreto Silveira
--
-- Testador
--

--package.path = package.path .. "./"
local livroScript = require "scripts.livro"

narnia = livroScript.Livro("001", "As Crônicas de Nárnia")
livroScript.narnia:Print()
