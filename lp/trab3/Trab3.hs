import System.Environment
import Catalogo

main = do
    [f] <- getArgs
    contents <- readFile f
    let listaInfo = splitOn "" (lines contents)
    let livros = criaListaLivros [] listaInfo
    return livros
    --writeFile g lineslist
