import System.Environment
import Catalogo

main = do
    contents <- readFile "catalogo.txt"
    let listaInfo = splitOn "" (lines contents)
    let catalogo = Catalogo (criaListaLivros [] listaInfo)
    --writeFile "saida.txt" (show catalogo)
    print catalogo
