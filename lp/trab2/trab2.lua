--
-- Trabalho 2 de LP - Lua
-- André Barreto Silveira
--

-- Adicionando arquivo de script catalogo.lua
local cs = require("catalogo")

catalogo = cs.Catalogo()

catalogo.lerCatalogo("catalogo.txt")
--catalogo.atualiza("atual.txt")
--catalogo.escreveSaida("saida.txt")
--catalogo.ordena(Livro.comparaCodigo)
--catalogo.escreveCatalogo("catalogo.txt")
