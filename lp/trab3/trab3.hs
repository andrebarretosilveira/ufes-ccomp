--
-- trab3.hs
--
-- Arquivo principal do trabalho.
-- Pode ser executado com 'runhaskell trab3.hs'
--

-- Importando modulos necessários
import System.Environment
import Catalogo

-- Bloco de comandos principais
main = do
    -- Lendo e criando o catálogo
    fileContents <- readFile "catalogo.txt"
    let catalogo = criaCatalogo fileContents

    -- Lendo arquivo de atualizações
    -- e atualizando o catálogo
    fileContents <- readFile "atual.txt"
    let catalogoAtualizado = atualizaCatalogo catalogo fileContents

    -- Escrevendo saída no arquivo "saida.txt"
    escreveSaida "saida.txt" catalogoAtualizado

    -- Reescrevendo catálogo atualizado em "catalogo.txt"
    escreveCatalogo "catalogo.txt" catalogoAtualizado
