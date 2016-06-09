--
-- livro.hs
--
-- Definição e implementação da
-- classe Livro e suas funções
--
module Livro
( Livro
, toString
) where

data Livro = Livro {
    codigo :: Int,
    titulo :: String,
    autor :: String,
    assunto :: String,
    dataPub :: String,
    editora :: String,
    resumo :: String
} deriving (Show)

toString (Livro c t a ass d e r) = putStr(show c ++ "\n" ++ t ++ "\n" ++ a ++ "\n"  ++ ass ++ "\n" ++ d ++ "\n" ++ e ++ "\n" ++ r ++ "\n")
