--
-- Trabalho 2 de LP - Lua
-- André Barreto Silveira
--

-- Adicionando arquivos de scripts
local cs = require("catalogo") -- catalogo.lua
local ls = require("livro") -- livro.lua

catalogo = cs.Catalogo()

catalogo:lerCatalogo("catalogo.txt")
catalogo:atualiza("atual.txt")
catalogo:escreveSaida("saida.txt")
catalogo:ordena(ls.comparaCodigo)
catalogo:escreveCatalogo("catalogo.txt")
