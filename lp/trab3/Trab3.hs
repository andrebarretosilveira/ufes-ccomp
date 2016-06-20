import System.Environment

main = do
    [f,g] <- getArgs
    contents <- readFile f
    let lineslist = lines contents
    print lineslist
    --writeFile g lineslist
