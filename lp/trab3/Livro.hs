--
-- Livro.hs
--
-- Definição e implementação da
-- classe Livro e suas funções
--

-- Definição do módulo Livro
module Livro
( Livro(..)
, toString
) where

-- Definição da estrutura Livro
data Livro  = Livro {
    codigo  :: Int,
    titulo  :: String,
    autor   :: String,
    assunto :: String,
    dataPub :: String,
    editora :: String,
    resumo  :: String
} deriving (Show)

-- Função que imprime os dados de um livro
toString :: Livro -> IO()
toString (Livro c t a ass d e r) = putStr(show c ++ "\n" ++ t ++ "\n" ++ a ++ "\n"  ++ ass ++ "\n" ++ d ++ "\n" ++ e ++ "\n" ++ r ++ "\n")
